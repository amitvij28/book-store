package mini_project;

 class Address {
	 String street,city,state,country;
	 int postal_code;
	 
	 void display() {
		 System.out.printf("street:%s \n city:%s \n state:%s \n country:%s \n postal code:%d", street,city,state,country,postal_code);
	 }
	 
	 Address(String[] address,int code){
		 street = address[0];
		 city =  address[1];
		 state = address[2];
		 country = address[3];
		 postal_code = code;
	 }
 
 }
