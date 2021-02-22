package week1.day1;

/*
 For the numbers from 1 to 25, check the divisibility of these numbers by 3 and 7
(ie) if the number is divisible by 3, then print the output as "biz" 
If the number is divisible by 7, then print the output as "fiz"
If the number is divisible both by 3 and 7, then print the output as "bizfiz". 
 */

public class divisibleby3and7 {
	
	public void checkdiv(){
		int i;
		int j=0,k=0;
		System.out.println("Divisible by 3 ---> biz");
		System.out.println("Divisible by 7 ---> fiz");
		System.out.println("Divisible by 3&7 ---> bizfiz");
		
		for(i=1;i<26;i++) {
			if((i/3)!=0 && (i%3)==0) {
				j=1;
				System.out.println(i+"-biz");
			}if((i/7)!=0 && (i%7)==0) {
				k=1;
				System.out.println(i+"-fiz");
			} if(j==1 && k==1) {
				System.out.println(i+"-bizfiz");
			}
			j=0;
			k=0;
			}
		
		}
	public static void main(String[] args) {
		
		divisibleby3and7 div=new divisibleby3and7();
		div.checkdiv();
		}
}
