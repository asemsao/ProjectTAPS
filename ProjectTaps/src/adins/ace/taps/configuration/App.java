package adins.ace.taps.configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class App {
  public static String getConfiguration(String keyProperties) { 
	Properties prop = new Properties();
	InputStream input = null;
	String output = "";
	try {
		String filename = "config.properties";
		input = App.class.getClassLoader().getResourceAsStream(filename);
		if(input==null){
	            System.out.println("Sorry, unable to find " + filename);
		    return null;
		}

		//load a properties file from class path, inside static method
		prop.load(input);
		// get the property value and print it out
		output = prop.getProperty(keyProperties);
			 
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return output;
  }
}