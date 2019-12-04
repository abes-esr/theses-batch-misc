package fr.abes.theses.model.dto;

import fr.abes.theses.model.entities.GenericEntity;
import fr.abes.theses.model.entities.NoticeBiblio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NoticeBiblioDto implements Serializable, GenericEntity<Integer> {
    private Integer id;

    private Integer idJob;

    private Integer iddoc;

    private String codeEtab;

    private Integer done;

    private String retourSudoc;

    private Date dateCreation;

    private Date dateModification;

    private String indicSudoc;

    private String ppn;

    public NoticeBiblioDto(Integer idJob, Integer iddoc, String codeEtab, Integer done, String retourSudoc, Date dateCreation, Date dateModification, String indicSudoc, String ppn) {
        this.idJob = idJob;
        this.iddoc = iddoc;
        this.codeEtab = codeEtab;
        this.done = done;
        this.retourSudoc = retourSudoc;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.indicSudoc = indicSudoc;
        this.ppn = ppn;
    }

    public NoticeBiblioDto(NoticeBiblio notice) {
        this.id = notice.getId();
        this.iddoc = notice.getIddoc();
        this.idJob = notice.getIdJob();
        this.codeEtab = notice.getCodeEtab();
        this.done = notice.getDone();
        this.retourSudoc = notice.getRetourSudoc();
        this.dateCreation = notice.getDateCreation();
        this.dateModification = notice.getDateModification();
        this.indicSudoc = notice.getIndicSudoc();
        this.ppn = notice.getPpn();
    }

    @Override
    public Integer getId() {
        return id;
    }
}
