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
 *       &lt;attribute name="dateOai" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="indicOai" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majOai" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "oai")
public class Oai {

    @XmlAttribute(name = "dateOai", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dateOai;
    @XmlAttribute(name = "indicOai", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicOai;
    @XmlAttribute(name = "majOai", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String majOai;

    /**
     * Obtient la valeur de la propriété dateOai.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOai() {
        return dateOai;
    }

    /**
     * Définit la valeur de la propriété dateOai.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOai(String value) {
        this.dateOai = value;
    }

    /**
     * Obtient la valeur de la propriété indicOai.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicOai() {
        return indicOai;
    }

    /**
     * Définit la valeur de la propriété indicOai.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicOai(String value) {
        this.indicOai = value;
    }

    /**
     * Obtient la valeur de la propriété majOai.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajOai() {
        return majOai;
    }

    /**
     * Définit la valeur de la propriété majOai.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajOai(String value) {
        this.majOai = value;
    }

}
