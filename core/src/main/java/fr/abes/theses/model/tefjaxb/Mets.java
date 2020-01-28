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
 *         &lt;element ref="{http://www.loc.gov/METS/}dmdSec" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}amdSec"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}fileSec"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}structMap"/&gt;
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
    "dmdSec",
    "amdSec",
    "fileSec",
    "structMap"
})
@XmlRootElement(name = "mets", namespace = "http://www.loc.gov/METS/")
public class Mets {

    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected List<DmdSec> dmdSec;
    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected AmdSec amdSec;
    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected FileSec fileSec;
    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected StructMap structMap;

    /**
     * Gets the value of the dmdSec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dmdSec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDmdSec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DmdSec }
     * 
     * 
     */
    public List<DmdSec> getDmdSec() {
        if (dmdSec == null) {
            dmdSec = new ArrayList<DmdSec>();
        }
        return this.dmdSec;
    }

    /**
     * Obtient la valeur de la propriété amdSec.
     * 
     * @return
     *     possible object is
     *     {@link AmdSec }
     *     
     */
    public AmdSec getAmdSec() {
        return amdSec;
    }

    /**
     * Définit la valeur de la propriété amdSec.
     * 
     * @param value
     *     allowed object is
     *     {@link AmdSec }
     *     
     */
    public void setAmdSec(AmdSec value) {
        this.amdSec = value;
    }

    /**
     * Obtient la valeur de la propriété fileSec.
     * 
     * @return
     *     possible object is
     *     {@link FileSec }
     *     
     */
    public FileSec getFileSec() {
        return fileSec;
    }

    /**
     * Définit la valeur de la propriété fileSec.
     * 
     * @param value
     *     allowed object is
     *     {@link FileSec }
     *     
     */
    public void setFileSec(FileSec value) {
        this.fileSec = value;
    }

    /**
     * Obtient la valeur de la propriété structMap.
     * 
     * @return
     *     possible object is
     *     {@link StructMap }
     *     
     */
    public StructMap getStructMap() {
        return structMap;
    }

    /**
     * Définit la valeur de la propriété structMap.
     * 
     * @param value
     *     allowed object is
     *     {@link StructMap }
     *     
     */
    public void setStructMap(StructMap value) {
        this.structMap = value;
    }

}
