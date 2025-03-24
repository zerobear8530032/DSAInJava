//1720. Decode XORed Array
//Solved
//Easy
//Topics
//Companies
//Hint
//There is a hidden integer array arr that consists of n non-negative integers.
//
//It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
//
//You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
//
//Return the original array arr. It can be proved that the answer exists and is unique.
//
// 
//
//Example 1:
//
//Input: encoded = [1,2,3], first = 1
//Output: [1,0,2,1]
//Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
//Example 2:
//
//Input: encoded = [6,2,7,3], first = 4
//Output: [4,2,0,7,4]
// 
//
//Constraints:
//
//2 <= n <= 104
//encoded.length == n - 1
//0 <= encoded[i] <= 105
//0 <= first <= 105



package BitWise;

import java.util.Arrays;

class DecodeXORedArray_1720 {
// approch 
// we can make observation that first element is just first number
//	and if we just xor first element with input [0]  we will get decoded 
//	number and new decoded nnumber can be xor with next encoded number and soon
//	time complexity : O(n)
//	space complexity : O(1)
	public static int[] decode(int[] encoded, int first) {
        int ans []= new int [encoded.length+1];
        int ansidx=0;
        ans[ansidx]= first;
        ansidx++;
        for(int i =0;i<encoded.length;i++){
            ans[ansidx]= ans[i]^encoded[i];
            ansidx++;
        }
        return ans;

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

    	int [] encoded1 = {1,2,3};
    	int first1 = 1;
    	int [] output1= {1,0,2,1};
    	
    	//Output: [1,0,2,1]
    	//Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
    	//Example 2:

    	int [] encoded2 = {6,2,7,3};
    	int first2 = 4;
    	int [] output2= {4,2,0,7,4};
    	
    	
		int []ans1 = decode(encoded1, first1);
		int []ans2 = decode(encoded2, first2);
		
		
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