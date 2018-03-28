package mini_project;
import java.util.*;

 class Bill {
	 ArrayList<Item> item_bought = new ArrayList<Item>();
	 ArrayList<Integer> item_quantity = new ArrayList<Integer>();
	 int bill_id;
	 
	 
	 void display() {
		float total_price=0;
		Item temp;
		int quant;
		 for(int i=0;i<item_bought.size();i++) {
			 temp = item_bought.get(i);
			 quant = item_quantity.get(i);
			 total_price += temp.price*quant;
			 System.out.printf("book id:%d title:%s author:%s quantity:%d price:%.2f \n", temp.id,temp.title,temp.book.author,quant,temp.price);
		 }
		System.out.printf("Total bill: Rs. %.2f",total_price); 
	 }
	 
	 
}
