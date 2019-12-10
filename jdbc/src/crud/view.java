package crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class view {
connectionmanager con=new connectionmanager();

	public void display() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement s1= (Statement) con.geConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from firstapp");
		while(r.next()) {
			System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3));
		}
		firstapp fa=new firstapp();
		fa.choice();
		
	}

	
}
