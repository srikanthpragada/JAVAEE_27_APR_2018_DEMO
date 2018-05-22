package json;

import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadCountryInfo {
	public static void main(String[] args) throws Exception {
		 URL url = new URL("https://restcountries.eu/rest/v2/alpha/us");
		 
		 JsonReader reader = Json.createReader(url.openStream());
		 JsonObject country = reader.readObject();
		 
		 System.out.println( country.getString("name"));
		 System.out.println( country.getString("capital"));
		 System.out.println( country.getInt("population"));
		 
	}

}
