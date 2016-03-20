package Environnement;

public class API_ENV {
	
	public static String MAIN_BDD_NAME="NCYs_CORE_BDD.db";
	private static API_ENV  instance = null;
	
	private API_ENV()
	{
		
	}
	
	public static API_ENV getInstance()
	{
		if (instance == null) 
			instance = new API_ENV();
		return instance;
	}
}
