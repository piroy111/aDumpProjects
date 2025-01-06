package aDumpProjects.makeproyclientofbunker.objects.metal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;

public class PRMetal {

	protected PRMetal(String _sName, PRMetalManager _sPRMetalManager) {
		pName = _sName;
		pPRMetalManager = _sPRMetalManager;
		/*
		 * 
		 */
		pMapIDToPRBar = new HashMap<>();
		pListPRBarPROYPrevious = new ArrayList<>();
		pListPRBarPROYCurrent = new ArrayList<>();
	}
	
	/*
	 * Data
	 */
	private String pName;
	private PRMetalManager pPRMetalManager;
	private Map<String, PRBar> pMapIDToPRBar;
	private List<PRBar> pListPRBarPROYPrevious;
	private List<PRBar> pListPRBarPROYCurrent;
	private double pAmountOzCurrent;
	private double pAmountOzPrevious;
	private double pAmountLoanOz;
	private double pPrice;
	private double pAmountAdditionalOz;
	private double pAmountAdditionalUSD;
	
	/**
	 * 
	 * @param _sID
	 * @return
	 */
	public final PRBar getpOrCreatePRBar(String _sID) {
		PRBar lPRBar = pMapIDToPRBar.get(_sID);
		if (lPRBar == null) {
			lPRBar = new PRBar(_sID, this);
			pMapIDToPRBar.put(_sID, lPRBar);
		}
		return lPRBar;
	}
	
	/**
	 * 
	 * @param _sPRBar
	 */
	public final void declareNewPRBarPrevious(PRBar _sPRBar) {
		pListPRBarPROYPrevious.add(_sPRBar);
		pAmountOzPrevious += _sPRBar.getpWeight();
	}
	
	/**
	 * 
	 * @param _sPRBar
	 */
	public final void declareNewPRBarCurrent(PRBar _sPRBar) {
		pListPRBarPROYCurrent.add(_sPRBar);
		pAmountOzCurrent += _sPRBar.getpWeight();
	}
	
	/*
	 * Getters & Setters
	 */
	public final String getpName() {
		return pName;
	}
	public final PRMetalManager getpPRMetalManager() {
		return pPRMetalManager;
	}
	public final Map<String, PRBar> getpMapIDToPRBar() {
		return pMapIDToPRBar;
	}
	public final List<PRBar> getpListPRBarPROYPrevious() {
		return pListPRBarPROYPrevious;
	}
	public final List<PRBar> getpListPRBarPROYCurrent() {
		return pListPRBarPROYCurrent;
	}
	public final double getpAmountOzCurrent() {
		return pAmountOzCurrent;
	}
	public final double getpAmountOzPrevious() {
		return pAmountOzPrevious;
	}

	public final double getpAmountLoanOz() {
		return pAmountLoanOz;
	}

	public final void setpAmountLoanOz(double _sPAmountLoanOz) {
		pAmountLoanOz = _sPAmountLoanOz;
	}

	public final double getpPrice() {
		return pPrice;
	}

	public final void setpPrice(double _sPPrice) {
		pPrice = _sPPrice;
	}

	public final double getpAmountAdditionalOz() {
		return pAmountAdditionalOz;
	}

	public final void setpAmountAdditionalOz(double _sPAmountAdditionalOz) {
		pAmountAdditionalOz = _sPAmountAdditionalOz;
	}

	public final double getpAmountAdditionalUSD() {
		return pAmountAdditionalUSD;
	}

	public final void setpAmountAdditionalUSD(double _sPAmountAdditionalUSD) {
		pAmountAdditionalUSD = _sPAmountAdditionalUSD;
	}
	
}
