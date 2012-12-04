package edu.georgetown.library.fileAnalyzer.stats;

import java.io.File;

import gov.nara.nwts.ftapp.filetest.FileTest;
import gov.nara.nwts.ftapp.stats.Stats;

public class DSpaceInventoryStats extends Stats {
	
	public DSpaceInventoryStats(String key, int metacols) {
		super(key);
		for(int i=0; i<metacols; i++) vals.add("");
	}

	public Object compute(File f, FileTest fileTest) {
		Object o = fileTest.fileTest(f);
		
		String path = f.getAbsolutePath().substring(fileTest.getRoot().getAbsolutePath().length()+1);
		String tpath = path + ".jpg";
		String tfull = fileTest.getRoot().getAbsolutePath() + "\\" + tpath;
		File f2 = new File(tfull);
		if (!f2.exists()) tpath = "";
		
		vals.set(0, path);
		vals.set(1, tpath);
		
		return o;
	}
	


}
