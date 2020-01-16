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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}auteur"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}identifier" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://purl.org/dc/terms/}dateAccepted"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesis.degree"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}theseSurTravaux"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}avisJury"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}directeurThese"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}presidentJury"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}membreJury" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}rapporteur" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}ecoleDoctorale"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}partenaireRecherche" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}oaiSetSpec"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}MADSAuthority" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "auteur",
    "identifier",
    "dateAccepted",
    "thesisDegree",
    "theseSurTravaux",
    "avisJury",
    "directeurThese",
    "presidentJury",
    "membreJury",
    "rapporteur",
    "ecoleDoctorale",
    "partenaireRecherche",
    "oaiSetSpec",
    "madsAuthority"
})
@XmlRootElement(name = "thesisAdmin")
public class ThesisAdmin {

    @XmlElement(required = true)
    protected Auteur auteur;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> identifier;
    @XmlElement(namespace = "http://purl.org/dc/terms/", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateAccepted;
    @XmlElement(name = "thesis.degree", required = true)
    protected ThesisDegree thesisDegree;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String theseSurTravaux;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String avisJury;
    @XmlElement(required = true)
    protected DirecteurThese directeurThese;
    @XmlElement(required = true)
    protected PresidentJury presidentJury;
    @XmlElement(required = true)
    protected List<MembreJury> membreJury;
    @XmlElement(required = true)
    protected List<Rapporteur> rapporteur;
    @XmlElement(required = true)
    protected EcoleDoctorale ecoleDoctorale;
    @XmlElement(required = true)
    protected List<PartenaireRecherche> partenaireRecherche;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String oaiSetSpec;
    @XmlElement(name = "MADSAuthority", required = true)
    protected List<MADSAuthority> madsAuthority;

    /**
     * Obtient la valeur de la propriété auteur.
     * 
     * @return
     *     possible object is
     *     {@link Auteur }
     *     
     */
    public Auteur getAuteur() {
        return auteur;
    }

    /**
     * Définit la valeur de la propriété auteur.
     * 
     * @param value
     *     allowed object is
     *     {@link Auteur }
     *     
     */
    public void setAuteur(Auteur value) {
        this.auteur = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdentifier() {
        if (identifier == null) {
            identifier = new ArrayList<String>();
        }
        return this.identifier;
    }

    /**
     * Obtient la valeur de la propriété dateAccepted.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAccepted() {
        return dateAccepted;
    }

    /**
     * Définit la valeur de la propriété dateAccepted.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAccepted(XMLGregorianCalendar value) {
        this.dateAccepted = value;
    }

    /**
     * Obtient la valeur de la propriété thesisDegree.
     * 
     * @return
     *     possible object is
     *     {@link ThesisDegree }
     *     
     */
    public ThesisDegree getThesisDegree() {
        return thesisDegree;
    }

    /**
     * Définit la valeur de la propriété thesisDegree.
     * 
     * @param value
     *     allowed object is
     *     {@link ThesisDegree }
     *     
     */
    public void setThesisDegree(ThesisDegree value) {
        this.thesisDegree = value;
    }

    /**
     * Obtient la valeur de la propriété theseSurTravaux.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheseSurTravaux() {
        return theseSurTravaux;
    }

    /**
     * Définit la valeur de la propriété theseSurTravaux.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheseSurTravaux(String value) {
        this.theseSurTravaux = value;
    }

    /**
     * Obtient la valeur de la propriété avisJury.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvisJury() {
        return avisJury;
    }

    /**
     * Définit la valeur de la propriété avisJury.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvisJury(String value) {
        this.avisJury = value;
    }

    /**
     * Obtient la valeur de la propriété directeurThese.
     * 
     * @return
     *     possible object is
     *     {@link DirecteurThese }
     *     
     */
    public DirecteurThese getDirecteurThese() {
        return directeurThese;
    }

    /**
     * Définit la valeur de la propriété directeurThese.
     * 
     * @param value
     *     allowed object is
     *     {@link DirecteurThese }
     *     
     */
    public void setDirecteurThese(DirecteurThese value) {
        this.directeurThese = value;
    }

    /**
     * Obtient la valeur de la propriété presidentJury.
     * 
     * @return
     *     possible object is
     *     {@link PresidentJury }
     *     
     */
    public PresidentJury getPresidentJury() {
        return presidentJury;
    }

    /**
     * Définit la valeur de la propriété presidentJury.
     * 
     * @param value
     *     allowed object is
     *     {@link PresidentJury }
     *     
     */
    public void setPresidentJury(PresidentJury value) {
        this.presidentJury = value;
    }

    /**
     * Gets the value of the membreJury property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the membreJury property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMembreJury().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MembreJury }
     * 
     * 
     */
    public List<MembreJury> getMembreJury() {
        if (membreJury == null) {
            membreJury = new ArrayList<MembreJury>();
        }
        return this.membreJury;
    }

    /**
     * Gets the value of the rapporteur property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rapporteur property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRapporteur().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rapporteur }
     * 
     * 
     */
    public List<Rapporteur> getRapporteur() {
        if (rapporteur == null) {
            rapporteur = new ArrayList<Rapporteur>();
        }
        return this.rapporteur;
    }

    /**
     * Obtient la valeur de la propriété ecoleDoctorale.
     * 
     * @return
     *     possible object is
     *     {@link EcoleDoctorale }
     *     
     */
    public EcoleDoctorale getEcoleDoctorale() {
        return ecoleDoctorale;
    }

    /**
     * Définit la valeur de la propriété ecoleDoctorale.
     * 
     * @param value
     *     allowed object is
     *     {@link EcoleDoctorale }
     *     
     */
    public void setEcoleDoctorale(EcoleDoctorale value) {
        this.ecoleDoctorale = value;
    }

    /**
     * Gets the value of the partenaireRecherche property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partenaireRecherche property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartenaireRecherche().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartenaireRecherche }
     * 
     * 
     */
    public List<PartenaireRecherche> getPartenaireRecherche() {
        if (partenaireRecherche == null) {
            partenaireRecherche = new ArrayList<PartenaireRecherche>();
        }
        return this.partenaireRecherche;
    }

    /**
     * Obtient la valeur de la propriété oaiSetSpec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOaiSetSpec() {
        return oaiSetSpec;
    }

    /**
     * Définit la valeur de la propriété oaiSetSpec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOaiSetSpec(String value) {
        this.oaiSetSpec = value;
    }

    /**
     * Gets the value of the madsAuthority property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the madsAuthority property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMADSAuthority().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MADSAuthority }
     * 
     * 
     */
    public List<MADSAuthority> getMADSAuthority() {
        if (madsAuthority == null) {
            madsAuthority = new ArrayList<MADSAuthority>();
        }
        return this.madsAuthority;
    }

}
