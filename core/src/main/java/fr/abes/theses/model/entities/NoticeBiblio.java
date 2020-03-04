package fr.abes.theses.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "T_E_TRAITEMENT_NOTICEBIB_TNB", schema = "STAR")
public class NoticeBiblio implements Serializable,GenericEntity<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JOB_ID")
    private Integer idJob;

    @Column(name = "THE_ID")
    private Integer iddoc;

    @Column(name = "ETA_ID")
    private String codeEtab;

    @Column(name = "TRAITEE")
    private Integer done;

    @Column(name = "RETOUR_SUDOC")
    private String retourSudoc;

    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    private Date dateModification;

    @Column(name = "INDIC_SUDOC")
    private String indicSudoc;

    @Column(name = "PPN")
    private String ppn;

    @Column(name = "EPN")
    private String epn;



    public NoticeBiblio(Integer id, Integer idJob, Integer iddoc, String codeEtab, Integer done, String retourSudoc, Date dateCreation, Date dateModification, String indicSudoc, String ppn, String epn) {
        this.id = id;
        this.idJob = idJob;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.indicSudoc = indicSudoc;
        this.ppn = ppn;
        this.epn = epn;
    }
    public NoticeBiblio(Integer idJob, Integer iddoc, String codeEtab, Integer done, String retourSudoc, Date dateCreation, Date dateModification, String indicSudoc, String ppn, String epn) {
        this.idJob = idJob;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.indicSudoc = indicSudoc;
        this.ppn = ppn;
        this.epn = epn;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
