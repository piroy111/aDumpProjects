package aDumpProjects.translatecsvintoenglish.writefinalfiles;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.translatecsvintoenglish.TRManager;
import aDumpProjects.translatecsvintoenglish.constants.TRStatic;
import aDumpProjects.translatecsvintoenglish.objects.TRFile;
import aDumpProjects.translatecsvintoenglish.objects.TRLine;
import basicmethods.BasicFichiers;
import basicmethods.BasicPrintMsg;

public class TRFileFinalWriter {

	public TRFileFinalWriter(TRManager _sTRManager) {
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
		/*
		 * Read all translations and put them into the object TRFile/TRLine
		 */
//		BasicPrintMsg.displaySuperTitle(this, "Read all the files translated");
//		for (TRFile lTRFile : pTRManager.getpTRFileManager().getpMapKeyToTRFile().values()) {
//			lTRFile.readFileTempEnglish();
//		}
		/*
		 * Write the file in English with the correct title
		 */
		BasicPrintMsg.displaySuperTitle(this, "Write all files translated");
		for (TRFile lTRFile : pTRManager.getpTRFileManager().getpMapKeyToTRFile().values()) {
			/*
			 * Build file content
			 */
			List<String> lListLineToWrite = new ArrayList<>();
			for (TRLine lTRLine : lTRFile.getpListTRLine()) {
				String lLine = lTRLine.getpTitle() + TRStatic.getSEPARATOR() + lTRLine.getpLineEnglish();
				lListLineToWrite.add(lLine);
			}
			/*
			 * Write file
			 */
			String lDir = lTRFile.getpDir();
			String lNameFile = lTRFile.getpNameEnglish();
			BasicFichiers.writeFile(lDir, lNameFile, null, lListLineToWrite);
			BasicPrintMsg.display(this, "File written= '" + lDir + lNameFile + "'");
		}
	}
	
}
