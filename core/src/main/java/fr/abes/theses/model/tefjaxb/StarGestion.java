//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.19 à 03:54:21 PM CET 
//


package fr.abes.theses.model.tefjaxb;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}traitements"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}workflow"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ID_THESE" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="codeEtab" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="enProd" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="etat" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="libEtab" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="ppnEtab" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="scenarioEtab" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "traitements",
    "workflow"
})
@XmlRootElement(name = "star_gestion")
public class StarGestion {

    @XmlElement(required = true)
    protected Traitements traitements;
    @XmlElement(required = true)
    protected Workflow workflow;
    @XmlAttribute(name = "ID_THESE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String idthese;
    @XmlAttribute(name = "codeEtab", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codeEtab;
    @XmlAttribute(name = "enProd", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String enProd;
    @XmlAttribute(name = "etat", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etat;
    @XmlAttribute(name = "libEtab", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String libEtab;
    @XmlAttribute(name = "ppnEtab", required = true)
    protected BigInteger ppnEtab;
    @XmlAttribute(name = "scenarioEtab", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String scenarioEtab;

    /**
     * Obtient la valeur de la propriété traitements.
     * 
     * @return
     *     possible object is
     *     {@link Traitements }
     *     
     */
    public Traitements getTraitements() {
        return traitements;
    }

    /**
     * Définit la valeur de la propriété traitements.
     * 
     * @param value
     *     allowed object is
     *     {@link Traitements }
     *     
     */
    public void setTraitements(Traitements value) {
        this.traitements = value;
    }

    /**
     * Obtient la valeur de la propriété workflow.
     * 
     * @return
     *     possible object is
     *     {@link Workflow }
     *     
     */
    public Workflow getWorkflow() {
        return workflow;
    }

    /**
     * Définit la valeur de la propriété workflow.
     * 
     * @param value
     *     allowed object is
     *     {@link Workflow }
     *     
     */
    public void setWorkflow(Workflow value) {
        this.workflow = value;
    }

    /**
     * Obtient la valeur de la propriété idthese.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDTHESE() {
        return idthese;
    }

    /**
     * Définit la valeur de la propriété idthese.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDTHESE(String value) {
        this.idthese = value;
    }

    /**
     * Obtient la valeur de la propriété codeEtab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtab() {
        return codeEtab;
    }

    /**
     * Définit la valeur de la propriété codeEtab.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtab(String value) {
        this.codeEtab = value;
    }

    /**
     * Obtient la valeur de la propriété enProd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnProd() {
        return enProd;
    }

    /**
     * Définit la valeur de la propriété enProd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnProd(String value) {
        this.enProd = value;
    }

    /**
     * Obtient la valeur de la propriété etat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Définit la valeur de la propriété etat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtat(String value) {
        this.etat = value;
    }

    /**
     * Obtient la valeur de la propriété libEtab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtab() {
        return libEtab;
    }

    /**
     * Définit la valeur de la propriété libEtab.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtab(String value) {
        this.libEtab = value;
    }

    /**
     * Obtient la valeur de la propriété ppnEtab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPpnEtab() {
        return ppnEtab;
    }

    /**
     * Définit la valeur de la propriété ppnEtab.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPpnEtab(BigInteger value) {
        this.ppnEtab = value;
    }

    /**
     * Obtient la valeur de la propriété scenarioEtab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScenarioEtab() {
        return scenarioEtab;
    }

    /**
     * Définit la valeur de la propriété scenarioEtab.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScenarioEtab(String value) {
        this.scenarioEtab = value;
    }

}
