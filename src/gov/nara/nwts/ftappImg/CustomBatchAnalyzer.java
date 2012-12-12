package gov.nara.nwts.ftappImg;

import edu.georgetown.library.fileAnalyzer.filetest.GUActionRegistry;
import edu.georgetown.library.fileAnalyzer.importer.CustomImporterRegistry;

import gov.nara.nwts.ftapp.BatchAnalyzer;
import gov.nara.nwts.ftapp.FTDriver;
import gov.nara.nwts.ftapp.filetest.ActionRegistry;
import gov.nara.nwts.ftapp.importer.ImporterRegistry;
/**
 * Driver for the File Analyzer GUI loading image-specific rules but not NARA specific rules.
 * @author TBrady
 *
 */
public class CustomBatchAnalyzer extends BatchAnalyzer {

	public CustomBatchAnalyzer() {
		super();
	}
	
	public ActionRegistry getActionRegistry(FTDriver ft) {
		return new GUActionRegistry(ft, true);
	}

	protected ImporterRegistry getImporterRegistry(FTDriver ft) {
		return new CustomImporterRegistry(ft);
	}
	public static void main(String[] args) {
		CustomBatchAnalyzer ba = new CustomBatchAnalyzer();
		ba.run(args);
	}

}
