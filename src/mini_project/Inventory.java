package mini_project;
import java.util.*;

public class Inventory {
	
	static ArrayList<Item> item_list = new ArrayList<Item>();
	static Scanner sc = new Scanner(System.in);
	static void display() {
		int count = 0;
		for(Item x:item_list) {
			count++;
			System.out.printf("%d.",count);
			x.display();
		}
	}
	
	static void add_existing() {
		int i;
		System.out.print("Enter item id:");
		i=sc.nextInt();
		boolean flag = false;
		for(Item temp:item_list) {
			if(temp.id==i) {
				temp.display();
				System.out.print("Enter number of this item you want to add:");
				int num = sc.nextInt();
				temp.quantity+=num;
				flag = true;
			}
		}
		if(flag == false)
			System.out.println("item not found");
	}
	
	static void add_books() {
		
		System.out.print("Enter item id");
		int id = sc.nextInt();
		System.out.print("\n Enter title:");
		String title = sc.next();
		System.out.print("Enter author:");
		String author = sc.next();
		System.out.print("Enter edition:");
		int edition = sc.nextInt();
		System.out.print("Enter volume:");
		int volume = sc.nextInt();
		System.out.print("Enter publisher:");
		String publisher = sc.next();
		System.out.print("Enter price:");
		float price = sc.nextFloat();
		System.out.print("Enter quantity:");
		int quantity = sc.nextInt();
		System.out.print("Enter genre:");
		String genre = sc.next();

		
		Item temp = new Item(title,author,edition,volume,publisher,price,quantity,id,genre);
		item_list.add(temp);
	}



}
