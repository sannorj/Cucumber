package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConstantsReader {
public Properties prop;
	

	String result =null;
	public String getProp(String value) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/configurations/mypData.properties"));
			result = prop.getProperty(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	
	public String getLoginProp(String value) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/configurations/env.properties"));
			result = prop.getProperty(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public String getMYP1Prop(String value) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/resources/configurations/myp1Data.properties"));
			result = prop.getProperty(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
