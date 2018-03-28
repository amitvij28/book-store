package mini_project;
import java.util.*;

class Login {
	
	static ArrayList<Customer> customer_list = new ArrayList<Customer>();
	
	static Scanner sc = new Scanner(System.in);
	
	static void login_portal() {
		int opt;
		while(true) {
			
			System.out.println("WELCOME TO BOOKKART \n1.Login \t2.Sign Up \t3.Go Back");
			System.out.print("Enter your option:");
			opt=sc.nextInt();
			switch(opt) {
			case 1:log_in();
					break;
			case 2:sign_up();
					break;
			case 3:break;
			default:System.out.println("Enter valid option");
			}
		if(opt ==3)
			break;
		}
	}
	
	 static void sign_up() {
		System.out.println("Sign Up Portal");
		int id;
		boolean flag;
		do {
			flag=false;
			System.out.print("Enter new ID:");
			id = sc.nextInt();
			for(Customer temp : customer_list) {
				if(id==temp.customer_id) {
					System.out.println("ID already exists");
					flag=true;
					break;
				}
			}
		}while(flag==true);
		System.out.print("Enter name:");
		String name= sc.next();
		System.out.print("Enter password:");
		String passw = sc.next();
		String s_address[] = new String[4] ;
		int s_code;
		System.out.print("Enter shipping street,city,state,country,postal code:");
		s_address[0] =sc.next();
		s_address[1] =sc.next();
		s_address[2] =sc.next();
		s_address[3] =sc.next();
		s_code = sc.nextInt();
		
		System.out.print("Do you want your shipping address to be your billing address too?(yes/no)");
		String o = sc.next();
		if(o.equals("yes")) {
			Customer temp = new Customer(id,name,passw,s_address,s_code);
			customer_list.add(temp);
		}
		else if(o.equals("no")) {
			String b_address[] = new String[4] ;
			int b_code;
			System.out.print("Enter billing street,city,state,country,postal code:");
			b_address[0] =sc.next();
			b_address[1] =sc.next();
			b_address[2] =sc.next();
			b_address[3] =sc.next();
			b_code = sc.nextInt();
			Customer temp = new Customer(id,name,passw,s_address,s_code,b_address,b_code);
			customer_list.add(temp);

		}
		
	 }

	static void log_in() {
		int id;
		String passw;
		boolean flag=false;
		System.out.print("Enter ID:");
		id = sc.nextInt();
		for(Customer temp:customer_list) {
			if(temp.customer_id==id) {
				flag = true;
				System.out.print("Enter password:");
				passw = sc.next();
				if(passw.equals(temp.password)) 
					temp.logged_in();
				break;
			}
		}
		if(flag==false)	
			System.out.println("ID not found ,Sign up to create a new ID");
	}




}
