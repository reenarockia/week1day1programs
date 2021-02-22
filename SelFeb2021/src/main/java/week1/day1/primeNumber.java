package week1.day1;
/*
 Find if the given number is a prime number.
Eg: if the number is 13,  print the output as " Prime Number" 
 */

public class primeNumber {
	/*
	Prime numbers are numbers that have only 2 factors:
	1 and themselves.
	*/
	public void checkPrime(int numto_test) {
		int i,k;
		k=0;
	
		for(i=1;i<=numto_test;i++) {
			if((numto_test/i)!=0 && (numto_test%i)==0) { //check for the factors of a given number
				k=k+1;
			}
		}
		
		if(k==2) {
			System.out.println(numto_test+" is a prime number");
		}else {
			System.out.println(numto_test+" is not a prime number");
		}
	}
	public static void main(String[] args) {
		primeNumber pm=new primeNumber();
		int a;
		for (a=0;a<25;a++) {
			pm.checkPrime(a);
		}
	}
}