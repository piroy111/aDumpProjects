package aDumpProjects.translatecsvintoenglish;

import aDumpProjects.translatecsvintoenglish.comparefiles.TRFileComparator;
import aDumpProjects.translatecsvintoenglish.objects.TRFileManager;
import aDumpProjects.translatecsvintoenglish.readfiles.TRReadFileManager;
import aDumpProjects.translatecsvintoenglish.writefilestemptobetranslated.TRFileToTranslateWriter;
import aDumpProjects.translatecsvintoenglish.writefinalfiles.TRFileFinalWriter;

public class TRManager {

	protected TRManager() {
		pTRFileManager = new TRFileManager(this);
		pTRReadFileManager = new TRReadFileManager(this);
		pTRFileToTranslateWriter = new TRFileToTranslateWriter(this);
		pTRFileFinalWriter = new TRFileFinalWriter(this);
		pTRFileComparator = new TRFileComparator(this);
		pTRFileTempManager = new TRFileManager(this);
	}
	
	/*
	 * 
	 */
	private TRFileManager pTRFileManager;
	private TRReadFileManager pTRReadFileManager;
	private TRFileToTranslateWriter pTRFileToTranslateWriter;
	private TRFileFinalWriter pTRFileFinalWriter;
	private TRFileComparator pTRFileComparator;
	private TRFileManager pTRFileTempManager;
	
	/**
	 * 
	 */
	protected final void prepareTranslation() {
		pTRReadFileManager.run();
		pTRFileToTranslateWriter.run();
	}
	
	/**
	 * 
	 */
	protected final void formatTranslation() {
		pTRReadFileManager.run();
		pTRFileComparator.run();
		pTRFileFinalWriter.run();
	}
	
	/*
	 * Getters & Setters
	 */
	public final TRReadFileManager getpTRReadFileManager() {
		return pTRReadFileManager;
	}
	public final TRFileToTranslateWriter getpTRFileToTranslateWriter() {
		return pTRFileToTranslateWriter;
	}
	public final TRFileFinalWriter getpTRFileFinalWriter() {
		return pTRFileFinalWriter;
	}
	public final TRFileManager getpTRFileManager() {
		return pTRFileManager;
	}
	public final TRFileManager getpTRFileTempManager() {
		return pTRFileTempManager;
	}
	
	
	
	
}
