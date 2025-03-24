//1486. XOR Operation in an Array
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an integer n and an integer start.
//
//Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
//
//Return the bitwise XOR of all elements of nums.
//
// 
//
//Example 1:
//
//Input: n = 5, start = 0
//Output: 8
//Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
//Where "^" corresponds to bitwise XOR operator.
//Example 2:
//
//Input: n = 4, start = 3
//Output: 8
//Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
// 
//
//Constraints:
//
//1 <= n <= 1000
//0 <= start <= 1000
//n == nums.length

package Arrays;
class XOROperationInAnArray_1486 {
//	brute force :
//	simiulate what said create an array 
//	iterate over array and set each element as start+ 2*i
//	ans take xor of it
//	time complexity :O(n)
//	space complexity : O(n)
    public static int xorOperationBruteForce(int n, int start) {
        int []arr= new int [n];
        for(int i =0;i<n;i++){
            int eq= start+(2*i);
            arr[i]=eq;
        }
        int xor=0;
        for(int x:arr){
            xor^=x;
        }
        return xor;
    }
    
//    Better approch :
//	we can just go on with eqation without array as last number output only matters    
//	time complexity :O(n)
//	space complexity : O(1)
    private static int xorOperationBest(int n, int start) {
    	int ans =0;
    	for(int i =0;i<n;i++) {
    		int eq=start+(2*i);
    		ans^=eq;
    	}
		return ans;
	}
    public static void main(String[] args) {
    	//Example 1:

    	int n1 = 5, start1 = 0;
    	int output1=8;

    	//Example 2:

    	int n2 = 4, start2 = 3;
    	int output2=8;
    	
    	
    	int ans1=xorOperationBruteForce(n1,start1);
    	int ans2=xorOperationBruteForce(n2,start2);

    	if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		System.out.println("Better Approch :");
		
		ans1=xorOperationBest(n1,start1);
		ans2=xorOperationBest(n2,start2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}

	}
	
}