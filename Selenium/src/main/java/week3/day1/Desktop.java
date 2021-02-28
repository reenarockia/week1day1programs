package week3.day1;

public class Desktop implements Software,Hardware {

	public void hardwareResources() {
		System.out.println("Method from interface Hardware");
		
	}

	public void softwareResources() {
		System.out.println("Method from interface Software");
		
	}

	public static void main(String[] args) {
		Desktop d1=new Desktop();
		d1.hardwareResources();
		d1.softwareResources();
		
	}

}
