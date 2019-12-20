//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://cosimo.stanford.edu/sdr/metsrights/}ConstraintDescription"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CONSTRAINTTYPE" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "constraintDescription"
})
@XmlRootElement(name = "Constraints", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
public class Constraints {

    @XmlElement(name = "ConstraintDescription", namespace = "http://cosimo.stanford.edu/sdr/metsrights/", required = true)
    protected String constraintDescription;
    @XmlAttribute(name = "CONSTRAINTTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String constrainttype;

    /**
     * Obtient la valeur de la propriété constraintDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstraintDescription() {
        return constraintDescription;
    }

    /**
     * Définit la valeur de la propriété constraintDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstraintDescription(String value) {
        this.constraintDescription = value;
    }

    /**
     * Obtient la valeur de la propriété constrainttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONSTRAINTTYPE() {
        return constrainttype;
    }

    /**
     * Définit la valeur de la propriété constrainttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONSTRAINTTYPE(String value) {
        this.constrainttype = value;
    }

}
