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
 *       &lt;attribute name="etatDOCT" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="interventionFicheEtablissement" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majDOCT" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "DOCT")
public class DOCT {

    @XmlAttribute(name = "etatDOCT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etatDOCT;
    @XmlAttribute(name = "interventionFicheEtablissement", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String interventionFicheEtablissement;
    @XmlAttribute(name = "majDOCT", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String majDOCT;

    /**
     * Obtient la valeur de la propriété etatDOCT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatDOCT() {
        return etatDOCT;
    }

    /**
     * Définit la valeur de la propriété etatDOCT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatDOCT(String value) {
        this.etatDOCT = value;
    }

    /**
     * Obtient la valeur de la propriété interventionFicheEtablissement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterventionFicheEtablissement() {
        return interventionFicheEtablissement;
    }

    /**
     * Définit la valeur de la propriété interventionFicheEtablissement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterventionFicheEtablissement(String value) {
        this.interventionFicheEtablissement = value;
    }

    /**
     * Obtient la valeur de la propriété majDOCT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajDOCT() {
        return majDOCT;
    }

    /**
     * Définit la valeur de la propriété majDOCT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajDOCT(String value) {
        this.majDOCT = value;
    }

}
