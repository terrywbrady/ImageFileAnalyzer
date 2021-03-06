package gov.nara.nwts.ftappImg.tags;

import java.util.Vector;

/**
 * Categorizations of common image tags found in NARA digitized files.
 * Note: some NARA-specific notions have crept into this file.  Some clean-up is likely needed if sharing this code outside of NARA.
 * @author TBrady
 *
 */
public class ImageTags {
	/**
	 * Location where a metadata field was found
	 * @author TBrady
	 *
	 */
	public enum TAGLOC {
		NA,
		TAG,
		XMP,
		JPG
	}
	/**
	 * Mandatory vs Optional designations; note that this would likely be a NARA-specific designation; the deisgnations that are in place are incomplete.
	 * @author TBrady
	 *
	 */
	public enum USAGE {
		REQUIRED,
		TECH_REQUIRED,
		OPTIONAL,
		UNDECIDED,
		IGNORE
	}
	/**
	 * Classification of a metadata field; only a preliminary designation has been done to date.
	 * @author TBrady
	 *
	 */
	public enum TAGCONTENT {
		ID,
		DESCRIPTIVE,
		PROCESS,
		TECHNICAL,
		CONTAINER,
		COMPLEX,
		IGNORE,
		UNDECIDED
	}
	/**
	 * For metadata fields that are captured with multiple tag definitions, this field provides a normalized way to identify that content.
	 * @author TBrady
	 *
	 */
	public enum DUP {
		NA,
		BitsPerSample,
		BitsPerSampleDetailed,
		Description,
		Copyright,
		CreationDate,
		ModificationDate,
		Software,
		Creator,
		Orientation,
		ColorSpace,
		ResolutionUnit,
		Width,
		Length,
		XResolution,
		YResolution,
		Subject,
		Title,
		Instructions,
		Credit,
		OtherDescriptive;
		
		public Vector<TAGS> duptags;
		DUP() {
			duptags = new Vector<TAGS>();
		}
	}
	/**
	 * Standard or namespace used to define a specific tag
	 * @author TBrady
	 *
	 */
	public enum TAGTYPE {
		NA,
		JPG,
		TIFF_TAG,
		CORE("http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/"),
		TIFF("http://ns.adobe.com/tiff/1.0/"),
		EXIF("http://ns.adobe.com/exif/1.0/"),
		DUBCORE("http://purl.org/dc/elements/1.1/"),
		XAP("http://ns.adobe.com/xap/1.0/"),
		XAPMM("http://ns.adobe.com/xap/1.0/mm/"),
		PHOTOSHOP("http://ns.adobe.com/photoshop/1.0/"),
		XAP_RIGHTS("http://ns.adobe.com/xap/1.0/rights/"),
		OTHER_XMP;
		
		public String ns;
		TAGTYPE(String ns) {
			this.ns = ns;
		}
		
		TAGTYPE() {
			this("");
		}
	}
	
	/**
	 * Designation of tags that have been commonly found in NARA digitized records; many of these designations are preliminary; this list should be refined over time.
	 * @author TBrady
	 *
	 */
	public enum TAGS {
		UNDEFINED(-1, TAGCONTENT.UNDECIDED, TAGTYPE.NA, USAGE.UNDECIDED, DUP.NA),
		TIFF_BITS_PER_CHANNEL(258, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.REQUIRED, DUP.BitsPerSample),
		
