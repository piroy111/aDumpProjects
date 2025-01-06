package aDumpProjects.makeproyclientofbunker.writefiles.toexport;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.makeproyclientofbunker.PRManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import aDumpProjects.makeproyclientofbunker.proy.PRComputor;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticDir;
import aDumpProjects.makeproyclientofbunker.staticdata.PRStaticNameFile;
import basicmethods.BasicFichiers;
import basicmethods.BasicPrintMsg;

public class PRWriteFileForCompta {

	public PRWriteFileForCompta(PRManager _sPRManager) {
		pPRManager = _sPRManager;
	}

	/*
	 * Data
	 */
	private PRManager pPRManager;

	/**
	 * 
	 */
	public final void run() {
		BasicPrintMsg.displayTitle(this, "write file for compta");
		/*
		 * Initiate
		 */
		List<String> lListLineToWrite = new ArrayList<>();
		int lDate = 20210227;
		/*
		 * Cash
		 */
		double lAmountToPay = PRComputor.getHOLDING_USD_PREVIOUS() - pPRManager.getpPRComputor().getpHoldingUSDCurrent();
		String lLineCashPROY = lDate
				+ "," + "USD"
				+ "," + "Buy back of loans into physical bars from PROY"
				+ "," + lAmountToPay
				+ "," + "NaN"
				+ "," + "pierre.roy@hotmail.com"
				+ "," + "Cost of loan";
		String lLineCashBunker = lDate
				+ "," + "USD"
				+ "," + "Buy back of loans into physical bars from PROY"
				+ "," + (-lAmountToPay)
				+ "," + "NaN"
				+ "," + "contact@bunker-group.com"
				+ "," + "Cost of loan";
		lListLineToWrite.add(lLineCashPROY);
		lListLineToWrite.add(lLineCashBunker);
		lListLineToWrite.add("#");
		/*
		 * Loans
		 */
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			String lLineLoanPROY = lDate
					+ "," + lPRMetal.getpName().replaceAll("BAR", "LOAN")
					+ "," + "Buy back of loans into physical bars from PROY"
					+ "," + (-lPRMetal.getpAmountLoanOz())
					+ "," + "NaN"
					+ "," + "pierre.roy@hotmail.com"
					+ "," + "Cost of loan";
			String lLineLoanBunker = lDate
					+ "," + lPRMetal.getpName().replaceAll("BAR", "LOAN")
					+ "," + "Buy back of loans into physical bars from PROY"
					+ "," + (lPRMetal.getpAmountLoanOz())
					+ "," + "NaN"
					+ "," + "contact@bunker-group.com"
					+ "," + "Cost of loan";
			lListLineToWrite.add(lLineLoanPROY);
			lListLineToWrite.add(lLineLoanBunker);
			lListLineToWrite.add("#");
		}
		/*
		 * Loss of bars
		 */
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			for (PRBar lPRBar : lPRMetal.getpListPRBarPROYPrevious()) {
				if (!lPRMetal.getpListPRBarPROYCurrent().contains(lPRBar)) {
					String lLineLossBarPROY = lDate
							+ "," + lPRMetal.getpName()
							+ "," + lPRBar.getpID()
							+ "," + (-lPRBar.getpWeight())
							+ "," + "NaN"
							+ "," + "pierre.roy@hotmail.com"
							+ "," + "Bars";
					String lLineLossBarBunker = lDate
							+ "," + lPRMetal.getpName()
							+ "," + lPRBar.getpID()
							+ "," + (+lPRBar.getpWeight())
							+ "," + "NaN"
							+ "," + "contact@bunker-group.com"
							+ "," + "Bars";
					lListLineToWrite.add(lLineLossBarPROY);
					lListLineToWrite.add(lLineLossBarBunker);
				}
			}
			lListLineToWrite.add("#");
		}
		/*
		 * Gain of bars
		 */
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			for (PRBar lPRBar : lPRMetal.getpListPRBarPROYCurrent()) {
				if (!lPRMetal.getpListPRBarPROYPrevious().contains(lPRBar)) {
					String lLineGainBarPROY = lDate
							+ "," + lPRMetal.getpName()
							+ "," + lPRBar.getpID()
							+ "," + (+lPRBar.getpWeight())
							+ "," + "NaN"
							+ "," + "pierre.roy@hotmail.com"
							+ "," + "Bars";
					String lLineGainBarBunker = lDate
							+ "," + lPRMetal.getpName()
							+ "," + lPRBar.getpID()
							+ "," + (-lPRBar.getpWeight())
							+ "," + "NaN"
							+ "," + "contact@bunker-group.com"
							+ "," + "Bars";
					lListLineToWrite.add(lLineGainBarPROY);
					lListLineToWrite.add(lLineGainBarBunker);
				}
			}
			lListLineToWrite.add("#");
		}
		/*
		 * Write file
		 */
		String lDir = PRStaticDir.getOUTPUT_COMPTA();
		String lNameFile = PRStaticNameFile.getOUTPUT_COMPTA();
		String lHeader = "#Date of the transaction,BKASset (as per names in the conf file 'Prices_histo_assets.csv'),Comment,Quantity,Price (for physical assets write NaN; for paper assets we must have a price executed),BKAccount (email as per the emails in the conf file 'Accounts and currency.csv'),BKIncome (as per names in the conf file 'BKIncome.csv')";
		BasicFichiers.writeFile(this, lDir, lNameFile, lHeader, lListLineToWrite);
	}
	
}
