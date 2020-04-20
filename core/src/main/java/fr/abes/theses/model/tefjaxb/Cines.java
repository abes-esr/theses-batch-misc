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
 *       &lt;attribute name="dateCines" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="indicCines" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="numeroPAC" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="trace" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "cines")
public class Cines {

    @XmlAttribute(name = "dateCines", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dateCines;
    @XmlAttribute(name = "indicCines", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicCines;
    @XmlAttribute(name = "numeroPAC", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String numeroPAC;
    @XmlAttribute(name = "trace", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String trace;

    /**
     * Obtient la valeur de la propriété dateCines.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateCines() {
        return dateCines;
    }

    /**
     * Définit la valeur de la propriété dateCines.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCines(String value) {
        this.dateCines = value;
    }

    /**
     * Obtient la valeur de la propriété indicCines.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicCines() {
        return indicCines;
    }

    /**
     * Définit la valeur de la propriété indicCines.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicCines(String value) {
        this.indicCines = value;
    }

    /**
     * Obtient la valeur de la propriété numeroPAC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroPAC() {
        return numeroPAC;
    }

    /**
     * Définit la valeur de la propriété numeroPAC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroPAC(String value) {
        this.numeroPAC = value;
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
