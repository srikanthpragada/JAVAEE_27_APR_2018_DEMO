package json;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class CreateProductWithGenerator {

	public static void main(String[] args) {
 
          JsonGenerator gen = Json.createGenerator(System.out);
          
          gen.writeStartObject()
             .write("name","iPhone X")
             .write("price","80000")
             // .write("features").writeStartArray().write("Feature1").write("Feature2").writeEnd()
             .writeEnd();
   
          gen.close();
	}

}
