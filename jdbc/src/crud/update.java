package crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class update {
	connectionmanager con=new connectionmanager();

public void updates() throws ClassNotFoundException, SQLException {
	Scanner s=new Scanner(System.in);
System.out.println("enter the  id to update");
int id1=s.nextInt();
System.out.println("enter the new userid");
int id=s.nextInt();
System.out.println("enter the new name");
String name=s.next();
System.out.println("enter the new password");
String pwd=s.next();
PreparedStatement st=con.geConnection().prepareStatement("update firstapp set ID=?,Name=?, Password=?where ID=?");
st.setInt(1,id);
st.setString(2, name);
st.setString(3, pwd);
st.setInt(4,id1);
st.executeUpdate();
System.out.println("updated successfully");
firstapp first=new firstapp();
first.choice();


}

}


