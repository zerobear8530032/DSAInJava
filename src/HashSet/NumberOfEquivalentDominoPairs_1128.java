//1128. Number of Equivalent Domino Pairs
//Attempted
//Easy
//Topics
//Companies
//Hint
//Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
//
//Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
//
// 
//
//Example 1:
//
//Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
//Output: 1
//Example 2:
//
//Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
//Output: 3
// 
//
//Constraints:
//
//1 <= dominoes.length <= 4 * 104
//dominoes[i].length == 2
//1 <= dominoes[i][j] <= 9


package HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumberOfEquivalentDominoPairs_1128 {
//	Brute Force :
//	check every single pair
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static int numEquivDominoPairsBruteForce(int[][] dominoes) {
	        int count=0;
	        for(int i =0;i<dominoes.length;i++){
	            for(int j=i+1;j<dominoes.length;j++){
	                if(dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1] || dominoes[i][1]==dominoes[j][0] && dominoes[i][0]==dominoes[j][1] ){
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
//	Better Force :
//	sort each pair and combine both value by index 0 *10+index 1 
//	this will create a number btw 0 to 100
//	cause of contrains
//	then just add each pair in  hashMap and make a frequency map
//	lastly we can use formula nCr: frequencyC2 fromula will give  number of pairs
//	if yes increment counter other wise continue
//	time complexity :O(n)
//	space complexity :O(n)
	public static int numEquivDominoPairsBetter(int[][] dominoes) {
		        HashMap<Integer,Integer> map= new HashMap();
		        int count=0;
		        for(int [] nums:dominoes){
		            if(nums[0]>nums[1]){swap(nums);}
		            int x=nums[0]*10+nums[1];
		            if(map.containsKey(x)){
		                map.put(x,map.get(x)+1);
		            }else{
		                map.put(x,1);
		            }
		        }
		        for(Map.Entry<Integer,Integer> e:map.entrySet()){
		            int val=e.getValue();
		            int pairs= val*(val-1)/2;
		            count+=pairs;
		        }
		        return count;
		    }
		    public static void swap(int [] nums){
		        int t=nums[0];
		        nums[0]=nums[1];
		        nums[1]=t;
		    }
		
	

//	Best Force :
//	sort each pair and combine both value by index 0 *10+index 1 
//	this will create a number btw 0 to 100
//	cause of contrains
//	we can make a frequency array which will take less over head
//	lastly we can use formula nCr: frequencyC2 fromula will give  number of pairs
//	if yes increment counter other wise continue
//	time complexity :O(n)
//	space complexity :O(n)
public static int numEquivDominoPairsBest(int[][] dominoes) {
    	int map[]= new int [100];
    	int count=0;
    	for(int [] nums:dominoes){
    		if(nums[0]>nums[1]){swap(nums);}
    		int x=nums[0]*10+nums[1];
    		map[x]++;
    	}
    	for(int x :map){
    		int pairs= x*(x-1)/2;
    		count+=pairs;
    	}
    	return count;
    }
		    
		    
	
	public static void main(String[] args) {
		
		
		//Example 1:

		int [][] dominoes1 = {{1,2},{2,1},{3,4},{5,6}};
		int output1=1;

		//Example 2:

		int [][] dominoes2 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
		int output2=3;

		System.out.println("Brute Force Approch :");

		int ans1=numEquivDominoPairsBruteForce(dominoes1);
		int ans2=numEquivDominoPairsBruteForce(dominoes2);
		
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
		
		System.out.println("Better Approch :");
		
		ans1=numEquivDominoPairsBetter(dominoes1);
		ans2=numEquivDominoPairsBetter(dominoes2);
		
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
		
		System.out.println("Best Approch :");
		
		ans1=numEquivDominoPairsBest(dominoes1);
		ans2=numEquivDominoPairsBest(dominoes2);
		
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

