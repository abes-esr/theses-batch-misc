package fr.abes.theses.model.dto;

import fr.abes.theses.model.entities.NoticeBiblio;

public class NoticeBiblioDtoMapper {
    public static NoticeBiblio getNoticeBiblioEntity(NoticeBiblioDto noticeBiblioDto){
        return new NoticeBiblio(
                noticeBiblioDto.getId(),
                noticeBiblioDto.getIdJob(),
                noticeBiblioDto.getIddoc(),
                noticeBiblioDto.getCodeEtab(),
                noticeBiblioDto.getDone(),
                noticeBiblioDto.getRetourSudoc(),
                noticeBiblioDto.getDateCreation(),
                noticeBiblioDto.getDateModification(),
                noticeBiblioDto.getIndicSudoc(),
                noticeBiblioDto.getPpn(),
                noticeBiblioDto.getEpn());
    }
}
