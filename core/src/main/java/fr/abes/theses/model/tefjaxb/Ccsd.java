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
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}domaineCcsd"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}laboCcsd"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}sujetPastel"/&gt;
 *         &lt;element ref="{http://www.abes.fr/abes/documents/tef}fondPastel"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ccsdDiffuseurPolEtablissement" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="dateCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="identifiantCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="indicCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="majCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="numVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="pastel" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="pwdCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="trace" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="urlCcsd" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "domaineCcsd",
    "laboCcsd",
    "sujetPastel",
    "fondPastel"
})
@XmlRootElement(name = "ccsd")
public class Ccsd {

    @XmlElement(required = true)
    protected DomaineCcsd domaineCcsd;
    @XmlElement(required = true)
    protected LaboCcsd laboCcsd;
    @XmlElement(required = true)
    protected SujetPastel sujetPastel;
    @XmlElement(required = true)
    protected FondPastel fondPastel;
    @XmlAttribute(name = "ccsdDiffuseurPolEtablissement", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String ccsdDiffuseurPolEtablissement;
    @XmlAttribute(name = "dateCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dateCcsd;
    @XmlAttribute(name = "identifiantCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String identifiantCcsd;
    @XmlAttribute(name = "indicCcsd", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String indicCcsd;
    @XmlAttribute(name = "majCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String majCcsd;
    @XmlAttribute(name = "numVersion", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String numVersion;
    @XmlAttribute(name = "pastel", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String pastel;
    @XmlAttribute(name = "pwdCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String pwdCcsd;
    @XmlAttribute(name = "trace", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String trace;
    @XmlAttribute(name = "urlCcsd", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String urlCcsd;

    /**
     * Obtient la valeur de la propriété domaineCcsd.
     * 
     * @return
     *     possible object is
     *     {@link DomaineCcsd }
     *     
     */
    public DomaineCcsd getDomaineCcsd() {
        return domaineCcsd;
    }

    /**
     * Définit la valeur de la propriété domaineCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link DomaineCcsd }
     *     
     */
    public void setDomaineCcsd(DomaineCcsd value) {
        this.domaineCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété laboCcsd.
     * 
     * @return
     *     possible object is
     *     {@link LaboCcsd }
     *     
     */
    public LaboCcsd getLaboCcsd() {
        return laboCcsd;
    }

    /**
     * Définit la valeur de la propriété laboCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link LaboCcsd }
     *     
     */
    public void setLaboCcsd(LaboCcsd value) {
        this.laboCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété sujetPastel.
     * 
     * @return
     *     possible object is
     *     {@link SujetPastel }
     *     
     */
    public SujetPastel getSujetPastel() {
        return sujetPastel;
    }

    /**
     * Définit la valeur de la propriété sujetPastel.
     * 
     * @param value
     *     allowed object is
     *     {@link SujetPastel }
     *     
     */
    public void setSujetPastel(SujetPastel value) {
        this.sujetPastel = value;
    }

    /**
     * Obtient la valeur de la propriété fondPastel.
     * 
     * @return
     *     possible object is
     *     {@link FondPastel }
     *     
     */
    public FondPastel getFondPastel() {
        return fondPastel;
    }

    /**
     * Définit la valeur de la propriété fondPastel.
     * 
     * @param value
     *     allowed object is
     *     {@link FondPastel }
     *     
     */
    public void setFondPastel(FondPastel value) {
        this.fondPastel = value;
    }

    /**
     * Obtient la valeur de la propriété ccsdDiffuseurPolEtablissement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcsdDiffuseurPolEtablissement() {
        return ccsdDiffuseurPolEtablissement;
    }

    /**
     * Définit la valeur de la propriété ccsdDiffuseurPolEtablissement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcsdDiffuseurPolEtablissement(String value) {
        this.ccsdDiffuseurPolEtablissement = value;
    }

    /**
     * Obtient la valeur de la propriété dateCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateCcsd() {
        return dateCcsd;
    }

    /**
     * Définit la valeur de la propriété dateCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCcsd(String value) {
        this.dateCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété identifiantCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifiantCcsd() {
        return identifiantCcsd;
    }

    /**
     * Définit la valeur de la propriété identifiantCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifiantCcsd(String value) {
        this.identifiantCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété indicCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicCcsd() {
        return indicCcsd;
    }

    /**
     * Définit la valeur de la propriété indicCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicCcsd(String value) {
        this.indicCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété majCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajCcsd() {
        return majCcsd;
    }

    /**
     * Définit la valeur de la propriété majCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajCcsd(String value) {
        this.majCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété numVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumVersion() {
        return numVersion;
    }

    /**
     * Définit la valeur de la propriété numVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumVersion(String value) {
        this.numVersion = value;
    }

    /**
     * Obtient la valeur de la propriété pastel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastel() {
        return pastel;
    }

    /**
     * Définit la valeur de la propriété pastel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastel(String value) {
        this.pastel = value;
    }

    /**
     * Obtient la valeur de la propriété pwdCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwdCcsd() {
        return pwdCcsd;
    }

    /**
     * Définit la valeur de la propriété pwdCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdCcsd(String value) {
        this.pwdCcsd = value;
    }

    /**
     * Obtient la valeur de la propriété trace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrace() {
        return trace;
    }

    /**
     * Définit la valeur de la propriété trace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrace(String value) {
        this.trace = value;
    }

    /**
     * Obtient la valeur de la propriété urlCcsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlCcsd() {
        return urlCcsd;
    }

    /**
     * Définit la valeur de la propriété urlCcsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlCcsd(String value) {
        this.urlCcsd = value;
    }

}
