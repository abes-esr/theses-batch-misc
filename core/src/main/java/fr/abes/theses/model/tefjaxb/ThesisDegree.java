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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesis.degree.discipline"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesis.degree.grantor" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesis.degree.level"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}thesis.degree.name"/&gt;
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
    "thesisDegreeDiscipline",
    "thesisDegreeGrantor",
    "thesisDegreeLevel",
    "thesisDegreeName"
})
@XmlRootElement(name = "thesis.degree")
public class ThesisDegree {

    @XmlElement(name = "thesis.degree.discipline", required = true)
    protected ThesisDegreeDiscipline thesisDegreeDiscipline;
    @XmlElement(name = "thesis.degree.grantor", required = true)
    protected List<ThesisDegreeGrantor> thesisDegreeGrantor;
    @XmlElement(name = "thesis.degree.level", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String thesisDegreeLevel;
    @XmlElement(name = "thesis.degree.name", required = true)
    protected ThesisDegreeName thesisDegreeName;

    /**
     * Obtient la valeur de la propriété thesisDegreeDiscipline.
     * 
     * @return
     *     possible object is
     *     {@link ThesisDegreeDiscipline }
     *     
     */
    public ThesisDegreeDiscipline getThesisDegreeDiscipline() {
        return thesisDegreeDiscipline;
    }

    /**
     * Définit la valeur de la propriété thesisDegreeDiscipline.
     * 
     * @param value
     *     allowed object is
     *     {@link ThesisDegreeDiscipline }
     *     
     */
    public void setThesisDegreeDiscipline(ThesisDegreeDiscipline value) {
        this.thesisDegreeDiscipline = value;
    }

    /**
     * Gets the value of the thesisDegreeGrantor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thesisDegreeGrantor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThesisDegreeGrantor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThesisDegreeGrantor }
     * 
     * 
     */
    public List<ThesisDegreeGrantor> getThesisDegreeGrantor() {
        if (thesisDegreeGrantor == null) {
            thesisDegreeGrantor = new ArrayList<ThesisDegreeGrantor>();
        }
        return this.thesisDegreeGrantor;
    }

    /**
     * Obtient la valeur de la propriété thesisDegreeLevel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThesisDegreeLevel() {
        return thesisDegreeLevel;
    }

    /**
     * Définit la valeur de la propriété thesisDegreeLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThesisDegreeLevel(String value) {
        this.thesisDegreeLevel = value;
    }

    /**
     * Obtient la valeur de la propriété thesisDegreeName.
     * 
     * @return
     *     possible object is
     *     {@link ThesisDegreeName }
     *     
     */
    public ThesisDegreeName getThesisDegreeName() {
        return thesisDegreeName;
    }

    /**
     * Définit la valeur de la propriété thesisDegreeName.
     * 
     * @param value
     *     allowed object is
     *     {@link ThesisDegreeName }
     *     
     */
    public void setThesisDegreeName(ThesisDegreeName value) {
        this.thesisDegreeName = value;
    }

}
