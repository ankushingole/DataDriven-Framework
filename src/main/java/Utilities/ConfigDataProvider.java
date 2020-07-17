package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {

		File src = new File("./Config/config.properties");
		try {

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("File not found" + e.getMessage());
		}
	}

	public String getDataFromConfig(String keyToSearch) {

		return prop.getProperty(keyToSearch);
	}

	public String getBrowser() {

		return prop.getProperty("Browser");
	}

	public String getQaURL() {

		return prop.getProperty("qaURL");
	}

}
