package week1.day1;

public class Mobile {
	int price;
	public int getPrice(int mobileNumber) {
		if (mobileNumber == 1) {
		price= 10000;
		} else if (mobileNumber == 2) {
			price= 20000;
		} else if (mobileNumber == 3 ) {
			price= 30000;
		} else {
			price= 40000;
		}
		return price;
	}
	
	public String getModel() {
		return "Apple11";
	}
	private void printPicture(String person_name) { // private methods should be called or used to get rid of this warning
		//return person_name;
		System.out.println("Print the picture of "+person_name);
	}

public static void main(String[] args) {
	Mobile myMobile = new Mobile();
	System.out.println(myMobile.getPrice(2));
	System.out.println(myMobile.getModel());
	myMobile.printPicture("Juana");
}
}
