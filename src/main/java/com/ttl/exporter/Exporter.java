package com.ttl.exporter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Exporter {
	void exportData(List<Map<String, Object>> data, 
			Map<String,String> headers,
			boolean bulkExport, String namingColumn
			) throws IOException;
}
