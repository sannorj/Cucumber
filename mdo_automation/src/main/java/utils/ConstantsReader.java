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

}
