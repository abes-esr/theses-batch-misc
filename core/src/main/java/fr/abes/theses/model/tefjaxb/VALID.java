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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.abes.fr/abes/documents/tef}tef.notes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}refusValidationIntermediaire"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="etatVALID" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majVALID" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="validIndependant" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "refusValidationIntermediaire"
})
@XmlRootElement(name = "VALID")
public class VALID
    extends TefNotes
{

    @XmlElement(required = true)
    protected RefusValidationIntermediaire refusValidationIntermediaire;
    @XmlAttribute(name = "etatVALID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etatVALID;
    @XmlAttribute(name = "majVALID", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar majVALID;
    @XmlAttribute(name = "validIndependant", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String validIndependant;

    /**
     * Obtient la valeur de la propriété refusValidationIntermediaire.
     * 
     * @return
     *     possible object is
     *     {@link RefusValidationIntermediaire }
     *     
     */
    public RefusValidationIntermediaire getRefusValidationIntermediaire() {
        return refusValidationIntermediaire;
    }

    /**
     * Définit la valeur de la propriété refusValidationIntermediaire.
     * 
     * @param value
     *     allowed object is
     *     {@link RefusValidationIntermediaire }
     *     
     */
    public void setRefusValidationIntermediaire(RefusValidationIntermediaire value) {
        this.refusValidationIntermediaire = value;
    }

    /**
     * Obtient la valeur de la propriété etatVALID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatVALID() {
        return etatVALID;
    }

    /**
     * Définit la valeur de la propriété etatVALID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatVALID(String value) {
        this.etatVALID = value;
    }

    /**
     * Obtient la valeur de la propriété majVALID.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMajVALID() {
        return majVALID;
    }

    /**
     * Définit la valeur de la propriété majVALID.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMajVALID(XMLGregorianCalendar value) {
        this.majVALID = value;
    }

    /**
     * Obtient la valeur de la propriété validIndependant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidIndependant() {
        return validIndependant;
    }

    /**
     * Définit la valeur de la propriété validIndependant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidIndependant(String value) {
        this.validIndependant = value;
    }

}
