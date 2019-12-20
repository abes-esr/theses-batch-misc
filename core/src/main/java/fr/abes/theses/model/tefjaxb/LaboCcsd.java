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


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="codeLaboCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="libLaboCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "laboCcsd")
public class LaboCcsd {

    @XmlAttribute(name = "codeLaboCcsd", required = true)
    protected BigInteger codeLaboCcsd;
    @XmlAttribute(name = "libLaboCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String libLaboCcsd;

    /**
     * Obtient la valeur de la propriété codeLaboCcsd.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodeLaboCcsd() {
        return codeLaboCcsd;
    }

    /**
     * Définit la valeur de la propriété codeLaboCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodeLaboCcsd(BigInteger value) {
        this.codeLaboCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété libLaboCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLaboCcsd() {
        return libLaboCcsd;
    }

    /**
     * Définit la valeur de la propriété libLaboCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLaboCcsd(String value) {
        this.libLaboCcsd = value;
    }

}
