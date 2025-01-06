package aDumpProjects.writeallcombinationpokerhands.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aDumpProjects.writeallcombinationpokerhands.Main;
import aDumpProjects.writeallcombinationpokerhands.color.Color;

public class CardManager {

	public CardManager(Main _sMain) {
		pMain = _sMain;
	}

	/**
	 * 
	 */
	private Main pMain;
	private List<Card> pListCard;

	/**
	 * Initiate
	 */
	public final void initiate() {
		/**
		 * Instantiate the cards
		 */
		pListCard = new ArrayList<>();
		for (Color lColor : pMain.getpColorManager().getpListColor()) {
			for (int lIdx = 0; lIdx < 13; lIdx++) {
				pListCard.add(new Card(lColor, lIdx, this));
			}
		}
		/**
		 * Initiate the cards
		 */
		for (Card lCard : pListCard) {
			lCard.initiate();
		}
		/**
		 * 
		 */
		Collections.sort(pListCard);
		/**
		 * 
		 */
		for (Card lCard : pListCard) {
			System.out.println(lCard.getpRankCard() + " - " + lCard);
		}
	}


	/**
	 * Getters & Setters
	 * @return
	 */
	public final List<Card> getpListCard() {
		return pListCard;
	}

}
