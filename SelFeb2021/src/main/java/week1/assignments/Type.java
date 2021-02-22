package week1.assignments;

public class Type {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		char[] inputArray=test.toCharArray();
		int letters=0,numbers=0,specialchar=0,space=0;
		for(int i=0;i<inputArray.length;i++) {
			if(Character.isDigit(inputArray[i])){
				numbers++;
			}else if(Character.isLetter(inputArray[i])){
				letters++;
			}else if(Character.isSpaceChar(inputArray[i])) {
				space++;
			}else {
				specialchar++;
			}
		}System.out.println("Number of Digits present:"+numbers);
		System.out.println("Number of letters present:"+letters);
		System.out.println("Number of spaces present:"+space);
		System.out.println("Number of special characters present:"+specialchar);
		
	}

}
