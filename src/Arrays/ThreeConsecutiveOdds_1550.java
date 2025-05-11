//1550. Three Consecutive Odds
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
// 
//
//Example 1:
//
//Input: arr = [2,6,4,1]
//Output: false
//Explanation: There are no three consecutive odds.
//Example 2:
//
//Input: arr = [1,2,34,3,4,5,7,23,12]
//Output: true
//Explanation: [5,7,23] are three consecutive odds.
// 
//
//Constraints:
//
//1 <= arr.length <= 1000
//1 <= arr[i] <= 1000
package Arrays;

public class ThreeConsecutiveOdds_1550 {
	
	    public static boolean threeConsecutiveOdds(int[] arr) {
	    int n = arr.length;
	    for(int i =0;i<n-2;i++){
	        if(arr[i]%2!=0 && arr[i+1]%2!=0 && arr[i+2]%2!=0){
	            return true;
	        }
	    }
	            return false;
	    }
	

	public static void main(String[] args) {
		
		//Example 1:

		int [] arr1 = {2,6,4,1};
		boolean output1=false;

		//Example 2:

		int []arr2 = {1,2,34,3,4,5,7,23,12};
		boolean output2=true;
		

		boolean ans1 = threeConsecutiveOdds(arr1);
		boolean ans2 = threeConsecutiveOdds(arr2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}




	}

}
