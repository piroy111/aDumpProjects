package aDumpProjects.writeallcombinationpokerhands.color;

import java.util.ArrayList;
import java.util.List;

public class ColorManager {

	public ColorManager() {

	}

	/**
	 * 
	 */
	private List<Color> pListColor;

	/**
	 * Initiate
	 */
	public final void initiate() {
		pListColor = new ArrayList<>();
		for (int lIdx = 0; lIdx < 4; lIdx++) {
			pListColor.add(new Color(lIdx, this));
		}
		for (Color lColor : pListColor) {
			lColor.initiate();
		}
	}


	/**
	 * Getters & Setters
	 * @return
	 */
	public final List<Color> getpListColor() {
		return pListColor;
	}

}
