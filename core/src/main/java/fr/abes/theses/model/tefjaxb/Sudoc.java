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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}RCR"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}EPN"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PPN" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="dateSudoc" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="indicSudoc" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majSudoc" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="trace" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rcr",
    "epn"
})
@XmlRootElement(name = "sudoc")
public class Sudoc {

    @XmlElement(name = "RCR", required = true)
    protected RCR rcr;
    @XmlElement(name = "EPN", required = true)
    protected EPN epn;
    @XmlAttribute(name = "PPN", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String ppn;
    @XmlAttribute(name = "dateSudoc", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dateSudoc;
    @XmlAttribute(name = "indicSudoc", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicSudoc;
    @XmlAttribute(name = "majSudoc", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String majSudoc;
    @XmlAttribute(name = "trace", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String trace;

    /**
     * Obtient la valeur de la propriété rcr.
     * 
     * @return
     *     possible object is
     *     {@link RCR }
     *     
     */
    public RCR getRCR() {
        return rcr;
    }

    /**
     * Définit la valeur de la propriété rcr.
     * 
     * @param value
     *     allowed object is
     *     {@link RCR }
     *     
     */
    public void setRCR(RCR value) {
        this.rcr = value;
    }

    /**
     * Obtient la valeur de la propriété epn.
     * 
     * @return
     *     possible object is
     *     {@link EPN }
     *     
     */
    public EPN getEPN() {
        return epn;
    }

    /**
     * Définit la valeur de la propriété epn.
     * 
     * @param value
     *     allowed object is
     *     {@link EPN }
     *     
     */
    public void setEPN(EPN value) {
        this.epn = value;
    }

    /**
     * Obtient la valeur de la propriété ppn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPPN() {
        return ppn;
    }

    /**
     * Définit la valeur de la propriété ppn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPPN(String value) {
        this.ppn = value;
    }

    /**
     * Obtient la valeur de la propriété dateSudoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateSudoc() {
        return dateSudoc;
    }

    /**
     * Définit la valeur de la propriété dateSudoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateSudoc(String value) {
        this.dateSudoc = value;
    }

    /**
     * Obtient la valeur de la propriété indicSudoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicSudoc() {
        return indicSudoc;
    }

    /**
     * Définit la valeur de la propriété indicSudoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicSudoc(String value) {
        this.indicSudoc = value;
    }

    /**
     * Obtient la valeur de la propriété majSudoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajSudoc() {
        return majSudoc;
    }

    /**
     * Définit la valeur de la propriété majSudoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajSudoc(String value) {
        this.majSudoc = value;
    }

    /**
     * Obtient la valeur de la propriété trace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrace() {
        return trace;
    }

    /**
     * Définit la valeur de la propriété trace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrace(String value) {
        this.trace = value;
    }

}
