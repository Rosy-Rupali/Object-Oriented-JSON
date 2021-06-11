package helper;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonParseException;


public class JsonHelper {
	private static ObjectMapper mapper;
	static{
		mapper = new ObjectMapper();
	}
	
	/**
	 * @param object is here the java object, which we are fetching from the file path
	 * and with json helper we are converting it to output String and printing it in the console
	 * @return result value after converting java type to String
	 */
	public static String converToJson(Object object) {
		String result = null;
		try {
				result = mapper.writeValueAsString(object);
		
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	/**
	 * @param path : it is the file path which contains JSON file which uses humam readable text to store and transmit data objects
	 * consisting of attribute - value pairs and arrays.
	 * @param object : It is the Java object which we need to fetch
	 * @return :  deserialize  JSON content into the java type  
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object convertToJava(String path,Object object)throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(new File(path), object.getClass());
	}
	

}
