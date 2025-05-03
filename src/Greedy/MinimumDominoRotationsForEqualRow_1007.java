//1007. Minimum Domino Rotations For Equal Row
//Solved
//Medium
//Topics
//Companies
//In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
//
//We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
//
//Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
//
//If it cannot be done, return -1.
//
// 
//
//Example 1:
//
//
//Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
//Output: 2
//Explanation: 
//The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
//If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
//Example 2:
//
//Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
//Output: -1
//Explanation: 
//In this case, it is not possible to rotate the dominoes to make one row of values equal.
// 
//
//Constraints:
//
//2 <= tops.length <= 2 * 104
//bottoms.length == tops.length
//1 <= tops[i], bottoms[i] <= 6

package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow_1007 {
	
//	approch bruteforce ;
//	we can create a hash map of frequency of 
//	each element in the both array 
//	now the only element which can fill the entire row is the one whose
//	frequecy is greater or equal to length of top , bottom array
//	so we can find that element
//	there is a possibility of that element could be multiple
//	so we will find all such elements and
//	and check for each element is it possible to put all element on top 
//	or bottom and count there opertation
//	find the lowest number of operations 
//	time complexity : O(n)
//	time complexity : O(1): because hash map size will not exceed  over 6 
	
	  public static int minDominoRotationsBruteForce(int[] tops, int[] bottoms) {
	        HashMap<Integer,Integer> map = new HashMap();
	        for(int x:tops){
	            if(map.containsKey(x)){
	                map.put(x,map.get(x)+1);
	            }else{
	                map.put(x,1);
	            }
	        }
	        for(int x:bottoms){
	            if(map.containsKey(x)){
	                map.put(x,map.get(x)+1);
	            }else{
	                map.put(x,1);
	            }
	        }
	        int n =tops.length;
	        List<Integer> HFV= new ArrayList<Integer>();
	        for(Map.Entry<Integer,Integer> e:map.entrySet()){
	            if(e.getValue()>=n){
	                HFV.add(e.getKey());
	            }
	        }
	        if(HFV.size()==0){
	            return -1;
	        }
	        int res=Integer.MAX_VALUE;
	        for(int x:HFV){
	            int top=validSequence(tops,bottoms,x);
	            int bottom=validSequence(bottoms,tops,x);
	            if(top!=-1){
	                res=Math.min(res,top);
	            }
	            if(bottom!=-1){
	                res=Math.min(res,bottom);
	            }
	        }
	        if(res==Integer.MAX_VALUE) return -1;
	        return res;
	    }

	    public static int validSequence(int [] tops,int []bottoms, int e){
	        int count=0;
	        for(int i =0;i<tops.length;i++){
	            if( tops[i]!=e && bottoms[i]==e){
	                count++;
	            }
	            if(tops[i]!=e  && bottoms[i]!=e){
	                return -1;
	            }
	        }
	        return count;
	    }
	    
	    
//		approch bruteforce :
//	    the entire approch is same 
//	    but we can optimize space with array to map element then hash map
//	    and the element which will be greater in frequency then length 
//	    can only be at most 2 element so we can remove arraylist also
//		time complexity : O(n)
//		time complexity : O(1): because hash map size will not exceed  over 6 
		
		  public static int minDominoRotationsBetter(int[] tops, int[] bottoms) {
		        int[] map = new int[7];
		        for(int x:tops){
		        	map[x]++;
		        }
		        for(int x:bottoms){
		            	map[x]++;
		        }
		        int n =tops.length;
		        int e1=0;
		        int e2=0;
		        		
		        for(int i=0;i<map.length;i++){
		            if(map[i]>=n){
		                if(e1==0) {
		                	e1=i;
		                }else {
		                	e2=i;
		                }
		            }
		        }
		        if(e1==0 && e2==0){
		            return -1;
		        }
		        int res=Integer.MAX_VALUE;
		        if(e1!=0) {
		        	int top=validSequence(tops,bottoms,e1);
		        	int bottom=validSequence(bottoms,tops,e1);
		        	if(top!=-1){
		        		res=Math.min(res,top);
		        	}
		        	if(bottom!=-1){
		        		res=Math.min(res,bottom);
		        	}		        	
		        }
		        if(e2!=0) {
		        	int top=validSequence(tops,bottoms,e1);
		        	int bottom=validSequence(bottoms,tops,e1);
		        	if(top!=-1){
		        		res=Math.min(res,top);
		        	}
		        	if(bottom!=-1){
		        		res=Math.min(res,bottom);
		        	}		        	
		        }
		        
		        if(res==Integer.MAX_VALUE) return -1;
		        return res;
		    }

	public static void main(String[] args) {
		
		
		//Example 1:

		int [] tops1 = {2,1,2,4,2,2}, bottoms1 = {5,2,6,2,3,2};
		int output1=2;

		//Example 2:

		int [] tops2 = {3,5,1,2,3}, bottoms2 = {3,6,3,3,4};
		int output2= -1;

		System.out.println("Brute Force Approch :");
		
		int ans1=minDominoRotationsBruteForce(tops1,bottoms1);
		int ans2=minDominoRotationsBruteForce(tops2,bottoms2);
		
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
		
		ans1=minDominoRotationsBetter(tops1,bottoms1);
		ans2=minDominoRotationsBetter(tops2,bottoms2);
		
		
		System.out.println("Better Approch :");
		
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
