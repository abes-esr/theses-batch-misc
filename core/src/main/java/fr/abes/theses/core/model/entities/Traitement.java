package fr.abes.theses.core.model.entities;

import fr.abes.theses.core.model.data.STATUT_TRAITEMENT;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "T_E_TRAITEMENT_TRA")
@NoArgsConstructor
public class Traitement implements Serializable,GenericEntity<Integer> {
    @Id
    @Column(name = "TRA_ID")
    private Integer id;
    @Column(name = "TRA_ACTION")
    private String action;
    @Column(name = "TRA_DATE_DEBUT")
    private Date dateDebut;
    @Column(name = "TRA_DATE_FIN")
    private Date dateFin;
    @Column(name = "TRA_NB_LIGNE")
    private Integer nbLignes;
    @Column(name = "TRA_STATUT")
    private STATUT_TRAITEMENT statut;

    @OneToMany(mappedBy = "traitement", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<TraitementLigne> traitementLignes;

    public Traitement(Integer id, String action, Date dateDebut, Date dateFin, Integer nbLignes, STATUT_TRAITEMENT statut) {
        this.id = id;
        this.action = action;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbLignes = nbLignes;
        this.statut = statut;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
