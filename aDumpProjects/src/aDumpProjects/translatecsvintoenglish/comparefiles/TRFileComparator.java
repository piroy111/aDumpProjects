package aDumpProjects.translatecsvintoenglish.comparefiles;

import aDumpProjects.translatecsvintoenglish.TRManager;
import aDumpProjects.translatecsvintoenglish.constants.TRStatic;
import aDumpProjects.translatecsvintoenglish.objects.TRFile;
import aDumpProjects.translatecsvintoenglish.objects.TRLine;
import basicmethods.BasicPrintMsg;

public class TRFileComparator {

	public TRFileComparator(TRManager _sTRManager) {
		pTRManager = _sTRManager;
		/*
		 * 
		 */
	}

	/*
	 * Data
	 */
	private TRManager pTRManager;

	/**
	 * 
	 */
	public final void run() {
		BasicPrintMsg.displaySuperTitle(this, "Check consistency between source files (French) and temp files (English)"); 
		/*
		 * Check every line
		 */
		for (TRFile lTRFile : pTRManager.getpTRFileManager().getpMapKeyToTRFile().values()) {
			String lComError = "";
			/*
			 * Check for the file
			 */
			if (lTRFile.getpReadFileTemp() == null) {
				lComError += "\nFile source in French is here but the File temp in English is missing";
			}
			if (lTRFile.getpReadFileSourceFrench() == null) {
				lComError += "\nFile source in French is missing but the file temp in English is here";
			}
			/*
			 * Check each line
			 */
			if (lComError.equals("")) {
				for (TRLine lTRLine : lTRFile.getpListTRLine()) {
					String lComLine = "";
					if (lTRLine.getpLineEnglish() == null || lTRLine.getpLineEnglish().equals("")) {
						lComLine += "Missing the line in the English file";
					} else if (lTRLine.getpLineEnglish().length() < (lTRLine.getpLineFrench().length() / 10)) {
						lComLine += "The line in Englisgh is not long enough. It is weird";
					} else if (lTRLine.getpLineEnglish().equals(lTRLine.getpLineFrench()) && lTRLine.getpLineFrench().indexOf(" ") != lTRLine.getpLineFrench().lastIndexOf(" ")) {
						lComLine += "The line has not been translated to English";
					}
					if (!lComLine.equals("")) {
						lComLine = "\nIdxLine= " + lTRLine.getpIdxLineInFile() + "; " 
								+ lComLine
								+ "; Line in French= '" + lTRLine.getpLineFrench() + "'"
								+ "; Line in English= '" + lTRLine.getpLineEnglish() + "'";
						lComError += lComLine;
					}
				}
			}
			/*
			 * 
			 */
			if (lComError.equals("")) {
				BasicPrintMsg.display(this, lTRFile.getpDirSub() + lTRFile.getpNameEnglish() + " --> All good");
			} else {
				lComError += "\n\nlTRFile.getpDirSub()= " + lTRFile.getpDirSub()
				+ "\nlTRFile.getpNameFrench()= " + lTRFile.getpDirSub() + lTRFile.getpNameFrench()
				+ "\nlTRFile.getpNameEnglish()= " + lTRFile.getpDirSub() + lTRFile.getpNameEnglish()
				+ "\nFolder source= " + TRStatic.getDIR_SOURCES()
				+ "\nFolder Temp= " + TRStatic.getDIR_TEMP();

				BasicPrintMsg.error(lComError);
			}
		}
	}




}
