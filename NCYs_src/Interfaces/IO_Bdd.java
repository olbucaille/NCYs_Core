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
		Connection c= null;
		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+name);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return c;
	}

	public static  void createTABLES(Connection c)
	{
		Statement stmt = null;
		try {

			stmt = c.createStatement();
			String sql = "CREATE TABLE COMPANY " +
					"(ID INT PRIMARY KEY     NOT NULL," +
					" NAME           TEXT    NOT NULL, " + 
					" AGE            INT     NOT NULL, " + 
					" ADDRESS        CHAR(50), " + 
					" SALARY         REAL)"; 
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table created successfully");

	}
	public static void InsertStatement(Connection c, String sql)
	{
		Statement stmt = null;
		try{  
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			// c.commit();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");

	}

	public static ResultSet SelectStatement(Connection c, String sql)
	{
		ResultSet rs= null;
		try
		{
			Statement stmt = c.createStatement();
	rs	 = stmt.executeQuery( sql );

			/*while ( rs.next() ) {
     
       String  name = rs.getString("name");
       int age  = rs.getInt("age");
       String  address = rs.getString("address");
       float salary = rs.getFloat("salary");
       System.out.println( "ID = " + id );
       System.out.println( "NAME = " + name );
       System.out.println( "AGE = " + age );
       System.out.println( "ADDRESS = " + address );
       System.out.println( "SALARY = " + salary );
       System.out.println();
    }*/

			//rs.close();
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
		return rs;
	}

	public static void UpdateStatement(Connection c, String sql)
	{
		try {

			Statement stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Operation done successfully");
		
	}
	
	public static void DeleteStatement(Connection c, String sql)
	{
		try {

			Statement stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Operation done successfully");
		
	}

}
