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
 *       &lt;attribute name="BIBL" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="FICH" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="SCOL" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="contenu" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "refus")
public class Refus {

    @XmlAttribute(name = "BIBL", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String bibl;
    @XmlAttribute(name = "FICH", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fich;
    @XmlAttribute(name = "SCOL", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String scol;
    @XmlAttribute(name = "contenu", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String contenu;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String date;

    /**
     * Obtient la valeur de la propriété bibl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIBL() {
        return bibl;
    }

    /**
     * Définit la valeur de la propriété bibl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIBL(String value) {
        this.bibl = value;
    }

    /**
     * Obtient la valeur de la propriété fich.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFICH() {
        return fich;
    }

    /**
     * Définit la valeur de la propriété fich.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFICH(String value) {
        this.fich = value;
    }

    /**
     * Obtient la valeur de la propriété scol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCOL() {
        return scol;
    }

    /**
     * Définit la valeur de la propriété scol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCOL(String value) {
        this.scol = value;
    }

    /**
     * Obtient la valeur de la propriété contenu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Définit la valeur de la propriété contenu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContenu(String value) {
        this.contenu = value;
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
