//2780. Minimum Index of a Valid Split
//Medium
//Topics
//Companies
//Hint
//An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.
//
//You are given a 0-indexed integer array nums of length n with one dominant element.
//
//You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:
//
//0 <= i < n - 1
//nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
//Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
//
//Return the minimum index of a valid split. If no valid split exists, return -1.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2,2]
//Output: 2
//Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2]. 
//In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3. 
//In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
//Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split. 
//It can be shown that index 2 is the minimum index of a valid split. 
//Example 2:
//
//Input: nums = [2,1,3,1,1,1,7,1,2,1]
//Output: 4
//Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
//In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
//In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
//Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
//It can be shown that index 4 is the minimum index of a valid split.
//Example 3:
//
//Input: nums = [3,3,3,3,7,2,2]
//Output: -1
//Explanation: It can be shown that there is no valid split.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//nums has exactly one dominant element.
package Arrays;
import java.util.*;
class MinimumIndexOfAValidSplit_2780 {
	
//	brute force approch :
//	approch : create a hashmap to find the frequency of each element
//	and get the max frequency element as dominating
//	now just check from 0 till n
//	which split satisfy the condition size of subarray < dominating frequncy 
//	if it condition satisfies some where return i
//	ther wise return -1;
//	Time complexity :O(n*n)
//	Space complexity :O(n)
	
    public static int minimumIndexBruteForce(List<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int x: nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        int dominating =0;
        int freq=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>freq){
                freq=e.getValue();
                dominating=e.getKey();
            }
        } 
        int n = nums.size();
        for(int i =0;i<n;i++){
            int firsthalf=0;
            for(int f =0;f<=i;f++){
                if(nums.get(f)==dominating){
                    firsthalf++;
                }
            }
            int subarraysize=i+1;
            if( (subarraysize/2)>=firsthalf ) continue;
            int sechalf=0;
            for(int s =i+1;s<n;s++){
                if(nums.get(s)==dominating){
                   sechalf ++;
                }
            }
            subarraysize=n-(i+1);
            if( (subarraysize/2)>=sechalf ) continue;
            else return i;
        }
        return -1;
    }
    
    
//	Better force approch :
//	approch :
//    every thing is same just the finding dominating term can be solved
//    using a trick of prefix and suffix max
//    where we create a array of same length as input
//    and get prefix max and suffix max to get find frequency in O(1)
//    this reduce time and remove the nestewd loops
//    time complexity : O(n)
//    space complexity : O(n)
    public static int minimumIndexBetter(List<Integer> nums) {
    	HashMap<Integer,Integer> map = new HashMap();
    	for(int x: nums){
    		if(map.containsKey(x)){
    			map.put(x,map.get(x)+1);
    		}else{
    			map.put(x,1);
    		}
    	}
    	int dominating =0;
    	int freq=0;
    	for(Map.Entry<Integer,Integer> e:map.entrySet()){
    		if(e.getValue()>freq){
    			freq=e.getValue();
    			dominating=e.getKey();
    		}
    	} 
    	
    	int n = nums.size();
    	int [] prefixMax= new int [n];
    	int [] suffixMax= new int [n];
    	int prefixFreq=0;
    	int suffixFreq=0;
    	for(int i =0;i<n;i++) {
    		if(nums.get(i)==dominating) {
    			prefixFreq++;
    		}
    		prefixMax[i]=prefixFreq;
    		if(nums.get(n-1-i)==dominating) {
    			suffixFreq++;
    		}
    		suffixMax[n-1-i]=suffixFreq;
    	}
    	
    	for(int i =0;i<n;i++){
    		int fhalf= prefixMax[i];
    		int subarraysize= (i+1);
    		if( fhalf <= subarraysize / 2 ) {
    			continue;
    		}
    		if(i+1>=n) {
    			break;
    		}
    		int shalf=suffixMax[i+1];
    		subarraysize=n-(i+1);
    		if( shalf <= subarraysize / 2) {
    			continue;
    		}else {
    			return i;
    		}
    		
    	}
    	return -1;
    }
//	Best force approch :
//	approch :
//    from better approch we can make one observation
//    the dominating term is what we want to track 
//    if the input=[1,2,2,2]
//    so inital if at split 0 :[1] ,[2,2,2]
//    the dominating terms 0, 3
//    if it split 1 : [1,2] ,[2,2]
//    the dominating terns = 1,2
//    if it split 2 : [1,2,2] ,[2]
//    the dominating terns = 2,1
//    so do i need prefix sum or suffix sum
//    i can find the frequency of dominating term 
//    and say left hand side array have 0 dominating term and right have frequency of dominating term
//    with that each time i move i +1 if the current number is
//    a dominating term i will increase domcount at left side by 1
//    and decrease the dom count at right side by 1 
//    and exit if both have satisfying the condition
//    time complexity : O(n)
//    space complexity : O(n)
    public static int minimumIndexBest(List<Integer> nums) {
    	
        HashMap<Integer,Integer> map = new HashMap();
    	for(int x: nums){
    		if(map.containsKey(x)){
    			map.put(x,map.get(x)+1);
    		}else{
    			map.put(x,1);
    		}
    	}
    	int dominating =0;
    	int freq=0;
    	for(Map.Entry<Integer,Integer> e:map.entrySet()){
    		if(e.getValue()>freq){
    			freq=e.getValue();
    			dominating=e.getKey();
    		}
    	} 
    	
    	int n = nums.size();    	
    	int fhalf=0 ;
        int shalf=freq;
     	for(int i =0;i<n;i++){
            if(nums.get(i)==dominating){
                fhalf++;
                shalf--;
            }
    		int subarraysize= (i+1);
    		if( fhalf <= subarraysize / 2 ) {
    			continue;
    		}
    		
    		subarraysize=n-(i+1);
    		if( shalf <= subarraysize / 2) {
    			continue;
    		}else {
    			return i;
    		}
    		
    	}
    	return -1;
    }
    
    
    
    
    public static void main(String[] args) {
    	//Example 1:
    	//
    	List<Integer> nums1= new ArrayList(Arrays.asList(1,2,2,2));
    	int output1=2;

    	//Example 2:

    	List<Integer> nums2= new ArrayList(Arrays.asList(2,1,3,1,1,1,7,1,2,1));
    	int output2=4;
    	

    	//Example 3:

    	List<Integer> nums3= new ArrayList(Arrays.asList(3,3,3,3,7,2,2));
    	int output3=-1;
    	
System.out.println("Brute Force Approch :");
    	
    	int ans1= minimumIndexBruteForce(nums1);
    	int ans2= minimumIndexBruteForce(nums2);
    	int ans3= minimumIndexBruteForce(nums3);
    	
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
		ans1= minimumIndexBetter(nums1);
		ans2= minimumIndexBetter(nums2);
		ans3= minimumIndexBetter(nums3);
		
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
		
		System.out.println("Best Approch :");
		ans1= minimumIndexBest(nums1);
		ans2= minimumIndexBest(nums2);
		ans3= minimumIndexBest(nums3);
		
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