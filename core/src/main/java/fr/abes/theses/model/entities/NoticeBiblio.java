package fr.abes.theses.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "T_E_TRAITEMENT_NOTICEBIB_TNB", schema = "STAR")
@NoArgsConstructor
public class NoticeBiblio implements Serializable,GenericEntity<Integer> {
    @Id
    @Column(name = "JOB_ID")
    @GeneratedValue
    private  Integer idJob;

    @Column(name = "THE_ID")
    private Integer iddoc;

    @Column(name = "ETA_ID")
    private String codeEtab;

    @Column(name = "TRAITEE")
    private Integer done;

    @Column(name = "RETOUR_SUDOC")
    private String retourSudoc;

    public NoticeBiblio(Integer idJob, Integer iddoc, String codeEtab, Integer done, String retourSudoc) {
        this.idJob = idJob;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
    }
    public NoticeBiblio(Integer iddoc, String codeEtab, Integer done, String retourSudoc) {
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
    }

    @Override
    public Integer getId() {
        return this.idJob;
    }
}
