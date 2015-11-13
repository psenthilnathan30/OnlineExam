package com.exam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {

	private final static Properties properties = new Properties();

	private PropertiesCache() {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("application.properties");
		//InputStream is =null;
		try {
			//is = new FileInputStream(new File("application.properties"));
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class LazyHolder {
		private static PropertiesCache propertiesCache = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return LazyHolder.propertiesCache;
	}

	public  String getProperty(String key) {
		return properties.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return properties.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}
}
