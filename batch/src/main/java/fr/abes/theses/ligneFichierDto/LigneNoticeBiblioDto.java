package fr.abes.theses.ligneFichierDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
public class LigneNoticeBiblioDto implements Serializable {

    @Getter
    @Setter
    private Integer numLigneFichier;
    @Getter @Setter
    private Integer iddoc;
    @Getter @Setter
    private String codeEtab;
    @Getter @Setter
    private Integer traitee;
    @Getter @Setter
    private String retourSudoc;


    LigneNoticeBiblioDto(Integer numLigneFichier, Integer iddoc, String codeEtab, Integer traitee, String retourSudoc) {
        this.numLigneFichier = numLigneFichier;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.traitee = traitee;
        this.retourSudoc = retourSudoc;
    }
}
