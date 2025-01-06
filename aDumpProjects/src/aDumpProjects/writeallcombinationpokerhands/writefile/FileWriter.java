package aDumpProjects.writeallcombinationpokerhands.writefile;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.writeallcombinationpokerhands.Main;
import aDumpProjects.writeallcombinationpokerhands.card.Card;
import aDumpProjects.writeallcombinationpokerhands.deal.Deal;
import aDumpProjects.writeallcombinationpokerhands.hand.Hand;
import basicmethods.BasicFichiers;

public class FileWriter {

	public FileWriter(Main _sMain) {
		pMain = _sMain;
	}

	/*
	 * Data
	 */
	private Main pMain;



	public final void run() {
		/*
		 * Choose which deal to keep
		 */
		List<Deal> lListDealToKeep = new ArrayList<>();
		for (Hand lHand : pMain.getpHandIdentificator().getpListHand()) {
			/*
			 * Initiate
			 */
			List<Deal> lListDealInHand = lHand.getpListDeal();
			int lFreqwuencyToKeep = 2500;
			int lIdxToKeep = 0;
			/*
			 * Add every frequency + add the first and the last
			 */
			while (lIdxToKeep < lListDealInHand.size() - 1) {
				lListDealToKeep.add(lListDealInHand.get(lIdxToKeep));
				lIdxToKeep += lFreqwuencyToKeep;
			}
			lListDealToKeep.add(lListDealInHand.get(lListDealInHand.size() - 1));
		}
		/*
		 * Transform the deals to keep into lines to write
		 */
		List<String> lListLineToWrite = new ArrayList<>();
		for (Deal lDeal : lListDealToKeep) {
			String lLine = "";
			lLine += (Math.floor((1 - lDeal.getpRank() / 2598960.) * 10000) / 10000);
			lLine += "," + lDeal.getpRank();
			lLine += "," + lDeal.getpHand().getpName();
			for (Card lCard : lDeal.getpListCard()) {
				lLine += "," + lCard.getpName();
			}
			lListLineToWrite.add(lLine);
		}
		/*
		 * Transform the deals to keep into lines to write with rank
		 */
		List<String> lListLineToWriteRank = new ArrayList<>();
		for (Deal lDeal : lListDealToKeep) {
			String lLine = "";
			lLine += (Math.floor((1 - lDeal.getpRank() / 2598960.) * 10000) / 10000);
			lLine += "," + lDeal.getpRank();
			lLine += "," + lDeal.getpHand().getpIdx();
			for (Card lCard : lDeal.getpListCard()) {
				lLine += "," + lCard.getpRankCard();
			}
			lListLineToWriteRank.add(lLine);
		}
		/*
		 * Transform the deals to keep into lines to write
		 */
		List<String> lListLineToWriteCode = new ArrayList<>();
		for (Deal lDeal : lListDealToKeep) {
			String lLine = "pListProbaDeals.push([";
			lLine += (Math.floor((1 - lDeal.getpRank() / 2598960.) * 10000) / 10000);
			lLine += "," + lDeal.getpHand().getpIdx();
			for (Card lCard : lDeal.getpListCard()) {
				lLine += ", " + lCard.getpRankCard();
			}
			lLine += "]);";
			lListLineToWriteCode.add(lLine);
		}

		/*
		 * Write file
		 */
		String lDir = "C:/zz_Temp/2023-05-11 - Test poker game/";
		String lNameFile = "poker_deals.csv";
		String lHeader = "Proba success,Rank,Hand,Card0,Card1,Card2,Card3,Card4";
		BasicFichiers.writeFile(lDir, lNameFile, lHeader, lListLineToWrite);
		/*
		 * Write file ranks
		 */
		lNameFile = "Ranks_" + lNameFile;
		BasicFichiers.writeFile(lDir, lNameFile, lHeader, lListLineToWriteRank);
		/*
		 * Write file for code
		 */
		lNameFile = "Code_" + lNameFile;
		BasicFichiers.writeFile(lDir, lNameFile, null, lListLineToWriteCode);
	}

}
