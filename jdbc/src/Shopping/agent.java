package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class agent {
connections con=new connections();

	public void agentup() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username");
		String name=sc.next();
		System.out.println("Enter the password");
		String pass=sc.next();

		int flag=1;
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet set=st.executeQuery("select * from agent");
		String name1="";String pw1="";
		while(set.next()) {
		//to display the values
		 name1=set.getString(1);
		pw1=set.getString(2);

		if(name1.equals(name)&& pw1.equals(pass)) {
			flag=2;
		break;
		}
		else {
		flag=0;
		}
		}
		if(flag==2) {
			System.out.println("Successfully Verified");
			agent n=new agent();
			n.agents();

		}else {
			System.out.println("Please enter correct username and password");
			Shopping  fa=new Shopping();
			fa.choice();
		}

	
	
	}

	public void agents() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner (System.in);
		System.out.println("1)BuySell\n2)View Product\n3)logout\nEnter the choice:");
	int n=s.nextInt();
	switch(n) {
	case 1:
		
		System.out.println("Enter the product Id:");
		int id=s.nextInt();
		System.out.println("Enter the quantity:");
		int qty=s.nextInt();
	int id1=0,price=0,qt=0;
	Statement sta=(Statement) con.getConnection().createStatement();
	ResultSet re=sta.executeQuery("select ID,Quantity,Price from addproduct");
	while(re.next()) {
		id1=re.getInt(1);
		if(id==id1) {
			qt=re.getInt(2);
			price=re.getInt(3);
	
		System.out.println("Cost is : "+(qty*price));
		qt=qt-qty;
		if(qt>=0) {
			qt=qt;
		}
		else {
			qt=0;
		}
		PreparedStatement pr1=con.getConnection().prepareStatement("update addproduct set Quantity=? where ID=?");
		pr1.setInt(1, qt);
		pr1.setInt(2, id);
		pr1.execute();
		System.out.println("Enter 1 to confirm Booking");
		int dd=s.nextInt();
		System.out.println("Your Booking is Confirmed\nThank you...!!!");
		}
	}
		

		
	agent admm=new agent();
	admm.agents();
		
		
		
		break;
	case 2:
		System.out.println("******Products******");
		Statement s1= (Statement) con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from addproduct");
		while(r.next()) {
			System.out.println("Product ID   : "+r.getInt(1)+"\nProduct Name : "+r.getString(2)+"\nQuantity     : "+r.getInt(3)+"\nPrice        : "+r.getInt(4)+"\n******************");
		
		}
		agent adm=new agent();
		adm.agents();
		break;
	case 3:
		System.out.println("Agent logouted");
		Shopping sh=new Shopping();
		sh.choice();
	default:System.out.println("invalid input");
	
		break;
	}
	
	}

}
