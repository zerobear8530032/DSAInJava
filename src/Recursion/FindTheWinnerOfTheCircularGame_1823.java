//1823. Find the Winner of the Circular Game
//Solved
//Medium
//Topics
//Companies
//Hint
//There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
//
//The rules of the game are as follows:
//
//Start at the 1st friend.
//Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
//The last friend you counted leaves the circle and loses the game.
//If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
//Else, the last friend in the circle wins the game.
//Given the number of friends, n, and an integer k, return the winner of the game.
//
// 
//
//Example 1:
//
//
//Input: n = 5, k = 2
//Output: 3
//Explanation: Here are the steps of the game:
//1) Start at friend 1.
//2) Count 2 friends clockwise, which are friends 1 and 2.
//3) Friend 2 leaves the circle. Next start is friend 3.
//4) Count 2 friends clockwise, which are friends 3 and 4.
//5) Friend 4 leaves the circle. Next start is friend 5.
//6) Count 2 friends clockwise, which are friends 5 and 1.
//7) Friend 1 leaves the circle. Next start is friend 3.
//8) Count 2 friends clockwise, which are friends 3 and 5.
//9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
//Example 2:
//
//Input: n = 6, k = 5
//Output: 1
//Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
// 
//
//Constraints:
//
//1 <= k <= n <= 500
// 
//
//Follow up:
//
//Could you solve this problem in linear time with constant space?



package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame_1823 {

	
//	brute force recursive approch:
// here we can uses the ciruclar traversal using (idx +(k-1) )%size array
//	here the k-1 is used because we are dealing with index starting from 0
//	to find the next kth person to remove
//	and use this recursively untill only a single person left 
//	adn return its index
//  time complexity :O(n)
//  space complexity :O(n)
	public static int findTheWinner(int n, int k) {
	        List<Integer> person = new ArrayList();
	        for(int i =1;i<=n;i++){
	            person.add(i);
	        }
	        return helper(person,0,k,person.size());
	    }

	    public static int helper(List<Integer> person,int start,int k, int s){
	        if(s==1){
	            return person.get(0);
	        }
	        int remove = (start+k-1)%s;
	        person.remove(remove);
	        return helper(person, remove,k,person.size());
	    }

	
	public static void main(String[] args) {
		
		
		//Example 1:

		int n1 = 5, k1 = 2, output1=3;

		//Example 2:

		int n2 = 6, k2 = 5, output2=1;
		
		System.out.println("Recursion Approch :");
		
		int ans1=findTheWinner(n1,k1);
		int ans2=findTheWinner(n2,k2);
		
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
