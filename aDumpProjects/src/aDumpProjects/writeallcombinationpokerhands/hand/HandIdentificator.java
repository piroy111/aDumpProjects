package aDumpProjects.writeallcombinationpokerhands.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aDumpProjects.writeallcombinationpokerhands.card.Card;
import aDumpProjects.writeallcombinationpokerhands.deal.Deal;

public class HandIdentificator {

	public HandIdentificator() {
	}

	/**
	 * 
	 */
	private List<Hand> pListHand;


	/**
	 * 
	 */
	public final void initiate() {
		pListHand = new ArrayList<>();
		for (int lIdx = 0; lIdx < 10; lIdx++) {
			pListHand.add(new Hand(lIdx));
		}
		Collections.sort(pListHand);
	}

	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	public Hand getpHand(Deal _sDeal) {
		return pListHand.get(getpIdxHand(_sDeal));
	}


	private int getpIdxHand(Deal _sDeal) {
		if (getpIsRoyalFlush(_sDeal)) {
			return 0;
		} else if (getpIsStraightFlush(_sDeal)) {
			return 1;
		} else if (getpIsFourOfAKind(_sDeal)) {
			return 2;
		} else if (getpIsFullHouse(_sDeal)) {
			return 3;
		} else if (getpIsFlush(_sDeal)) {
			return 4;
		} else if (getpIsStraight(_sDeal)) {
			return 5;
		} else if (getpIsThreeOfAKind(_sDeal)) {
			return 6;
		} else if (getpIsTwoPairs(_sDeal)) {
			return 7;
		} else if (getpIsOnePair(_sDeal)) {
			return 8;
		} else {
			return 9;
		}	
	}


	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsRoyalFlush(Deal _sDeal) {
		return getpIsStraightFlush(_sDeal) && _sDeal.getpListCard().get(1).getpIdxCard() == 1;
	}

	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsStraightFlush(Deal _sDeal) {
		return getpIsFlush(_sDeal) && getpIsStraight(_sDeal);
	}


	/**
	 * 
	 */
	private boolean getpIsFourOfAKind(Deal _sDeal) {
		Card lCard0 = _sDeal.getpListCard().get(0);
		for (int lIdx = 1; lIdx < 4; lIdx++) {
			Card lCard = _sDeal.getpListCard().get(lIdx);
			if (lCard.getpIdxCard() != lCard0.getpIdxCard()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 */
	private boolean getpIsFullHouse(Deal _sDeal) {
		return getpIsThreeOfAKind(_sDeal) 
				&& _sDeal.getpListCard().get(3).getpIdxCard() == _sDeal.getpListCard().get(4).getpIdxCard();
	}

	/**
	 * 
	 */
	private boolean getpIsFlush(Deal _sDeal) {
		return _sDeal.getpIsAllSameColor();
	}


	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsStraight(Deal _sDeal) {
		/*
		 * Case of the Ace which is the 1 instead of the Ace
		 */
		if (_sDeal.getpListCard().get(0).getpIdxCard() == 0) {
			boolean lIsCheckStraightWithAceAsOne = true;
			for (int lIdx = 1; lIdx < 4; lIdx++) {
				Card lCard = _sDeal.getpListCard().get(lIdx);
				if (lCard.getpIdxCard() != lIdx + 8) {
					lIsCheckStraightWithAceAsOne = false;
					break;
				}
			}
			if (lIsCheckStraightWithAceAsOne) {
				return true;
			}
		}
		/*
		 * Normal case
		 */
		for (int lIdx = 0; lIdx < 4; lIdx++) {
			Card lCard = _sDeal.getpListCard().get(lIdx);
			Card lCardNext = _sDeal.getpListCard().get(lIdx + 1);
			if (lCardNext.getpIdxCard() != lCard.getpIdxCard() + 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsThreeOfAKind(Deal _sDeal) {
		Card lCard0 = _sDeal.getpListCard().get(0);
		for (int lIdx = 1; lIdx < 3; lIdx++) {
			Card lCard = _sDeal.getpListCard().get(lIdx);
			if (lCard.getpIdxCard() != lCard0.getpIdxCard()) {
				return false;
			}
		}
		return true;
	}


	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsTwoPairs(Deal _sDeal) {
		if (_sDeal.getpListCard().get(0).getpIdxCard() != _sDeal.getpListCard().get(1).getpIdxCard()) {
			return false;
		}
		if (_sDeal.getpListCard().get(2).getpIdxCard() != _sDeal.getpListCard().get(3).getpIdxCard()) {
			return false;
		}
		return true;
	}


	/**
	 * 
	 * @param _sDeal
	 * @return
	 */
	private boolean getpIsOnePair(Deal _sDeal) {
		if (_sDeal.getpListCard().get(0).getpIdxCard() != _sDeal.getpListCard().get(1).getpIdxCard()) {
			return false;
		}
		return true;
	}

	public final List<Hand> getpListHand() {
		return pListHand;
	}























}
