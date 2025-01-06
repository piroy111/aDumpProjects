package aDumpProjects.makeproyclientofbunker.loadfiles.specialcaseofsales;

import java.util.List;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;
import basicmethods.BasicDir;
import basicmethods.BasicFile;
import basicmethods.BasicPrintMsg;
import basicmethods.BasicString;
import basicmethods.ReadFile;

public class PRLoaderSales {

	public PRLoaderSales(PRLoaderManager _sPRLoaderManager) {
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
		BasicPrintMsg.displayTitle(this, "Load file for sales");
		/*
		 * Read file
		 */
		String lDir = PRStaticDir.getINPUT();
		String lSuffix = PRStaticNameFile.getSUFFIX_SALES_WEBSITE();
		BasicDir lBasicDir = new BasicDir(lDir, lSuffix);
		BasicFile lBasicFile = lBasicDir.getmTreeMapDateToBasicFile().lastEntry().getValue();
		ReadFile lReadFile = lBasicFile.getmReadFile();
		BasicPrintMsg.display(this, "File found= " + lReadFile.getmDirPlusNameFile());
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
			lIdx++;
			String lMetalName = lListLine.get(++lIdx);
			String lID = lListLine.get(++lIdx);
			double lWeight = BasicString.getDouble(lListLine.get(++lIdx));
			/*
			 * Case of not a bar --> we skip
			 */
			if (!lMetalName.contains("BAR")) {
				continue;
			}
			/*
			 * Create PRBar
			 */
			PRMetal lPRMetal = pPRLoaderManager.getpPRManager().getpPRMetalManager().getpOrCreatePRMetal(lMetalName);
			PRBar lPRBar = lPRMetal.getpOrCreatePRBar(lID);
			lPRBar.setpWeight(Math.abs(lWeight));
			/*
			 * Availability
			 */
			int lImpact = lWeight < 0 ? 1 : -1;
			String lImpactStr = this.getClass().getSimpleName().substring("PRLoader".length()) + "= " + lImpact;
			lPRBar.addpIndexAvailability(lImpact);
			lPRBar.addpImpactOnAvailability(lImpactStr);
		}
		BasicPrintMsg.display(this, "Nb line read= " + lReadFile.getmContentList().size());
	}
	
	
	
}
