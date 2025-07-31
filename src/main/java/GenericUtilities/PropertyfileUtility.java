package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author D.Maheswari
 */
public class PropertyfileUtility {
/**
 * This method is used to fetch the data from property file
 * @param key
 * @return String
 * @throws IOException
 */
	public String FetchingDtadaFromPropertyFile(String key) throws IOException{
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_commandata.properties");
		
		Properties p= new Properties();
		
		p.load(fis);
		
		String data = p.getProperty(key);
		
		return data;
		
	}
	
	public void WrightBackDataToPropertyFile(String key,String value,String comments) throws IOException
	{
		/**
		 * this method is used to wright back the date to property file
		 */
	FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_commandata.properties");
	
	Properties p = new Properties();
	
	p.load(fis);
	
	p.put(key, value);
	
	FileOutputStream fos = new FileOutputStream("/src/test/resources/vtiger_commandata.properties");
	p.store(fos, comments);
	
	
	
	
	}
}
