package aDumpProjects.translatecsvintoenglish.objects;

import java.util.HashMap;
import java.util.Map;

import aDumpProjects.translatecsvintoenglish.TRManager;

public class TRFileManager {

	public TRFileManager(TRManager _sTRManager) {
		pTRManager = _sTRManager;
		/*
		 * 
		 */
		pMapKeyToTRFile = new HashMap<>();
	}

	/*
	 * Data
	 */
	private TRManager pTRManager;
	private Map<String, TRFile> pMapKeyToTRFile;

	/**
	 * Classic get or create / except that it returns null if the file is not of the relevant type with the expected extension French or English
	 * @param _sDir
	 * @param _sNameFile
	 * @return
	 */
	public final TRFile getpOrCreateTRFile(String _sDirSub, String _sNameFile) {
		String lNameRoot = TRFile.getNameRoot(_sNameFile);
		if (lNameRoot == null) {
			return null;
		}
		String lKeyStr = TRFile.getKey(_sDirSub, lNameRoot);
		TRFile lTRFile = pMapKeyToTRFile.get(lKeyStr);
		if (lTRFile == null) {
			lTRFile = new TRFile(_sDirSub, lNameRoot);
			pMapKeyToTRFile.put(lKeyStr, lTRFile);
		}
		return lTRFile;
	}
	
	/*
	 * Getters & Setters
	 */
	public final TRManager getpTRManager() {
		return pTRManager;
	}
	public final Map<String, TRFile> getpMapKeyToTRFile() {
		return pMapKeyToTRFile;
	}



}
