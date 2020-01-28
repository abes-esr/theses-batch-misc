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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}entree"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}maj"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}facile"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}ctrlUrl"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}remonteeArchive"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}purge"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}invalidation"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}sorties"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="scenario" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entree",
    "maj",
    "facile",
    "ctrlUrl",
    "remonteeArchive",
    "purge",
    "invalidation",
    "sorties"
})
@XmlRootElement(name = "traitements")
public class Traitements {

    @XmlElement(required = true)
    protected Entree entree;
    @XmlElement(required = true)
    protected Maj maj;
    @XmlElement(required = true)
    protected Facile facile;
    @XmlElement(required = true)
    protected CtrlUrl ctrlUrl;
    @XmlElement(required = true)
    protected RemonteeArchive remonteeArchive;
    @XmlElement(required = true)
    protected Purge purge;
    @XmlElement(required = true)
    protected Invalidation invalidation;
    @XmlElement(required = true)
    protected Sorties sorties;
    @XmlAttribute(name = "scenario", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String scenario;

    /**
     * Obtient la valeur de la propriété entree.
     * 
     * @return
     *     possible object is
     *     {@link Entree }
     *     
     */
    public Entree getEntree() {
        return entree;
    }

    /**
     * Définit la valeur de la propriété entree.
     * 
     * @param value
     *     allowed object is
     *     {@link Entree }
     *     
     */
    public void setEntree(Entree value) {
        this.entree = value;
    }

    /**
     * Obtient la valeur de la propriété maj.
     * 
     * @return
     *     possible object is
     *     {@link Maj }
     *     
     */
    public Maj getMaj() {
        return maj;
    }

    /**
     * Définit la valeur de la propriété maj.
     * 
     * @param value
     *     allowed object is
     *     {@link Maj }
     *     
     */
    public void setMaj(Maj value) {
        this.maj = value;
    }

    /**
     * Obtient la valeur de la propriété facile.
     * 
     * @return
     *     possible object is
     *     {@link Facile }
     *     
     */
    public Facile getFacile() {
        return facile;
    }

    /**
     * Définit la valeur de la propriété facile.
     * 
     * @param value
     *     allowed object is
     *     {@link Facile }
     *     
     */
    public void setFacile(Facile value) {
        this.facile = value;
    }

    /**
     * Obtient la valeur de la propriété ctrlUrl.
     * 
     * @return
     *     possible object is
     *     {@link CtrlUrl }
     *     
     */
    public CtrlUrl getCtrlUrl() {
        return ctrlUrl;
    }

    /**
     * Définit la valeur de la propriété ctrlUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link CtrlUrl }
     *     
     */
    public void setCtrlUrl(CtrlUrl value) {
        this.ctrlUrl = value;
    }

    /**
     * Obtient la valeur de la propriété remonteeArchive.
     * 
     * @return
     *     possible object is
     *     {@link RemonteeArchive }
     *     
     */
    public RemonteeArchive getRemonteeArchive() {
        return remonteeArchive;
    }

    /**
     * Définit la valeur de la propriété remonteeArchive.
     * 
     * @param value
     *     allowed object is
     *     {@link RemonteeArchive }
     *     
     */
    public void setRemonteeArchive(RemonteeArchive value) {
        this.remonteeArchive = value;
    }

    /**
     * Obtient la valeur de la propriété purge.
     * 
     * @return
     *     possible object is
     *     {@link Purge }
     *     
     */
    public Purge getPurge() {
        return purge;
    }

    /**
     * Définit la valeur de la propriété purge.
     * 
     * @param value
     *     allowed object is
     *     {@link Purge }
     *     
     */
    public void setPurge(Purge value) {
        this.purge = value;
    }

    /**
     * Obtient la valeur de la propriété invalidation.
     * 
     * @return
     *     possible object is
     *     {@link Invalidation }
     *     
     */
    public Invalidation getInvalidation() {
        return invalidation;
    }

    /**
     * Définit la valeur de la propriété invalidation.
     * 
     * @param value
     *     allowed object is
     *     {@link Invalidation }
     *     
     */
    public void setInvalidation(Invalidation value) {
        this.invalidation = value;
    }

    /**
     * Obtient la valeur de la propriété sorties.
     * 
     * @return
     *     possible object is
     *     {@link Sorties }
     *     
     */
    public Sorties getSorties() {
        return sorties;
    }

    /**
     * Définit la valeur de la propriété sorties.
     * 
     * @param value
     *     allowed object is
     *     {@link Sorties }
     *     
     */
    public void setSorties(Sorties value) {
        this.sorties = value;
    }

    /**
     * Obtient la valeur de la propriété scenario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScenario() {
        return scenario;
    }

    /**
     * Définit la valeur de la propriété scenario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScenario(String value) {
        this.scenario = value;
    }

}
