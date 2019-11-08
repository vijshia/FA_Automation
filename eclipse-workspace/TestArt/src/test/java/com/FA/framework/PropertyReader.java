/**
 * 
 */
package com.FA.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author AJP16088
 *
 */
public class PropertyReader {
	
	@SuppressWarnings("unused")
	public Properties getProperty(String propertypath) throws IOException {
		
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(propertypath);
			if(inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("Property File '"+propertypath+"' not found in the path");
			}
		} catch (Exception e){
			System.out.println("Exception: "+e);
		} finally {
			inputStream.close();
		}
		return properties;		
	}

}
