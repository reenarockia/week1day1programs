package week1.day2;
public class duplicate {
	public static void main(String[] args) {
		int[] arr= {3,5,6,5,6,5,6,5,7,9,8,7,8,9,7,8,9};
		int dupcount;
		int arrinit=0;
		int[] arr1=new int[arr.length]; 
		boolean conti;
		for(int i=0;i<arr.length-1;i++) {
			dupcount = 1;
			conti=true;
			for(int j=i+1;j<arr.length;j++) {
				for(int k:arr1) {
					if(arr[i]==k) {
					conti=false;
					}
				}
				if (conti) {
				if(arr[i]==arr[j]) {
					dupcount=dupcount+1;
					}
				}
			}
			
			if(dupcount > 1) {
				arr1[arrinit]=arr[i];
				arrinit++;
				System.out.println(arr[i]+" is present "+dupcount+" times in this array");
				}
			}
		}
	}

