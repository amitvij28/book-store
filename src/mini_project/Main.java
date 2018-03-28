package mini_project;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		boolean flag = false;
		while(true) {
			
			do {
				try {
					System.out.println("\t BOOKCART \n 1.Manager \t 2.Customer \t 3.Exit");
					System.out.print("Enter your option:");
					opt=sc.nextInt();
					flag=true;
				}catch(InputMismatchException e) {
					System.out.println("Enter valid input");
					sc.nextLine();
				}
			}while(flag!=true);
			switch(opt){
			case 1: Manager.log();
					break;
			case 2:	Login.login_portal();
					break;
			case 3:System.exit(0);
			default:System.out.println("Enter valid input");
			}
			
		}
	}
}
