package edu.georgetown.library.fileAnalyzer.importer;

import edu.georgetown.library.fileAnalyzer.importer.demo.CreateDateParser;
import edu.georgetown.library.fileAnalyzer.importer.demo.MarcImporter;
import edu.georgetown.library.fileAnalyzer.importer.demo.TabSepToDC;
import gov.nara.nwts.ftapp.FTDriver;
import gov.nara.nwts.ftapp.importer.ImporterRegistry;


/**
 * Activates the Importers that will be presented on the Import tab.
 * @author TBrady
 *
 */
public class CustomImporterRegistry extends ImporterRegistry {
	
	private static final long serialVersionUID = 1L;

	public CustomImporterRegistry(FTDriver dt) {
		super(dt);
		add(new IngestFolderCreate(dt));

		add(new TabSepToDC(dt));
		add(new MarcImporter(dt));
		add(new CreateDateParser(dt));
	}
	

}
