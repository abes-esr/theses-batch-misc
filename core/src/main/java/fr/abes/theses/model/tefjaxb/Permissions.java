//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="COPY" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="DELETE" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="DISPLAY" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="DUPLICATE" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="MODIFY" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="PRINT" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Permissions", namespace = "http://cosimo.stanford.edu/sdr/metsrights/")
public class Permissions {

    @XmlAttribute(name = "COPY", required = true)
    protected boolean copy;
    @XmlAttribute(name = "DELETE", required = true)
    protected boolean delete;
    @XmlAttribute(name = "DISPLAY", required = true)
    protected boolean display;
    @XmlAttribute(name = "DUPLICATE", required = true)
    protected boolean duplicate;
    @XmlAttribute(name = "MODIFY", required = true)
    protected boolean modify;
    @XmlAttribute(name = "PRINT", required = true)
    protected boolean print;

    /**
     * Obtient la valeur de la propriété copy.
     * 
     */
    public boolean isCOPY() {
        return copy;
    }

    /**
     * Définit la valeur de la propriété copy.
     * 
     */
    public void setCOPY(boolean value) {
        this.copy = value;
    }

    /**
     * Obtient la valeur de la propriété delete.
     * 
     */
    public boolean isDELETE() {
        return delete;
    }

    /**
     * Définit la valeur de la propriété delete.
     * 
     */
    public void setDELETE(boolean value) {
        this.delete = value;
    }

    /**
     * Obtient la valeur de la propriété display.
     * 
     */
    public boolean isDISPLAY() {
        return display;
    }

    /**
     * Définit la valeur de la propriété display.
     * 
     */
    public void setDISPLAY(boolean value) {
        this.display = value;
    }

    /**
     * Obtient la valeur de la propriété duplicate.
     * 
     */
    public boolean isDUPLICATE() {
        return duplicate;
    }

    /**
     * Définit la valeur de la propriété duplicate.
     * 
     */
    public void setDUPLICATE(boolean value) {
        this.duplicate = value;
    }

    /**
     * Obtient la valeur de la propriété modify.
     * 
     */
    public boolean isMODIFY() {
        return modify;
    }

    /**
     * Définit la valeur de la propriété modify.
     * 
     */
    public void setMODIFY(boolean value) {
        this.modify = value;
    }

    /**
     * Obtient la valeur de la propriété print.
     * 
     */
    public boolean isPRINT() {
        return print;
    }

    /**
     * Définit la valeur de la propriété print.
     * 
     */
    public void setPRINT(boolean value) {
        this.print = value;
    }

}
