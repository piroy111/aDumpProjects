package aDumpProjects.writeallcombinationpokerhands.deal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aDumpProjects.writeallcombinationpokerhands.card.Card;
import aDumpProjects.writeallcombinationpokerhands.color.Color;
import aDumpProjects.writeallcombinationpokerhands.hand.Hand;
import basicmethods.BasicPrintMsg;

public class Deal implements Comparable<Deal> {

	protected Deal(Card _sCard0, Card _sCard1, Card _sCard2, Card _sCard3, Card _sCard4, DealManager _sDealManager) {
		pListCard = new ArrayList<>();
		pListCard.add(_sCard0);
		pListCard.add(_sCard1);
		pListCard.add(_sCard2);
		pListCard.add(_sCard3);
		pListCard.add(_sCard4);
		pDealManager = _sDealManager;

	}

	/*
	 * Data
	 */
	private DealManager pDealManager;
	private List<Card> pListCard; // 5 cards
	private Map<Integer, Integer> pMapCardIdxToOccurence;
	private boolean pIsAllSameColor;
	private Hand pHand;
	private int pRank;
	
	/**
	 * 
	 */
	public final void compute() {
		/*
		 * Initiate
		 */
		pMapCardIdxToOccurence = new HashMap<>();
		pIsAllSameColor = true;
		Color lColor = pListCard.get(0).getpColor();;
		/*
		 * Compute the frequency of each card
		 */		
		for (Card lCard : pListCard) {
			Integer lOccurence = pMapCardIdxToOccurence.get(lCard.getpIdxCard());
			if (lOccurence == null) {
				lOccurence = 0;
			}
			lOccurence++;
			pMapCardIdxToOccurence.put(lCard.getpIdxCard(), lOccurence);
			/*
			 * 
			 */
			if (!lCard.getpColor().equals(lColor)) {
				pIsAllSameColor = false;
			}
		}
		/*
		 * 
		 */
		Collections.sort(pListCard, new sortCardsForDeal());
		/*
		 * 
		 */
		pHand = pDealManager.getpMain().getpHandIdentificator().getpHand(this);
		/*
		 * Specific case of a straight with an Ace --> we need to reorder and put the Ace at the end
		 */
		if (pHand.getpName().contains("Straight") && pListCard.get(0).getpIdxCard() == 0 && pListCard.get(4).getpIdxCard() == 12) {
			Card lCard0 = pListCard.get(0);
			pListCard.remove(0);
			pListCard.add(lCard0);
		}
	}	

	/**
	 * 
	 * @param _sCard0
	 * @param _sCard1
	 * @return
	 */
	public class sortCardsForDeal implements Comparator<Card> {
		public final int compare(Card _sCard0, Card _sCard1) {
			int lOccurence0 = pMapCardIdxToOccurence.get(_sCard0.getpIdxCard());
			int lOccurence1 = pMapCardIdxToOccurence.get(_sCard1.getpIdxCard());
			int lCompareOccurence = lOccurence1 - lOccurence0;
			if (lCompareOccurence != 0) {
				return lCompareOccurence;
			} else {
				return _sCard0.compareTo(_sCard1);
			}
		}
	}

	@Override public int compareTo(Deal _sDeal) {
		int lCompareHand = pHand.compareTo(_sDeal.pHand);
		if (lCompareHand != 0) {
			return lCompareHand;
		} else {
			/*
			 * Compare cards with numbers
			 */
			for (int lIdx = 0; lIdx < 5; lIdx++) {
				Card lCard0 = pListCard.get(lIdx);
				Card lCard1 = _sDeal.getpListCard().get(lIdx);
				int lCompareCard = Integer.compare(lCard0.getpIdxCard(), lCard1.getpIdxCard());
				if (lCompareCard != 0) {
					return lCompareCard;
				}
			}
			/*
			 * If all numbers are the same, then we compare cards with colours
			 */
			for (int lIdx = 0; lIdx < 5; lIdx++) {
				Color lColor0 = pListCard.get(lIdx).getpColor();
				Color lColor1 = _sDeal.getpListCard().get(lIdx).getpColor();
				int lCompareCard = Integer.compare(lColor0.getpIdxColor(), lColor1.getpIdxColor());
				if (lCompareCard != 0) {
					return lCompareCard;
				}
			}
			/*
			 * Should not arrive
			 */
			BasicPrintMsg.errorCodeLogic();
			return -1;
		}
	}

	public String toString() {
		String lToString = "";
		for (int lIdx = 0; lIdx < 5; lIdx++) {
			lToString += pListCard.get(lIdx).toString() + "; ";
		}
		return lToString;
	}

	/**
	 * Getters & Setters
	 */
	public final List<Card> getpListCard() {
		return pListCard;
	}
	public final boolean getpIsAllSameColor() {
		return pIsAllSameColor;
	}
	public final Hand getpHand() {
		return pHand;
	}
	public final int getpRank() {
		return pRank;
	}
	public final void setpRank(int pRank) {
		this.pRank = pRank;
	}






}
