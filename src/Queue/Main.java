package Queue;
import java.util.*;
public class Main {
	  public static int[] maxSlidingWindow(int[] nums, int k) {
	        int [] res =  new int [nums.length-k+1];
	        for(int i =0;i<nums.length-k+1;i++){
	            int max =Integer.MIN_VALUE;
	            for(int j=0;j<k;j++){
	                max= Math.max(max,nums[i+j]);
	            }
	            res[i]=max;
	        }
	        return res;
	    }
	
	public static void main(String[] args) {
		int [] nums1= {1,3,-1,-3,5,3,6,7};
		int k1= 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
	}
}
