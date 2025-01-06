package aDumpProjects.makeproyclientofbunker.loadfiles.realloader;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.loadfiles.abstractloader.PRLoaderAbstract;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;

public class PRLoaderBunker extends PRLoaderAbstract {

	public PRLoaderBunker(PRLoaderManager _sPRLoaderManager) {
		super(_sPRLoaderManager);
	}

	@Override public int addToIndexAvailabilityOfPRBar(PRBar _sPRBar) {
		return 1;
	}

	@Override public String getpNameFile() {
		return PRStaticNameFile.getBUNKER();
	}

}
