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
 *         &lt;element ref="{http://www.loc.gov/METS/}techMD" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}rightsMD" maxOccurs="unbounded"/&gt;
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
    "techMD",
    "rightsMD"
})
@XmlRootElement(name = "amdSec", namespace = "http://www.loc.gov/METS/")
public class AmdSec {

    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected List<TechMD> techMD;
    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected List<RightsMD> rightsMD;

    /**
     * Gets the value of the techMD property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the techMD property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechMD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechMD }
     * 
     * 
     */
    public List<TechMD> getTechMD() {
        if (techMD == null) {
            techMD = new ArrayList<TechMD>();
        }
        return this.techMD;
    }

    /**
     * Gets the value of the rightsMD property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rightsMD property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRightsMD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RightsMD }
     * 
     * 
     */
    public List<RightsMD> getRightsMD() {
        if (rightsMD == null) {
            rightsMD = new ArrayList<RightsMD>();
        }
        return this.rightsMD;
    }

}
