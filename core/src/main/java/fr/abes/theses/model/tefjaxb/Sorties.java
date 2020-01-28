//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.19 à 03:54:21 PM CET 
//


package fr.abes.theses.model.tefjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}cines"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}sudoc"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}diffusion"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cines",
    "sudoc",
    "diffusion"
})
@XmlRootElement(name = "sorties")
public class Sorties {

    @XmlElement(required = true)
    protected Cines cines;
    @XmlElement(required = true)
    protected Sudoc sudoc;
    @XmlElement(required = true)
    protected Diffusion diffusion;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String date;

    /**
     * Obtient la valeur de la propriété cines.
     * 
     * @return
     *     possible object is
     *     {@link Cines }
     *     
     */
    public Cines getCines() {
        return cines;
    }

    /**
     * Définit la valeur de la propriété cines.
     * 
     * @param value
     *     allowed object is
     *     {@link Cines }
     *     
     */
    public void setCines(Cines value) {
        this.cines = value;
    }

    /**
     * Obtient la valeur de la propriété sudoc.
     * 
     * @return
     *     possible object is
     *     {@link Sudoc }
     *     
     */
    public Sudoc getSudoc() {
        return sudoc;
    }

    /**
     * Définit la valeur de la propriété sudoc.
     * 
     * @param value
     *     allowed object is
     *     {@link Sudoc }
     *     
     */
    public void setSudoc(Sudoc value) {
        this.sudoc = value;
    }

    /**
     * Obtient la valeur de la propriété diffusion.
     * 
     * @return
     *     possible object is
     *     {@link Diffusion }
     *     
     */
    public Diffusion getDiffusion() {
        return diffusion;
    }

    /**
     * Définit la valeur de la propriété diffusion.
     * 
     * @param value
     *     allowed object is
     *     {@link Diffusion }
     *     
     */
    public void setDiffusion(Diffusion value) {
        this.diffusion = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

}
