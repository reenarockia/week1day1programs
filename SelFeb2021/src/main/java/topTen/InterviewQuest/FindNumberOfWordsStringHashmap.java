package topTen.InterviewQuest;
/*
A HashMap uses a technique called “Hashing”. 
In hashing, a longer string is converted into 
a shorter string by applying some algorithm or ‘hash function’.
A string is converted to a shorter string as it helps in searching that is faster.
It is also used for efficient indexing.

HashMap in Java is a collection based on Map and consists of key-value pairs. 
A HashMap is denoted by < Key, Value > or < K, V >. 
A HashMap element can be accessed using a Key
 i.e. we must know the key to access the HashMap element.
 
 HashMap=HashTable. 
 But HashMap is not synchronized and allows Null values to the key and value
 
 Some of the important characteristics of HashMap are given below:

HashMap is implemented in Java in the “Hashmap” class that is a part of java.util package.
HashMap class inherits from the class “AbstractMap” that partially implements the Map interface.
HashMap also implements ‘cloneable’ and ‘serializable’ interfaces.
HashMap permits duplicate values but does not permit duplicate keys. HashMap also allows multiple null values but a null key can be only one.
HashMap is unsynchronized and also does not guarantee the order of the elements.
Java HashMap class has an initial capacity of 16 and the default (initial) load factor is 0.75.


*/

import java.util.Scanner;

public class FindNumberOfWordsStringHashmap {

	public static void main(String[] args) {
		System.out.println("Enter the input string:");
		Scanner scan1=new Scanner(System.in);
		String inputString=scan1.nextLine();
		scan1.close();
		

	}

}
