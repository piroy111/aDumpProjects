package aDumpProjects.makeproyclientofbunker.loadfiles.abstractloader;

import java.util.List;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import basicmethods.BasicPrintMsg;
import basicmethods.BasicString;
import basicmethods.ReadFile;
import basicmethods.ReadFile.comReadFile;

public abstract class PRLoaderAbstract {

	public PRLoaderAbstract(PRLoaderManager _sPRLoaderManager) {
		pPRLoaderManager = _sPRLoaderManager;
		/*
		 * 
		 */
		pPRLoaderManager.declareNewPRLoaderAbstract(this);
	}
	
	/*
	 * Abstract
	 */
	public abstract int addToIndexAvailabilityOfPRBar(PRBar _sPRBar);
	public abstract String getpNameFile();
	/*
	 * Data
	 */
	protected PRLoaderManager pPRLoaderManager;
	
	
	/**
	 * 
	 */
	public final void loadFile() {
		BasicPrintMsg.displayTitle(this, "Load file");
		/*
		 * Read file
		 */
		String lDir = PRStaticDir.getINPUT();
		String lNameFile = getpNameFile();
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
			String lID = lListLine.get(++lIdx);
			double lWeight = BasicString.getDouble(lListLine.get(++lIdx));
			/*
			 * Create PRBar
			 */
			PRMetal lPRMetal = pPRLoaderManager.getpPRManager().getpPRMetalManager().getpOrCreatePRMetal(lMetalName);
			PRBar lPRBar = lPRMetal.getpOrCreatePRBar(lID);
			lPRBar.setpWeight(lWeight);
			/*
			 * Impact on availability
			 */
			int lImpact = addToIndexAvailabilityOfPRBar(lPRBar);
			String lImpactStr = this.getClass().getSimpleName().substring("PRLoader".length()) + "= " + lImpact;
			lPRBar.addpIndexAvailability(lImpact);
			lPRBar.addpImpactOnAvailability(lImpactStr);
		}
		BasicPrintMsg.display(this, "Nb line read= " + lReadFile.getmContentList().size());
	}
	
	
	
}
