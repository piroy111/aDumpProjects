package aDumpProjects.writeallcombinationpokerhands.card;

import aDumpProjects.writeallcombinationpokerhands.color.Color;

public class Card implements Comparable<Card> {

	protected Card(Color _sColor, int _sIdxCard, CardManager _sCardManager) {
		pColor = _sColor;
		pIdxCard = _sIdxCard;
		pCardManager = _sCardManager;
	}
	
	/**
	 * Data
	 */
	private Color pColor;
	private CardManager pCardManager;
	private int pIdxCard;		// [0, 12] = [As, 2]
	private String pName;
	private int pRankCard;		//	[0, 51]
	
	public void initiate() {
		switch(pIdxCard) {
		case 3 : pName = "Jack"; break;
		case 2 : pName = "Queen"; break;
		case 1 : pName = "King"; break;
		case 0 : pName = "As"; break;
		default : pName = "" + (14 - pIdxCard);
		}
		pName += " of " + pColor.getpName();
		/**
		 * 
		 */
		pRankCard = 4 * pIdxCard + pColor.getpIdxColor();
	}
	
	
	@Override public int compareTo(Card _sCard) {
		int lCompareIdxCard = Integer.compare(pIdxCard, _sCard.pIdxCard);
		if (lCompareIdxCard == 0) {
			return pColor.compareTo(_sCard.pColor);
		} else {
			return lCompareIdxCard;
		}
	}
	
	public String toString() {
		return pName;
	}
	
	
	/*
	 * Getters & setters
	 */
	public final CardManager getpCardManager() {
		return pCardManager;
	}
	public final int getpIdxCard() {
		return pIdxCard;
	}
	public final String getpName() {
		return pName;
	}
	public final Color getpColor() {
		return pColor;
	}
	public final int getpRankCard() {
		return pRankCard;
	}
	
}
