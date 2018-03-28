package mini_project;
import java.util.*;
class Customer {
	
	Scanner sc = new Scanner(System.in);
	int bill_count=0;
	ArrayList<Item> cart = new ArrayList<Item>();
	ArrayList<Bill> bills = new ArrayList<Bill>();
	
	Category preference;
	
	String customer_name;
	int customer_id;
	 String password;
	Address shipping_address,billing_address;

	void display() {
		System.out.printf("name:%s \t id:%d ", customer_name,customer_id);
	}

	 void logged_in() {
		 int opt;
		 while(true) {
			 System.out.println("Welcome "+customer_name);
			 System.out.print("1.Search \t 2.My Cart \t 3.Old bills \t 4.Check preferences \t 5.Go Back");
			 opt = sc.nextInt();
			 switch(opt) {
			 case 1: search_books();
			 		break;
			 case 2: my_cart();
			 		break;
			 case 3:old_bill();
			 		break;
			 case 5: break;
			 case 4:check_preferences();
			 		break;
			 default:System.out.println("Enter valid option");
			 }
			 if(opt == 5) 
				 break;
		 }
	}
	void check_preferences() {
		int max=-1;
		try {
		for(int num: preference.category_pref) {
			if(num>max) 
				max=num;
		}
		int i = preference.category_pref.indexOf(max);
		String genre = preference.category__name.get(i);
		for(Item temp : Inventory.item_list) {
			if(temp.genre.equals(genre)) {
				temp.display();
				
			}
		}
		}catch(NullPointerException e) {
			System.out.println("No preference");
			sc.nextLine();
		}
		
	}
	
	void increase_preference(Item temp) {
		
		if(!preference.category__name.contains(temp.genre)) {
			preference.category__name.add(temp.genre);
			preference.category_pref.add(1);
		}else {
			int i = preference.category__name.indexOf(temp.genre);
			int num = preference.category_pref.get(i);
			num++;
			preference.category_pref.set(i, num);
		}
	}

	void old_bill() {
		int i;
		boolean flag=false;
		System.out.print("Enter bill id:");
		i=sc.nextInt();
		for(Bill temp : bills) {
			if(temp.bill_id==i) {
				temp.display();
				flag=true;
				break;
			}
		}
		if(flag==false)
			System.out.println("Bill not found");
	}

	void my_cart() {
		for(Item temp:cart) {
			temp.display();
		}
		System.out.println("\n 1.Buy whole cart   2.Buy specific item in cart  3.Go back");
		System.out.print("Enter option:");
		int opt = sc.nextInt();
		switch(opt) {
		case 1:buy_whole_cart();
				break;
		case 2:buy_specific();
				break;
		case 3:break;
		default:System.out.println("Enter valid option");
		}
	}

	 void buy_specific() {
		Bill b = new Bill();
		boolean flag;
		String s;
		
		do {
			System.out.print("Enter item id that you want to buy:");
			int i = sc.nextInt();
			flag=false;
			for(Item temp:cart) {
				 if(temp.id==i) {flag=true;
					 System.out.print("Enter quantity for book "+temp.title+":");
					 int q =sc.nextInt();
					 if((temp.quantity-q)>=0) {
						 temp.quantity-=q;
						 b.item_bought.add(temp);
						 b.item_quantity.add(q);
						 cart.remove(temp);
						 
					 }
					 else {
						 System.out.println("Not enough quantity");
					 }
					 break;
				 }
			}
			if(flag==false) {
				System.out.println("Item not found");
			}
			System.out.print("Do you want to buy more(yes/no):");
			 s = sc.next();
			
		}while(s.equals("yes"));
		if(!b.item_bought.isEmpty()){
			b.bill_id=bill_count;
			bill_count++;
		}
		b.display();
		bills.add(b);
	}

	void buy_whole_cart() {
		Bill b = new Bill(); 
		for(Item temp:cart) {
			 
			 System.out.print("Enter quantity for book "+temp.title+":");
			 int q =sc.nextInt();
			 if((temp.quantity-q)>=0) {
				 temp.quantity-=q;
				 b.item_bought.add(temp);
				 b.item_quantity.add(q);
			 }
			 else {
				 System.out.println("Not enough quantity");
			 }
			 
		 }
		if(!b.item_bought.isEmpty()){
			b.bill_id=bill_count;
			bill_count++;
		}
		b.display();
		bills.add(b);
		cart.clear();
	}

	void search_books() {
		System.out.print("Search:");
		String search = sc.next();
		int count = 0;
		for(Item temp : Inventory.item_list) {
			if(temp.title.contains(search) || temp.book.author.contains(search)) {
				count++;
				temp.id=count;
				
				System.out.printf("id:%d %s by %s \t price:%f   ",temp.id,temp.title,temp.book.author,temp.price );
				if(temp.quantity==0)
					System.out.println("OUT OF STOCK");
				else
					System.out.println();
			}
		}
		String c;
		do {
			System.out.print("Enter item id that you want to buy");
			int i = sc.nextInt();
			
			for(Item temp:Inventory.item_list) {
				if(temp.id == i) {
					if(temp.quantity!=0) {
						if(!cart.contains(temp)) {
							cart.add(temp);
							increase_preference(temp);
							System.out.println("Added to cart");
						}else {
							System.out.println("Already in cart");
						}
					}
					else 
						System.out.println("Item OUT OF STOCK!!");
				}
			}
			System.out.print("Do you want to add more items?(yes/no):");
			c = sc.next();
		}while(c.equals("yes"));
		System.out.print("Do you want to access your cart?(yes/no):");
		c = sc.next();
		if(c.equals("yes"))
			my_cart();
		
	}

	Customer(int id,String name,String passw,String[] s_address,int s_code){
		 customer_id=id;
		 customer_name=name;
		 password =passw;
		 shipping_address = new Address(s_address,s_code);
		 billing_address  = new Address(s_address,s_code);
		 preference = new Category();
	}
	 Customer(int id,String name,String passw,String[] s_address,int s_code,String[] b_address,int b_code){
		 customer_id=id;
		 customer_name=name;
		 password =passw;
		 shipping_address = new Address(s_address,s_code);
		 billing_address  = new Address(b_address,b_code);
		
	 }
}
