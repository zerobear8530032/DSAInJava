//1534. Count Good Triplets
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
//
//A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
//
//0 <= i < j < k < arr.length
//|arr[i] - arr[j]| <= a
//|arr[j] - arr[k]| <= b
//|arr[i] - arr[k]| <= c
//Where |x| denotes the absolute value of x.
//
//Return the number of good triplets.
//
// 
//
//Example 1:
//
//Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
//Output: 4
//Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
//Example 2:
//
//Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
//Output: 0
//Explanation: No triplet satisfies all conditions.
// 
//
//Constraints:
//
//3 <= arr.length <= 100
//0 <= arr[i] <= 1000
//0 <= a, b, c <= 1000

package Arrays;

public class CountGoodTriplets_1534 {
	
//	brute froce approch :
//	here we check every single triplets to found whichof them are 
//	satisfying conditions
//	time complexity :O(n^3)
//	space complexity :O(1)
	public static int countGoodTripletsBruteForce(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int triplets=0;
        for(int i =0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int valA=Math.abs(arr[i]-arr[j]);
                    int valB=Math.abs(arr[j]-arr[k]);
                    int valC=Math.abs(arr[i]-arr[k]);
                    if(valA<=a && valB<=b && valC<=c){
                        triplets++;
                    }
                }
            }
        }
        return triplets;
    }
	
//	Better Approch :
//	we can optimize the approch 
//	by stopping iteration earlier when the  condition does not satisfy
//	this will not change time complexity but it will skip the iterations 
//	time complexity :O(n^3)
//	space complexity :O(1)
//	satisfying conditions
	public static int countGoodTripletsBetter(int[] arr, int a, int b, int c) {
		int n = arr.length;
		int triplets=0;
		for(int i =0;i<n-2;i++){
			for(int j=i+1;j<n-1;j++){
				for(int k=j+1;k<n;k++){
					int valA=Math.abs(arr[i]-arr[j]);
					int valB=Math.abs(arr[j]-arr[k]);
					int valC=Math.abs(arr[i]-arr[k]);
					if(valA<=a && valB<=b && valC<=c){
						triplets++;
					}
				}
			}
		}
		return triplets;
	}


	public static void main(String[] args) {
		
		
		//Example 1:
		
		int [] arr1 = {3,0,1,1,9,7};
		int a1 = 7, b1 = 2, c1 = 3;
		int output1=4;

		//Example 2:

		int [] arr2 = {1,1,2,2,3};
		int a2 = 0, b2 = 0, c2 = 1;
		int output2=0;
		
		
		System.out.println("Brute Force Approch :");
		
		int ans1=countGoodTripletsBruteForce(arr1, a1, b1, c1);
		int ans2=countGoodTripletsBruteForce(arr2, a2, b2, c2);
    	
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		
		
		
		System.out.println("Better Approch :");
		
		ans1=countGoodTripletsBetter(arr1, a1, b1, c1);
		ans2=countGoodTripletsBetter(arr2, a2, b2, c2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		
		


	}

}
