package com.ttl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ttl.configuration.DatabaseConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseDAO {
	private DatabaseConfig config;
	
	private Connection getConnection() throws ClassNotFoundException,  SQLException {
		Class.forName(config.getDriverClass());
		return DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
	}
	
	
	public List<Map<String, Object>> executeQuery(String query) throws Exception {
		List<Map<String,Object>> results = new ArrayList<>();
		
		try(Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
				) {
			ResultSetMetaData meta = rs.getMetaData();
			int colCount = meta.getColumnCount();
			while(rs.next()) {
				Map<String,Object> row = new HashMap<>();
				for (int i = 1; i <= colCount; i++) {
					row.put(meta.getColumnName(i), rs.getObject(i));
				}
				results.add(row);
			}
			
		}
		return results;
	}
}
