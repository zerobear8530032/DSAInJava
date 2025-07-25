//Gas Station
//Difficulty: MediumAccuracy: 34.79%Submissions: 204K+Points: 4Average Time: 20m
//There are some gas stations along a circular route. You are given two integer arrays gas[] denoted as the amount of gas present at each station and cost[] denoted as the cost of travelling to the next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank from one of the gas stations. Return the index of the starting gas station if it's possible to travel around the circuit without running out of gas at any station in a clockwise direction. If there is no such starting station exists, return -1.
//Note: If a solution exists, it is guaranteed to be unique.
//
//Examples:
//
//Input: gas[] = [4, 5, 7, 4], cost[]= [6, 6, 3, 5]
//Output: 2
//Explanation: It is possible to travel around the circuit from station at index 2. Amount of gas at station 2 is (0 + 7) = 7.
//Travel to station 3. Available gas = (7 – 3 + 4) = 8.
//Travel to station 0. Available gas = (8 – 5 + 4) = 7.
//Travel to station 1. Available gas = (7 – 6 + 5) = 6.
//Return to station 2. Available gas = (6 – 6) = 0.
//Input: gas[] = [1, 2, 3, 4, 5], cost[] = [3, 4, 5, 1, 2]
//Output: 3
//Explanation: It is possible to travel around the circuit from station at index 3. Amount of gas at station 3 is (0 + 4) = 4.
//Travel to station 4. Available gas = 4 – 1 + 5 = 8.
//Travel to station 0. Available gas = 8 – 2 + 1 = 7.
//Travel to station 1. Available gas= 7 – 3 + 2 = 6.
//Travel to station 2. Available gas = 6 – 4 + 3 = 5.
//Travel to station 3. The cost is 5. The gas is just enough to travel back to station 3.
//Input: gas[] = [3, 9], cost[] = [7, 6]
//Output: -1
//Explanation: There is no gas station to start with such that you can complete the circuit.
//Constraints:
//1 ≤ gas.size(), cost.size() ≤ 106
//1 ≤ gas[i], cost[i] ≤ 103
//
//Expected Complexities
//Time Complexity: O(n)
//Auxiliary Space: O(1)


package Queue;

public class GasStation_GFG {
// brute force approch :
//	here we can check from current index its possible to reach 
//	next station if it have more gas then cost to reach next gasstation
//	so we can   check at each gas station wheather this condition satisfies or not
//	when that happen we can just try to test to move ahead by maintaing the cost to reach 
//	next station and curr gas 
//	it we reach back where we start we can return start other wise we will check from next stations 
//	and it no found return -1;
//	time complexity :O(n*n)
//	space complexity :O(1)
    public static int startStationBruteForce(int[] gas, int[] cost) {
        // Your code here
        int n = cost.length;
        for(int i =0;i<n;i++){
            if(gas[i]>=cost[i]){
                int currgas = 0;
                int start=i;
                int curr=start;
                for(int j=0;j<n;j++){
                    currgas= currgas+ gas[curr]-cost[curr];
                    if(currgas<0){              
                    	break;
                    }
                    curr=(curr+1)%n;
                }
                if(curr==start){
                    return start;
                }
            }
        }
        return -1;
    }
    
//    here we can say 2 statement 
//    first to reach all station we need to have more gas or equal gas to move to next station
//    and we can go from start to end only if sum of all element pf gas >= sum of all element of cost array
//    then only we can complete a cycle 
//    so we can  maintain a total gas and current gas and a starting pointer
//    we will compute total gas= totalgas+gas[i]-cost[i]
//    we will compute currgas same way 
//    but we will check at each station our curr gas <0 if yes 
//    we will reset it and our new start = i+1; or next station
//   in the end if total gas < 0 we can return -1
//    ther wise we can say the starting index is the station to complete the circle
//    time complexity :O(n)
//    space complexity :O(1)
    public static int startStationBest(int[] gas, int[] cost) {
        // Your code here
        int start=0;
        int currgas=0;
        int totalgas=0;
        for(int i =0;i<cost.length;i++){
            currgas=currgas+gas[i]-cost[i];
            totalgas=totalgas+gas[i]-cost[i];
            if(currgas<0){
                currgas=0;
                start=i+1;
            }
        }
        if(totalgas<0){
            return -1;
        }
        return start;
        
    }
	public static void main(String[] args) {
		
		//Examples 1:
		
		int [] gas1 = {4, 5, 7, 4}, cost1= {6, 6, 3, 5};
		int output1=2;
		
		//Examples 2:
		
		int [] gas2 = {1, 2, 3, 4,5}, cost2= {3, 4, 5,1,2};
		int output2=3;
		
		//Examples 3:
		
		int [] gas3 = {0,3,6,2,1}, cost3= {1,2,5, 4,5};
		int output3=-1;
		
		System.out.println("Brute Force Approch :");
		
		int ans1= startStationBruteForce(gas1,cost1);		
		int ans2= startStationBruteForce(gas2,cost2);		
		int ans3= startStationBruteForce(gas3,cost3);		
		
		if(ans1==(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Better Approch :");
		
		ans1= startStationBest(gas1,cost1);		
		ans2= startStationBest(gas2,cost2);		
		ans3= startStationBest(gas3,cost3);		
		
		if(ans1==(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
	}

}
