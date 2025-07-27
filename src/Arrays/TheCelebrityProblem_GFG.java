//The Celebrity Problem
//Difficulty: MediumAccuracy: 38.33%Submissions: 326K+Points: 4Average Time: 30m
//A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] (n*n) is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
//
//Note: Follow 0-based indexing.
//
//Examples:
//
//Input: mat[][] = [[1, 1, 0], [0, 1, 0], [0, 1, 1]]
//Output: 1
//Explanation: 0th and 2nd person both know 1st person. Therefore, 1 is the celebrity person. 
//Input: mat[][] = [[1, 1], [1, 1]]
//Output: -1
//Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.
//Input: mat[][] = [[1]]
//Output: 0
//Constraints:
//1 <= mat.size()<= 1000
//0 <= mat[i][j]<= 1
//mat[i][i] == 1

package Arrays;

import java.util.HashSet;

public class TheCelebrityProblem_GFG {
//	approch :
//	here we go through each person and check how many people they know 
//	if they know more then one 1 person which is them selves means 
//	they are not a celebrity so we can take the person who know know no one 
//  and check does every one knows him if yes return true other wise -1
//	    time complexity :O(n*n)
//	    space complexity :O(1)
	
	    public static int celebrityBruteForce(int mat[][]) {
	    	int celeb=-1;
//	    	check every person number of person they know
	        for(int i=0;i<mat.length;i++){
	            int [] person = mat[i];
	            boolean KnowOthers=false;
	            for(int j=0;j<person.length;j++){
	               if(i!=j  && person[j]==1 ) {
	            	   KnowOthers=true;
	            	   break;
	               }
	            }
	            if(KnowOthers==false){
	                celeb=i;
	                break;
	            }

	        }
//	        if no celeb return false;
	        if(celeb==-1) {
	        	return -1;
	        }
            boolean know=true;
//            if celeb found we can check every one knows him or not
            
            for(int i=0;i<mat.length;i++){
                int [] person = mat[i];
                if(person[celeb]!=1){
                    know=false;
                }
            }
            if(know){
	        return celeb;
                
            }
            return -1;	    
	    }
	   
	    
//	    approch 2 pointers : 
//	    a at 0 and b = mat.length-1
//	    here we check a knows b  if yes then a is not a celeb do a++
//	    if a does not know b then b is not a celeb do b--
//	    we can repeat until a<b
//	    at the end a ==b 
//	    and last person reamin can be celeb 
//	    we can check it by going at each person and check they know him or not 
//	    time complexity :O(n)
//	    space complexity :O(1)
	    public static int celebrityBest(int mat[][]) {
	        // code here
	        int a = 0;
	        int b = mat.length-1;
	        int celeb=-1;
	        while(a<b){
	            // if a  know b means a is not a celeb
	            if(mat[a][b]==1){
	                a++;
	                // if a does not know b then b is not a celeb
	            }else {
	                b--;
	            }
	        }
	          // Step 2: Verify candidate
	        for (int i = 0; i < mat.length; i++) {
	            if (i == a) continue;
	            
	            // Check both conditions
	            if (mat[a][i] == 1 || mat[i][a] == 0) {
	                return -1;
	            }
	        }

	        return a;
	    }

	

	public static void main(String[] args) {
		
		//Examples 1:

		int [][] mat1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
		int output1=1;
		
		//Examples 2:
		
		int [][] mat2 = {{1, 1}, { 1, 1}};
		int output2=-1;

		//Examples 3:

		int [][] mat3 = {{1}};
		int output3=0;
		
		System.out.println("Brute Force Approch :");
		
		int ans1=celebrityBruteForce(mat1);
		int ans2=celebrityBruteForce(mat2);
		int ans3=celebrityBruteForce(mat3);
		
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
		
		ans1=celebrityBest(mat1);
		ans2=celebrityBest(mat2);
		ans3=celebrityBest(mat3);
		
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
