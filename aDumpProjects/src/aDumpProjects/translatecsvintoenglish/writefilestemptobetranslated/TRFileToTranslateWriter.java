package aDumpProjects.translatecsvintoenglish.writefilestemptobetranslated;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.translatecsvintoenglish.TRManager;
import aDumpProjects.translatecsvintoenglish.constants.TRStatic;
import aDumpProjects.translatecsvintoenglish.objects.TRFile;
import aDumpProjects.translatecsvintoenglish.objects.TRLine;
import basicmethods.BasicFichiers;
import basicmethods.BasicPrintMsg;

public class TRFileToTranslateWriter {

	public TRFileToTranslateWriter(TRManager _sTRManager) {
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
		BasicPrintMsg.displaySuperTitle(this, "Wrtie file .EN.csv with the text to transalte");
		for (TRFile lTRFile : pTRManager.getpTRFileManager().getpMapKeyToTRFile().values()) {
			/*
			 * Lines to write
			 */
			List<String> lListLineToWrite = new ArrayList<>();
			for (TRLine lTRLine : lTRFile.getpListTRLine()) {
				if (lListLineToWrite.size() > 0) {
					lListLineToWrite.add(TRStatic.getSEPARATOR_TRANSLATION());
				}
				lListLineToWrite.add(lTRLine.getpLineFrench());
			}
			/*
			 *	Create directory if necessary 
			 */
			String lDir = TRStatic.getDIR_TEMP() + lTRFile.getpDirSub();
			BasicFichiers.getOrCreateDirectory(lDir);
			/*
			 * Write file
			 */
			String lNameFile = lTRFile.getpNameEnglish();
			BasicFichiers.writeFile(lDir, lNameFile, null, lListLineToWrite);
			/*
			 * Communication
			 */
			BasicPrintMsg.display(this, "File written: " + lDir + lNameFile);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
