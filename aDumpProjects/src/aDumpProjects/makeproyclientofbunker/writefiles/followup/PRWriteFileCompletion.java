package aDumpProjects.makeproyclientofbunker.writefiles.followup;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.makeproyclientofbunker.PRManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;
import basicmethods.BasicFichiers;
import basicmethods.BasicPrintMsg;

public class PRWriteFileCompletion {

	public PRWriteFileCompletion(PRManager _sPRManager) {
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
		BasicPrintMsg.displayTitle(this, "write file output bars completed to PROY");
		/*
		 * Compute
		 */
		List<PRBar> lListPRBar = new ArrayList<>();
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			for (PRBar lPRBar : lPRMetal.getpListPRBarPROYCurrent()) {
				if (!lPRMetal.getpListPRBarPROYPrevious().contains(lPRBar)) {
					lListPRBar.add(lPRBar);
				}
			}
		}
		/*
		 * Build file content
		 */
		List<String> lListLineToWrite = new ArrayList<>();
		for (PRBar lPRBar : lListPRBar) {
			String lLine = lPRBar.getpPRMetal().getpName()
					+ "," + lPRBar.getpID()
					+ "," + lPRBar.getpWeight()
					+ "," + lPRBar.getpIndexAvailability()
					+ "," + lPRBar.getpImpactOnAvailability();
			lListLineToWrite.add(lLine);
		}
		/*
		 * Write file
		 */
		String lDir = PRStaticDir.getOUTPUT();
		String lNameFile = PRStaticNameFile.getBAR_COMPLETION();
		String lHeader = "BKAsset,ID,Weight in Oz,Index availability,Source of availability";
		BasicFichiers.writeFile(this, lDir, lNameFile, lHeader, lListLineToWrite);
	}

}
