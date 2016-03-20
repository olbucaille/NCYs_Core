package Services;

import BusinessClasses.GlobalConfiguration;

public class Configuration {

	
	//to put as JSON format
	public static String getAllConfiguration(String profile)
	{
	//	System.out.println(Integer.parseInt(profile));
		GlobalConfiguration GC = new GlobalConfiguration(Integer.parseInt(profile));
		
		
		return GC.toString();
		
	}
	
}
