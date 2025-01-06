package aDumpProjects.makeproyclientofbunker.loadfiles.loans;

import java.util.List;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;
import basicmethods.BasicPrintMsg;
import basicmethods.BasicString;
import basicmethods.ReadFile;
import basicmethods.ReadFile.comReadFile;

public class PRLoaderLoans {

	public PRLoaderLoans(PRLoaderManager _sPRLoaderManager) {
		pPRLoaderManager = _sPRLoaderManager;
	}
	
	/*
	 * Data
	 */
	protected PRLoaderManager pPRLoaderManager;
	
	
	/**
	 * 
	 */
	public final void loadFile() {
		BasicPrintMsg.displayTitle(this, "Load file loans");
		/*
		 * Read file
		 */
		String lDir = PRStaticDir.getINPUT();
		String lNameFile = PRStaticNameFile.getLOANS();
		ReadFile lReadFile = new ReadFile(lDir, lNameFile, comReadFile.FULL_COM);
		/*
		 * Load BKBar
		 */
		for (List<String> lListLine : lReadFile.getmContentList()) {
			if (lListLine.size() == 0 || lListLine.get(0).equals("")) {
				continue;
			}
			/*
			 * Load line
			 */
			int lIdx = -1;
			String lMetalName = lListLine.get(++lIdx);
			double lAmountLoan = BasicString.getDouble(lListLine.get(++lIdx));
			double lPrice = BasicString.getDouble(lListLine.get(++lIdx));
			/*
			 * Store loan amount
			 */
			PRMetal lPRMetal = pPRLoaderManager.getpPRManager().getpPRMetalManager().getpOrCreatePRMetal(lMetalName);
			lPRMetal.setpAmountLoanOz(lAmountLoan);
			lPRMetal.setpPrice(lPrice);
		}
	}
	
	
	
}
