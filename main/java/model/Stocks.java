/**************************************************
 * Purpose :  It is a program to print the JSON input file to Java String type
 * @author Rosy Rupali
 * @since 11-06-2021
 *
 *************************************************/
package model;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import helper.JsonHelper;

public class Stocks {

	public List<Parle> parle;
	public List<Marie> marie;
	public List<Oreo> oreo;

	/**
	 * This the main method which uses the convert to java and convert json function fron jsonHelper
	 * class to read and write the json input file in java type
	 * @param args
	 */
	public static void main(String[] args) {
		Stocks stocks = new Stocks();

		try {
			stocks = (Stocks) JsonHelper.convertToJava("../StockShare/src/object/input.json", stocks);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		double allStocksValue = 0;
		for (int i = 0; i < stocks.parle.size(); i++) {
			allStocksValue = stocks.parle.get(i).getNumber_of_shares() * stocks.parle.get(i).getShare_price();
			stocks.parle.get(i).setTotalPrice(allStocksValue);
		}
		for (int j = 0; j < stocks.marie.size(); j++) {
			allStocksValue = stocks.marie.get(j).getNumber_of_shares() * stocks.marie.get(j).getShare_price();
			stocks.marie.get(j).setTotalPrice(allStocksValue);
		}
		for (int k = 0; k < stocks.oreo.size(); k++) {
			allStocksValue = stocks.oreo.get(k).getNumber_of_shares() * stocks.oreo.get(k).getShare_price();
			stocks.oreo.get(k).setTotalPrice(allStocksValue);
		}

		String outputString = JsonHelper.convertToJson(stocks);
		System.out.println(outputString);
		System.out.println("The java object has been sucessfully converted to json string  ");

	}
}
