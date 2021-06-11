/**************************************************
 * Purpose : It is a program to print the JSON input file to Java String type  
 * @author Rosy Rupali
 * @since 11-06-2021
 *
 *************************************************/
package model;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.JsonParseException;
import helper.JsonHelper;

public class Inventory {

	public List<Rice> rice;
	public List<Wheat> wheat;
	public List<Pulse> pulse;

	/**
	 * This the main method which uses the convertToJava and convertToJSON function from jsonHelper
	 * class to read and write the json input file in java type
	 * @param args
	 */
	public static void main(String[] args) {

		Inventory invent = new Inventory();
		try {
			invent = (Inventory) JsonHelper.convertToJava("../oops/src/object/input.json", invent);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int total = 0;
		for (int j = 0; j < invent.rice.size(); j++) {
			total = invent.rice.get(j).getWeight() * invent.rice.get(j).getPricePerKg();
			invent.rice.get(j).setTotalPrice(total);
		}
		for (int k = 0; k < invent.pulse.size(); k++) {
			total = invent.pulse.get(k).getWeight() * invent.pulse.get(k).getPricePerKg();
			invent.pulse.get(k).setTotalPrice(total);
		}
		for (int l = 0; l < invent.wheat.size(); l++) {
			total = invent.wheat.get(l).getWeight() * invent.wheat.get(l).getPricePerKg();
			invent.wheat.get(l).setTotalPrice(total);
		}

		String outputString = JsonHelper.converToJson(invent);
		System.out.println(outputString);
		System.out.println("The java object has been sucessfully converted to json string  ");

	}

}
