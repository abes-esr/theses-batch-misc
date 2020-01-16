//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.19 à 03:54:21 PM CET 
//


package fr.abes.theses.model.tefjaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}agent" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.loc.gov/METS/}altRecordID"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CREATEDATE" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="LASTMODDATE" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="RECORDSTATUS" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "agent",
    "altRecordID"
})
@XmlRootElement(name = "metsHdr", namespace = "http://www.loc.gov/METS/")
public class MetsHdr {

    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected List<Agent> agent;
    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected AltRecordID altRecordID;
    @XmlAttribute(name = "CREATEDATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdate;
    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "LASTMODDATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastmoddate;
    @XmlAttribute(name = "RECORDSTATUS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String recordstatus;

    /**
     * Gets the value of the agent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Agent }
     * 
     * 
     */
    public List<Agent> getAgent() {
        if (agent == null) {
            agent = new ArrayList<Agent>();
        }
        return this.agent;
    }

    /**
     * Obtient la valeur de la propriété altRecordID.
     * 
     * @return
     *     possible object is
     *     {@link AltRecordID }
     *     
     */
    public AltRecordID getAltRecordID() {
        return altRecordID;
    }

    /**
     * Définit la valeur de la propriété altRecordID.
     * 
     * @param value
     *     allowed object is
     *     {@link AltRecordID }
     *     
     */
    public void setAltRecordID(AltRecordID value) {
        this.altRecordID = value;
    }

    /**
     * Obtient la valeur de la propriété createdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCREATEDATE() {
        return createdate;
    }

    /**
     * Définit la valeur de la propriété createdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCREATEDATE(XMLGregorianCalendar value) {
        this.createdate = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété lastmoddate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLASTMODDATE() {
        return lastmoddate;
    }

    /**
     * Définit la valeur de la propriété lastmoddate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLASTMODDATE(XMLGregorianCalendar value) {
        this.lastmoddate = value;
    }

    /**
     * Obtient la valeur de la propriété recordstatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECORDSTATUS() {
        return recordstatus;
    }

    /**
     * Définit la valeur de la propriété recordstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECORDSTATUS(String value) {
        this.recordstatus = value;
    }

}
