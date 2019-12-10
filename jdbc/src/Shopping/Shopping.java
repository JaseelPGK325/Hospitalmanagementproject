package Shopping;

import java.util.Scanner;
import java.sql.SQLException;


public class Shopping {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Shopping sh=new Shopping();
sh.choice();
	}

	public void choice() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("1)Admin Login\n2)Agent Login\n3)exit");
		System.out.println("enter your choice");
		int n=s.nextInt();
		switch(n) {
		case 1:
			admin ad=new admin();
			ad.adminup();
			break;
		case 2:
			agent ag=new agent();
			ag.agentup();
			break;
		case 3:System.out.println("Process will be completed");
			System.exit(0);
			break;
			default:System.out.println("invalid option");
		}	
	}

}
