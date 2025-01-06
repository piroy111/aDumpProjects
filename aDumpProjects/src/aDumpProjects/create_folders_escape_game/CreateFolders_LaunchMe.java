package aDumpProjects.create_folders_escape_game;

import java.nio.file.Paths;
import java.util.List;

import basicmethods.BasicFichiers;
import basicmethods.BasicFichiersNio;
import basicmethods.BasicPrintMsg;

public class CreateFolders_LaunchMe {

	/*
	 * Parameters
	 */
	private static String FOLDER_INTERACTS_QML = "C:/Users/pierr/Documents/Escape_001_Jomere_WebAssembly/qml/interacts/";
	private static String FOLDER_OUTPUT_3D_ARTIST = "C:/Users/pierr/OneDrive/08_DCT/13_3D_Artist/Escape_001_Jomere/01_To_Do/";
	
	
	/*
	 * Launch me
	 */
	public static void main(String[] _sArgs) {
		List<String> lListFiles = BasicFichiersNio.getListFilesAndDirectoriesInDirectory(Paths.get(FOLDER_INTERACTS_QML));
		for (String lNameFile : lListFiles) {
			if (lNameFile.endsWith(".qml")) {
				root lRoot = null;
				/*
				 * Withdraw QML
				 */
				lNameFile = lNameFile.substring(0,  lNameFile.length() - ".qml".length());
				/*
				 * Extract the root
				 */
				for (root lRootTest : root.values()) {
					String lRootStr = lRootTest.toString();
					if (lNameFile.startsWith(lRootStr)) {
						lRoot = lRootTest;
						break;
					}
				}
				/*
				 * Create the new folder
				 */
				if (lRoot != null) {
					String lPrefix = "";
					switch (lRoot) {
					case IItem: lPrefix = "Item"; break;
					case IPanel3D: lPrefix = "View3D" + "_" + "Panel"; break;
					case IPuzzle: lPrefix = "View3D" + "_" + "Puzzle"; break;
					case IViewItem: lPrefix = "View3D" + "_" + "Interact"; break;
					case IViewSimple: lPrefix = "View3D" + "_" + "Simple"; break;
					default: BasicPrintMsg.errorCodeLogic();
					}
					String lNameFolderOutput = lPrefix + "_" + lNameFile.substring(lRoot.toString().length());
					BasicFichiers.getOrCreateDirectory(FOLDER_OUTPUT_3D_ARTIST + lNameFolderOutput);
				}
			}
		}
	}
	
	
	private static enum root {IItem, IPanel3D, IPuzzle, IViewItem, IViewSimple}
	

	
	
	
}
