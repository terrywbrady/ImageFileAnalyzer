package edu.georgetown.library.fileAnalyzer.importer.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.TreeMap;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import gov.nara.nwts.ftapp.ActionResult;
import gov.nara.nwts.ftapp.FTDriver;
import gov.nara.nwts.ftapp.Timer;
import gov.nara.nwts.ftapp.importer.DelimitedFileImporter;
import gov.nara.nwts.ftapp.stats.Stats;
import gov.nara.nwts.ftapp.stats.StatsItem;
import gov.nara.nwts.ftapp.stats.StatsItemEnum;
import gov.nara.nwts.ftapp.util.XMLUtil;

/**
 * Importer for tab delimited files
 * @author TBrady
 *
 */
public class TabSepToDC extends DelimitedFileImporter {

	public enum status {PASS,FAIL}
	NumberFormat nf;
	
	private static enum DCStatsItems implements StatsItemEnum {
		LineNo(StatsItem.makeStringStatsItem("LineNo").setExport(false)),
		Status(StatsItem.makeEnumStatsItem(status.class)),
		ItemFolder(StatsItem.makeStringStatsItem("Item Folder", 200)),
		ItemTitle(StatsItem.makeStringStatsItem("Item Title", 150)),
		Author(StatsItem.makeStringStatsItem("Author", 150)),
		Date(StatsItem.makeStringStatsItem("Date", 80)),
		Language(StatsItem.makeStringStatsItem("Language", 80)),
		Subject(StatsItem.makeStringStatsItem("Subject", 150)),
		Format(StatsItem.makeStringStatsItem("Format", 150)),
		Publsiher(StatsItem.makeStringStatsItem("Publisher", 150)),
		;
		
		StatsItem si;
		Integer col;
		DCStatsItems(StatsItem si) {this.si=si;}
		DCStatsItems(int col, StatsItem si) {this.si=si; this.col = col;}
		public StatsItem si() {return si;}
	}

	public static Object[][] details = StatsItem.toObjectArray(DCStatsItems.class);
	public class DCStats extends Stats {
		
		public DCStats(String key) {
			super(key);
			init(DCStatsItems.class);
		}

		public void setColumnVals(Vector<String> cols) {
			for(DCStatsItems dc: DCStatsItems.values()) {
				setColumnVal(dc, cols);
			}
		}
		
		public void setColumnVal(DCStatsItems dc, Vector<String> cols) {
			if (dc.col == null) return;
			if (cols.size() > dc.col) {
				setVal(dc, cols.get(dc.col));
			}
		}
	}

	public TabSepToDC(FTDriver dt) {
		super(dt);
		nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(8);
		nf.setGroupingUsed(false);
	}

	public String getSeparator() {
		return "\t";
	}
	public String toString() {
		return "Demo: Convert Tab Separated File to Dublin Core";
	}
	public String getDescription() {
		return "Prototype: This rule will import a tab separated file and create a Dublin Core File from it";
	}
	public String getShortName() {
		return "Tab2DC";
	}

	public void createItems(Document d, Vector<String> cols) {
		Element e = d.createElement("item");
		e.setAttribute("dir", cols.get(0));
		d.getDocumentElement().appendChild(e);
		addElement(e, "creator", cols.get(2));
		addElement(e, "title", cols.get(1));
		addElement(e, "date", cols.get(3));
		addElement(e, "language", cols.get(4));
		addElement(e, "subject", cols.get(5));
		addElement(e, "format", cols.get(6));
		addElement(e, "publisher", cols.get(7));
	}
	
	public void addElement(Element e, String name, String val) {
		Element el = e.getOwnerDocument().createElement("dcvalue");
		e.appendChild(el);
		el.setAttribute("element",name);
		el.setAttribute("qualifier", "none");
		el.appendChild(e.getOwnerDocument().createTextNode(val));
	}
	
	public ActionResult importFile(File selectedFile) throws IOException {
		Document d = XMLUtil.db.newDocument();
		d.appendChild(d.createElement("items"));
		Timer timer = new Timer();
		FileReader fr = new FileReader(selectedFile);
		BufferedReader br = new BufferedReader(fr);
		TreeMap<String,Stats> types = new TreeMap<String,Stats>();
		int rowKey = 0;
		for(String line=br.readLine(); line!=null; line=br.readLine()){
			Vector<String> cols = parseLine(line, getSeparator());
			String key = nf.format(rowKey++);
			DCStats stats = new DCStats(key);
			if (cols.size() == 8) {
				stats.setVal(DCStatsItems.Status, status.PASS);
				createItems(d, cols);
			} else {
				stats.setVal(DCStatsItems.Status, status.FAIL);
			}
			
			stats.setColumnVals(cols);
			types.put(key, stats);
		}
		fr.close();
		File f = new File(selectedFile.getParentFile(), selectedFile.getName() + ".xml");
		XMLUtil.serialize(d, f);
		
		return new ActionResult(selectedFile, selectedFile.getName(), this.toString(), details, types, true, timer.getDuration());
	}
}
