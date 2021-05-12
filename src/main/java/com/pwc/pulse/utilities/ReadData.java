package com.pwc.pulse.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * @author - Ritesh Awasthi
 * @date - 12-May-2021
 * @Purpose - Purpose of this class is to fetch values from values from the external file
 */
public class ReadData {
	
	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - prop value
	 * 
	 * @Purpose - Purpose of this method is to read the data from the input file provided in the method
	 */
	public Properties readFile(String nameOfFile) {

		// Get the user directory
		String Path = System.getProperty("user.dir");

		// Get the config.properties file from the location
		File file = new File(Path + "/src/test/resources/properties/" + nameOfFile);

		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
}
