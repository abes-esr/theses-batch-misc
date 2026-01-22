package fr.abes.theses.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Document_Envoi_Sudoc", schema = "STAR")
public class DocumentEnvoiSudoc implements Serializable, GenericEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iddoc", nullable = false)
    private Integer iddoc;

    @Column(name = "niveau", nullable = false)
    private String niveau;
}
