package aDumpProjects.translatecsvintoenglish.objects;

import aDumpProjects.translatecsvintoenglish.constants.TRStatic;

public class TRLine {

	protected TRLine(TRFile _sTRFile, int _sIdxLineInFile) {
		pTRFile = _sTRFile;
		pIdxLineInFile = _sIdxLineInFile;
	}
	
	/*
	 * Data
	 */
	private TRFile pTRFile;
	private int pIdxLineInFile;
	private String pTitle;
	private String pLineFrench;
	private String pLineEnglish;
	private boolean pIsValid;
	
	/**
	 * 
	 */
	protected final void initiateFromFullLineInFrench(String _sFullLineInFrench) {
		String[] lArray = _sFullLineInFrench.split(TRStatic.getSEPARATOR(), 2);
		if (lArray.length == 2) {
			pIsValid = true;
			pTitle = lArray[0];
			pLineFrench = lArray[1];
		} else {
			pIsValid = false;
		}				
	}

	/*
	 * Getters & Setters
	 */
	public final String getpLineFrench() {
		return pLineFrench;
	}
	public final String getpLineEnglish() {
		return pLineEnglish;
	}
	public final boolean getpIsValid() {
		return pIsValid;
	}
	public final void setpLineEnglish(String pLineEnglish) {
		this.pLineEnglish = pLineEnglish;
	}
	public final String getpTitle() {
		return pTitle;
	}
	public final TRFile getpTRFile() {
		return pTRFile;
	}
	public final int getpIdxLineInFile() {
		return pIdxLineInFile;
	}
	 
	
	
}
