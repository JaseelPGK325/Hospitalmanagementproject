package Shopping;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;





public class admin {

connections con=new connections();

	public void adminup() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username");
		String name=sc.next();
		System.out.println("Enter the password");
		String pass=sc.next();

		int flag=1;
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet set=st.executeQuery("select * from admin");
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
			admin nt=new admin();
			nt.admini();

		}else {
			System.out.println("Please enter correct username and password");
			Shopping  fa=new Shopping();
			fa.choice();

			
		}
		
		
	}
		
		
		public void admini() throws ClassNotFoundException, SQLException
		{
			// TODO Auto-generated method stub
		
		
		
		Scanner s=new Scanner(System.in);
	System.out.println("1)add products\n2)display products\n3)remove products\n4)update products\n5)logout\nenter your choice:\n");
	int n=s.nextInt();
	switch(n){
	case 1:
		System.out.println("Enter the product Id:");
		int id=s.nextInt();
		System.out.println("Enter the product Name:");
		String pname=s.next();
		System.out.println("Enter the minsellquantity:");
		int qty=s.nextInt();
		System.out.println("Enter the price:");
		int price=s.nextInt();
PreparedStatement ps=con.getConnection().prepareStatement("insert into addproduct(ID,Name,Quantity,Price)values(?,?,?,?);");
		
		ps.setInt(1, id);
		ps.setString(2, pname);
		ps.setInt(3, qty);
		ps.setInt(4, price);
		ps.executeUpdate(); 
		System.out.println("Product added successfully");
		admin ad=new admin();
		ad.admini();
		break;
	case 2:
		System.out.println("******Products******");
		Statement s1= (Statement) con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from addproduct");
		while(r.next()) {
			System.out.println("Product ID   : "+r.getInt(1)+"\nProduct Name : "+r.getString(2)+"\nQuantity     : "+r.getInt(3)+"\nPrice        : "+r.getInt(4)+"\n******************");
		
		}
		admin adm=new admin();
		adm.admini();
		break;
	case 3:
		System.out.println("******Products******");
		Statement s12= (Statement) con.getConnection().createStatement();
		ResultSet r23=s12.executeQuery("select * from addproduct");
		while(r23.next()) {
			System.out.println("Product ID   : "+r23.getInt(1)+"\nProduct Name : "+r23.getString(2)+"\n******************");
		
		}
		System.out.println("enter your id");
		int i=s.nextInt();
		PreparedStatement pss=con.getConnection().prepareStatement("delete from addproduct where ID=?;");
		pss.setInt(1, i);
		pss.executeUpdate();
		System.out.println("Product removed");
		admin admi=new admin();
		admi.admini();
		break;
	case 4:
		System.out.println("******Products******");
		Statement s2= (Statement) con.getConnection().createStatement();
		ResultSet rr=s2.executeQuery("select * from addproduct");
		while(rr.next()) {
			System.out.println("Product ID   : "+rr.getInt(1)+"\nProduct Name : "+rr.getString(2)+"\n******************");
		
		}
		System.out.println("enter the  id to update");
		int id1=s.nextInt();
		System.out.println("which parameter want to update\n11)name\n22)price\n33)Quantity");
		int m=s.nextInt();
		switch(m) {
		case 11:
			System.out.println("enter new product name");
			String nm=s.next();
			PreparedStatement st4=con.getConnection().prepareStatement("update addproduct Name=?where ID=?");
			st4.setString(1,nm);
			st4.setInt(2, id1);
			break;
		case 22:
			System.out.println("enter updated price");
			int p=s.nextInt();
			PreparedStatement st5=con.getConnection().prepareStatement("update addproduct Price=?where ID=?");
			st5.setInt(1,p);
			st5.setInt(2, id1);
			break;
		case 33:
		System.out.println("enter the quantity");
		int qt=s.nextInt();
		int quant=0;int id2=0;
		Statement st2=(Statement) con.getConnection().createStatement();
		ResultSet r45=st2.executeQuery("select ID,Quantity from addproduct");
		while(r45.next()) {
			id2=r45.getInt(1);
			if(id2==id1) {
				quant=r45.getInt(2);
			}
		}
		qt=quant+qt;
		PreparedStatement st=con.getConnection().prepareStatement("update addproduct set Quantity=? where ID=?");
		st.setInt(1, qt);
		st.setInt(2, id2);
		st.executeUpdate();
		System.out.println("product Quantity updated successfully");
		break;
		default:System.out.println("invalid input");
		
		}
		admin admii=new admin();
		admii.admini();

		break;
	case 5:
System.out.println("admin logouted");
	Shopping sh=new Shopping();
	sh.choice();
	
		break;
		default:System.out.println("invalid input");
	}
	
	
	
	}
}
