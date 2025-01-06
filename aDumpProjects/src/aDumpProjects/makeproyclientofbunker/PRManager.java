package aDumpProjects.makeproyclientofbunker;

import aDumpProjects.makeproyclientofbunker.loadfiles.PRLoaderManager;
import aDumpProjects.makeproyclientofbunker.objects.metal.PRMetalManager;
import aDumpProjects.makeproyclientofbunker.proy.PRComputor;
import aDumpProjects.makeproyclientofbunker.writefiles.followup.PRWriteFileAvailable;
import aDumpProjects.makeproyclientofbunker.writefiles.followup.PRWriteFileCompletion;
import aDumpProjects.makeproyclientofbunker.writefiles.followup.PRWriteFilePrevious;
import aDumpProjects.makeproyclientofbunker.writefiles.toexport.PRWriteFileCurrent;
import aDumpProjects.makeproyclientofbunker.writefiles.toexport.PRWriteFileForCompta;

public class PRManager {

	public PRManager() {
		pPRMetalManager = new PRMetalManager(this);
		pPRLoaderManager = new PRLoaderManager(this);
		pPRWriteFilePrevious = new PRWriteFilePrevious(this);
		pPRWriteFileAvailable = new PRWriteFileAvailable(this);
		pPRComputor = new PRComputor(this);
		pPRWriteFileCompletion = new PRWriteFileCompletion(this);
		pPRWriteFileCurrent = new PRWriteFileCurrent(this);
		pPRWriteFileForCompta = new PRWriteFileForCompta(this);
	}
	
	/*
	 * Data
	 */
	private PRMetalManager pPRMetalManager;
	private PRLoaderManager pPRLoaderManager;
	private PRWriteFilePrevious pPRWriteFilePrevious;
	private PRWriteFileAvailable pPRWriteFileAvailable;
	private PRComputor pPRComputor;
	private PRWriteFileCompletion pPRWriteFileCompletion;
	private PRWriteFileCurrent pPRWriteFileCurrent;
	private PRWriteFileForCompta pPRWriteFileForCompta;

	/**
	 * 
	 */
	public final void run() {
		pPRLoaderManager.run();
		pPRWriteFilePrevious.run();
		pPRWriteFileAvailable.run();
		pPRComputor.run();
		pPRWriteFileCompletion.run();
		pPRWriteFileCurrent.run();
		pPRWriteFileForCompta.run();
	}
	
	/*
	 * Getters & Setters
	 */
	public final PRMetalManager getpPRMetalManager() {
		return pPRMetalManager;
	}
	public final PRLoaderManager getpPRLoaderManager() {
		return pPRLoaderManager;
	}
	public final PRWriteFilePrevious getpPRWriteFilePrevious() {
		return pPRWriteFilePrevious;
	}
	public final PRWriteFileAvailable getpPRWriteFileAvailable() {
		return pPRWriteFileAvailable;
	}
	public final PRComputor getpPRComputor() {
		return pPRComputor;
	}
}
