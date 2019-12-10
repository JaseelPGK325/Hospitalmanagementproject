package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class StudentDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.jdbc.Driver");
Connection con=null;
con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
if(con!=null) {
	System.out.println("Connection Successful");
}else {
	System.out.println("check your connection");
}
Scanner s=new Scanner(System.in);
System.out.println("enter option\n1)insert\n2)display");
int n=s.nextInt();
switch(n) {
case 1:
System.out.println("enter name");
String name=s.next();
System.out.println("enter roll number");
int roll=s.nextInt();
System.out.println("enter department");
String dept=s.next();
System.out.println("enter year");
int year=s.nextInt();
System.out.println("enter the address");
String adr=s.next();
PreparedStatement st=(PreparedStatement) con.prepareStatement("insert into Student(Name,Roll_No,Department,Year,Address)values(?,?,?,?,?);");
st.setString(1,name);
st.setInt(2, roll);
st.setString(3,dept);
st.setInt(4, year);
st.setString(5,adr);
st.executeUpdate();
System.out.println("insert successfully");
con.close();
break;
case 2:
	Statement s1=(Statement) con.createStatement();
	ResultSet r=s1.executeQuery("select * from Student");
	while(r.next()) {
		System.out.println(r.getString(1)+" "+r.getInt(2)+" "+r.getString(3)+" "+r.getInt(4)+" "+r.getString(5));
	}

	}

}}