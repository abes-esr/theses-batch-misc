//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
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
 *         &lt;element ref="{http://www.loc.gov/METS/}fileGrp"/&gt;
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
    "fileGrp"
})
@XmlRootElement(name = "fileSec", namespace = "http://www.loc.gov/METS/")
public class FileSec {

    @XmlElement(namespace = "http://www.loc.gov/METS/", required = true)
    protected FileGrp fileGrp;

    /**
     * Obtient la valeur de la propriété fileGrp.
     * 
     * @return
     *     possible object is
     *     {@link FileGrp }
     *     
     */
    public FileGrp getFileGrp() {
        return fileGrp;
    }

    /**
     * Définit la valeur de la propriété fileGrp.
     * 
     * @param value
     *     allowed object is
     *     {@link FileGrp }
     *     
     */
    public void setFileGrp(FileGrp value) {
        this.fileGrp = value;
    }

}
