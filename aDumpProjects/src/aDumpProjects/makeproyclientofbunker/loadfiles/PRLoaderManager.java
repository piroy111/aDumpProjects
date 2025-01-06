package aDumpProjects.makeproyclientofbunker.loadfiles;

import java.util.ArrayList;
import java.util.List;

import aDumpProjects.makeproyclientofbunker.PRManager;
import aDumpProjects.makeproyclientofbunker.loadfiles.abstractloader.PRLoaderAbstract;
import aDumpProjects.makeproyclientofbunker.loadfiles.loans.PRLoaderLoans;
import aDumpProjects.makeproyclientofbunker.loadfiles.realloader.PRLoaderBunker;
import aDumpProjects.makeproyclientofbunker.loadfiles.realloader.PRLoaderCarousell;
import aDumpProjects.makeproyclientofbunker.loadfiles.realloader.PRLoaderFCCS;
import aDumpProjects.makeproyclientofbunker.loadfiles.realloader.PRLoaderNadir;
import aDumpProjects.makeproyclientofbunker.loadfiles.realloader.PRLoaderPROY;
import aDumpProjects.makeproyclientofbunker.loadfiles.specialcaseofsales.PRLoaderSales;
import basicmethods.BasicPrintMsg;

public class PRLoaderManager {

	public PRLoaderManager(PRManager _sPRManager) {
		pPRManager = _sPRManager;
		/*
		 * 
		 */
		pListPRLoaderAbstract = new ArrayList<>();
	}
	
	/*
	 * Data
	 */
	/**
	 * 
	 */
	private PRManager pPRManager;
	private List<PRLoaderAbstract> pListPRLoaderAbstract;
	
	/**
	 * 
	 */
	public final void run() {
		BasicPrintMsg.displaySuperTitle(this, "LOAD FILES");
		/*
		 * Create loaders
		 */
		new PRLoaderBunker(this);
		new PRLoaderCarousell(this);
		new PRLoaderFCCS(this);
		new PRLoaderNadir(this);
		new PRLoaderPROY(this);
		/*
		 * Run
		 */
		for (PRLoaderAbstract lPRLoaderAbstract : pListPRLoaderAbstract) {
			lPRLoaderAbstract.loadFile();
		}
		new PRLoaderLoans(this).loadFile();
		new PRLoaderSales(this).loadFile();
	}
	
	
	/**
	 * 
	 * @param _sPRLoaderAbstract
	 */
	public final void declareNewPRLoaderAbstract(PRLoaderAbstract _sPRLoaderAbstract) {
		pListPRLoaderAbstract.add(_sPRLoaderAbstract);
	}


	/*
	 * Getters & Setters
	 */
	public final PRManager getpPRManager() {
		return pPRManager;
	}
	public final List<PRLoaderAbstract> getpListPRLoaderAbstract() {
		return pListPRLoaderAbstract;
	}
	
}
