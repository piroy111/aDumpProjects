package aDumpProjects.translatecsvintoenglish;

import basicmethods.ReadFile;
import basicmethods.ReadFile.comReadFile;

public class Step03_LaunchMeFormatTranslation {

	/*
	 * Step 00: put the game extracted of Thibault in 'C:/Game - Stranded dreams'
	 * Step 01: launch 'LaunchMePrepareTranslation' --> the program will override the files .EN.csv with a text to prepare for translation. It will do it in the folder  'C:/Game - Stranded dreams/StrandedDreams_Data/loc' where the files were originally
	 * Step 02: copy paste all the contents of the files written '.EN.csv' in google translate and copy paste back the translation in the file '.EN.csv'. Note the presence of the # in order to separate the translation. USE NOTEPAD, this is important
	 * Step 03: launch 'LaunchMeFormatTranslation', which will remove the '#'
	 */
	public static void main(String[] _sArgs) {
		new TRManager().formatTranslation();
	}
	
}
