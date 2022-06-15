package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties prop;
	
	public Properties readProperties() {
		prop = new Properties();
		try {
			FileInputStream ip =  new FileInputStream("./src/test/resources/configurations/env.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	String result =null;
	public String getProp(String value) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/configurations/env.properties"));
			result = prop.getProperty(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	String myp1Data =null;
	public String getMYP1Prop(String value) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/configurations/myp1_env.properties"));
			myp1Data = prop.getProperty(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return myp1Data;
	}

}
