package com.ttl.configuration;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigLoader {
	public static AppConfiguration loadConfig() {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		File configFile = new File("");
		
			return mapper.readValue(configFile, AppConfiguration.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
	}
	
	
	public static void saveConfig(AppConfiguration config) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(""), config);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
