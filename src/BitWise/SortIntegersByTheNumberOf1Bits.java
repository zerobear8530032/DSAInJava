//1356. Sort Integers by The Number of 1 Bits
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
//
//Return the array after sorting it.
//
// 
//
//Example 1:
//
//Input: arr = [0,1,2,3,4,5,6,7,8]
//Output: [0,1,2,4,8,3,5,6,7]
//Explantion: [0] is the only integer with 0 bits.
//[1,2,4,8] all have 1 bit.
//[3,5,6] have 2 bits.
//[7] has 3 bits.
//The sorted array by bits is [0,1,2,4,8,3,5,6,7]
//Example 2:
//
//Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
//Output: [1,2,4,8,16,32,64,128,256,512,1024]
//Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
// 
//
//Constraints:
//
//1 <= arr.length <= 500
//0 <= arr[i] <= 104

package BitWise;

import java.util.Arrays;

class SortIntegersByTheNumberOf1Bits {
    
	
//	using brute force approch :
//	sort the array according using insertion sort on the basic of bits 
//	but we need to check 2 condition if current number bits and next number bits is smaller swap
//	if both are equal we can only swap if the current number is smaller the n next
//	time complexity :O(n*n)
//	space complexity :O(1)
	public  static int[] sortByBitsBruteForce(int[] arr) {
        // better approch :
        sortArray(arr);
        return arr;
    }
    
    public static void sortArray(int [] arr){
        int n = arr.length;
        for(int i =0;i<n-1;i++){
            for(int j= i+1;j>0;j--){
                if(Integer.bitCount(arr[j])<Integer.bitCount(arr[j-1])){
                    int t = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1]=t;
                }else if(Integer.bitCount(arr[j])==Integer.bitCount(arr[j-1])){
                    if(arr[j]<arr[j-1]){
                        int t= arr[j];
                        arr[j]=arr[j-1];
                        arr[j-1]=t;
                    }
                }
            }
        }
    }
    
//	using better approch:
//  we can sort the array in less time using the inbuidl sorting
//Algorithm:
// For eg: just take a arra like [0,1,2,3,4,5,6,7,8]
// step 1: After the first for loop...
// it will look like [0,10001,10003,20004,10005,20006,20007,30008,10009] (don't forget to add the number also)
// Step 2:sort the array...
// It, will look like [0,10001,10003,10005,10009,20004,20006,20007,30008]
//	time complexity :O(n log n )
//	space complexity :O(1)
    public  static int[] sortByBitsBetter(int[] arr) {
    	int MAX_VALUE = 10001;
    	for(int i =0;i<arr.length;i++) {
    		arr[i]+= Integer.bitCount(arr[i])*MAX_VALUE;
    	}
    	Arrays.sort(arr);
    	for(int i =0;i<arr.length;i++) {
    		arr[i]= arr[i]%MAX_VALUE;
    	}
    	
    	return arr;
    }
    
    
    public static boolean check(int [] arr1, int [] arr2) {
		if(arr1.length!=arr2.length) {
			return false;
		}
		for(int i =0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
	
		
		return true;
	}
    
    public static void main(String[] args) {
    	//Example 1:

    	int []arr1 = {0,1,2,3,4,5,6,7,8};
    	int []output1= {0,1,2,4,8,3,5,6,7};
    	
    	//Example 2:

    	int []arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
    	int []output2= {1,2,4,8,16,32,64,128,256,512,1024};
    	
    	System.out.println("Brute Force Approch :");
    	
		int ans1[]=sortByBitsBruteForce(arr1.clone());
		int ans2[]=sortByBitsBruteForce(arr2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}	
		
		System.out.println("Brute Force Approch :");
		
    	
		 ans1=sortByBitsBetter(arr1.clone());
		 ans2=sortByBitsBetter(arr2.clone());
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}	
		

	}
}