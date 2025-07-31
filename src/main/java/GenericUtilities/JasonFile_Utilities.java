package GenericUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonFile_Utilities{
	/**
	 * this method is used to fetch data from jason file
	 * 
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
        public String FetchDataFromJasonFile(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser js=new JSONParser();
		Object obj = js.parse(new FileReader("./src/test/resources/JsonData.json"));
		JSONObject js1= (JSONObject)obj;
		String data = js1.get(key).toString();
		
		return data;
	}

}
