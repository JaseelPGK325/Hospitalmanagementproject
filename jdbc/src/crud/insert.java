package crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class insert {

	connectionmanager con=new connectionmanager();


		// TODO Auto-generated method stub
		
	
	

	public void Insertion() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner (System.in);
		System.out.println("enter id");
		int n=s.nextInt();
		System.out.println("enter user name");
		String name=s.next();
		System.out.println("enter password");
		String pw=s.next();
		PreparedStatement ps=con.geConnection().prepareStatement("insert into firstapp(ID,Name,Password)values(?,?,?);");
		
		ps.setInt(1, n);
		ps.setString(2, name);
		ps.setString(3, pw);
		ps.executeUpdate();
		System.out.println("Data inserted");
		firstapp fa=new firstapp();
		fa.choice();
	}

}
