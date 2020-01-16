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
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}SCOL"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}BIBL"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}FICH"/&gt;
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
    "scol",
    "bibl",
    "fich"
})
@XmlRootElement(name = "rolesMD")
public class RolesMD {

    @XmlElement(name = "SCOL", required = true)
    protected SCOL scol;
    @XmlElement(name = "BIBL", required = true)
    protected BIBL bibl;
    @XmlElement(name = "FICH", required = true)
    protected FICH fich;

    /**
     * Obtient la valeur de la propriété scol.
     * 
     * @return
     *     possible object is
     *     {@link SCOL }
     *     
     */
    public SCOL getSCOL() {
        return scol;
    }

    /**
     * Définit la valeur de la propriété scol.
     * 
     * @param value
     *     allowed object is
     *     {@link SCOL }
     *     
     */
    public void setSCOL(SCOL value) {
        this.scol = value;
    }

    /**
     * Obtient la valeur de la propriété bibl.
     * 
     * @return
     *     possible object is
     *     {@link BIBL }
     *     
     */
    public BIBL getBIBL() {
        return bibl;
    }

    /**
     * Définit la valeur de la propriété bibl.
     * 
     * @param value
     *     allowed object is
     *     {@link BIBL }
     *     
     */
    public void setBIBL(BIBL value) {
        this.bibl = value;
    }

    /**
     * Obtient la valeur de la propriété fich.
     * 
     * @return
     *     possible object is
     *     {@link FICH }
     *     
     */
    public FICH getFICH() {
        return fich;
    }

    /**
     * Définit la valeur de la propriété fich.
     * 
     * @param value
     *     allowed object is
     *     {@link FICH }
     *     
     */
    public void setFICH(FICH value) {
        this.fich = value;
    }

}
