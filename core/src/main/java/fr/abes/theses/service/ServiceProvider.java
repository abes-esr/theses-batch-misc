package fr.abes.theses.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import fr.abes.theses.service.IMajStarSudocService;

@Service
@Getter
public class ServiceProvider {
    @Resource
    private IMajStarSudocService majStarSudocService;

    @Resource
    private INoticeBiblioService noticeBiblioService;

    @Resource
    private IDocumentService documentService;

    @Resource
    private IGestionTefService gestionTefService;
}
