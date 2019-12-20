//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.19 à 03:54:21 PM CET 
//


package fr.abes.theses.model.tefjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;choice&gt;
 *         &lt;element ref="{http://cosimo.stanford.edu/sdr/metsrights/}RightsDeclarationMD"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}edition"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}meta_fichier"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}ressourceExterneDescription"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}star_gestion"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesisAdmin"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesisRecord"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}version"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rightsDeclarationMD",
    "edition",
    "metaFichier",
    "ressourceExterneDescription",
    "starGestion",
    "thesisAdmin",
    "thesisRecord",
    "version"
})
@XmlRootElement(name = "xmlData", namespace = "http://www.loc.gov/METS/")
public class XmlData {

    @XmlElement(name = "RightsDeclarationMD", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
    protected RightsDeclarationMD rightsDeclarationMD;
    protected Edition edition;
    @XmlElement(name = "meta_fichier")
    protected MetaFichier metaFichier;
    protected RessourceExterneDescription ressourceExterneDescription;
    @XmlElement(name = "star_gestion")
    protected StarGestion starGestion;
    protected ThesisAdmin thesisAdmin;
    protected ThesisRecord thesisRecord;
    protected Version version;

    /**
     * Obtient la valeur de la propriété rightsDeclarationMD.
     * 
     * @return
     *     possible object is
     *     {@link RightsDeclarationMD }
     *     
     */
    public RightsDeclarationMD getRightsDeclarationMD() {
        return rightsDeclarationMD;
    }

    /**
     * Définit la valeur de la propriété rightsDeclarationMD.
     * 
     * @param value
     *     allowed object is
     *     {@link RightsDeclarationMD }
     *     
     */
    public void setRightsDeclarationMD(RightsDeclarationMD value) {
        this.rightsDeclarationMD = value;
    }

    /**
     * Obtient la valeur de la propriété edition.
     * 
     * @return
     *     possible object is
     *     {@link Edition }
     *     
     */
    public Edition getEdition() {
        return edition;
    }

    /**
     * Définit la valeur de la propriété edition.
     * 
     * @param value
     *     allowed object is
     *     {@link Edition }
     *     
     */
    public void setEdition(Edition value) {
        this.edition = value;
    }

    /**
     * Obtient la valeur de la propriété metaFichier.
     * 
     * @return
     *     possible object is
     *     {@link MetaFichier }
     *     
     */
    public MetaFichier getMetaFichier() {
        return metaFichier;
    }

    /**
     * Définit la valeur de la propriété metaFichier.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaFichier }
     *     
     */
    public void setMetaFichier(MetaFichier value) {
        this.metaFichier = value;
    }

    /**
     * Obtient la valeur de la propriété ressourceExterneDescription.
     * 
     * @return
     *     possible object is
     *     {@link RessourceExterneDescription }
     *     
     */
    public RessourceExterneDescription getRessourceExterneDescription() {
        return ressourceExterneDescription;
    }

    /**
     * Définit la valeur de la propriété ressourceExterneDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link RessourceExterneDescription }
     *     
     */
    public void setRessourceExterneDescription(RessourceExterneDescription value) {
        this.ressourceExterneDescription = value;
    }

    /**
     * Obtient la valeur de la propriété starGestion.
     * 
     * @return
     *     possible object is
     *     {@link StarGestion }
     *     
     */
    public StarGestion getStarGestion() {
        return starGestion;
    }

    /**
     * Définit la valeur de la propriété starGestion.
     * 
     * @param value
     *     allowed object is
     *     {@link StarGestion }
     *     
     */
    public void setStarGestion(StarGestion value) {
        this.starGestion = value;
    }

    /**
     * Obtient la valeur de la propriété thesisAdmin.
     * 
     * @return
     *     possible object is
     *     {@link ThesisAdmin }
     *     
     */
    public ThesisAdmin getThesisAdmin() {
        return thesisAdmin;
    }

    /**
     * Définit la valeur de la propriété thesisAdmin.
     * 
     * @param value
     *     allowed object is
     *     {@link ThesisAdmin }
     *     
     */
    public void setThesisAdmin(ThesisAdmin value) {
        this.thesisAdmin = value;
    }

    /**
     * Obtient la valeur de la propriété thesisRecord.
     * 
     * @return
     *     possible object is
     *     {@link ThesisRecord }
     *     
     */
    public ThesisRecord getThesisRecord() {
        return thesisRecord;
    }

    /**
     * Définit la valeur de la propriété thesisRecord.
     * 
     * @param value
     *     allowed object is
     *     {@link ThesisRecord }
     *     
     */
    public void setThesisRecord(ThesisRecord value) {
        this.thesisRecord = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Définit la valeur de la propriété version.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setVersion(Version value) {
        this.version = value;
    }

}
