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
 *         &lt;element ref="{http://www.loc.gov/METS/}xmlData"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MDTYPE" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="OTHERMDTYPE" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "xmlData"
})
@XmlRootElement(name = "mdWrap", namespace = "http://www.loc.gov/METS/")
public class MdWrap {

    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected XmlData xmlData;
    @XmlAttribute(name = "MDTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String mdtype;
    @XmlAttribute(name = "OTHERMDTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String othermdtype;

    /**
     * Obtient la valeur de la propriété xmlData.
     * 
     * @return
     *     possible object is
     *     {@link XmlData }
     *     
     */
    public XmlData getXmlData() {
        return xmlData;
    }

    /**
     * Définit la valeur de la propriété xmlData.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlData }
     *     
     */
    public void setXmlData(XmlData value) {
        this.xmlData = value;
    }

    /**
     * Obtient la valeur de la propriété mdtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMDTYPE() {
        return mdtype;
    }

    /**
     * Définit la valeur de la propriété mdtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMDTYPE(String value) {
        this.mdtype = value;
    }

    /**
     * Obtient la valeur de la propriété othermdtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERMDTYPE() {
        return othermdtype;
    }

    /**
     * Définit la valeur de la propriété othermdtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERMDTYPE(String value) {
        this.othermdtype = value;
    }

}
