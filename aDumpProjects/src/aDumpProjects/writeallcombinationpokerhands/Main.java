package aDumpProjects.writeallcombinationpokerhands;

import aDumpProjects.writeallcombinationpokerhands.card.CardManager;
import aDumpProjects.writeallcombinationpokerhands.color.ColorManager;
import aDumpProjects.writeallcombinationpokerhands.deal.DealManager;
import aDumpProjects.writeallcombinationpokerhands.hand.HandIdentificator;
import aDumpProjects.writeallcombinationpokerhands.writefile.FileWriter;

public class Main {
	
	protected Main() {
		
	}
	
	/**
	 * Data
	 */
	private ColorManager pColorManager;
	private CardManager pCardManager;
	private DealManager pDealManager;
	private HandIdentificator pHandIdentificator;
	private FileWriter pFileWriter;

	/**
	 * 
	 */
	public final void run() {
		/**
		 * Instantiate
		 */
		pColorManager = new ColorManager();
		pCardManager = new CardManager(this);
		pDealManager = new DealManager(this);
		pHandIdentificator = new HandIdentificator();
		pFileWriter = new FileWriter(this);
		/**
		 * 
		 */
		pColorManager.initiate();
		pCardManager.initiate();
		pHandIdentificator.initiate();
		/**
		 * 
		 */
		pDealManager.run();
		pFileWriter.run();
	}

	/**
	 * Getters & Setters
	 */
	public final ColorManager getpColorManager() {
		return pColorManager;
	}
	public final CardManager getpCardManager() {
		return pCardManager;
	}
	public final DealManager getpDealManager() {
		return pDealManager;
	}
	public final HandIdentificator getpHandIdentificator() {
		return pHandIdentificator;
	}
	
	
	
	
	
}
