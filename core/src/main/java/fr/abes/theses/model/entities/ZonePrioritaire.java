package fr.abes.theses.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "T_E_REDIFFUSION_ZONES_PRIO_TZP")
public class ZonePrioritaire implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LABEL_ZONE")
    private String labelZone;

    public ZonePrioritaire(Integer id, String labelZone) {
        this.id = id;
        this.labelZone = labelZone;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
