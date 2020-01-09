//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.loc.gov/METS/}FLocat"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ADMID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="SEQ" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fLocat"
})
@XmlRootElement(name = "file", namespace = "http://www.loc.gov/METS/")
public class File {

    @XmlElement(name = "FLocat", namespace = "http://www.loc.gov/METS/", required = true)
    protected FLocat fLocat;
    @XmlAttribute(name = "ADMID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String admid;
    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "SEQ", required = true)
    protected BigInteger seq;

    /**
     * Obtient la valeur de la propriété fLocat.
     * 
     * @return
     *     possible object is
     *     {@link FLocat }
     *     
     */
    public FLocat getFLocat() {
        return fLocat;
    }

    /**
     * Définit la valeur de la propriété fLocat.
     * 
     * @param value
     *     allowed object is
     *     {@link FLocat }
     *     
     */
    public void setFLocat(FLocat value) {
        this.fLocat = value;
    }

    /**
     * Obtient la valeur de la propriété admid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADMID() {
        return admid;
    }

    /**
     * Définit la valeur de la propriété admid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADMID(String value) {
        this.admid = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété seq.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSEQ() {
        return seq;
    }

    /**
     * Définit la valeur de la propriété seq.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSEQ(BigInteger value) {
        this.seq = value;
    }

}