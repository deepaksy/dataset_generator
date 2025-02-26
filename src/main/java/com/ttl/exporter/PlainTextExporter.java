package com.ttl.exporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PlainTextExporter implements Exporter{

	@Override
	public void exportData(List<Map<String, Object>> data, Map<String, String> headers, boolean bulkExport,
			String namingColumn) throws IOException {
		if(bulkExport) {
			for(Map<String, Object> row: data) {
				Object nameVal = row.get(namingColumn);
				if(nameVal == null) continue;
				
				String fileName = sanitizeFileName(nameVal.toString())  + ".txt";
				
				try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\deepak\\Documents\\sts_workspace\\DATASET_GENERATOR\\files\\"+fileName)))){
					for(String col: row.keySet()) {
						if(headers!=null) {
							String header = headers.getOrDefault(col, col);
							writer.write(header+": "+row.get(col));
							writer.newLine();
						} else {
							String header = col;
							writer.write(header+": "+row.get(col));
							writer.newLine();
						}
					}
				}
			}
		} else {
			// Export all 
		}
		
	}
	
	private String sanitizeFileName(String filename) {
		return filename.replaceAll("[\\\\/:*?\"<>|]", "_");
	}

}
