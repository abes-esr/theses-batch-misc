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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}personMADS"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="authorityID" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personMADS"
})
@XmlRootElement(name = "MADSAuthority")
public class MADSAuthority {

    @XmlElement(required = true)
    protected PersonMADS personMADS;
    @XmlAttribute(name = "authorityID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String authorityID;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String type;

    /**
     * Obtient la valeur de la propriété personMADS.
     * 
     * @return
     *     possible object is
     *     {@link PersonMADS }
     *     
     */
    public PersonMADS getPersonMADS() {
        return personMADS;
    }

    /**
     * Définit la valeur de la propriété personMADS.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonMADS }
     *     
     */
    public void setPersonMADS(PersonMADS value) {
        this.personMADS = value;
    }

    /**
     * Obtient la valeur de la propriété authorityID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityID() {
        return authorityID;
    }

    /**
     * Définit la valeur de la propriété authorityID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityID(String value) {
        this.authorityID = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
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
    public void setType(String value) {
        this.type = value;
    }

}
