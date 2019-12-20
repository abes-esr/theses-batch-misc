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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.abes.fr/abes/documents/tef}tef.notes"&gt;
 *       &lt;attribute name="alerteTheseTravaux" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="bilan" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="etatMD" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="indicBilan" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majMD" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "FICH")
public class FICH
    extends TefNotes
{

    @XmlAttribute(name = "alerteTheseTravaux", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String alerteTheseTravaux;
    @XmlAttribute(name = "bilan", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String bilan;
    @XmlAttribute(name = "etatMD", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String etatMD;
    @XmlAttribute(name = "indicBilan", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicBilan;
    @XmlAttribute(name = "majMD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar majMD;

    /**
     * Obtient la valeur de la propriété alerteTheseTravaux.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlerteTheseTravaux() {
        return alerteTheseTravaux;
    }

    /**
     * Définit la valeur de la propriété alerteTheseTravaux.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlerteTheseTravaux(String value) {
        this.alerteTheseTravaux = value;
    }

    /**
     * Obtient la valeur de la propriété bilan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBilan() {
        return bilan;
    }

    /**
     * Définit la valeur de la propriété bilan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBilan(String value) {
        this.bilan = value;
    }

    /**
     * Obtient la valeur de la propriété etatMD.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatMD() {
        return etatMD;
    }

    /**
     * Définit la valeur de la propriété etatMD.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatMD(String value) {
        this.etatMD = value;
    }

    /**
     * Obtient la valeur de la propriété indicBilan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicBilan() {
        return indicBilan;
    }

    /**
     * Définit la valeur de la propriété indicBilan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicBilan(String value) {
        this.indicBilan = value;
    }

    /**
     * Obtient la valeur de la propriété majMD.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMajMD() {
        return majMD;
    }

    /**
     * Définit la valeur de la propriété majMD.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMajMD(XMLGregorianCalendar value) {
        this.majMD = value;
    }

}
