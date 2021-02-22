package week1.day2;

import java.util.Arrays;

public class secondbiggest {
	public void findSecondBiggest(int[] arr) {
		Arrays.sort(arr);
		int secondlargest=arr[arr.length-2];
		System.out.println("the second largegest value is : "+secondlargest);
	}
	public static void main(String[] args) {
		secondbiggest sb=new secondbiggest();
		int[] samplearr= {3,2,11,4,6,7};
		sb.findSecondBiggest(samplearr);
	}

}
