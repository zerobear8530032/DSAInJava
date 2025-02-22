package myDataStructures.arrays;
import java.util.ArrayList;
import java.util.Arrays;
public class ArraysInJava {
	
	
	public static void changeArray(int [] arr) {
		arr[2]=34;
	}
	
	
	public static void main(String args[]) {
		
//		creating array 
		
//		create empty array 
		int []arr1= new int [5]; // initalize an empty array it is a array of size 5 each element will be 0 
		System.out.println("Arrays 1 :"+Arrays.toString(arr1));	// this will print array 
//		create array with value initalize
		int []arr2= {1,5,34,4,43,2};// declaration with initalizeation of array where we does not need to metnsion size 		
		System.out.println("Arrays 2 :"+Arrays.toString(arr2));	// this will print array 
//		create value initalize array with new keyword 
		int []arr3= new int []{2,4,1,4,6,3,2};// declaration with initalizeation of array where we does not need to metnsion size 		
		System.out.println("Arrays 3 :"+Arrays.toString(arr3));	// this will print array
		
//		accessning element in array : it range from 0 till length -1
		
		System.out.println("Arrays 1 before updating :"+Arrays.toString(arr1));	// this will print array 
		arr1[1]=23;// this will make the index 1 of arr1=23
		
		System.out.println("Arrays 1 after updating :"+Arrays.toString(arr1));	// this will print array 
		
		System.out.println("Arrays 1 before updating :"+Arrays.toString(arr1));	// this will print array 
		
//		printing entire array :
		for(int i =0;i<arr1.length;i++) {
			System.out.print(arr1[i]);
		}
		
		
//		in java we can change array using methods because when we pass a value to the method it create copy of that object 
//		when we print array it gives us random address in  memory so when we pass it in function it passed as copy of that address from memory and that why we can upadte it 
//		unlike variables 
		changeArray(arr1);
		
		System.out.println("Arrays 1 after updating :"+Arrays.toString(arr1));	// this will print array 
		
//		multi dimentional array :
//		we can make an array more then 1 dimentional in simple way we can say its an array where 
//		each index of array is also an array 
		int [][] twoDarr1= new int [2][3];// this will create a new 2 d array where we can acces element using r and cols we need to mention the dimention of that array 
// above array is 2 rows and 3 ccols : where each row index is an individual array :
		System.out.println("row 1 :"+twoDarr1[0]);// see this will give address of array present at that index 
		System.out.println("row 2 :"+twoDarr1[1]);// see this will give address of array present at that index

//		now we can access element using both r , c index :
		System.out.println("2D array :"+twoDarr1[1][2]);// this will give zero because we does nto initialize the indexes 
	
		
		int [][] twoDarr2= {					
							{1,3,5},
							{2,5,7},
							{2,7,9}
							}; // 3x3 array 
		
//		printing array :
		System.out.println("printing 2D array ");
		for(int i =0;i<twoDarr2.length;i++) {
			for(int j =0;j<twoDarr2[i].length;j++) {
				System.out.print(twoDarr2[i][j]+"\t");
			}
			
			System.out.println();
		}
		
//		in java we cannot change the size of array again once it is created we cannot change its size
//		arr2= new int[4];// this will create a new array and arr2 will point to it 
		
//		to solve the problem of resizable array we can use arraylist in java :
		ArrayList<Integer> arr= new ArrayList();
		System.out.println("initial :"+arr);
		arr.add(23);
		arr.add(3);
		arr.add(23);
		arr.add(2555);
		System.out.println("after update"+arr);
		
//		we can remove element from array list also :
		arr.remove(2);// this take an index:
		System.out.println(arr);
//		 to get size here we using .size method not length
		System.out.println(arr.size());
		
//		we can access element in array list using get method :
		System.out.println(arr.get(2));

//		we can access change element in array list using set method which take integer index,value method :
		System.out.println(arr.set(2,23));
		
		System.out.println(arr);
		
	}
}
