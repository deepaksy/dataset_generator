package com.ttl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ttl.configuration.DatabaseConfig;
import com.ttl.dao.DatabaseDAO;
import com.ttl.exporter.PlainTextExporter;


public class DatabaseConnectionTest  {
	
	@Test
	public void TestCase1() {
		DatabaseConfig config = new DatabaseConfig();
		config.setDriverClass("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://192.168.1.203:9981/portfolio");
		config.setUsername("root");
		config.setPassword(null);
		DatabaseDAO dao = new DatabaseDAO(config);
		try {
			List<Map<String, Object>> list = dao.executeQuery("select * from projects");
			PlainTextExporter exporter = new PlainTextExporter();
			exporter.exportData(list, null, true, "name");
			assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(true);
		}
	}
}
