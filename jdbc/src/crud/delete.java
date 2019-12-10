package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class delete {
connectionmanager con=new connectionmanager();

	public void del() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("enter your id");
		int id=s.nextInt();
		PreparedStatement ps=con.geConnection().prepareStatement("delete from firstapp where ID=?;");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("data deleted");
		firstapp fa=new firstapp();
		fa.choice();
		
	}


}
