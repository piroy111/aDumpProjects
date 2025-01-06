package aDumpProjects.makeproyclientofbunker.writefiles.toexport;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.makeproyclientofbunker.PRManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;
import basicmethods.BasicFichiers;
import basicmethods.BasicPrintMsg;

public class PRWriteFileCurrent {

	public PRWriteFileCurrent(PRManager _sPRManager) {
		pPRManager = _sPRManager;
	}
	
	/*
	 * Data
	 */
	private PRManager pPRManager;
	
	/**
	 * 
	 */
	public final void run() {
		BasicPrintMsg.displayTitle(this, "write file output bars for website");
		/*
		 * Build file content
		 */
		List<String> lListLineToWrite = new ArrayList<>();
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			for (PRBar lPRBar : lPRMetal.getpListPRBarPROYCurrent()) {
				String lLine = lPRMetal.getpName()
						+ "," + lPRBar.getpID()
						+ "," + lPRBar.getpWeight()
						+ "," + lPRBar.getpIndexAvailability()
						+ "," + lPRBar.getpImpactOnAvailability();
				lListLineToWrite.add(lLine);
			}
		}
		/*
		 * Write file
		 */
		String lDir = PRStaticDir.getOUTPUT_WEBSITE();
		String lNameFile = PRStaticNameFile.getBAR_PROY_TO_UPLOAD_IN_WEBSITE();
		String lHeader = "BKAsset,ID,Weight in Oz,Index availability,Source of availability";
		BasicFichiers.writeFile(this, lDir, lNameFile, lHeader, lListLineToWrite);
	}
	
	
	
}
