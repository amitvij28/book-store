package mini_project;

class Item {
	
	String genre;
	Book book;
	String title;
	float price;
	String publisher;
	int quantity;
	int id;
	
	void display() {
		System.out.printf("id:%d title:%s author:%s volume:%d edition:%d publisher:%s genre:%s price:%.2f quantity:%d\n",id,title,book.author,book.volume,book.edition,publisher,genre,price,quantity);
	}
	Item(String title,String author,int edition,int volume,String publisher,float price,int quantity,int id,String genre){
		this.title=title;
		this.price=price;
		this.quantity=quantity;
		this.publisher=publisher;
		this.id=id;
		this.genre=genre;
		book = new Book(author,edition,volume);
	}

}