		TIFF_COLOR_SPACE(262, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.REQUIRED, DUP.ColorSpace),
		TIFF_DESCRIPTION(270, TAGCONTENT.DESCRIPTIVE, TAGTYPE.TIFF_TAG, USAGE.REQUIRED, DUP.Description),
		TIFF_XMP(700, TAGCONTENT.COMPLEX, TAGTYPE.TIFF_TAG, USAGE.REQUIRED, DUP.NA),
		TIFF_KEYWORDS(37510, TAGCONTENT.DESCRIPTIVE, TAGTYPE.TIFF_TAG, USAGE.OPTIONAL, DUP.Subject),
		TIFF_NEW_SUBFILE_TYPE(254, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_IMAGE_WIDTH(256, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.Width),
		TIFF_IMAGE_LENGTH(257, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.Length),
		TIFF_COMPRESSION(259, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.NA),
		TIFF_STRIP_OFFSETS(273, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.NA),
		TIFF_ORIENTATION(274, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.Orientation),
		TIFF_SAMPLES_PER_PIXEL(277, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.NA),
		TIFF_ROWS_PER_STRIP(278, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_STRIP_BYTE_COUNTS(279, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_X_RESOLUTION(282, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.XResolution),
		TIFF_Y_RESOLUTION(283, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.YResolution),
		TIFF_PLANAR_CONFIGURATION(284, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_RESOLUTION_UNIT(296, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.ResolutionUnit),
		TIFF_SOFTWARE(305, TAGCONTENT.PROCESS, TAGTYPE.TIFF_TAG, USAGE.OPTIONAL, DUP.Software),
		TIFF_DATE_TIME(306, TAGCONTENT.PROCESS, TAGTYPE.TIFF_TAG, USAGE.OPTIONAL, DUP.CreationDate),
		TIFF_ARTIST(315, TAGCONTENT.PROCESS, TAGTYPE.TIFF_TAG, USAGE.OPTIONAL, DUP.Creator),
		TIFF_COLOR_MAP(320, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.NA),
		TIFF_COPYRIGHT(33432, TAGCONTENT.DESCRIPTIVE, TAGTYPE.TIFF_TAG, USAGE.OPTIONAL, DUP.Copyright),
		TIFF_TAG33723(33723, TAGCONTENT.UNDECIDED, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_TAG34377(34377, TAGCONTENT.COMPLEX, TAGTYPE.TIFF_TAG, USAGE.UNDECIDED, DUP.NA),
		TIFF_EXIF_IFD_POINTER(34665, TAGCONTENT.TECHNICAL, TAGTYPE.EXIF, USAGE.UNDECIDED, DUP.NA),
		TIFF_ICC_PROFILE(34675, TAGCONTENT.TECHNICAL, TAGTYPE.TIFF_TAG, USAGE.TECH_REQUIRED, DUP.NA),

		Location("Iptc4xmpCore:Location",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		IntellectualGenre("Iptc4xmpCore:IntellectualGenre",TAGCONTENT.DESCRIPTIVE, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.OtherDescriptive),
		CountryCode("Iptc4xmpCore:CountryCode",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CreatorContactInfo("Iptc4xmpCore:CreatorContactInfo",TAGCONTENT.CONTAINER, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiAdrExtadr("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiAdrExtadr",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiAdrCity("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiAdrCity",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiAdrRegion("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiAdrRegion",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiAdrPcode("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiAdrPcode",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiAdrCtry("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiAdrCtry",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiTelWork("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiTelWork",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiEmailWork("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiEmailWork",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		CiUrlWork("Iptc4xmpCore:CreatorContactInfo/Iptc4xmpCore:CiUrlWork",TAGCONTENT.PROCESS, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		SubjectCode("Iptc4xmpCore:SubjectCode",TAGCONTENT.CONTAINER, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		SubjectCode1("Iptc4xmpCore:SubjectCode[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.OtherDescriptive),
		Scene("Iptc4xmpCore:Scene",TAGCONTENT.CONTAINER, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.NA),
		Scene1("Iptc4xmpCore:Scene[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.CORE, USAGE.UNDECIDED, DUP.OtherDescriptive),

		Orientation("tiff:Orientation",TAGCONTENT.TECHNICAL, TAGTYPE.TIFF, USAGE.TECH_REQUIRED, DUP.Orientation),
		XResolution("tiff:XResolution",TAGCONTENT.TECHNICAL, TAGTYPE.TIFF, USAGE.TECH_REQUIRED, DUP.XResolution),
		YResolution("tiff:YResolution",TAGCONTENT.TECHNICAL, TAGTYPE.TIFF, USAGE.TECH_REQUIRED, DUP.YResolution),
		ResolutionUnit("tiff:ResolutionUnit",TAGCONTENT.TECHNICAL, TAGTYPE.TIFF, USAGE.TECH_REQUIRED, DUP.ResolutionUnit),
		NativeDigest("tiff:NativeDigest",TAGCONTENT.TECHNICAL, TAGTYPE.TIFF, USAGE.TECH_REQUIRED, DUP.NA),

		PixelXDimension("exif:PixelXDimension",TAGCONTENT.TECHNICAL, TAGTYPE.EXIF, USAGE.TECH_REQUIRED, DUP.Width),
		PixelYDimension("exif:PixelYDimension",TAGCONTENT.TECHNICAL, TAGTYPE.EXIF, USAGE.TECH_REQUIRED, DUP.Length),
		ColorSpace("exif:ColorSpace",TAGCONTENT.TECHNICAL, TAGTYPE.EXIF, USAGE.TECH_REQUIRED, DUP.ColorSpace),
		ExifNativeDigest("exif:NativeDigest",TAGCONTENT.TECHNICAL, TAGTYPE.EXIF, USAGE.UNDECIDED, DUP.NA),

		format("dc:format",TAGCONTENT.TECHNICAL, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		title("dc:title",TAGCONTENT.CONTAINER, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		title1("dc:title[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.Title),
		creator("dc:creator",TAGCONTENT.CONTAINER, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		creator1("dc:creator[1]",TAGCONTENT.PROCESS, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.Creator),
		description("dc:description",TAGCONTENT.CONTAINER, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		description1("dc:description[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.DUBCORE, USAGE.REQUIRED, DUP.Description),
		subject("dc:subject",TAGCONTENT.CONTAINER, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		subject1("dc:subject[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.Subject),
		rights("dc:rights",TAGCONTENT.CONTAINER, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.NA),
		rights1("dc:rights[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.DUBCORE, USAGE.UNDECIDED, DUP.Copyright),

		CreatorTool("xmp:CreatorTool",TAGCONTENT.PROCESS, TAGTYPE.XAP, USAGE.UNDECIDED, DUP.Software),
		CreateDate("xmp:CreateDate",TAGCONTENT.PROCESS, TAGTYPE.XAP, USAGE.UNDECIDED, DUP.CreationDate),
		ModifyDate("xmp:ModifyDate",TAGCONTENT.PROCESS, TAGTYPE.XAP, USAGE.UNDECIDED, DUP.ModificationDate),
		MetadataDate("xmp:MetadataDate",TAGCONTENT.PROCESS, TAGTYPE.XAP, USAGE.UNDECIDED, DUP.NA),

		DocumentID("xmpMM:DocumentID",TAGCONTENT.ID, TAGTYPE.XAPMM, USAGE.UNDECIDED, DUP.NA),
		InstanceID("xmpMM:InstanceID",TAGCONTENT.ID, TAGTYPE.XAPMM, USAGE.UNDECIDED, DUP.NA),
		DerivedFrom("xmpMM:DerivedFrom",TAGCONTENT.CONTAINER, TAGTYPE.XAPMM, USAGE.UNDECIDED, DUP.NA),
		DerivInstanceId("xmpMM:DerivedFrom/stRef:instanceID",TAGCONTENT.ID, TAGTYPE.XAPMM, USAGE.UNDECIDED, DUP.NA),
		DerivDocumentID("xmpMM:DerivedFrom/stRef:documentID",TAGCONTENT.ID, TAGTYPE.XAPMM, USAGE.UNDECIDED, DUP.NA),

		ColorMode("photoshop:ColorMode",TAGCONTENT.TECHNICAL, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		ICCProfile("photoshop:ICCProfile",TAGCONTENT.TECHNICAL, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		AuthorsPosition("photoshop:AuthorsPosition",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		CaptionWriter("photoshop:CaptionWriter",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		Category("photoshop:Category",TAGCONTENT.DESCRIPTIVE, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.OtherDescriptive),
		Headline("photoshop:Headline",TAGCONTENT.DESCRIPTIVE, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.OtherDescriptive),
		DateCreated("photoshop:DateCreated",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.CreationDate),
		City("photoshop:City",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		State("photoshop:State",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		Country("photoshop:Country",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		TransmissionReference("photoshop:TransmissionReference",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		Instructions("photoshop:Instructions",TAGCONTENT.DESCRIPTIVE, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.Instructions),
		Credit("photoshop:Credit",TAGCONTENT.DESCRIPTIVE, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.Credit),
		Source("photoshop:Source",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		Urgency("photoshop:Urgency",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		SupplementalCategories("photoshop:SupplementalCategories",TAGCONTENT.CONTAINER, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		SupplementalCategories1("photoshop:SupplementalCategories[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.OtherDescriptive),
		History("photoshop:History",TAGCONTENT.PROCESS, TAGTYPE.PHOTOSHOP, USAGE.UNDECIDED, DUP.NA),
		
		Marked("xmpRights:Marked",TAGCONTENT.IGNORE, TAGTYPE.XAP_RIGHTS, USAGE.UNDECIDED, DUP.NA),
		WebStatement("xmpRights:WebStatement",TAGCONTENT.DESCRIPTIVE, TAGTYPE.XAP_RIGHTS, USAGE.UNDECIDED, DUP.OtherDescriptive),
		UsageTerms("xmpRights:UsageTerms",TAGCONTENT.DESCRIPTIVE, TAGTYPE.XAP_RIGHTS, USAGE.UNDECIDED, DUP.OtherDescriptive),
		UsageTerms1("xmpRights:UsageTerms[1]",TAGCONTENT.DESCRIPTIVE, TAGTYPE.XAP_RIGHTS, USAGE.UNDECIDED, DUP.OtherDescriptive),
		
		J_Artist(TAGLOC.JPG, "Artist",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Creator),
		J_Author(TAGLOC.JPG, "Author",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Creator),
		J_Bits_Per_Sample(TAGLOC.JPG, "Bits Per Sample",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.BitsPerSampleDetailed),
		J_By_line(TAGLOC.JPG, "By-line",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Creator),
		J_By_line_Title(TAGLOC.JPG, "By-line Title",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Title),

		J_Caption_Abstract(TAGLOC.JPG, "Caption/Abstract",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_City(TAGLOC.JPG, "City",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_Color_Space(TAGLOC.JPG, "Color Space",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Component1(TAGLOC.JPG, "Component 1",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Component2(TAGLOC.JPG, "Component 2",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Component3(TAGLOC.JPG, "Component 3",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Compression(TAGLOC.JPG, "Compression",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Copyright(TAGLOC.JPG, "Copyright",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Copyright),
		J_CopyrightNotice(TAGLOC.JPG, "Copyright Notice",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Copyright),
		J_Country_Primary_Location(TAGLOC.JPG, "Country/Primary Location",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_creator(TAGLOC.JPG, "creator",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Creator),
		J_Credit(TAGLOC.JPG, "Credit",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Credit),
		J_Data_Precision(TAGLOC.JPG, "Data Precision",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),

		J_date(TAGLOC.JPG, "date",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.CreationDate),
		J_Date_Time(TAGLOC.JPG, "Date/Time",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.CreationDate),
		J_Date_Created(TAGLOC.JPG, "Date Created",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.CreationDate),
		J_description(TAGLOC.JPG, "description",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Description),
		J_Directory_Version(TAGLOC.JPG, "Directory Version",TAGCONTENT.TECHNICAL,TAGTYPE.EXIF, USAGE.OPTIONAL, DUP.NA),

		J_Exif_Image_Height(TAGLOC.JPG, "Exif Image Height",TAGCONTENT.TECHNICAL,TAGTYPE.EXIF, USAGE.OPTIONAL, DUP.Length),
		J_Exif_Image_Width(TAGLOC.JPG, "Exif Image Width",TAGCONTENT.TECHNICAL,TAGTYPE.EXIF, USAGE.OPTIONAL, DUP.Width),
		J_Headline(TAGLOC.JPG, "Headline",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),

		J_Image_Description(TAGLOC.JPG, "Image Description",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Description),
		J_Image_Height(TAGLOC.JPG, "Image Height",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Length),
		J_Image_Width(TAGLOC.JPG, "Image Width",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Width),
		J_Keywords(TAGLOC.JPG, "Keywords",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_Last_Modified(TAGLOC.JPG, "Last-Modified",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.ModificationDate),
		J_Number_of_Components(TAGLOC.JPG, "Number of Components",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Object_Name(TAGLOC.JPG, "Object Name",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Title),
		J_Orientation(TAGLOC.JPG, "Orientation",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Orientation),
		J_Original_Transmission_Reference(TAGLOC.JPG, "Original Transmission Reference",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),

		J_Photometric_Interpretation(TAGLOC.JPG, "Photometric Interpretation",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Planar_Configuration(TAGLOC.JPG, "Planar Configuration",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Province_State(TAGLOC.JPG, "Province/State",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_Resolution_Unit(TAGLOC.JPG, "Resolution Unit",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.ResolutionUnit),
		J_Samples_Per_Pixel(TAGLOC.JPG, "Samples Per Pixel",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Software(TAGLOC.JPG, "Software",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Software),
		J_Source(TAGLOC.JPG, "Source",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_Special_Instructions(TAGLOC.JPG, "Special Instructions",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Instructions),
		J_subject(TAGLOC.JPG, "subject",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Subject),
		J_Supplemental_Category(TAGLOC.JPG, "Supplemental Category(s)",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),

		J_Thumbnail_Data(TAGLOC.JPG, "Thumbnail Data",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Thumbnail_Image_Height(TAGLOC.JPG, "Thumbnail Image Height",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Thumbnail_Image_Width(TAGLOC.JPG, "Thumbnail Image Width",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Thumbnail_Length(TAGLOC.JPG, "Thumbnail Length",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_Thumbnail_Offset(TAGLOC.JPG, "Thumbnail Offset",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_tiff_BitsPerSample(TAGLOC.JPG, "tiff:BitsPerSample",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.BitsPerSample),
		J_tiff_ImageLength(TAGLOC.JPG, "tiff:ImageLength",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Length),
		J_tiff_ImageWidth(TAGLOC.JPG, "tiff:ImageWidth",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Width),
		J_tiff_Orientation(TAGLOC.JPG, "tiff:Orientation",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Orientation),
		J_tiff_ResolutionUnit(TAGLOC.JPG, "tiff:ResolutionUnit",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.ResolutionUnit),
		J_tiff_SamplesPerPixel(TAGLOC.JPG, "tiff:SamplesPerPixel",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.NA),
		J_tiff_Software(TAGLOC.JPG, "tiff:Software",TAGCONTENT.PROCESS,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Software),
		J_tiff_XResolution(TAGLOC.JPG, "tiff:XResolution",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.XResolution),
		J_tiff_YResolution(TAGLOC.JPG, "tiff:YResolution",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.YResolution),
		J_title(TAGLOC.JPG, "title",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.Title),

		J_Urgency(TAGLOC.JPG, "Urgency",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_Writer_Editor(TAGLOC.JPG, "Writer/Editor",TAGCONTENT.DESCRIPTIVE,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.OtherDescriptive),
		J_X_Resolution(TAGLOC.JPG, "X Resolution",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.XResolution),
		J_Y_Resolution(TAGLOC.JPG, "Y Resolution",TAGCONTENT.TECHNICAL,TAGTYPE.JPG, USAGE.OPTIONAL, DUP.YResolution),
;
		
		
		public TAGLOC tiffloc;
		public TAGTYPE tagtype;
		public USAGE usage;
		public TAGCONTENT tagcontent;
		public int tag;
		public String path;
		public DUP dup;
		
		TAGS(int tag, TAGCONTENT tagcontent, TAGTYPE type, USAGE usage, DUP dup) {
			this.tiffloc = (tag > 0) ? TAGLOC.TAG : TAGLOC.NA;
			this.tagtype = type;
			this.usage = usage;
			this.tagcontent = tagcontent;
			this.tag = tag;
			this.dup = dup;
			dup.duptags.add(this);
		}
		TAGS(String path, TAGCONTENT tagcontent, TAGTYPE type, USAGE usage, DUP dup) {
			this.tiffloc = TAGLOC.XMP;
			this.tagtype = type;
			this.usage = usage;
			this.tagcontent = tagcontent;
			this.path = path;
			this.dup = dup;
			dup.duptags.add(this);
		}
		TAGS(TAGLOC loc, String path, TAGCONTENT tagcontent, TAGTYPE type, USAGE usage, DUP dup) {
			this.tiffloc = loc;
			this.tagtype = type;
			this.usage = usage;
			this.tagcontent = tagcontent;
			this.path = path;
			this.dup = dup;
			dup.duptags.add(this);
		}
	}

}
