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
 *         &lt;element ref="{http://cosimo.stanford.edu/sdr/metsrights/}Context" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RIGHTSCATEGORY" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "context"
})
@XmlRootElement(name = "RightsDeclarationMD", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
public class RightsDeclarationMD {

    @XmlElement(name = "Context", namespace = "http://cosimo.stanford.edu/sdr/metsrights/", required = true)
    protected List<Context> context;
    @XmlAttribute(name = "RIGHTSCATEGORY")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String rightscategory;

    /**
     * Gets the value of the context property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the context property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Context }
     * 
     * 
     */
    public List<Context> getContext() {
        if (context == null) {
            context = new ArrayList<Context>();
        }
        return this.context;
    }

    /**
     * Obtient la valeur de la propriété rightscategory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRIGHTSCATEGORY() {
        return rightscategory;
    }

    /**
     * Définit la valeur de la propriété rightscategory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRIGHTSCATEGORY(String value) {
        this.rightscategory = value;
    }

}
