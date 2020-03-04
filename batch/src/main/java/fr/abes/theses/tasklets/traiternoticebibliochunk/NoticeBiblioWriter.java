package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.dto.NoticeBiblioDtoMapper;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class NoticeBiblioWriter implements ItemWriter<NoticeBiblioDto>, StepExecutionListener {
    private List<NoticeBiblioDto> noticeBiblioDtos;

    @Getter
    final ServiceProvider service;

    public NoticeBiblioWriter(ServiceProvider service) {
        this.service = service;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.noticeBiblioDtos = (List<NoticeBiblioDto>) executionContext.get("noticesBiblio");

    }

    /**
     * This method deals with the rebroadcasting and allows the writing of the marc transformed noticeBibio data from sudoc into STAR.Document table
     * @param
     * @return
     * @throws
     */
    @Override
    public void write(List<? extends NoticeBiblioDto> list) throws Exception {
        for (NoticeBiblioDto noticeBiblioDto : list) {
            try {
                this.majNoticeBiblio(noticeBiblioDto);
                this.majDonneesGestion(noticeBiblioDto);
            } catch (DataAccessException e) {
                log.error("Erreur dans la mise à jour de la ligne " + noticeBiblioDto.getId());
            }
        }
    }

    private void majDonneesGestion(NoticeBiblioDto noticeBiblioDto) throws DocumentException, InstantiationException {
        getService().getGestionTefService().majDonneesGestion(noticeBiblioDto);
    }

    private void majNoticeBiblio(NoticeBiblioDto noticeBiblioDto) throws DataAccessException {
        noticeBiblioDto.setDone(1);
        NoticeBiblio noticeBiblio = NoticeBiblioDtoMapper.getNoticeBiblioEntity(noticeBiblioDto);
        log.info("majNoticeBiblio RetourSudoc : " + noticeBiblio.getRetourSudoc());
        service.getNoticeBiblioService().save(noticeBiblio);
        log.info("notice traitée : " + noticeBiblio.getIddoc());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution.getJobExecution().getExecutionContext().put("noticesBiblio", this.noticeBiblioDtos);
        return ExitStatus.COMPLETED;
    }
}
