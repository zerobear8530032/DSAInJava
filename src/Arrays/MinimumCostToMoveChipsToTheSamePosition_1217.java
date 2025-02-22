//1217. Minimum Cost to Move Chips to The Same Position
//Solved
//Easy
//Topics
//Companies
//Hint
//We have n chips, where the position of the ith chip is position[i].
//
//We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
//
//position[i] + 2 or position[i] - 2 with cost = 0.
//position[i] + 1 or position[i] - 1 with cost = 1.
//Return the minimum cost needed to move all the chips to the same position.
//
// 
//
//Example 1:
//
//
//Input: position = [1,2,3]
//Output: 1
//Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
//Second step: Move the chip at position 2 to position 1 with cost = 1.
//Total cost is 1.
//Example 2:
//
//
//Input: position = [2,2,2,3,3]
//Output: 2
//Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
//Example 3:
//
//Input: position = [1,1000000000]
//Output: 1
// 
//
//Constraints:
//
//1 <= position.length <= 100
//1 <= position[i] <= 10^9

package Arrays;
class MinimumCostToMoveChipsToTheSamePosition_1217 {
//	You might initially think we need to try all possibilities, possibly using dynamic programming. But the question is an "easy" for a reason.
//The key observation here is that it's free to move a chip from an even number to another even number, and it is free to move a chip from an odd number to another odd number. It only costs to move an even to an odd, or an odd to an even. Therefore, we want to minimise such moves.
//All chips must be on the same position once we're done, which is either even or odd. Therefore, we want to calculate whether it is cheaper to move all the odd chips to even or all the even chips to odd. This will simply come down to how many even chips we start with, and how many odd chips. Each chip that has to be moved will cost exactly 1.
//To determine the cost, we need to count how many are even, and how many are odd, and then take the minimum of these two values.
//	Time complexity :O(n)
//	Space complexity :O(1)
	
    public static int minCostToMoveChips(int[] position) {
        int even=0;
        int odd =0;
        for(int i =0;i<position.length;i++){
            if(position[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(even,odd);
    }
    
    public static void main(String[] args) {
    	//Example 1:

    	int []position1 = {1,2,3};
    	int output1=1;

    	//Example 2:

    	int []position2 = {2,2,2,3,3};
    	int output2=2;

    	//Example 3:
    	//

    	int []position3 = {1,1000000000};
    	int output3=1;
    	
    	int ans1=minCostToMoveChips(position1);   
    	int ans2=minCostToMoveChips(position2);   
    	int ans3=minCostToMoveChips(position3);   
    	
    	
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
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}


	}
}