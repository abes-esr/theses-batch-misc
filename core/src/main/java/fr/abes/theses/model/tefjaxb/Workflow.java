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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}commentaires"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}DOCT"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}rolesMD"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}VALID"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="etatWF" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "commentaires",
    "doct",
    "rolesMD",
    "valid"
})
@XmlRootElement(name = "workflow")
public class Workflow {

    @XmlElement(required = true)
    protected Commentaires commentaires;
    @XmlElement(name = "DOCT", required = true)
    protected DOCT doct;
    @XmlElement(required = true)
    protected RolesMD rolesMD;
    @XmlElement(name = "VALID", required = true)
    protected VALID valid;
    @XmlAttribute(name = "etatWF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etatWF;

    /**
     * Obtient la valeur de la propriété commentaires.
     * 
     * @return
     *     possible object is
     *     {@link Commentaires }
     *     
     */
    public Commentaires getCommentaires() {
        return commentaires;
    }

    /**
     * Définit la valeur de la propriété commentaires.
     * 
     * @param value
     *     allowed object is
     *     {@link Commentaires }
     *     
     */
    public void setCommentaires(Commentaires value) {
        this.commentaires = value;
    }

    /**
     * Obtient la valeur de la propriété doct.
     * 
     * @return
     *     possible object is
     *     {@link DOCT }
     *     
     */
    public DOCT getDOCT() {
        return doct;
    }

    /**
     * Définit la valeur de la propriété doct.
     * 
     * @param value
     *     allowed object is
     *     {@link DOCT }
     *     
     */
    public void setDOCT(DOCT value) {
        this.doct = value;
    }

    /**
     * Obtient la valeur de la propriété rolesMD.
     * 
     * @return
     *     possible object is
     *     {@link RolesMD }
     *     
     */
    public RolesMD getRolesMD() {
        return rolesMD;
    }

    /**
     * Définit la valeur de la propriété rolesMD.
     * 
     * @param value
     *     allowed object is
     *     {@link RolesMD }
     *     
     */
    public void setRolesMD(RolesMD value) {
        this.rolesMD = value;
    }

    /**
     * Obtient la valeur de la propriété valid.
     * 
     * @return
     *     possible object is
     *     {@link VALID }
     *     
     */
    public VALID getVALID() {
        return valid;
    }

    /**
     * Définit la valeur de la propriété valid.
     * 
     * @param value
     *     allowed object is
     *     {@link VALID }
     *     
     */
    public void setVALID(VALID value) {
        this.valid = value;
    }

    /**
     * Obtient la valeur de la propriété etatWF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatWF() {
        return etatWF;
    }

    /**
     * Définit la valeur de la propriété etatWF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatWF(String value) {
        this.etatWF = value;
    }

}
