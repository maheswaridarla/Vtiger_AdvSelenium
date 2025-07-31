package GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	public Connection con;
	/**
	 * this method is used to fetch the data from database
	 * @param url
	 * @param un
	 * @param pswd
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
public ResultSet FetchDataFromDataBase(String url,String un,String pswd,String query) throws SQLException {
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection(url,un,pswd);
	Statement stat = con.createStatement();
	ResultSet result = stat.executeQuery(query);
	return result;
	
	
}
/**
 * this method is used to fetch the data from database
 * @param query
 * @return ResultSet
 * @throws Exception
 */


	public ResultSet FetchTheDataFromDataBase(String query) throws Exception {
	
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery(query);
		return result;
		
	}
	
	/**
	 * this method is used to write back data to database
	 * @param query
	 * @return int
	 * @throws Exception
	 */
	
	public int WriteBackDataToDataBase(String query) throws Exception {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement stat = con.createStatement();
		int result = stat.executeUpdate(query);
		return result;
	}
	
	/**
	 * this method is used to close database connection
	 * @throws SQLException
	 */
	public void CloseDatabaseConnection() throws SQLException {
		con.close();
	}
	/**
	 * this method is used to gett connection from database
	 * @return
	 * @throws SQLException
	 */
	public Connection getDataBaseConnection() throws SQLException {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	    return con;
	}
}
