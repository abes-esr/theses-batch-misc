//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.12 à 05:12:30 PM CEST 
//


package fr.abes.theses.model.tefjaxb;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.abes.theses2ES.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Medium_QNAME = new QName("http://purl.org/dc/terms/", "medium");
    private final static QName _Extent_QNAME = new QName("http://purl.org/dc/terms/", "extent");
    private final static QName _Identifier_QNAME = new QName("http://purl.org/dc/elements/1.1/", "identifier");
    private final static QName _Nom_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "nom");
    private final static QName _Place_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "place");
    private final static QName _Issued_QNAME = new QName("http://purl.org/dc/terms/", "issued");
    private final static QName _FormatFichier_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "formatFichier");
    private final static QName _Taille_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "taille");
    private final static QName _Creator_QNAME = new QName("http://purl.org/dc/elements/1.1/", "creator");
    private final static QName _Publisher_QNAME = new QName("http://purl.org/dc/elements/1.1/", "publisher");
    private final static QName _Language_QNAME = new QName("http://purl.org/dc/elements/1.1/", "language");
    private final static QName _Date_QNAME = new QName("http://purl.org/dc/elements/1.1/", "date");
    private final static QName _Type_QNAME = new QName("http://purl.org/dc/elements/1.1/", "type");
    private final static QName _Prenom_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "prenom");
    private final static QName _DateNaissance_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "dateNaissance");
    private final static QName _DateAccepted_QNAME = new QName("http://purl.org/dc/terms/", "dateAccepted");
    private final static QName _AutoriteInterne_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "autoriteInterne");
    private final static QName _ThesisDegreeLevel_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "thesis.degree.level");
    private final static QName _TheseSurTravaux_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "theseSurTravaux");
    private final static QName _AvisJury_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "avisJury");
    private final static QName _OaiSetSpec_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "oaiSetSpec");
    private final static QName _NoteVersion_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "noteVersion");
    private final static QName _RessourceID_QNAME = new QName("http://www.abes.fr/abes/documents/tef", "ressourceID");
    private final static QName _ConstraintDescription_QNAME = new QName("http://cosimo.stanford.edu/sdr/metsrights/", "ConstraintDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.abes.theses2ES.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Edition }
     * 
     */
    public Edition createEdition() {
        return new Edition();
    }

    /**
     * Create an instance of {@link Editeur }
     * 
     */
    public Editeur createEditeur() {
        return new Editeur();
    }

    /**
     * Create an instance of {@link MetaFichier }
     * 
     */
    public MetaFichier createMetaFichier() {
        return new MetaFichier();
    }

    /**
     * Create an instance of {@link RessourceExterneDescription }
     * 
     */
    public RessourceExterneDescription createRessourceExterneDescription() {
        return new RessourceExterneDescription();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link ThesisAdmin }
     * 
     */
    public ThesisAdmin createThesisAdmin() {
        return new ThesisAdmin();
    }

    /**
     * Create an instance of {@link Auteur }
     * 
     */
    public Auteur createAuteur() {
        return new Auteur();
    }

    /**
     * Create an instance of {@link Nationalite }
     * 
     */
    public Nationalite createNationalite() {
        return new Nationalite();
    }

    /**
     * Create an instance of {@link AutoriteExterne }
     * 
     */
    public AutoriteExterne createAutoriteExterne() {
        return new AutoriteExterne();
    }

    /**
     * Create an instance of {@link ThesisDegree }
     * 
     */
    public ThesisDegree createThesisDegree() {
        return new ThesisDegree();
    }

    /**
     * Create an instance of {@link ThesisDegreeDiscipline }
     * 
     */
    public ThesisDegreeDiscipline createThesisDegreeDiscipline() {
        return new ThesisDegreeDiscipline();
    }

    /**
     * Create an instance of {@link ThesisDegreeGrantor }
     * 
     */
    public ThesisDegreeGrantor createThesisDegreeGrantor() {
        return new ThesisDegreeGrantor();
    }

    /**
     * Create an instance of {@link ThesisDegreeName }
     * 
     */
    public ThesisDegreeName createThesisDegreeName() {
        return new ThesisDegreeName();
    }

    /**
     * Create an instance of {@link DirecteurThese }
     * 
     */
    public DirecteurThese createDirecteurThese() {
        return new DirecteurThese();
    }

    /**
     * Create an instance of {@link PresidentJury }
     * 
     */
    public PresidentJury createPresidentJury() {
        return new PresidentJury();
    }

    /**
     * Create an instance of {@link MembreJury }
     * 
     */
    public MembreJury createMembreJury() {
        return new MembreJury();
    }

    /**
     * Create an instance of {@link Rapporteur }
     * 
     */
    public Rapporteur createRapporteur() {
        return new Rapporteur();
    }

    /**
     * Create an instance of {@link EcoleDoctorale }
     * 
     */
    public EcoleDoctorale createEcoleDoctorale() {
        return new EcoleDoctorale();
    }

    /**
     * Create an instance of {@link PartenaireRecherche }
     * 
     */
    public PartenaireRecherche createPartenaireRecherche() {
        return new PartenaireRecherche();
    }

    /**
     * Create an instance of {@link MADSAuthority }
     * 
     */
    public MADSAuthority createMADSAuthority() {
        return new MADSAuthority();
    }

    /**
     * Create an instance of {@link PersonMADS }
     * 
     */
    public PersonMADS createPersonMADS() {
        return new PersonMADS();
    }

    /**
     * Create an instance of {@link NamePart }
     * 
     */
    public NamePart createNamePart() {
        return new NamePart();
    }

    /**
     * Create an instance of {@link ThesisRecord }
     * 
     */
    public ThesisRecord createThesisRecord() {
        return new ThesisRecord();
    }

    /**
     * Create an instance of {@link Alternative }
     * 
     */
    public Alternative createAlternative() {
        return new Alternative();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link SujetRameau }
     * 
     */
    public SujetRameau createSujetRameau() {
        return new SujetRameau();
    }

    /**
     * Create an instance of {@link VedetteRameauPersonne }
     * 
     */
    public VedetteRameauPersonne createVedetteRameauPersonne() {
        return new VedetteRameauPersonne();
    }

    /**
     * Create an instance of {@link ElementdEntree }
     * 
     */
    public ElementdEntree createElementdEntree() {
        return new ElementdEntree();
    }

    /**
     * Create an instance of {@link Subdivision }
     * 
     */
    public Subdivision createSubdivision() {
        return new Subdivision();
    }

    /**
     * Create an instance of {@link VedetteRameauCollectivite }
     * 
     */
    public VedetteRameauCollectivite createVedetteRameauCollectivite() {
        return new VedetteRameauCollectivite();
    }

    /**
     * Create an instance of {@link VedetteRameauFamille }
     * 
     */
    public VedetteRameauFamille createVedetteRameauFamille() {
        return new VedetteRameauFamille();
    }

    /**
     * Create an instance of {@link VedetteRameauAuteurTitre }
     * 
     */
    public VedetteRameauAuteurTitre createVedetteRameauAuteurTitre() {
        return new VedetteRameauAuteurTitre();
    }

    /**
     * Create an instance of {@link VedetteRameauTitre }
     * 
     */
    public VedetteRameauTitre createVedetteRameauTitre() {
        return new VedetteRameauTitre();
    }

    /**
     * Create an instance of {@link VedetteRameauNomCommun }
     * 
     */
    public VedetteRameauNomCommun createVedetteRameauNomCommun() {
        return new VedetteRameauNomCommun();
    }

    /**
     * Create an instance of {@link VedetteRameauNomGeographique }
     * 
     */
    public VedetteRameauNomGeographique createVedetteRameauNomGeographique() {
        return new VedetteRameauNomGeographique();
    }

    /**
     * Create an instance of {@link Abstract }
     * 
     */
    public Abstract createAbstract() {
        return new Abstract();
    }

    /**
     * Create an instance of {@link Version }
     * 
     */
    public Version createVersion() {
        return new Version();
    }

    /**
     * Create an instance of {@link Manque }
     * 
     */
    public Manque createManque() {
        return new Manque();
    }

    /**
     * Create an instance of {@link MetsMdWrap }
     * 
     */
    public MetsMdWrap createMetsMdWrap() {
        return new MetsMdWrap();
    }

    /**
     * Create an instance of {@link RightsDeclarationMD }
     * 
     */
    public RightsDeclarationMD createRightsDeclarationMD() {
        return new RightsDeclarationMD();
    }

    /**
     * Create an instance of {@link Context }
     * 
     */
    public Context createContext() {
        return new Context();
    }

    /**
     * Create an instance of {@link Permissions }
     * 
     */
    public Permissions createPermissions() {
        return new Permissions();
    }

    /**
     * Create an instance of {@link Constraints }
     * 
     */
    public Constraints createConstraints() {
        return new Constraints();
    }

    /**
     * Create an instance of {@link Mets }
     * 
     */
    public Mets createMets() {
        return new Mets();
    }

    /**
     * Create an instance of {@link DmdSec }
     * 
     */
    public DmdSec createDmdSec() {
        return new DmdSec();
    }

    /**
     * Create an instance of {@link MdWrap }
     * 
     */
    public MdWrap createMdWrap() {
        return new MdWrap();
    }

    /**
     * Create an instance of {@link XmlData }
     * 
     */
    public XmlData createXmlData() {
        return new XmlData();
    }

    /**
     * Create an instance of {@link AmdSec }
     * 
     */
    public AmdSec createAmdSec() {
        return new AmdSec();
    }

    /**
     * Create an instance of {@link TechMD }
     * 
     */
    public TechMD createTechMD() {
        return new TechMD();
    }

    /**
     * Create an instance of {@link RightsMD }
     * 
     */
    public RightsMD createRightsMD() {
        return new RightsMD();
    }

    /**
     * Create an instance of {@link FileSec }
     * 
     */
    public FileSec createFileSec() {
        return new FileSec();
    }

    /**
     * Create an instance of {@link FileGrp }
     * 
     */
    public FileGrp createFileGrp() {
        return new FileGrp();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link FLocat }
     * 
     */
    public FLocat createFLocat() {
        return new FLocat();
    }

    /**
     * Create an instance of {@link StructMap }
     * 
     */
    public StructMap createStructMap() {
        return new StructMap();
    }

    /**
     * Create an instance of {@link Div }
     * 
     */
    public Div createDiv() {
        return new Div();
    }

    /**
     * Create an instance of {@link Fptr }
     * 
     */
    public Fptr createFptr() {
        return new Fptr();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "medium")
    public JAXBElement<String> createMedium(String value) {
        return new JAXBElement<String>(_Medium_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "extent")
    public JAXBElement<String> createExtent(String value) {
        return new JAXBElement<String>(_Extent_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "identifier")
    public JAXBElement<String> createIdentifier(String value) {
        return new JAXBElement<String>(_Identifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "nom")
    public JAXBElement<String> createNom(String value) {
        return new JAXBElement<String>(_Nom_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "place")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPlace(String value) {
        return new JAXBElement<String>(_Place_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "issued")
    public JAXBElement<XMLGregorianCalendar> createIssued(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Issued_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "formatFichier")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createFormatFichier(String value) {
        return new JAXBElement<String>(_FormatFichier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "taille")
    public JAXBElement<BigInteger> createTaille(BigInteger value) {
        return new JAXBElement<BigInteger>(_Taille_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "creator")
    public JAXBElement<String> createCreator(String value) {
        return new JAXBElement<String>(_Creator_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "publisher")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPublisher(String value) {
        return new JAXBElement<String>(_Publisher_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLanguage(String value) {
        return new JAXBElement<String>(_Language_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "date")
    public JAXBElement<BigInteger> createDate(BigInteger value) {
        return new JAXBElement<BigInteger>(_Date_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/elements/1.1/", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "prenom")
    public JAXBElement<String> createPrenom(String value) {
        return new JAXBElement<String>(_Prenom_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "dateNaissance")
    public JAXBElement<XMLGregorianCalendar> createDateNaissance(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateNaissance_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "dateAccepted")
    public JAXBElement<XMLGregorianCalendar> createDateAccepted(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateAccepted_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "autoriteInterne")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAutoriteInterne(String value) {
        return new JAXBElement<String>(_AutoriteInterne_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "thesis.degree.level")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createThesisDegreeLevel(String value) {
        return new JAXBElement<String>(_ThesisDegreeLevel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "theseSurTravaux")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createTheseSurTravaux(String value) {
        return new JAXBElement<String>(_TheseSurTravaux_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "avisJury")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAvisJury(String value) {
        return new JAXBElement<String>(_AvisJury_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "oaiSetSpec")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createOaiSetSpec(String value) {
        return new JAXBElement<String>(_OaiSetSpec_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "noteVersion")
    public JAXBElement<String> createNoteVersion(String value) {
        return new JAXBElement<String>(_NoteVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.abes.fr/abes/documents/tef", name = "ressourceID")
    public JAXBElement<String> createRessourceID(String value) {
        return new JAXBElement<String>(_RessourceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://cosimo.stanford.edu/sdr/metsrights/", name = "ConstraintDescription")
    public JAXBElement<String> createConstraintDescription(String value) {
        return new JAXBElement<String>(_ConstraintDescription_QNAME, String.class, null, value);
    }

}
