//881. Boats to Save People
//Medium
//Topics
//Companies
//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
//
// 
//
//Example 1:
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//Example 2:
//
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
//Example 3:
//
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
// 
//
//Constraints:
//
//1 <= people.length <= 5 * 104
//1 <= people[i] <= limit <= 3 * 104
//package TwoPointers;
package TwoPointers;

import java.util.Arrays;

public class BoatsToSavePeople_881 {

//	brute force approch :
//	we will check from 0 and iterate till end
//	with a nested loop we willl find the max weight from i+1 till length
//	then we check the that peorson at i and person at max weight are in limit 
//	if yes we mark both as send other wise we will just 
//	sennd person with higher weight
//	time complexity :O(n*n)
//	space complexity :O(n)
	
	public static int numRescueBoatsBruteForce(int[] people, int limit) {
		int n= people.length;
		int boats=0;
		boolean [] map = new boolean[n];
		int i =0;
		while(i<n) {
			if(map[i]) {
				i++ ;
				continue;
			}
		
			int index=0;
			int maxWeight=0;
			int j=i+1;
			for( ;j<n;j++) {
				if(map[j]) continue;
				if(maxWeight<people[j]) {
					index=j;
					maxWeight=people[j];
				}
			}
			if(people[i]+people[index] <= limit) {
				map[i]=true;
				map[index]=true;
				boats++;
			}else {
				if(people[i]<people[index]) {
					map[index]=true;
				}else {
					map[i]=true;
				}
				
				boats++;
			}
		}
		return boats;
        
    }
	
	
//	Better approch :
//	if we sort the array we can use a 2 pointer where we can compare 
//	both lowest and largest weight and pair them in O(n) time
//	one pointer will be at start 0 and one at end length-1
//	we will check if the combine weight of passanger is under limit 
//	we will increment i and decrement e by 1  which means both are saved
//	but if it exceed limit we will decrement e as only heigher weights can go
//	at the end both pointer will get cross we will get the boats 
//	required by increment boat at each time we save poeple
//	there is no edge case cause there are no people which exceed boat limits
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static int numRescueBoatsBetter(int[] people, int limit) {
		int boats=0;
		int s=0;
		int e=people.length-1;
		Arrays.sort(people);
		while(s<=e) {
			int totalweight= people[s]+people[e];
			if(totalweight<=limit) {
				s++;
				e--;
				boats++;
			}else{
				e--;
				boats++;
			}
		}
		return boats;
        
    }

	public static void main(String[] args) {
		
		
		
		//Example 1:

		int []people1 = {1,2};
		int limit1 = 3;
		int output1=1;

		//Example 2:

		int []people2 = {3,2,2,1};
		int limit2 = 3;
		int output2=3;

		//Example 3:

		int []people3 = {3,5,3,4};
		int limit3 = 5;
		int output3=4;
		
		
		System.out.println("Brute force Approch :");
		
		int ans1=numRescueBoatsBruteForce(people1,limit1);
		int ans2=numRescueBoatsBruteForce(people2,limit2);
		int ans3=numRescueBoatsBruteForce(people3,limit3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		System.out.println("Better Approch :");
		
		ans1=numRescueBoatsBetter(people1,limit1);
		ans2=numRescueBoatsBetter(people2,limit2);
		ans3=numRescueBoatsBetter(people3,limit3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}



	}

}
