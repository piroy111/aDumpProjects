package aDumpProjects.translatecsvintoenglish.objects;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.translatecsvintoenglish.constants.TRStatic;
import basicmethods.AMDebug;
import basicmethods.BasicPrintMsg;
import basicmethods.ReadFile;
import basicmethods.ReadFile.comReadFile;

public class TRFile {

	protected TRFile(String _sDirSub, String _sNameRoot) {
		pDirSub = _sDirSub;
		pNameRoot = _sNameRoot;
		/**
		 * 
		 */
		pDir = TRStatic.getDIR_SOURCES() + pDirSub;
		pDirTemp = TRStatic.getDIR_TEMP() + pDirSub;
		if (pNameRoot.endsWith(TRStatic.getEXTENSION_ENGLISH()) || pNameRoot.endsWith(TRStatic.getEXTENSION_FRENCH())) {
			BasicPrintMsg.errorCodeLogic();
		}
		pKeyStr = getKey(pDirSub, pNameRoot);
		pNameFrench = pNameRoot + TRStatic.getEXTENSION_FRENCH();
		pNameEnglish = pNameRoot + TRStatic.getEXTENSION_ENGLISH();
	}
	
	/*
	 * Data
	 */
	private String pDir;
	private String pDirTemp;
	private String pDirSub;
	private String pNameRoot;
	private String pKeyStr;
	private String pNameFrench;
	private String pNameEnglish;
	private ReadFile pReadFileSourceFrench;
	private ReadFile pReadFileTemp;
	private List<TRLine> pListTRLine;
	
	/**
	 * Return null if the file does not finish by a root
	 * @param _sNameFile
	 * @return
	 */
	public static String getNameRoot(String _sNameFile) {
		String lExtension = null;
		if (_sNameFile.endsWith(TRStatic.getEXTENSION_ENGLISH())) {
			lExtension = TRStatic.getEXTENSION_ENGLISH();
		} else if (_sNameFile.endsWith(TRStatic.getEXTENSION_FRENCH())) {
			lExtension = TRStatic.getEXTENSION_FRENCH();
		} else {
			return null;
		}
		return _sNameFile.substring(0,  _sNameFile.length() - lExtension.length());
	}
	
	/**
	 * 
	 * @param _sDir
	 * @param _sNameRoot
	 * @return
	 */
	public static String getKey(String _sDirSub, String _sNameRoot) {
		return _sDirSub + ";;" + _sNameRoot;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return pDir + pNameRoot;
	}
	
	/**
	 * read the source file with the title and the text to be translated
	 */
	public final void readFileSourceFrench() {
		ReadFile lReadFile = new ReadFile(pDir + pNameFrench, comReadFile.FULL_COM);
		pReadFileSourceFrench = lReadFile;
		pListTRLine = new ArrayList<>();
		for (int lIdx = 0; lIdx < lReadFile.getmContent().size(); lIdx++) {
			String lLine = lReadFile.getmContent().get(lIdx);
			TRLine lTRLine = getpOrCreateTRLine(lIdx);
			
			/////////////////////////////////////////////////////////////
			if (pDir.equals("C:/Game - Stranded dreams - translation/loc/MIRO1/")
					&& pNameFrench.equals("Discussion_FR.csv")
					&& lIdx == 19) {
				AMDebug.DEBUG();
			}
			
			/////////////////////////////////////////////////////////////
			
			
			lTRLine.initiateFromFullLineInFrench(lLine);
			if (!lTRLine.getpIsValid()) {
				String lErrorMsg =
						"pDir= '" + pDir + "'"
						+ "\npNameFrench= '" + pNameFrench + "'"
						+ "\nlIdxLine= '" + lIdx + "'"
						+ "\nlLine= '" + lLine + "'";
				BasicPrintMsg.error(lErrorMsg);
			}
		}
	}
	
	/**
	 * read the text translated
	 */
	public final void readFileTempEnglish() {
		ReadFile lReadFile = new ReadFile(pDirTemp + pNameEnglish, comReadFile.FULL_COM);
		pReadFileTemp = lReadFile;
		for (int lIdx = 0; lIdx < lReadFile.getmContent().size(); lIdx++) {
			String lLineEnglish = lReadFile.getmContent().get(lIdx);
			TRLine lTRLine = getpOrCreateTRLine(lIdx);
			lTRLine.setpLineEnglish(lLineEnglish);
		}
	}
	
	/**
	 * 
	 * @param _sIdx
	 * @return
	 */
	public TRLine getpOrCreateTRLine(int _sIdx) {
		while (pListTRLine.size() <= _sIdx) {
			pListTRLine.add(new TRLine(this, pListTRLine.size()));
		}
		return pListTRLine.get(_sIdx);		
	}
	
	/*
	 * Getters & Setters
	 */
	public final String getpNameRoot() {
		return pNameRoot;
	}
	public final String getpNameFrench() {
		return pNameFrench;
	}
	public final String getpNameEnglish() {
		return pNameEnglish;
	}
	public final String getpKeyStr() {
		return pKeyStr;
	}
	public final List<TRLine> getpListTRLine() {
		return pListTRLine;
	}
	public final String getpDir() {
		return pDir;
	}
	public final String getpDirTemp() {
		return pDirTemp;
	}
	public final String getpDirSub() {
		return pDirSub;
	}
	public final ReadFile getpReadFileSourceFrench() {
		return pReadFileSourceFrench;
	}
	public final ReadFile getpReadFileTemp() {
		return pReadFileTemp;
	}
	
	
}
