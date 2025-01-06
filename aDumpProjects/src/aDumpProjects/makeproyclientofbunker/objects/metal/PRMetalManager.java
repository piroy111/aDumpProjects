package aDumpProjects.makeproyclientofbunker.objects.metal;

import java.util.HashMap;
import java.util.Map;

import aDumpProjects.makeproyclientofbunker.PRManager;

public class PRMetalManager {

	public PRMetalManager(PRManager _sPRManager) {
		pPRManager = _sPRManager;
		/*
		 * 
		 */
		pMapIDToPRMetal = new HashMap<>();
	}
	
	/*
	 * Data
	 */
	private PRManager pPRManager;
	private Map<String, PRMetal> pMapIDToPRMetal;
	
	/**
	 * 
	 * @param _sName
	 * @return
	 */
	public final PRMetal getpOrCreatePRMetal(String _sName) {
		PRMetal lPRMetal = pMapIDToPRMetal.get(_sName);
		if (lPRMetal == null) {
			lPRMetal = new PRMetal(_sName, this);
			pMapIDToPRMetal.put(_sName, lPRMetal);
		}
		return lPRMetal;
	}

	/*
	 * Getters & Setters
	 */
	public final PRManager getpPRManager() {
		return pPRManager;
	}
	public final Map<String, PRMetal> getpMapIDToPRMetal() {
		return pMapIDToPRMetal;
	}
	
}
