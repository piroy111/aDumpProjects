package aDumpProjects.translatecsvintoenglish.constants;

public class TRStatic {
	
	/*
	 * DIR
	 */
	private static String DIR_SOURCES = "C:/Game - Stranded dreams - translation/loc/";
	private static String DIR_ROOT = "C:/Game - Stranded dreams - translation/";
	private static String DIR_TEMP = "C:/Users/pierr/OneDrive/10_pa/03_Shabaaz/06_Translation/"; // DIR_ROOT + "step01_files_in_French_to_translate_in_English/";
	private static String DIR_LOG = DIR_ROOT + "Output - error messages/";
	/*
	 * Extensions
	 */
	private static String EXTENSION_FRENCH = "_FR.csv";
	private static String EXTENSION_ENGLISH = "_EN.csv";	
	private static String SEPARATOR = ";";
	private static String SEPARATOR_TRANSLATION = "###";
	
	/*
	 * Getters & Setters
	 */
	public static final String getDIR_SOURCES() {
		return DIR_SOURCES;
	}
	public static final String getEXTENSION_FRENCH() {
		return EXTENSION_FRENCH;
	}
	public static final String getEXTENSION_ENGLISH() {
		return EXTENSION_ENGLISH;
	}
	public static final String getSEPARATOR() {
		return SEPARATOR;
	}
	public static final String getSEPARATOR_TRANSLATION() {
		return SEPARATOR_TRANSLATION;
	}
	public static final String getDIR_ROOT() {
		return DIR_ROOT;
	}
	public static final String getDIR_TEMP() {
		return DIR_TEMP;
	}
	public static final String getDIR_LOG() {
		return DIR_LOG;
	}
	
	
}
