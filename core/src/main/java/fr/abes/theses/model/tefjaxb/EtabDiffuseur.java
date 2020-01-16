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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}urlEtabDiffuseur"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="editeurScientifiqueLieu" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="editeurScientifiqueNom" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="etabDiffuseurPolEtablissement" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "urlEtabDiffuseur"
})
@XmlRootElement(name = "etabDiffuseur")
public class EtabDiffuseur {

    @XmlElement(required = true)
    protected UrlEtabDiffuseur urlEtabDiffuseur;
    @XmlAttribute(name = "editeurScientifiqueLieu", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String editeurScientifiqueLieu;
    @XmlAttribute(name = "editeurScientifiqueNom", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String editeurScientifiqueNom;
    @XmlAttribute(name = "etabDiffuseurPolEtablissement", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etabDiffuseurPolEtablissement;

    /**
     * Obtient la valeur de la propriété urlEtabDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link UrlEtabDiffuseur }
     *     
     */
    public UrlEtabDiffuseur getUrlEtabDiffuseur() {
        return urlEtabDiffuseur;
    }

    /**
     * Définit la valeur de la propriété urlEtabDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlEtabDiffuseur }
     *     
     */
    public void setUrlEtabDiffuseur(UrlEtabDiffuseur value) {
        this.urlEtabDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété editeurScientifiqueLieu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditeurScientifiqueLieu() {
        return editeurScientifiqueLieu;
    }

    /**
     * Définit la valeur de la propriété editeurScientifiqueLieu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditeurScientifiqueLieu(String value) {
        this.editeurScientifiqueLieu = value;
    }

    /**
     * Obtient la valeur de la propriété editeurScientifiqueNom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditeurScientifiqueNom() {
        return editeurScientifiqueNom;
    }

    /**
     * Définit la valeur de la propriété editeurScientifiqueNom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditeurScientifiqueNom(String value) {
        this.editeurScientifiqueNom = value;
    }

    /**
     * Obtient la valeur de la propriété etabDiffuseurPolEtablissement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtabDiffuseurPolEtablissement() {
        return etabDiffuseurPolEtablissement;
    }

    /**
     * Définit la valeur de la propriété etabDiffuseurPolEtablissement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtabDiffuseurPolEtablissement(String value) {
        this.etabDiffuseurPolEtablissement = value;
    }

}
