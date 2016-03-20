package BusinessClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Environnement.API_ENV;
import Interfaces.IO_Bdd;

public class GlobalConfiguration {

	private int Id_profile;
	private ArrayList<QuickConfiguration> ApplicationList;
	
	
	public GlobalConfiguration( int profile)
	{
		Id_profile = profile;
		ApplicationList = new ArrayList<QuickConfiguration>();
		GetFromDatabase(Id_profile);
	}
	
	@Override
	public String toString() {
		String res =  "GlobalConfiguration [Id_profile=" + Id_profile + ", ApplicationList= [" ;
				for (int i =0;i<ApplicationList.size();i++)
				res = res+	ApplicationList.get(i).toString();
	res = res+ "]]";
	return res;
	}

	public void GetFromDatabase(int profile)
	{
		Connection c = IO_Bdd.ConnectBDD(API_ENV.MAIN_BDD_NAME);
		String sql = "SELECT * FROM Configuration WHERE Id_Profile = '"+Id_profile+"'";
	//	System.out.println(sql);
		ResultSet rs = IO_Bdd.SelectStatement(c, sql);
		try {
			while ( rs.next() ) {
			     int id_app = rs.getInt("Id_Application");
			     String  Position = rs.getString("Position");
			     boolean active  = Boolean.getBoolean(rs.getString("Active"));
			     QuickConfiguration qc = new QuickConfiguration(id_app, Position, active);
			    System.out.println(qc.toString()+"if just this fail");
			     ApplicationList.add(qc);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public int getId_profile() {
		return Id_profile;
	}


	public void setId_profile(int id_profile) {
		Id_profile = id_profile;
	}


	public ArrayList<QuickConfiguration> getApplicationList() {
		return ApplicationList;
	}


	public void setApplicationList(ArrayList<QuickConfiguration> applicationList) {
		ApplicationList = applicationList;
	}
	
	
	
}
