//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.loc.gov/METS/}div" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}fptr" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ADMID" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="CONTENTIDS" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DMDID" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="TYPE" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "div",
    "fptr"
})
@XmlRootElement(name = "div", namespace = "http://www.loc.gov/METS/")
public class Div {

    @XmlElement(namespace = "http://www.loc.gov/METS/")
    protected List<Div> div;
    @XmlElement(namespace = "http://www.loc.gov/METS/")
    protected Fptr fptr;
    @XmlAttribute(name = "ADMID")
    @XmlSchemaType(name = "anySimpleType")
    protected String admid;
    @XmlAttribute(name = "CONTENTIDS")
    @XmlSchemaType(name = "anySimpleType")
    protected String contentids;
    @XmlAttribute(name = "DMDID")
    @XmlSchemaType(name = "anySimpleType")
    protected String dmdid;
    @XmlAttribute(name = "ID")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String type;

    /**
     * Gets the value of the div property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the div property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Div }
     * 
     * 
     */
    public List<Div> getDiv() {
        if (div == null) {
            div = new ArrayList<Div>();
        }
        return this.div;
    }

    /**
     * Obtient la valeur de la propriété fptr.
     * 
     * @return
     *     possible object is
     *     {@link Fptr }
     *     
     */
    public Fptr getFptr() {
        return fptr;
    }

    /**
     * Définit la valeur de la propriété fptr.
     * 
     * @param value
     *     allowed object is
     *     {@link Fptr }
     *     
     */
    public void setFptr(Fptr value) {
        this.fptr = value;
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
     * Obtient la valeur de la propriété contentids.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENTIDS() {
        return contentids;
    }

    /**
     * Définit la valeur de la propriété contentids.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENTIDS(String value) {
        this.contentids = value;
    }

    /**
     * Obtient la valeur de la propriété dmdid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDMDID() {
        return dmdid;
    }

    /**
     * Définit la valeur de la propriété dmdid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMDID(String value) {
        this.dmdid = value;
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
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

}
