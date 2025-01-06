package aDumpProjects.makeproyclientofbunker.loadfiles.realloader;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.loadfiles.abstractloader.PRLoaderAbstract;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;

public class PRLoaderPROY extends PRLoaderAbstract {

	public PRLoaderPROY(PRLoaderManager _sPRLoaderManager) {
		super(_sPRLoaderManager);
	}

	@Override public int addToIndexAvailabilityOfPRBar(PRBar _sPRBar) {
		_sPRBar.getpPRMetal().declareNewPRBarPrevious(_sPRBar);
		return 0;
	}

	@Override public String getpNameFile() {
		return PRStaticNameFile.getPROY();
	}

}
