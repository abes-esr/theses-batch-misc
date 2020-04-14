package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExemplaireProcessor implements ItemProcessor<NoticeBiblioDto, NoticeBiblioDto> {
    @Override
    public NoticeBiblioDto process(NoticeBiblioDto noticeBiblioDto) throws Exception {
        return null;
    }
}
