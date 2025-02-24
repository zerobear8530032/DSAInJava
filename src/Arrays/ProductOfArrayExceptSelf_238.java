//238. Product of Array Except Self
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
//
//Constraints:
//
//2 <= nums.length <= 105
//-30 <= nums[i] <= 30
//The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
// 
//
//Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


package Arrays;
import java.util.Arrays;
class ProductOfArrayExceptSelf_238 {
//	approch :
//	just calcualte the product of all element except for the self using nested loops
//	time complexity :O(n*n)
//	space  complexity :O(1) -> including output : O(n)
    public static int[] productExceptSelfBruteForce(int[] nums) {
   
    	int [] ans = new int [nums.length];
    	for(int i =0;i<nums.length;i++) {
    		ans[i]=product(nums, i);
    	}
        return ans;
    }
    public static int product(int [] arr,int skipindex) {
    	int currprod=1;
    	for(int i =0;i<arr.length;i++) {
    		if(i==skipindex) {
    			continue;
    		}else {
    			currprod*=arr[i];
    		}
    	}
    	return currprod;
    	
    }
    
//	Better Approch :
//  we need to take product of each element except for it self
//	we can do is create a prefix and suffix product not including the element at current index 
//	means [1,2,3,4] prefix product : [_,1,1*2,1*2*3]= [1,1,2,6] we consider empty a value as 1 
//	similarly we can use the a suffix product :
//	means [1,2,3,4] suffix product : [2*3*4,3*4,4,_]= [24,12,4,1]
//	now we can just compute the element product element by elements :
//	[24,12,8,6]  output 
    
//	time complexity :O(n)
//	space  complexity :O(n) -> including output : O(3n)
    
    
    public static int[] productExceptSelfBetter(int[] nums) {
    	int  n = nums.length;
    	int prefixprod[] = new int [n];
    	// calculate left to right product :
    	int currprod=1;
    	// the first element does not have any number before it means we can let it be 1 
    	prefixprod[0]=1;
    	for(int i =1;i<n;i++){
    		// here we make a new array which will have a prefix product or original array without itself 
    		currprod=currprod*nums[i-1];
    		prefixprod[i]=currprod;
    	}
    	int suffixprod[] = new int [n];
    	// calculate left to left product :
    	currprod=1;
    	// the first element does not have any number before it means we can let it be 1 
    	suffixprod[n-1]=1;
    	for(int i =n-2;i>=0;i--){
    		// here we make a new array which will have a prefix product or original array without itself 
    		currprod=currprod*nums[i+1];
    		suffixprod[i]=currprod;
    	}
    	// now we have 2 product array prefix and suffix we can just multipliy  them element by element into each other and we will have our output :
    	int [] ans = new int [n];
    	for(int i =0;i<n;i++){
    		ans[i]=prefixprod[i]*suffixprod[i];
    	}
    	
    	return ans;
    }

//	Best Approch : answwer the follow up
//  combine the loops of better approch and create a single output array for prefix sum and output:    
//	time complexity :O(n)
//	space  complexity :O(1) -> including output : O(n)
    
    public static int[] productExceptSelfOptimize(int[] nums) {
           int  n = nums.length;
           int ans[] = new int [n];
           // calculate left to right product :
           int currprod=1;
           // the first element does not have any number before it means we can let it be 1 
           ans[0]=1;
           for(int i =1;i<n;i++){
        // here we make a new array which will have a prefix product or original array without itself 
        	   currprod=currprod*nums[i-1];
        	   ans[i]=currprod;
           }
           int suffixprod=1;
           for(int i =n-2;i>=0;i--){
//        	   here we will calculate the suffix product while makeing ans
//        	   suffixprod will make the product of suffix array and we multiply with its prefix array 
//        	   we will get our output array 
        	   suffixprod= suffixprod*nums[i+1];
        	   ans[i]=ans[i]*suffixprod;
			  }    	
           return ans;     
    }
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int [] nums1 = {1,2,3,4};
    	int [] output1 = {24,12,8,6};
    	
    	//Example 2:
    			
    	int [] nums2 = {-1,1,0,-3,3};
    	int [] output2= {0,0,9,0,0};

    	
    	int []ans1 =  productExceptSelfBruteForce(nums1);
    	int []ans2 =  productExceptSelfBruteForce(nums2);
		
		
		if(Arrays.equals(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
	}
		if(Arrays.equals(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		
		System.out.println("Better Approch :");
		
		ans1 = productExceptSelfBetter(nums1);
		ans2 = productExceptSelfBetter(nums2);
		
		if(Arrays.equals(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		
//		works for this contrain onlyy 
		System.out.println("Optimized Optimize Approch :");
		
		ans1 = productExceptSelfOptimize(nums1);
		ans2 = productExceptSelfOptimize(nums2);
		
		
		if(Arrays.equals(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+Arrays.toString(ans2) );
		}
		

	}
    
    
    
}