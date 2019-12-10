package crud;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class connectionmanager {

/*steps to connect a java app to database
 * 1.load and register the driver
 * 2.create aconnection
 * 3.create a statement
 * 4.resulting or execute the query
 * 5.closing the connection*/
	public Connection geConnection() throws ClassNotFoundException, SQLException {
		//register the driver
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;//connect object
		//create connection
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/firstapp","root","");
		//object=class.method(API:database:/server:port number/db name,username,password);
		if(con!=null) {
			return con;
		}else {
			return null;
		}
		
		
	}

	}