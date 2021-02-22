package week1Practice;

public class fibonacciSeries {

	public static void main(String[] args) {
		int firstNum=0,secondNum=1,nextNum=0;
		System.out.print(firstNum+" "+secondNum+" ");
		while(nextNum < 200) {
			nextNum=firstNum+secondNum;
			System.out.print(nextNum+" ");
			firstNum=secondNum;
			secondNum=nextNum;
		}
	}

}
