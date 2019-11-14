package fr.abes.theses.core.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "T_E_TRAITEMENT_NOTICEBIB_TNB")
@NoArgsConstructor
public class NoticeBiblio implements Serializable,GenericEntity<Integer> {
    @Id
    @Column(name = "JOB_ID")
    private  Integer id;

    @Column(name = "THE_ID")
    private Integer idThese;

    @Column(name = "ETA_ID")
    private String idEtablissement;

    @Column(name = "TRAITEE")
    private Integer done;

    @Column(name = "RETOUR_SUDOC")
    private String retourSudoc;

    public NoticeBiblio(Integer id, Integer idThese, String idEtablissement, Integer done, String retourSudoc) {
        this.id = id;
        this.idThese = idThese;
        this.idEtablissement = idEtablissement;
        this.done = done;
        this.retourSudoc = retourSudoc;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
