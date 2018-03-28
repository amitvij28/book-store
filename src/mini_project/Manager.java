package mini_project;
import java.util.*;

public class Manager {
	static Scanner sc = new Scanner(System.in);

	static void log() {
		int code = 0;
		System.out.println("\n Manager");
		boolean flag = false;
		do {
			try {
				System.out.print("\n Enter Pin:");
				code=sc.nextInt();
				flag=true;
			}catch(InputMismatchException e) {
				System.out.println("Pin is a 4-digit number");
				sc.nextLine();
			}
		}while(flag!=true);
		if(code==1234) {
			Manager.manager_portal();
		}else {
			System.out.println("Incorrect pin");
		}
	}
	
	static void manager_portal() {
		System.out.println("WELCOME MANAGER");
		while(true) {
			System.out.println("1.Display Inventory \t 2.Add Items \t 3.Add existing books \t 4.Go back");
			System.out.print("Enter option:");
			int opt = sc.nextInt();
			switch(opt) {
			case 1: Inventory.display();
					break;
			case 2: Inventory.add_books();
					break;
			case 4:break;
			case 3:Inventory.add_existing();
					break;
			default:System.out.println("Enter valid option");
			}
			if(opt == 4)	
				break;
		}
	}
}
