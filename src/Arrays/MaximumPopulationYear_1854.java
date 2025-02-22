//1854. Maximum Population Year
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
//
//The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
//
//Return the earliest year with the maximum population.
//
// 
//
//Example 1:
//
//Input: logs = [[1993,1999],[2000,2010]]
//Output: 1993
//Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
//Example 2:
//
//Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
//Output: 1960
//Explanation: 
//The maximum population is 2, and it had happened in years 1960 and 1970.
//The earlier year between them is 1960.
// 
//
//Constraints:
//
//1 <= logs.length <= 100
//1950 <= birthi < deathi <= 2050



package Arrays;


class MaximumPopulationYear_1854 {

	
	
//	Brute Force Approch :
//	here we allocate the max array of same size of max year that can be the death year +1
//	this will allow us to map logs[death]-1 and logs[birth] as index in the new array 
//	now we just take a prefix sum to calcualte how many max people were alive each year 
//	once we calculate prefix sum we can find max of that 
//	with max we can search through array and find what was thefirst year in where population was 
//	equal to max and return the index as we map it accordingly
//	Time complexity : O(n)
//	Time complexity : O(1)-> no extra space other then calamder which is constant 
	public static int maximumPopulationOptimizeApproch(int[][] logs) {
		int [] calander = new int [2051];// this is the mapping array called calander
		
		for(int i =0;i<logs.length;i++){// here we map each birth and death
			calander[logs[i][0]]++;// logs[birth] is same because the time of birth year is count in populatin
			calander[logs[i][1]]--;//logs[death]-1 is not used because the index start from 0
		}
		int sum=0;// prefix sum
		for(int i =0;i<calander.length;i++){
			sum+=calander[i];// calcualte prefix sum
			calander[i]=sum;
		}
		int max =0;// find max of the prefix sum
		for(int i =0;i<calander.length;i++){
			max=Math.max(max,calander[i]);/// get max
		}
		for(int i =0;i<calander.length;i++){// now find first occurence of the max 
			if(max==calander[i]){
				return i;// return year 
			}
		}
		return -1;
	}
//	Optimize Approch :
//	the approch is same as it was just the calander size is reduce to map every thing 
//	we can say 2050-1950+1 is the total year we need according to constrain rest of the index 
//	would not be used in our previous answer so we used that only
    public static int maximumPopulationBruteForce(int[][] logs) {
        int [] calander = new int [2050-1950+1];//this can be written as 101 also but its for description
        for(int i =0;i<logs.length;i++){
            calander[logs[i][0]-1950]++;// here the birth index is map by substracting with 1950 which is lower bound in constrain 
            calander[logs[i][1]-1950]--;// here we similarly map death year
        }
        int sum=0;// calculating the prefix sum
        for(int i =0;i<calander.length;i++){
            sum+=calander[i];
            calander[i]=sum;
        }
        int max =0;// findind max population
         for(int i =0;i<calander.length;i++){
            max=Math.max(max,calander[i]);
         }
         
//         finding first max popolation occurence
         for(int i =0;i<calander.length;i++){
            if(max==calander[i]){
                return 1950+i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int [] []logs1 = {{1993,1999},{2000,2010}};
    	int output1=1993;
    	
    	//Example 2:
    	//
    	int [][]logs2 = {{1950,1961},{1960,1971},{1970,1981}};
    	int output2= 1960;
    	
    	
    	
    	int ans1 = maximumPopulationBruteForce(logs1);
		int ans2 = maximumPopulationBruteForce(logs2);
		
    	System.out.println("Brute Force Approch :");
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
	
		
		System.out.println("Optimize Approch :");
		
		ans1 = maximumPopulationOptimizeApproch(logs1);
		ans2 = maximumPopulationOptimizeApproch(logs2);
		
		
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