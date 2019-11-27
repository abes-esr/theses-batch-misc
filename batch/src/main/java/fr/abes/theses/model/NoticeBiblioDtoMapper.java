package fr.abes.theses.model;

import fr.abes.theses.model.entities.NoticeBiblio;

public class NoticeBiblioDtoMapper {
    public NoticeBiblio getNoticeBiblioEntity(NoticeBiblioDto noticeBiblioDto){
        return new NoticeBiblio(
                noticeBiblioDto.getIdJob(),
                noticeBiblioDto.getIddoc(),
                noticeBiblioDto.getCodeEtab(),
                noticeBiblioDto.getDone(),
                noticeBiblioDto.getRetourSudoc());
    }
}
