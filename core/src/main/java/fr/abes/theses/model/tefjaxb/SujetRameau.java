//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauPersonne" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauCollectivite"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauFamille"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauAuteurTitre"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauTitre"/&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauNomCommun"/&gt;
 *           &lt;element ref="{http://www.abes.fr/abes/documents/tef}vedetteRameauNomGeographique"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang use="required""/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vedetteRameauPersonne",
    "vedetteRameauCollectivite",
    "vedetteRameauFamille",
    "vedetteRameauAuteurTitre",
    "vedetteRameauTitre",
    "vedetteRameauNomCommunOrVedetteRameauNomGeographique"
})
@XmlRootElement(name = "sujetRameau")
public class SujetRameau {

    @XmlElement(required = true)
    protected List<VedetteRameauPersonne> vedetteRameauPersonne;
    @XmlElement(required = true)
    protected VedetteRameauCollectivite vedetteRameauCollectivite;
    @XmlElement(required = true)
    protected VedetteRameauFamille vedetteRameauFamille;
    @XmlElement(required = true)
    protected VedetteRameauAuteurTitre vedetteRameauAuteurTitre;
    @XmlElement(required = true)
    protected VedetteRameauTitre vedetteRameauTitre;
    @XmlElements({
        @XmlElement(name = "vedetteRameauNomCommun", type = VedetteRameauNomCommun.class),
        @XmlElement(name = "vedetteRameauNomGeographique", type = VedetteRameauNomGeographique.class)
    })
    protected List<Object> vedetteRameauNomCommunOrVedetteRameauNomGeographique;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lang;

    /**
     * Gets the value of the vedetteRameauPersonne property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vedetteRameauPersonne property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVedetteRameauPersonne().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VedetteRameauPersonne }
     * 
     * 
     */
    public List<VedetteRameauPersonne> getVedetteRameauPersonne() {
        if (vedetteRameauPersonne == null) {
            vedetteRameauPersonne = new ArrayList<VedetteRameauPersonne>();
        }
        return this.vedetteRameauPersonne;
    }

    /**
     * Obtient la valeur de la propriété vedetteRameauCollectivite.
     * 
     * @return
     *     possible object is
     *     {@link VedetteRameauCollectivite }
     *     
     */
    public VedetteRameauCollectivite getVedetteRameauCollectivite() {
        return vedetteRameauCollectivite;
    }

    /**
     * Définit la valeur de la propriété vedetteRameauCollectivite.
     * 
     * @param value
     *     allowed object is
     *     {@link VedetteRameauCollectivite }
     *     
     */
    public void setVedetteRameauCollectivite(VedetteRameauCollectivite value) {
        this.vedetteRameauCollectivite = value;
    }

    /**
     * Obtient la valeur de la propriété vedetteRameauFamille.
     * 
     * @return
     *     possible object is
     *     {@link VedetteRameauFamille }
     *     
     */
    public VedetteRameauFamille getVedetteRameauFamille() {
        return vedetteRameauFamille;
    }

    /**
     * Définit la valeur de la propriété vedetteRameauFamille.
     * 
     * @param value
     *     allowed object is
     *     {@link VedetteRameauFamille }
     *     
     */
    public void setVedetteRameauFamille(VedetteRameauFamille value) {
        this.vedetteRameauFamille = value;
    }

    /**
     * Obtient la valeur de la propriété vedetteRameauAuteurTitre.
     * 
     * @return
     *     possible object is
     *     {@link VedetteRameauAuteurTitre }
     *     
     */
    public VedetteRameauAuteurTitre getVedetteRameauAuteurTitre() {
        return vedetteRameauAuteurTitre;
    }

    /**
     * Définit la valeur de la propriété vedetteRameauAuteurTitre.
     * 
     * @param value
     *     allowed object is
     *     {@link VedetteRameauAuteurTitre }
     *     
     */
    public void setVedetteRameauAuteurTitre(VedetteRameauAuteurTitre value) {
        this.vedetteRameauAuteurTitre = value;
    }

    /**
     * Obtient la valeur de la propriété vedetteRameauTitre.
     * 
     * @return
     *     possible object is
     *     {@link VedetteRameauTitre }
     *     
     */
    public VedetteRameauTitre getVedetteRameauTitre() {
        return vedetteRameauTitre;
    }

    /**
     * Définit la valeur de la propriété vedetteRameauTitre.
     * 
     * @param value
     *     allowed object is
     *     {@link VedetteRameauTitre }
     *     
     */
    public void setVedetteRameauTitre(VedetteRameauTitre value) {
        this.vedetteRameauTitre = value;
    }

    /**
     * Gets the value of the vedetteRameauNomCommunOrVedetteRameauNomGeographique property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vedetteRameauNomCommunOrVedetteRameauNomGeographique property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVedetteRameauNomCommunOrVedetteRameauNomGeographique().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VedetteRameauNomCommun }
     * {@link VedetteRameauNomGeographique }
     * 
     * 
     */
    public List<Object> getVedetteRameauNomCommunOrVedetteRameauNomGeographique() {
        if (vedetteRameauNomCommunOrVedetteRameauNomGeographique == null) {
            vedetteRameauNomCommunOrVedetteRameauNomGeographique = new ArrayList<Object>();
        }
        return this.vedetteRameauNomCommunOrVedetteRameauNomGeographique;
    }

    /**
     * Obtient la valeur de la propriété lang.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Définit la valeur de la propriété lang.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
