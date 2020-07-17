package com.ltts.wellspoc.ui.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class LoadProperties {

	private final Properties configProp = new Properties();
	
	LoadProperties() 
	{
	
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("resource.properties");
		try
		{
			configProp.load(in);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static class LazyHolder
	{
		private static final LoadProperties INSTANCE = new LoadProperties();
	}

	
	public static LoadProperties getInstance()
	{
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key)
	{
		return configProp.getProperty(key);
	}
	
	public Set<String> getAllPropertyNames()
	{
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key)
	{
		return configProp.containsKey(key);
	}
}
