package aDumpProjects.writeallcombinationpokerhands.color;

public class Color implements Comparable<Color>{

	protected Color(int _sIdxColor, ColorManager _sColorManager) {
		pIdxColor = _sIdxColor;
		pColorManager = _sColorManager;
	}
	
	/**
	 * Data
	 */
	private ColorManager pColorManager;
	private int pIdxColor;
	private String pName;
	
	
	protected void initiate() {
		switch(pIdxColor) {
		case 0 : pName = "Spades"; break;
		case 1 : pName = "Hearts"; break;
		case 2 : pName = "Diamonds"; break;
		case 3 : pName = "Clubs"; break;
		}
	}
	
	
	@Override public int compareTo(Color _sColor) {
		return Integer.compare(pIdxColor, _sColor.pIdxColor);
	}
	
	public String toString() {
		return pName;
	}
	
	/*
	 * Getters & setters
	 */
	public final ColorManager getpColorManager() {
		return pColorManager;
	}
	public final int getpIdxColor() {
		return pIdxColor;
	}
	public final String getpName() {
		return pName;
	}



	
}
