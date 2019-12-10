package Shopping;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class connections {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//register the driver
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;//connect object
		//create connection
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping","root","");
		//object=class.method(API:database:/server:port number/db name,username,password);
		if(con!=null) {
			return con;
		}else {
			return null;
		}
		
		
	}

	
}
