package fr.abes.theses.core.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Getter
public class ServiceProvider {
    @Resource
    private IMajStarSudocService majStarSudoc;

    @Resource
    private ITraitementService traitement;

    @Resource
    private ITraitementLigneService traitementLigne;

}
