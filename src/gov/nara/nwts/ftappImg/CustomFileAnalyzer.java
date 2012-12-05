package gov.nara.nwts.ftappImg;

import java.io.File;

import edu.georgetown.library.fileAnalyzer.filetest.GUActionRegistry;
import edu.georgetown.library.fileAnalyzer.importer.CustomImporterRegistry;

import gov.nara.nwts.ftapp.filetest.ActionRegistry;
import gov.nara.nwts.ftapp.gui.DirectoryTable;
import gov.nara.nwts.ftapp.importer.ImporterRegistry;
/**
 * Driver for the File Analyzer GUI loading image-specific rules but not NARA specific rules.
 * @author TBrady
 *
 */
public class CustomFileAnalyzer extends DirectoryTable {

	public CustomFileAnalyzer(File f, boolean modifyAllowed) {
		super(f, modifyAllowed);
	}
	
	protected ActionRegistry getActionRegistry() {
		return new GUActionRegistry(this, modifyAllowed);
	}

	protected ImporterRegistry getImporterRegistry() {
		return new CustomImporterRegistry(this);
	}
	public static void main(String[] args) {
		if (args.length > 0)
			new CustomFileAnalyzer(new File(args[0]), false);		
		else
			new CustomFileAnalyzer(null, false);		
	}

}
