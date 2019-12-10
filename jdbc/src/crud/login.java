package crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class login {
connectionmanager con=new connectionmanager();
public void logins() throws SQLException, ClassNotFoundException {
Scanner s=new Scanner(System.in);
System.out.println("Enter the username");
String name=s.next();
System.out.println("Enter the password");
String pass=s.next();
int flag=1;
Statement st=con.geConnection().createStatement();
ResultSet set=st.executeQuery("select * from firstapp");
String name1="";String pw1="";
while(set.next()) {
//to display the values
 name1=set.getString(2);
pw1=set.getString(3);

if(name1.contentEquals(name)&& pw1.contentEquals(pass)) {
	flag=2;
break;
}
else {
flag=0;
}
}
if(flag==2) {
	System.out.println("welcome "+name1);

}else {
	System.out.println("Please enter correct username and password");
}

firstapp fa=new firstapp();
fa.choice();

}

}

