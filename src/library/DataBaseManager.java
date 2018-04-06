package library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseManager {
	Connection con;
	ResultSet rs;
	Statement stmt;
	public DataBaseManager()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"xujun","123456");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		}catch(ClassNotFoundException e){
			System.out.println("Failed to load JDBC/ODBC driver.");
			e.printStackTrace();
			System.exit(1);
		}catch(SQLException sqle){
			System.out.println(sqle.toString());
		}
	}
		public ResultSet getResult(String strSQL)
		{
			try{
				rs=stmt.executeQuery(strSQL);
				return rs;
			}catch(SQLException sqle){
				System.out.println(sqle.toString());
				return null;
			}
		}
		public boolean updateSql(String strSQL)
		{
			try{
				stmt.executeQuery(strSQL);
				con.commit();
				return true;
				
			}catch(SQLException sqle){
				System.out.println(sqle.toString());
				return false;
			}
		}
		public void closeConnection(){
			try{
				con.close();
			}catch(SQLException sqle){
				System.out.println(sqle.toString());
			}
		}
		

}
