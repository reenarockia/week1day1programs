package week1.day1;

public class primeNmumber {
	
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
		primeNmumber pm=new primeNmumber();
		pm.checkPrime(21);
		}
}

