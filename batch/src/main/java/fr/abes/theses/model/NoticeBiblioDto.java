package fr.abes.theses.model;

import fr.abes.theses.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class NoticeBiblioDto implements Serializable, GenericEntity<Integer> {
    private Integer idJob;

    private Integer iddoc;

    private String codeEtab;

    private Integer done;

    private String retourSudoc;

    public NoticeBiblioDto(Integer idJob, Integer iddoc, String codeEtab, Integer done, String retourSudoc) {
        this.idJob = idJob;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
    }

    @Override
    public Integer getId() {
        return idJob;
    }
}
