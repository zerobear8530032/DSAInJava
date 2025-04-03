//1835. Find XOR Sum of All Pairs Bitwise AND
//Attempted
//Hard
//Topics
//Companies
//Hint
//The XOR sum of a list is the bitwise XOR of all its elements. If the list only contains one element, then its XOR sum will be equal to this element.
//
//For example, the XOR sum of [1,2,3,4] is equal to 1 XOR 2 XOR 3 XOR 4 = 4, and the XOR sum of [3] is equal to 3.
//You are given two 0-indexed arrays arr1 and arr2 that consist only of non-negative integers.
//
//Consider the list containing the result of arr1[i] AND arr2[j] (bitwise AND) for every (i, j) pair where 0 <= i < arr1.length and 0 <= j < arr2.length.
//
//Return the XOR sum of the aforementioned list.
//
// 
//
//Example 1:
//
//Input: arr1 = [1,2,3], arr2 = [6,5]
//Output: 0
//Explanation: The list = [1 AND 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1].
//The XOR sum = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0.
//Example 2:
//
//Input: arr1 = [12], arr2 = [4]
//Output: 4
//Explanation: The list = [12 AND 4] = [4]. The XOR sum = 4.
// 
//
//Constraints:
//
//1 <= arr1.length, arr2.length <= 105
//0 <= arr1[i], arr2[j] <= 109

package BitWise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FindXORSumOfAllPairsBitwiseAND_1835 {
//	brute Force Approch:
//	do what asked and the 2 array and find the XOR of it 
//	time compelxity :O(n*m)
//	space complexity : O(1)
//	this approch wont get accepted in this constrain
    public static int getXORSumBruteForce(int[] arr1, int[] arr2) {
        int ans=0;
        List<Integer> list= new ArrayList<Integer>();
        for(int  i =0;i<arr1.length;i++){
            for(int j =0;j<arr2.length;j++){
            	list.add(arr1[i]&arr2[j]);
               ans^=(arr1[i] & arr2[j]);
            }
        }
        
        System.out.println(list);
        
               
        return ans;
    }
    

    public static void main(String[] args) {
    	
    	//Example 1:

    	int []arr11 = {1,2,3}, arr12 = {6,5};
    	int output1=0;

    	//Example 2:

    	int []arr21 = {12}, arr22 = {4};
    	int output2=4;
    	
    	System.out.println("Brute Force Approch :");
    	
    	int ans1= getXORSumBruteForce(arr11,arr12);
    	int ans2= getXORSumBruteForce(arr21,arr22);
    	
     	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}




		
	}
}