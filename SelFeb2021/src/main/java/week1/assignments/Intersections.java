package week1.assignments;

public class Intersections {
	public void findIntersection(int[] arr1,int[] arr2) {
		int i,j;
		for(i=0;i<arr1.length;i++) {
			for(j=0;j<arr2.length;j++) {
				if(arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);
				}
			}
		}
	}
	public static void main(String[] args) {
		Intersections inter=new Intersections(); 
		int[] array1= {3,2,11,4,6,7};
		int[] array2= {1,2,8,4,9,7};
		inter.findIntersection(array1, array2);
	}

}
