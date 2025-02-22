//1726. Tuple with Same Product
//Medium
//Topics
//Companies
//Hint
//Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
//
// 
//
//Example 1:
//
//Input: nums = [2,3,4,6]
//Output: 8
//Explanation: There are 8 valid tuples:
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
//Example 2:
//
//Input: nums = [1,2,4,5,10]
//Output: 16
//Explanation: There are 16 valid tuples:
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= nums[i] <= 104
//All elements in nums are distinct.


package Arrays;
import java.util.*;
public class TupleWithSameProduct_1726 {
//	Brute Force :
//	here we check every single pair using 4 pointer for a,b,c,d
//	Time complexity : O(n^4)
//	Space complexity : O(1)
	
//	this will not get accepted in the contrains 
	
	public static  int tupleSameProductBruteForce(int[] nums) {
		
		int pairs  =0;
		for(int a =0;a<nums.length;a++) {
			for(int b=0;b<nums.length;b++) {
				if(b==a ) {
					continue;
					}
				if(nums[a]==nums[b]) {
					continue;
				}
				
				for(int c=0;c<nums.length;c++) {
					if(c==a || c==b ) {
						continue;
						}
					for(int d=0;d<nums.length;d++) {
						if(d==a || d==b || d==c) {
							continue;
							}
						
						
						if(nums[c]==nums[d]) {
							continue;
						}
						if(nums[a]*nums[b]==nums[c]*nums[d]) {
							pairs++;
						}
					}
				}
			}
		}
		return pairs;
		
	}

//	Better approch :
//  here we put each pointer ahead of its previous one which make us to not 
//	check each pair multiple times makes it faster but complexity is same 
//	Time complexity :O(n^4)
//	space complexity :O(1)
//	this solution will also not accepted 
	public static  int tupleSameProductBetter(int[] nums) {	
		int pairs  =0;
		for(int a =0;a<nums.length-3;a++) {
			for(int b=a+1;b<nums.length-2;b++) {
				for(int c=b+1;c<nums.length-1;c++) {
					for(int d=c+1;d<nums.length;d++) {
						if(nums[a]*nums[b]== nums[c]*nums[d] ||nums[a]*nums[c]== nums[b]*nums[d] || nums[a]*nums[d]== nums[c]*nums[b]) {
							pairs+=8;
						}
					}
				}
			}
		}
		return pairs;
		
	}
	
	
//	Best approch :
//	intution : here each pair can be converted to 8 pairs by just moving place of a,b,c,d
//	here we make a hash map to keep track of pairs and produtct 
//	hashmap key is the product and value is how many pairs it have 
//	first use 2 pointer i , j where i =0 , j=i+1 
//	here we make pairs of nums[i]*nums[j] taking product of and put it as key in hashmap and value as 1;
//	if that key alredy exists then we get the value of it and update pairs +=8*val
//	and update pair count by adding 1
	
//note : this approch only work for distinct values
//	Time complexity :O(n^2)
//	space complexity :O(n^2)
	public static  int tupleSameProductBest(int[] nums) {	
		    	int pairs =0;
	            HashMap <Integer,Integer> count = new HashMap();
	            for(int i =0;i<nums.length;i++){// a
	                for(int j=i+1;j<nums.length;j++){//b
	                    int product = nums[i]*nums[j];// prod
	                    if(count.containsKey(product)){//checking prod exits
	                    pairs+=8*count.get(product); // update pairs
	                    count.put(product, count.get(product)+1);// update count
	                    }else {
	                    	count.put(product,1);// this means the product is put once in the map and the next pair which will get same product will be able to use the product	
	                    }
	                }
	            }
	return pairs;
	    }	
	
	
	
	
	

	public static void main(String[] args) {

		//Example 1:
		
		int []nums1 = {2,3,4,6};
		int output1=8;


		//Example 2:
		

		int []nums2 = {1,2,4,5,10};
		int output2=16;
		
		//Example 3: // this very expesive with brute force approch:
		
		int [] nums3={69,252,95,725,112,345,390,221,405,27,58,100,392,156,147,377,32,288,350,17,230,609,29,357,66,728,140,462,190,621,51,7,475,105,255,81,391,120,690,250,308,261,68,464,28,540,116,18,192,16,468,189,532,60,56,420,207,425,630,126,40,432,2,153,84,272,870,210,552,200,228,161,285,648,322,320,132,87,459,70,336,64,184,44,338,15,196,90,117,20,14,45,266,270,374,204,133,416,165,99,780,102,551,195,34,506,182,160,513,48,114,175,72,560,494,364,22,299,225,180,460,171,104,580,476,598,4,437,150,152,76,340,650,50,145,672,522,378,75,396,12,325,375,406,21,1,170,702,10,306,348,304,224,575,418,342,696,368,24,500,483,231,203,78,399,253,26,644,174,19,54,9,486,128,567,57,720,450,8,297,162,52,96,125,588,35,456,240,30,440,260,130,594,525,91,840,154,25,330,264};
		int output3=293728;
		
    	System.out.println("Brute Force Approch :");
		int ans1 = tupleSameProductBruteForce(nums1);
		int ans2 = tupleSameProductBruteForce(nums2);
		int ans3 = tupleSameProductBruteForce(nums3);
		
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		
		
		
		System.out.println("Better Approch :");
		 ans1 = tupleSameProductBetter(nums1);
		 ans2 = tupleSameProductBetter(nums2);
		 ans3= tupleSameProductBetter(nums3);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		
		
		
		System.out.println("Best Approch :");
		ans1 = tupleSameProductBest(nums1);
		ans2 = tupleSameProductBest(nums2);
		ans3= tupleSameProductBest(nums3);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		
		
		

		

	}

}
