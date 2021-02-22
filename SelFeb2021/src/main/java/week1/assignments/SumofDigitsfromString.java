package week1.assignments;

public class SumofDigitsfromString {

	public static void main(String[] args) {
		String text = "Tes12Le79af65";
		int sum=0,b;
		char[] charArr=text.toCharArray();
		
		for(int i=0;i<charArr.length;i++) {
			if(Character.isDigit(charArr[i])) {
				b=Character.getNumericValue(charArr[i]);
				System.out.println("The numeric value found in the string:"+b);
				sum=sum+b;
				}
		}
		System.out.println("Sum of digits from the string "+text+"is:"+sum);
	}
}

