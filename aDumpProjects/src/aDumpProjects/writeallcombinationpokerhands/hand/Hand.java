package aDumpProjects.writeallcombinationpokerhands.hand;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.writeallcombinationpokerhands.deal.Deal;
import basicmethods.BasicPrintMsg;

public class Hand implements Comparable<Hand> {

	protected Hand(int _sIdx) {
		pIdx = _sIdx;
		/**
		 * 
		 */
		pName = findName();
		pListDeal = new ArrayList<>();
	}

	/**
	 * 
	 */
	private int pIdx;
	private String pName;
	private int pOccurence;
	private List<Deal> pListDeal;



	private String findName() {
		switch (pIdx) {
		case 0 : return "Royal flush";
		case 1 : return "Straight flush";
		case 2 : return "Four of a kind";
		case 3 : return "Full house";
		case 4 : return "Flush";
		case 5 : return "Straight";
		case 6 : return "Three of a kind";
		case 7 : return "Two pairs";
		case 8 : return "One pair";
		case 9 : return "Highest card";
		default : BasicPrintMsg.errorCodeLogic(); return "";				
		}
	}
	
	/**
	 * 
	 * @param _sDeal
	 */
	public final void declareNewDeal(Deal _sDeal) {
		pListDeal.add(_sDeal);
	}
	
	public String toString() {
		return pName + " (rank= " + pIdx + ")";
	}


	@Override public int compareTo(Hand _sHand) {
		return Integer.compare(pIdx, _sHand.pIdx);
	}

	/**
	 * Getters & Setters
	 * @return
	 */
	public final int getpIdx() {
		return pIdx;
	}
	public final String getpName() {
		return pName;
	}
	public final int getpOccurence() {
		return pOccurence;
	}
	public final void incpOccurence() {
		this.pOccurence++;
	}
	public final List<Deal> getpListDeal() {
		return pListDeal;
	}
	
	


}
