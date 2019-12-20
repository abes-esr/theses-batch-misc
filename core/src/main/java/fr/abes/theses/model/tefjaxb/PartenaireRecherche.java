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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}nom"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}autoriteInterne"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}autoriteExterne"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="autreType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
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
    "nom",
    "autoriteInterne",
    "autoriteExterne"
})
@XmlRootElement(name = "partenaireRecherche")
public class PartenaireRecherche {

    @XmlElement(required = true)
    protected String nom;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String autoriteInterne;
    @XmlElement(required = true)
    protected AutoriteExterne autoriteExterne;
    @XmlAttribute(name = "autreType")
    @XmlSchemaType(name = "anySimpleType")
    protected String autreType;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String type;

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété autoriteInterne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoriteInterne() {
        return autoriteInterne;
    }

    /**
     * Définit la valeur de la propriété autoriteInterne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoriteInterne(String value) {
        this.autoriteInterne = value;
    }

    /**
     * Obtient la valeur de la propriété autoriteExterne.
     * 
     * @return
     *     possible object is
     *     {@link AutoriteExterne }
     *     
     */
    public AutoriteExterne getAutoriteExterne() {
        return autoriteExterne;
    }

    /**
     * Définit la valeur de la propriété autoriteExterne.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoriteExterne }
     *     
     */
    public void setAutoriteExterne(AutoriteExterne value) {
        this.autoriteExterne = value;
    }

    /**
     * Obtient la valeur de la propriété autreType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutreType() {
        return autreType;
    }

    /**
     * Définit la valeur de la propriété autreType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutreType(String value) {
        this.autreType = value;
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
