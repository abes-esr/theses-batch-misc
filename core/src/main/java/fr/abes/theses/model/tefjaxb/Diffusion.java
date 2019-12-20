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
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}etabDiffuseur"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}abesDiffuseur"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}ccsd"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}autresEtabDiffuseurs"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}oai"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="confidentialiteFin" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="conformitePolDiffusion" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="embargoFin" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="restrictionTemporelleFin" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="restrictionTemporelleType" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="typeDiffusion" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="urlPerenne" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "etabDiffuseur",
    "abesDiffuseur",
    "ccsd",
    "autresEtabDiffuseurs",
    "oai"
})
@XmlRootElement(name = "diffusion")
public class Diffusion {

    @XmlElement(required = true)
    protected EtabDiffuseur etabDiffuseur;
    @XmlElement(required = true)
    protected AbesDiffuseur abesDiffuseur;
    @XmlElement(required = true)
    protected Ccsd ccsd;
    @XmlElement(required = true)
    protected AutresEtabDiffuseurs autresEtabDiffuseurs;
    @XmlElement(required = true)
    protected Oai oai;
    @XmlAttribute(name = "confidentialiteFin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar confidentialiteFin;
    @XmlAttribute(name = "conformitePolDiffusion", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String conformitePolDiffusion;
    @XmlAttribute(name = "embargoFin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar embargoFin;
    @XmlAttribute(name = "restrictionTemporelleFin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar restrictionTemporelleFin;
    @XmlAttribute(name = "restrictionTemporelleType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String restrictionTemporelleType;
    @XmlAttribute(name = "typeDiffusion", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String typeDiffusion;
    @XmlAttribute(name = "urlPerenne", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String urlPerenne;

    /**
     * Obtient la valeur de la propriété etabDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link EtabDiffuseur }
     *     
     */
    public EtabDiffuseur getEtabDiffuseur() {
        return etabDiffuseur;
    }

    /**
     * Définit la valeur de la propriété etabDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link EtabDiffuseur }
     *     
     */
    public void setEtabDiffuseur(EtabDiffuseur value) {
        this.etabDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété abesDiffuseur.
     * 
     * @return
     *     possible object is
     *     {@link AbesDiffuseur }
     *     
     */
    public AbesDiffuseur getAbesDiffuseur() {
        return abesDiffuseur;
    }

    /**
     * Définit la valeur de la propriété abesDiffuseur.
     * 
     * @param value
     *     allowed object is
     *     {@link AbesDiffuseur }
     *     
     */
    public void setAbesDiffuseur(AbesDiffuseur value) {
        this.abesDiffuseur = value;
    }

    /**
     * Obtient la valeur de la propriété ccsd.
     * 
     * @return
     *     possible object is
     *     {@link Ccsd }
     *     
     */
    public Ccsd getCcsd() {
        return ccsd;
    }

    /**
     * Définit la valeur de la propriété ccsd.
     * 
     * @param value
     *     allowed object is
     *     {@link Ccsd }
     *     
     */
    public void setCcsd(Ccsd value) {
        this.ccsd = value;
    }

    /**
     * Obtient la valeur de la propriété autresEtabDiffuseurs.
     * 
     * @return
     *     possible object is
     *     {@link AutresEtabDiffuseurs }
     *     
     */
    public AutresEtabDiffuseurs getAutresEtabDiffuseurs() {
        return autresEtabDiffuseurs;
    }

    /**
     * Définit la valeur de la propriété autresEtabDiffuseurs.
     * 
     * @param value
     *     allowed object is
     *     {@link AutresEtabDiffuseurs }
     *     
     */
    public void setAutresEtabDiffuseurs(AutresEtabDiffuseurs value) {
        this.autresEtabDiffuseurs = value;
    }

    /**
     * Obtient la valeur de la propriété oai.
     * 
     * @return
     *     possible object is
     *     {@link Oai }
     *     
     */
    public Oai getOai() {
        return oai;
    }

    /**
     * Définit la valeur de la propriété oai.
     * 
     * @param value
     *     allowed object is
     *     {@link Oai }
     *     
     */
    public void setOai(Oai value) {
        this.oai = value;
    }

    /**
     * Obtient la valeur de la propriété confidentialiteFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConfidentialiteFin() {
        return confidentialiteFin;
    }

    /**
     * Définit la valeur de la propriété confidentialiteFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConfidentialiteFin(XMLGregorianCalendar value) {
        this.confidentialiteFin = value;
    }

    /**
     * Obtient la valeur de la propriété conformitePolDiffusion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConformitePolDiffusion() {
        return conformitePolDiffusion;
    }

    /**
     * Définit la valeur de la propriété conformitePolDiffusion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConformitePolDiffusion(String value) {
        this.conformitePolDiffusion = value;
    }

    /**
     * Obtient la valeur de la propriété embargoFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEmbargoFin() {
        return embargoFin;
    }

    /**
     * Définit la valeur de la propriété embargoFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEmbargoFin(XMLGregorianCalendar value) {
        this.embargoFin = value;
    }

    /**
     * Obtient la valeur de la propriété restrictionTemporelleFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRestrictionTemporelleFin() {
        return restrictionTemporelleFin;
    }

    /**
     * Définit la valeur de la propriété restrictionTemporelleFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRestrictionTemporelleFin(XMLGregorianCalendar value) {
        this.restrictionTemporelleFin = value;
    }

    /**
     * Obtient la valeur de la propriété restrictionTemporelleType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictionTemporelleType() {
        return restrictionTemporelleType;
    }

    /**
     * Définit la valeur de la propriété restrictionTemporelleType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictionTemporelleType(String value) {
        this.restrictionTemporelleType = value;
    }

    /**
     * Obtient la valeur de la propriété typeDiffusion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeDiffusion() {
        return typeDiffusion;
    }

    /**
     * Définit la valeur de la propriété typeDiffusion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeDiffusion(String value) {
        this.typeDiffusion = value;
    }

    /**
     * Obtient la valeur de la propriété urlPerenne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPerenne() {
        return urlPerenne;
    }

    /**
     * Définit la valeur de la propriété urlPerenne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPerenne(String value) {
        this.urlPerenne = value;
    }

}
