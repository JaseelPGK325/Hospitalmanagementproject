package crud;

import java.sql.SQLException;
import java.util.Scanner;

public class firstapp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		firstapp fa=new firstapp();
		fa.choice();

	}

	public void choice() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("1)insert\n2)view\n3)update\n4)delete\n5)login\n6)exit");
		System.out.println("enter your choice");
		int n=s.nextInt();
		switch(n) {
		case 1:
			insert in=new insert();
			in.Insertion();
			break;
		case 2:
			view vw=new view();
			vw.display();
			break;
		case 3:
			update up=new update();
			up.updates();
			break;
		case 4:
			delete dl=new delete();
			dl.del();
			break;
		case 5:login lo=new login();
			lo.logins();
			break;
		case 6:
			System.exit(0);
			break;
			default:System.out.println("invalid option");
		}
	}

	
}
