package aDumpProjects.makeproyclientofbunker.codecesar;

public class CRCodeCesar {

	public static void main(String[] _sArgs) {
		/*
		 * Data
		 */
		String lTextToConvert = "Reminder to myself in case my memory plays tricks on me: Manipulate 'Fifty shames of grey', 'Nineteen Eighty-Four', 'Story of O'";
		int lDecal = -4;
		/*
		 * Conversion
		 */
		String lTextConverted = convert(lTextToConvert, lDecal);
		/*
		 * Display
		 */
		System.out.println(lTextToConvert);
		System.out.println(lTextConverted);
		System.out.println(convert(lTextConverted, -lDecal));
	}
	
	/**
	 * 
	 * @param lTextToConvert
	 * @param lDecal
	 * @return
	 */
	private static String convert(String lTextToConvert, int lDecal) {
		while (lDecal < 0) {
			lDecal += 26;
		}
		String lTextConverted = "";
		for (int lIdx = 0; lIdx < lTextToConvert.length(); lIdx++) {
			char lCharToConvert = lTextToConvert.charAt(lIdx);
			char lCharConverted;
			/*
			 * Keeps the same if this is not a letter 
			 */
			if (!('A' <= lCharToConvert && lCharToConvert <= 'Z') && !('a' <= lCharToConvert && lCharToConvert <= 'z')) {
				lCharConverted = lCharToConvert;
			}
			/*
			 * Convert
			 */
			else {
				lCharConverted = (char) (lCharToConvert + lDecal);
				if ('A' <= lCharToConvert && lCharToConvert <= 'Z') {
					while (lCharConverted > 'Z') {
						lCharConverted = (char) (lCharConverted - (int)('Z') + (int)('A') - 1);
					}
				} else {
					while (lCharConverted > 'z') {
						lCharConverted = (char) (lCharConverted - (int)('z') + (int)('a') - 1);
					}
				}
			}
			/*
			 * Add to converted text
			 */
			lTextConverted += lCharConverted;
		}
		return lTextConverted;
	}
	
}
