//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}noteVersion"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}ressourceID"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "noteVersion",
    "ressourceID"
})
@XmlRootElement(name = "manque")
public class Manque {

    protected String noteVersion;
    protected String ressourceID;

    /**
     * Obtient la valeur de la propriété noteVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteVersion() {
        return noteVersion;
    }

    /**
     * Définit la valeur de la propriété noteVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteVersion(String value) {
        this.noteVersion = value;
    }

    /**
     * Obtient la valeur de la propriété ressourceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRessourceID() {
        return ressourceID;
    }

    /**
     * Définit la valeur de la propriété ressourceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRessourceID(String value) {
        this.ressourceID = value;
    }

}
