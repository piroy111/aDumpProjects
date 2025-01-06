package aDumpProjects.pi_randomness;

import java.util.ArrayList;
import java.util.List;

import basicmethods.BasicPrintMsg;
import basicmethods.BasicString;
import basicmethods.ReadFile;
import basicmethods.ReadFile.comReadFile;

public class PIMain {

	private List<Integer> pListDecimals;
	private List<Double> pListProba;
	private List<List<Double>> pListProbaDoublet;
	
	public void run() {
		loadPi();
		computeProbaEachNumber(10000L);
//		computeProbaDoublet(-1);
	}
	
	public void loadPi() {
		BasicPrintMsg.displayTitle(this, "Read file with decimals of PI");
		String lPath = "C:/Users/pierr/OneDrive/02_Autres_personnes/02_Liliane/10_Grand_oral_du_BAC/Pi/";
		String lNameFile = "Pi_1million.csv";
		ReadFile lReadFile = new ReadFile(lPath, lNameFile, comReadFile.FULL_COM);
		pListDecimals = new ArrayList<>();
		String lLine = lReadFile.getmContent().get(0);
		for (int lIdx = 0; lIdx < lLine.length(); lIdx++) {
			pListDecimals.add(BasicString.getInt(lLine.substring(lIdx, lIdx + 1)));
		}
		System.out.println("Pi loaded. Number of decimals= " + pListDecimals.size());
	}
	
	public final void computeProbaEachNumber(long _sNbDecimals) {
		BasicPrintMsg.displayTitle(this, "Count occurence of each number 0..9 in the decimals of Pi");
		/*
		 * Initiate
		 */
		pListProba = new ArrayList<>();
		List<Long> lListCounts = new ArrayList<>();
		for (int lIdx = 0; lIdx <= 9; lIdx++) {
			lListCounts.add(0L);
		}
		/*
		 * Number of decimal we consider 
		 */
		long lNbDecimals = _sNbDecimals;
		if (lNbDecimals < 0 || lNbDecimals > pListDecimals.size()) {
			lNbDecimals = pListDecimals.size();
		}
		/*
		 * Compute counts
		 */
		for (int lIdx = 0; lIdx < lNbDecimals; lIdx++) {
			int lDecimal = pListDecimals.get(lIdx);
			long lCount = lListCounts.get(lDecimal);
			lListCounts.set(lDecimal, lCount + 1);
		}
		/*
		 * Compute PROBAS
		 */
		double lProbaMin = 1;
		double lProbaMax = 0;
		for (int lIdx = 0; lIdx <= 9; lIdx++) {
			long lCount = lListCounts.get(lIdx);
			double lProba = lCount * 1. / pListDecimals.size();
			pListProba.add(lProba);
			lProbaMin = Math.min(lProbaMin, lProba);
			lProbaMax = Math.max(lProbaMax, lProba);
		}		
		/*
		 * Display
		 */
		System.out.println("Number of decimals= " + lNbDecimals);
		for (int lIdx = 0; lIdx <= 9; lIdx++) {
			String lMsg = "Decimal= " + lIdx
					+ " -> Count= " + lListCounts.get(lIdx)
					+ " -> Proba= " + BasicPrintMsg.displayPctWithSignificantDigits(pListProba.get(lIdx), 5);
			System.out.println(lMsg);
		}
		double lProbaMean = (lProbaMax + lProbaMin) / 2;
		System.out.println("Erreur max= " + BasicPrintMsg.displayPctWithSignificantDigits((lProbaMax - lProbaMin) / lProbaMean, 5));
	}


	public final void computeProbaDoublet(long _sNbDecimals) {
		BasicPrintMsg.displayTitle(this, "Compute proba doublet");
		/*
		 * Initiate
		 */
		List<List<Long>> lListListCountX0X1 = new ArrayList<>();
		for (int lX0 = 0; lX0 <=9; lX0++) {
			List<Long> lListCountX1 = new ArrayList<>();			
			lListListCountX0X1.add(lListCountX1);
			for (int lX1 = 0; lX1 <=9; lX1++) {
				lListCountX1.add(0L);				
			}
		}
		/*
		 * Number of decimal we consider 
		 */
		long lNbDecimals = _sNbDecimals;
		if (lNbDecimals < 0 || lNbDecimals > pListDecimals.size()) {
			lNbDecimals = pListDecimals.size();
		}
		/*
		 * Count
		 */
		for (int lIdx = 0; lIdx < lNbDecimals - 1; lIdx++) {
			int lDecimal0 = pListDecimals.get(lIdx);
			int lDecimal1 = pListDecimals.get(lIdx + 1);
			List<Long> lListCountX1 = lListListCountX0X1.get(lDecimal0);
			long lCount = lListCountX1.get(lDecimal1);
			lListCountX1.set(lDecimal1, lCount + 1);			
		}
		/*
		 * Compute PROBAS
		 */
		pListProbaDoublet = new ArrayList<>();
		double lError = 0;
		for (int lX0 = 0; lX0 <=9; lX0++) {
			List<Long> lListCountX1 = lListListCountX0X1.get(lX0);
			List<Double> lListProba = new ArrayList<>();
			pListProbaDoublet.add(lListProba);
			for (int lX1 = 0; lX1 <=9; lX1++) {
				double lProba = lListCountX1.get(lX1) * 1. / (lNbDecimals - 1);
				lListProba.add(lProba);
				double lProbaProduit = pListProba.get(lX0) * pListProba.get(lX1);
				lError = Math.max(lError, Math.abs(lProbaProduit - lProba));
			}
		}		
		/*
		 * Display
		 */
		for (int lX0 = 0; lX0 <=9; lX0++) {
			for (int lX1 = 0; lX1 <=9; lX1++) {
				double lProba = pListProbaDoublet.get(lX0).get(lX1);
				System.out.println("Proba(X0= " + lX0 + ", X1= " + lX1 + ")= " + BasicPrintMsg.displayPctWithSignificantDigits(lProba ,2)
				+ "; Proba(" + lX0 + ")*Proba(" + lX1 + ")= " + BasicPrintMsg.displayPctWithSignificantDigits(pListProba.get(lX0) * pListProba.get(lX1) ,2));
			}
		}
		System.out.println("Error= " + BasicPrintMsg.displayPctWithSignificantDigits(lError, 5));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
