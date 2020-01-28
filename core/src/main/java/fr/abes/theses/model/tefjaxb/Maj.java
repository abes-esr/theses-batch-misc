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
import javax.xml.datatype.XMLGregorianCalendar;


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
 *       &lt;attribute name="VALID" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="import" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "maj")
public class Maj {

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
    @XmlAttribute(name = "VALID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String valid;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "import", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String _import;

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
     * Obtient la valeur de la propriété valid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALID() {
        return valid;
    }

    /**
     * Définit la valeur de la propriété valid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALID(String value) {
        this.valid = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété import.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImport() {
        return _import;
    }

    /**
     * Définit la valeur de la propriété import.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImport(String value) {
        this._import = value;
    }

}
