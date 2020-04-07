package fr.abes.theses.model.dto;

import fr.abes.theses.model.entities.NoticeBiblio;

public class NoticeBiblioDtoMapper {
    public static NoticeBiblio getNoticeBiblioEntity(NoticeBiblioDto noticeBiblioDto) {
        return new NoticeBiblio(
                noticeBiblioDto.getId(),
                noticeBiblioDto.getIdJob(),
                noticeBiblioDto.getIddoc(),
                shorten(noticeBiblioDto.getCodeEtab(), 49),
                noticeBiblioDto.getDone(),
                noticeBiblioDto.getRetourSudoc(),
                noticeBiblioDto.getDateCreation(),
                noticeBiblioDto.getDateModification(),
                noticeBiblioDto.getIndicSudoc(),
                noticeBiblioDto.getPpn(),
                noticeBiblioDto.getEpn());
    }

    private static String shorten(String stringToShorten, int maxLength) {
        if (stringToShorten == null){
            return null;
        }
        if (stringToShorten.length() < maxLength) {
            return stringToShorten;
        } else {
            return stringToShorten.substring(0, maxLength);
        }
    }
}
