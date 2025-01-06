package aDumpProjects.makeproyclientofbunker.proy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aDumpProjects.makeproyclientofbunker.PRManager;
import aDumpProjects.makeproyclientofbunker.objects.bars.PRBar;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetal;
import basicmethods.AMNumberTools;
import basicmethods.BasicPrintMsg;

public class PRComputor {

	public PRComputor(PRManager _sPRManager) {
		pPRManager = _sPRManager;
	}

	/*
	 * Static
	 */
	private static double HOLDING_USD_PREVIOUS = 12872767.5135401;
	/*
	 * Data
	 */
	private PRManager pPRManager;
	private double pHoldingUSDCurrent;

	/**
	 * 
	 */
	public final void run() {
		BasicPrintMsg.displaySuperTitle(this, "Compute");
		keepBarsPROYAvailable();
		addbarsfromavailable();
		computeAmountToPay();
	}

	/**
	 * 
	 */
	private void keepBarsPROYAvailable() {
		BasicPrintMsg.displayTitle(this, "Keep previous bars available");
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			for (PRBar lPRBar : lPRMetal.getpListPRBarPROYPrevious()) {
				if (lPRBar.getpIndexAvailability() >= 0) {
					lPRMetal.declareNewPRBarCurrent(lPRBar);
				}
			}
		}
		displayOz();
	}

	/**
	 * 
	 */
	private void addbarsfromavailable() {
		BasicPrintMsg.displayTitle(this, "Complete with bars currently available");
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			/*
			 * Find the list of bars that we can add
			 */
			List<PRBar> lListPRBarAvailable = new ArrayList<>();
			for (PRBar lPRBar : lPRMetal.getpMapIDToPRBar().values()) {
				if (!lPRMetal.getpListPRBarPROYPrevious().contains(lPRBar)
						&& lPRBar.getpIndexAvailability() >= 1) {
					lListPRBarAvailable.add(lPRBar);
				}
			}
			Collections.sort(lListPRBarAvailable);
			/*
			 * Add the bars up to the missing quantity
			 */
			for (PRBar lPRBar : lListPRBarAvailable) {
				double lAmountTarget = lPRMetal.getpAmountOzPrevious() + lPRMetal.getpAmountLoanOz();
				double lAmountCurrent = lPRMetal.getpAmountOzCurrent();
				if (AMNumberTools.isSmallerStrict(lAmountCurrent, lAmountTarget)) {
					lPRMetal.declareNewPRBarCurrent(lPRBar);
				} else {
					break;
				}
			}
		}
		displayOz();
	}

	/**
	 * 
	 */
	private void displayOz() {
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			BasicPrintMsg.display(this, lPRMetal.getpName() + " previous= " + lPRMetal.getpAmountOzPrevious());
			BasicPrintMsg.display(this, lPRMetal.getpName() + " loan    = " + lPRMetal.getpAmountLoanOz());
			BasicPrintMsg.display(this, lPRMetal.getpName() + " current = " + lPRMetal.getpAmountOzCurrent());
			BasicPrintMsg.display(this, lPRMetal.getpName() + " missing = " + (lPRMetal.getpAmountOzCurrent() - lPRMetal.getpAmountLoanOz() - lPRMetal.getpAmountOzPrevious()));
			BasicPrintMsg.display(this, "");
		}
	}

	/**
	 * 
	 */
	private void computeAmountToPay() {
		BasicPrintMsg.displayTitle(this, "Compute amount to pay");
		double lAmountToPayTotal = 0.;
		for (PRMetal lPRMetal : pPRManager.getpPRMetalManager().getpMapIDToPRMetal().values()) {
			double lAmountBoughtAdditional = lPRMetal.getpAmountOzCurrent()
					- lPRMetal.getpAmountLoanOz() - lPRMetal.getpAmountOzPrevious();
			double lAmountToPay = lAmountBoughtAdditional * lPRMetal.getpPrice();
			lPRMetal.setpAmountAdditionalOz(lAmountBoughtAdditional);
			lPRMetal.setpAmountAdditionalUSD(lAmountToPay);
			BasicPrintMsg.display(this, lPRMetal.getpName() + " --> " + lAmountToPay + " $");
			lAmountToPayTotal += -lAmountToPay;
		}
		BasicPrintMsg.display(this, "Total= " + lAmountToPayTotal + " $");
		BasicPrintMsg.display(this, "");
		pHoldingUSDCurrent = HOLDING_USD_PREVIOUS + lAmountToPayTotal;
		BasicPrintMsg.display(this, "Holding previous= " + HOLDING_USD_PREVIOUS + " $");
		BasicPrintMsg.display(this, "Holding current = " + pHoldingUSDCurrent + " $");
	}
	
	
	/*
	 * Getters & Setters
	 */
	public final PRManager getpPRManager() {
		return pPRManager;
	}

	public static final double getHOLDING_USD_PREVIOUS() {
		return HOLDING_USD_PREVIOUS;
	}

	public final double getpHoldingUSDCurrent() {
		return pHoldingUSDCurrent;
	}
}
