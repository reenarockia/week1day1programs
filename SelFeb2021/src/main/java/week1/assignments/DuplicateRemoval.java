package week1.assignments;

public class DuplicateRemoval {

	public static void main(String[] args) {
		String text = "we learn java basics as part of Java sessions java we learn java";
		int i,j;
		String temp="";
		String[] arrResult=text.split("\\s+");
		System.out.println("\nThe String array after split:");
		for (String string : arrResult) {
			System.out.println(string);
		}for(i=0;i<arrResult.length-1;i++) {
			for(j=i+1;j<arrResult.length;j++) {
				if(arrResult[i].equalsIgnoreCase(arrResult[j])) {
					arrResult[j]=arrResult[j].replace(arrResult[j],"");
				}
			}
		}System.out.println("\nThe string array after replacing the duplicates with empty string:");
		for (String string : arrResult) {
			System.out.println(string);
		}for(i=0;i<arrResult.length;i++) {
			if(!arrResult[i].isEmpty()) {
				temp=temp+arrResult[i]+" ";
				}
	}System.out.println("original String:\n"+text);
	System.out.println("Final Result:"+"\n"+temp);
			
} 
}

