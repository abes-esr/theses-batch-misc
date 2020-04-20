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
 *         &lt;element ref="{http://cosimo.stanford.edu/sdr/metsrights/}Permissions"/&gt;
 *         &lt;element ref="{http://cosimo.stanford.edu/sdr/metsrights/}Constraints" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CONTEXTCLASS" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "permissions",
    "constraints"
})
@XmlRootElement(name = "Context", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
public class Context {

    @XmlElement(name = "Permissions", namespace = "http://cosimo.stanford.edu/sdr/metsrights/", required = true)
    protected Permissions permissions;
    @XmlElement(name = "Constraints", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
    protected Constraints constraints;
    @XmlAttribute(name = "CONTEXTCLASS", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String contextclass;

    /**
     * Obtient la valeur de la propriété permissions.
     * 
     * @return
     *     possible object is
     *     {@link Permissions }
     *     
     */
    public Permissions getPermissions() {
        return permissions;
    }

    /**
     * Définit la valeur de la propriété permissions.
     * 
     * @param value
     *     allowed object is
     *     {@link Permissions }
     *     
     */
    public void setPermissions(Permissions value) {
        this.permissions = value;
    }

    /**
     * Obtient la valeur de la propriété constraints.
     * 
     * @return
     *     possible object is
     *     {@link Constraints }
     *     
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * Définit la valeur de la propriété constraints.
     * 
     * @param value
     *     allowed object is
     *     {@link Constraints }
     *     
     */
    public void setConstraints(Constraints value) {
        this.constraints = value;
    }

    /**
     * Obtient la valeur de la propriété contextclass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTEXTCLASS() {
        return contextclass;
    }

    /**
     * Définit la valeur de la propriété contextclass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTEXTCLASS(String value) {
        this.contextclass = value;
    }

}
