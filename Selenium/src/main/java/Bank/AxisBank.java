package Bank;

public class AxisBank extends BankInfo{
	public void deposit() {
		System.out.println("Home load interest is only 3%");
		System.out.println("Method to print the deposit amount in Axis Bank");
	}
	public static void main(String[] args) {
		AxisBank AB=new AxisBank();
		AB.deposit();
	}

}
