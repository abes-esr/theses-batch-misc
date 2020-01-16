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
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}title"/&gt;
 *         &lt;element ref="{http://purl.org/dc/terms/}alternative"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}subject" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}sujetRameau"/&gt;
 *         &lt;element ref="{http://purl.org/dc/terms/}abstract" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}type" maxOccurs="unbounded"/&gt;
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
    "title",
    "alternative",
    "subject",
    "sujetRameau",
    "_abstract",
    "type"
})
@XmlRootElement(name = "thesisRecord")
public class ThesisRecord {

    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected Title title;
    @XmlElement(namespace = "http://purl.org/dc/terms/", required = true)
    protected Alternative alternative;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected List<Subject> subject;
    @XmlElement(required = true)
    protected SujetRameau sujetRameau;
    @XmlElement(name = "abstract", namespace = "http://purl.org/dc/terms/", required = true)
    protected List<Abstract> _abstract;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected List<String> type;

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link Title }
     *     
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link Title }
     *     
     */
    public void setTitle(Title value) {
        this.title = value;
    }

    /**
     * Obtient la valeur de la propriété alternative.
     * 
     * @return
     *     possible object is
     *     {@link Alternative }
     *     
     */
    public Alternative getAlternative() {
        return alternative;
    }

    /**
     * Définit la valeur de la propriété alternative.
     * 
     * @param value
     *     allowed object is
     *     {@link Alternative }
     *     
     */
    public void setAlternative(Alternative value) {
        this.alternative = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subject }
     * 
     * 
     */
    public List<Subject> getSubject() {
        if (subject == null) {
            subject = new ArrayList<Subject>();
        }
        return this.subject;
    }

    /**
     * Obtient la valeur de la propriété sujetRameau.
     * 
     * @return
     *     possible object is
     *     {@link SujetRameau }
     *     
     */
    public SujetRameau getSujetRameau() {
        return sujetRameau;
    }

    /**
     * Définit la valeur de la propriété sujetRameau.
     * 
     * @param value
     *     allowed object is
     *     {@link SujetRameau }
     *     
     */
    public void setSujetRameau(SujetRameau value) {
        this.sujetRameau = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Abstract }
     * 
     * 
     */
    public List<Abstract> getAbstract() {
        if (_abstract == null) {
            _abstract = new ArrayList<Abstract>();
        }
        return this._abstract;
    }

    /**
     * Gets the value of the type property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the type property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getType() {
        if (type == null) {
            type = new ArrayList<String>();
        }
        return this.type;
    }

}
