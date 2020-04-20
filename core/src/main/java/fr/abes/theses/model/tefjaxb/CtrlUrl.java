//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.19 à 03:54:21 PM CET 
//


package fr.abes.theses.model.tefjaxb;

import java.math.BigInteger;
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
 *       &lt;attribute name="compteIndicCtrlUrlKO" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="erreurUrl" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="indicCtrlUrl" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ctrlUrl")
public class CtrlUrl {

    @XmlAttribute(name = "compteIndicCtrlUrlKO", required = true)
    protected BigInteger compteIndicCtrlUrlKO;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String date;
    @XmlAttribute(name = "erreurUrl", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String erreurUrl;
    @XmlAttribute(name = "indicCtrlUrl", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicCtrlUrl;

    /**
     * Obtient la valeur de la propriété compteIndicCtrlUrlKO.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCompteIndicCtrlUrlKO() {
        return compteIndicCtrlUrlKO;
    }

    /**
     * Définit la valeur de la propriété compteIndicCtrlUrlKO.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCompteIndicCtrlUrlKO(BigInteger value) {
        this.compteIndicCtrlUrlKO = value;
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

    /**
     * Obtient la valeur de la propriété erreurUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErreurUrl() {
        return erreurUrl;
    }

    /**
     * Définit la valeur de la propriété erreurUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErreurUrl(String value) {
        this.erreurUrl = value;
    }

    /**
     * Obtient la valeur de la propriété indicCtrlUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicCtrlUrl() {
        return indicCtrlUrl;
    }

    /**
     * Définit la valeur de la propriété indicCtrlUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicCtrlUrl(String value) {
        this.indicCtrlUrl = value;
    }

}
