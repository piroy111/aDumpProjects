package aDumpProjects.makeproyclientofbunker.objects.bars;

import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import basicmethods.BasicPrintMsg;

public class PRBar implements Comparable<PRBar> {

	public PRBar(String _sID, PRMetal _sPRMetal) {
		pID = _sID;
		pPRMetal = _sPRMetal;
		/*
		 * 
		 */
		pWeight = Double.NaN;
		pImpactOnAvailability = "";
	}
	
	/*
	 * Data
	 */
	private String pID;
	private PRMetal pPRMetal;
	private double pWeight;
	private int pIndexAvailability;
	private String pImpactOnAvailability;
	
	/**
	 * pIndexAvailability == 1 if available, = -1 if not available
	 * @param _sPIndexAvailability
	 */
	public final void addpIndexAvailability(int _sPIndexAvailability) {
		pIndexAvailability += _sPIndexAvailability;
	}
	
	/**
	 * 
	 * @param _sImpactOnAvailability
	 */
	public final void addpImpactOnAvailability (String _sImpactOnAvailability) {
		if (!pImpactOnAvailability.equals("")) {
			pImpactOnAvailability += "; ";
		}
		pImpactOnAvailability += _sImpactOnAvailability;
	}
	
	@Override public int compareTo(PRBar _sPRBar) {
		if (pWeight - _sPRBar.getpWeight() > 0.001) {
			return 1;
		} else if (pWeight - _sPRBar.getpWeight() < -0.001)  {
			return -1;
		} else {
			return 0;
		}
	}
	
	/*
	 * Getters & Setters
	 */
	public final String getpID() {
		return pID;
	}
	public final double getpWeight() {
		return pWeight;
	}
	/**
	 * pIndexAvailability == 1 if available, = -1 if not available
	 * @return
	 */
	public final int getpIndexAvailability() {
		return pIndexAvailability;
	}
	public final PRMetal getpPRMetal() {
		return pPRMetal;
	}
	public final void setpWeight(double _sPWeight) {
		if (!Double.isNaN(pWeight) && Math.abs(pWeight - _sPWeight) > 0.001) {
			BasicPrintMsg.errorCodeLogic();
		}
		pWeight = _sPWeight;
	}
	public final String getpImpactOnAvailability() {
		return pImpactOnAvailability;
	}

	
}
