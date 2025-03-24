//3169. Count Days Without Meetings
//Attempted
//Medium
//Topics
//Companies
//Hint
//You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
//
//Return the count of days when the employee is available for work but no meetings are scheduled.
//
//Note: The meetings may overlap.
//
// 
//
//Example 1:
//
//Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
//
//Output: 2
//
//Explanation:
//
//There is no meeting scheduled on the 4th and 8th days.
//
//Example 2:
//
//Input: days = 5, meetings = [[2,4],[1,3]]
//
//Output: 1
//
//Explanation:
//
//There is no meeting scheduled on the 5th day.
//
//Example 3:
//
//Input: days = 6, meetings = [[1,6]]
//
//Output: 0
//
//Explanation:
//
//Meetings are scheduled for all working days.
//
// 
//
//Constraints:
//
//1 <= days <= 109
//1 <= meetings.length <= 105
//meetings[i].length == 2
//1 <= meetings[i][0] <= meetings[i][1] <= days

package Arrays;

import java.util.Arrays;

class Solution {
//	brute force approch :
//	create a map array of length days+1 and for every
//	meeting i increment map array index form start till end of metting days
//	at last count number of indexes which are 0 in map
//	edge case if you take length of map array  n+1
//	ans = c-1
//	if length is days ans = count
//	every meeting [i] 
//	time complexity :O(n*m): n = length of meetings, m : days btw start & end 
//	space complexity :O(days)
    public static int countDaysBruteForce(int days, int[][] meetings) {
     int  [] map = new int[days];
     for(int i =0;i<meetings.length;i++){
        int start= meetings[i][0]-1;
        int end= meetings[i][1]-1;
        for(int j=start;j<=end;j++){
            map[j]++;
        }
    }
    int c=0;
    for(int x:map){
        if(x==0)c++;
    } 
    // here we takke c-1 because the map is having n+1 numbers
    return c;
    }
    
//	Better force approch :
//    will do it in future
    
    public static void main(String[] args) {
    	//Example 1:

    	int days1 = 10;
    	int [][] meetings1 = {{5,7},{1,3},{9,10}};
    	int output1=2;
    	

    	//Example 2:
    	
    	int days2 = 5;
    	int [][] meetings2 = {{2,4},{1,3}};
    	int output2=1;
    	


    	//Example 3:

    	int days3 = 6;
    	int [][] meetings3 = {{1,6}};
    	int output3=0;
    
    	System.out.println("Brute Force Approch :");
    	
    	int ans1=countDaysBruteForce(days1,meetings1);
    	int ans2=countDaysBruteForce(days2,meetings2);
    	int ans3=countDaysBruteForce(days3,meetings3);

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
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Better Approch :");
		
		ans1=countDaysBetter(days1,meetings1);
		ans2=countDaysBetter(days2,meetings2);
		ans3=countDaysBetter(days3,meetings3);
		
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
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
    	
	}
}