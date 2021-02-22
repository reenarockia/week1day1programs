package week1.day2;

public class amstrongNumber {

	public boolean isAmstrong(int numberto_check) {
			int reminder,original_number;
			int sum=0;
			original_number=numberto_check;
			while(numberto_check != 0) {
				reminder=numberto_check % 10;
				sum=sum+(reminder*reminder*reminder);
				numberto_check=numberto_check/10;
				
			}
			if(sum==original_number) {
				return true;
			}else {
				return false;
			}
		}

public static void main(String[] args) {
	
	amstrongNumber ams=new amstrongNumber();
	if(ams.isAmstrong(153)) {
		System.out.println("the given number is an amstrong number");
	}else {
		System.out.println("the given number is not an amstrong number");
	}
	
	}
}