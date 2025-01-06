package aDumpProjects.translatecsvintoenglish.readfiles;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import aDumpProjects.translatecsvintoenglish.TRManager;
import aDumpProjects.translatecsvintoenglish.constants.TRStatic;
import aDumpProjects.translatecsvintoenglish.objects.TRFile;
import basicmethods.BasicFichiersNio;
import basicmethods.BasicPrintMsg;

public class TRReadFileManager {

	public TRReadFileManager(TRManager _sTRManager) {
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
		BasicPrintMsg.displaySuperTitle(this, "Reading all the files and filling objects");
		/*
		 * Reading the name of all the files
		 */
		BasicPrintMsg.displayTitle(this, "Reading files from the game itself");
		String lDirRoot = TRStatic.getDIR_SOURCES();
		List<Path> lListPath = BasicFichiersNio.getListFilesAndSubFiles(Paths.get(lDirRoot));
		for (Path lPath : lListPath) {
			String lNameFile = lPath.getFileName().toString();
			if (lNameFile.endsWith(TRStatic.getEXTENSION_FRENCH())) {
				String lDirSub = getDirSub(lDirRoot, lPath);
				TRFile lTRFile = pTRManager.getpTRFileManager().getpOrCreateTRFile(lDirSub, lNameFile);
				lTRFile.readFileSourceFrench();
			}
		}
		/*
		 * Reading the files from the TEMP
		 */
		BasicPrintMsg.displayTitle(this, "Reading files from the temp folder");
		lDirRoot = TRStatic.getDIR_TEMP();
		lListPath = BasicFichiersNio.getListFilesAndSubFiles(Paths.get(lDirRoot));
		for (Path lPath : lListPath) {
			String lNameFile = lPath.getFileName().toString();
			if (lNameFile.endsWith(TRStatic.getEXTENSION_ENGLISH())) {
				String lDirSub = getDirSub(lDirRoot, lPath);
				TRFile lTRFile = pTRManager.getpTRFileManager().getpOrCreateTRFile(lDirSub, lNameFile);
				lTRFile.readFileTempEnglish();
			}
		}
	}

	/**
	 * 
	 * @param _sDirRoot
	 * @param _sPath
	 * @return
	 */
	private String getDirSub(String _sDirRoot, Path _sPath) {
		String lDir = (_sPath.getParent().toString() + "/").replaceAll("\\\\", "/");
		if (!lDir.startsWith(_sDirRoot)) {
			BasicPrintMsg.errorCodeLogic();
		}
		String lDirRoot = lDir.substring(_sDirRoot.length(), lDir.length());
		return lDirRoot;
	}



}
