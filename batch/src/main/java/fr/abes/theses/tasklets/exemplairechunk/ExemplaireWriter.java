package fr.abes.theses.tasklets.exemplairechunk;

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
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ExemplaireWriter implements ItemWriter<NoticeBiblioDto>, StepExecutionListener {

    @Getter
    final ServiceProvider service;

    public ExemplaireWriter(ServiceProvider service) {
        this.service = service;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }

    @Override
    public void write(List<? extends NoticeBiblioDto> list) throws Exception {
        for (NoticeBiblioDto noticeBiblioDto : list) {
            try {
                this.majNoticeBiblio(noticeBiblioDto);
                this.majDonneesGestion(noticeBiblioDto);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error("Erreur dans la mise à jour de la ligne " + noticeBiblioDto.getId());
                throw e;
            }
        }
    }

    private void majDonneesGestion(NoticeBiblioDto noticeBiblioDto) throws DocumentException, InstantiationException {
        getService().getGestionTefService().majDonneesGestionExemplarisation(noticeBiblioDto);
    }

    private void majNoticeBiblio(NoticeBiblioDto noticeBiblioDto) throws DataAccessException {
        noticeBiblioDto.setDone(1);
        NoticeBiblio noticeBiblio = NoticeBiblioDtoMapper.getNoticeBiblioEntity(noticeBiblioDto);
        log.info("majNoticeBiblio RetourSudoc : " + noticeBiblio.getRetourSudoc());
        service.getNoticeBiblioService().save(noticeBiblio);
        log.info("Exemplaire traité : " + noticeBiblio.getIddoc());
    }
}
