package fr.abes.theses.core.model.entities;

import fr.abes.theses.core.model.data.STATUT_LIGNE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@Table(name="T_E_TRAITEMENT_LIGNE_TLN")
@NoArgsConstructor
public class TraitementLigne implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "TLN_ID")
    private Integer id;
    @Column(name = "THE_ID")
    private Integer theseId;
    @Column(name="TLN_RESULT")
    private String result;
    @Column(name = "TLN_STATUT")
    private STATUT_LIGNE statut;
    @ManyToOne
    @JoinColumn(name = "TRA_ID")
    private Traitement traitement;

    public TraitementLigne(Integer id, Integer theseId, String result, STATUT_LIGNE statut, Traitement traitement) {
        this.id = id;
        this.theseId = theseId;
        this.result = result;
        this.statut = statut;
        this.traitement = traitement;
    }

    @Override
    public Integer getId(){
        return this.id;
    }
}
