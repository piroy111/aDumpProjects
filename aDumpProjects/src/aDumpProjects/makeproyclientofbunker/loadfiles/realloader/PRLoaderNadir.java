package aDumpProjects.makeproyclientofbunker.loadfiles.realloader;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.loadfiles.abstractloader.PRLoaderAbstract;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;

public class PRLoaderNadir extends PRLoaderAbstract {

	public PRLoaderNadir(PRLoaderManager _sPRLoaderManager) {
		super(_sPRLoaderManager);
	}

	@Override public int addToIndexAvailabilityOfPRBar(PRBar _sPRBar) {
		return -1000;
	}

	@Override public String getpNameFile() {
		return PRStaticNameFile.getNADIR_DEFAULT();
	}

}