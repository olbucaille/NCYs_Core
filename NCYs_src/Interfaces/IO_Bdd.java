package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Environnement.API_ENV;

public class IO_Bdd {

	public static void main( String args[] )
	{
		Connection c = ConnectBDD(API_ENV.getInstance().MAIN_BDD_NAME);
		// createTABLES(c);
		// String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		//        "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
		// InsertStatement(c, sql);
		//String sql = "SELECT * FROM COMPANY;" ;
		//SelectStatement(c, sql);
		
		//String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
		//String sql = "DELETE from COMPANY where ID=2;";
	      
		//UpdateStatement(c, sql);
	//	DeleteStatement(c, sql);
		
	}

	public static Connection ConnectBDD( String name)
	{

        
       try {
    	   Class.forName("org.hsqldb.jdbcDriver");
		return  DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/olbucaille/git/NCYs_Core/NCYs_src/"+name,"sa","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}                     
       return null;
    }

    
	public static  void createTABLES(Connection c)
	{
		String sql = "CREATE TABLE APPLICATION ("
				+ "	ID_APPLICATION INTEGER NOT NULL,"
				+ "	NAME VARCHAR(25),"
				+ "	NATIVE VARCHAR(25),"
				+ "	PRIMARY KEY (ID_APPLICATION)"
				+ ");"
				+ "CREATE TABLE PUBLIC.CONFIGURATION ("
				+ "	ID_PROFILE INTEGER,"
				+ "	ID_APPLICATION INTEGER,"
				+ "	POSITION VARCHAR(25),"
				+ "	ACTIVE VARCHAR(25));"
				+ "CREATE TABLE PUBLIC.PROFILE ("
				+ "	ID_PROFILE INTEGER NOT NULL,"
				+ "	NAME VARCHAR(30),"
				+ "	PRIMARY KEY (ID_PROFILE)"
				+ ");"
				+ "INSERT INTO PUBLIC.APPLICATION(ID_APPLICATION, NAME, NATIVE) VALUES (1, 'Clock', 'True');"
				+ "INSERT INTO PUBLIC.CONFIGURATION(ID_PROFILE, ID_APPLICATION, POSITION, ACTIVE) VALUES (1, 1, '500.1000', 'True');"
				+ "INSERT INTO PUBLIC.PROFILE(ID_PROFILE, NAME) VALUES (1, 'Default');";

		Statement stmt = null;
		try {

			stmt = c.createStatement();
		
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() +sql );
			System.exit(0);
		}
		System.out.println("Table created successfully");

	}
	public static void InsertStatement(Connection c, String sql)
	{
		   Statement st = null;

	        try {
				st = c.createStatement();
				 int i = st.executeUpdate(sql);    // run the query

			        if (i == -1) {
			            System.out.println("db error : " + sql);
			        }

			        st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // statements

	       
		System.out.println("Records created successfully");

	}

	public static ResultSet SelectStatement(Connection c, String sql)
	{
		Statement st = null;
        ResultSet rs = null;

        try {
			st = c.createStatement();
		
        // repeated calls to execute but we
        // choose to make a new one each time
        rs = st.executeQuery(sql);    // run the query
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         // statement objects can be reused with

        // do something with the result set.
      
        // closed too
        // so you should copy the contents to some other object.
        // the result set is invalidated also  if you recycle an Statement
        // and try to execute some other query before the result set has been
        // completely examined.
		return rs;
	}

	public static void UpdateStatement(Connection c, String sql)
	{
		 Statement st = null;

	        try {
				st = c.createStatement();
				 int i = st.executeUpdate(sql);    // run the query

			        if (i == -1) {
			            System.out.println("db error : " + sql);
			        }

			        st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // statements


		System.out.println("Operation done successfully");
		
	}
	
	public static void DeleteStatement(Connection c, String sql)
	{
		 Statement st = null;

	        try {
				st = c.createStatement();
				 int i = st.executeUpdate(sql);    // run the query

			        if (i == -1) {
			            System.out.println("db error : " + sql);
			        }

			        st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // statements


		System.out.println("Operation done successfully");
		
	}

}
