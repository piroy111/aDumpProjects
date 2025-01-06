package aDumpProjects.writeallcombinationpokerhands.deal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aDumpProjects.writeallcombinationpokerhands.Main;
import aDumpProjects.writeallcombinationpokerhands.card.Card;
import aDumpProjects.writeallcombinationpokerhands.hand.Hand;

public class DealManager {

	public DealManager(Main _sMain) {
		pMain = _sMain;
	}
	
	/**
	 * Data
	 */
	private Main pMain;
	private List<Deal> pListDeal;
	
	
	public final void run() {
		/*
		 * Initiate
		 */
		pListDeal = new ArrayList<>();
		List<Card> lListCard = pMain.getpCardManager().getpListCard();
		/*
		 * Build all possible deals
		 */		
		for (int lRank0 = 0; lRank0 < 52; lRank0++) {
			Card lCard0 = lListCard.get(lRank0);
			
			for (int lRank1 = lRank0 + 1; lRank1 < 52; lRank1++) {
				Card lCard1 = lListCard.get(lRank1);
				
				for (int lRank2 = lRank1 + 1; lRank2 < 52; lRank2++) {
					Card lCard2 = lListCard.get(lRank2);
					
					for (int lRank3 = lRank2 + 1; lRank3 < 52; lRank3++) {
						Card lCard3 = lListCard.get(lRank3);
						
						for (int lRank4 = lRank3 + 1; lRank4 < 52; lRank4++) {
							Card lCard4 = lListCard.get(lRank4);
							Deal lDeal = new Deal(lCard0, lCard1, lCard2, lCard3, lCard4, this);
							pListDeal.add(lDeal);
						}	
					}	
				}
			}
		}
		System.out.println();
		System.out.println("Number of deals= " + pListDeal.size());
		/*
		 * Sort the deals
		 */
		for (Deal lDeal : pListDeal) {
			lDeal.compute();
		}
		System.out.println();
		System.out.println("Cards inside deals sorted");
		/*
		 * Sort list of deals and assign the rank of the deal
		 */
		Collections.sort(pListDeal);
		for (int lIdx = 0; lIdx < pListDeal.size(); lIdx++) {
			Deal lDeal = pListDeal.get(lIdx);
			lDeal.setpRank(lIdx);
		}
		System.out.println();
		System.out.println("Deals sorted");
		/*
		 * Compute number of cards for each hand
		 */
		for (Deal lDeal : pListDeal) {
			lDeal.getpHand().declareNewDeal(lDeal);
			lDeal.getpHand().incpOccurence();
		}
		System.out.println();
		for (Hand lHand : pMain.getpHandIdentificator().getpListHand()) {
			System.out.println(lHand + " --> " + lHand.getpOccurence());
		}
	}

	
	/**
	 * Find a deal
	 */
	public Deal getpDeal(int _sRank0, int _sRank1, int _sRank2, int _sRank3, int _sRank4) {
		for (Deal lDeal : pListDeal) {
			if (lDeal.getpListCard().get(0).getpRankCard() == _sRank0
					&& lDeal.getpListCard().get(1).getpRankCard() == _sRank1
					&& lDeal.getpListCard().get(2).getpRankCard() == _sRank2
					&& lDeal.getpListCard().get(3).getpRankCard() == _sRank3
					&& lDeal.getpListCard().get(4).getpRankCard() == _sRank4) {
				return lDeal;
			}
		}
		return null;
	}
	
	/*
	 * Getters & Setters
	 */
	public final Main getpMain() {
		return pMain;
	}
	public final List<Deal> getpListDeal() {
		return pListDeal;
	}
	
	
	
}
