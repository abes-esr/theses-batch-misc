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
 *       &lt;attribute name="FichEtabDiffAbesIntranet" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="abesDiffuseurPolEtablissement" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="dateAbesDiffuseur" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="indicAbesDiffuseur" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majAbesDiffuseur" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="urlAbesDiffuseur" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "abesDiffuseur")
public class AbesDiffuseur {

    @XmlAttribute(name = "FichEtabDiffAbesIntranet", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fichEtabDiffAbesIntranet;
    @XmlAttribute(name = "abesDiffuseurPolEtablissement", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String abesDiffuseurPolEtablissement;
    @XmlAttribute(name = "dateAbesDiffuseur", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dateAbesDiffuseur;
    @XmlAttribute(name = "indicAbesDiffuseur", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicAbesDiffuseur;
    @XmlAttribute(name = "majAbesDiffuseur", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String majAbesDiffuseur;
    @XmlAttribute(name = "urlAbesDiffuseur", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String urlAbesDiffuseur;

    /**
     * Obtient la valeur de la propriété fichEtabDiffAbesIntranet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFichEtabDiffAbesIntranet() {
        return fichEtabDiffAbesIntranet;
    }

    /**
     * Définit la valeur de la propriété fichEtabDiffAbesIntranet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFichEtabDiffAbesIntranet(String value) {
        this.fichEtabDiffAbesIntranet = value;
    }

    /**
     * Obtient la valeur de la propriété abesDiffuseurPolEtablissement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbesDiffuseurPolEtablissement() {
        return abesDiffuseurPolEtablissement;
    }

    /**
     * Définit la valeur de la propriété abesDiffuseurPolEtablissement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbesDiffuseurPolEtablissement(String value) {
        this.abesDiffuseurPolEtablissement = value;
    }

    /**
     * Obtient la valeur de la propriété dateAbesDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateAbesDiffuseur() {
        return dateAbesDiffuseur;
    }

    /**
     * Définit la valeur de la propriété dateAbesDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateAbesDiffuseur(String value) {
        this.dateAbesDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété indicAbesDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicAbesDiffuseur() {
        return indicAbesDiffuseur;
    }

    /**
     * Définit la valeur de la propriété indicAbesDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicAbesDiffuseur(String value) {
        this.indicAbesDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété majAbesDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajAbesDiffuseur() {
        return majAbesDiffuseur;
    }

    /**
     * Définit la valeur de la propriété majAbesDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajAbesDiffuseur(String value) {
        this.majAbesDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété urlAbesDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlAbesDiffuseur() {
        return urlAbesDiffuseur;
    }

    /**
     * Définit la valeur de la propriété urlAbesDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlAbesDiffuseur(String value) {
        this.urlAbesDiffuseur = value;
    }

}
