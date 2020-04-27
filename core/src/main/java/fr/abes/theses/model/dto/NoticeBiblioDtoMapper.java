package fr.abes.theses.model.dto;


import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;

public class NoticeBiblioDtoMapper {
    public static NoticeBiblio getNoticeBiblioEntity(NoticeBiblioDto noticeBiblioDto) {
        return new NoticeBiblio(
                noticeBiblioDto.getId(),
                noticeBiblioDto.getIdJob(),
                noticeBiblioDto.getIddoc(),
                shorten(noticeBiblioDto.getCodeEtab(), 49),
                noticeBiblioDto.getDone(),
                shorten(noticeBiblioDto.getRetourSudoc(), 200),
                noticeBiblioDto.getDateCreation(),
                noticeBiblioDto.getDateModification(),
                shorten(noticeBiblioDto.getIndicSudoc(), 254),
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
