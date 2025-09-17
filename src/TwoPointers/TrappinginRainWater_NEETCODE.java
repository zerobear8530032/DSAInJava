//Trapping Rain Water
//You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
//
//Return the maximum area of water that can be trapped between the bars.
//
//Example 1:
//
//
//
//Input: height = [0,2,0,3,1,0,1,3,2,1]
//
//Output: 9
//Constraints:
//
//1 <= height.length <= 1000
//0 <= height[i] <= 1000

package TwoPointers;

import java.util.Arrays;
import java.util.Comparator;

class TrappinginRainWater_NEETCODE {
	
//	brute force approch :
//	we can make 2 observation that the water will get trapped in btw 2  buildings with highet greater then 0
//	and the max hight of water which can be store int just the min(both buildings)
//	with that we can say the  max water btw 2 building is just distance btw them * min(of there heights)
//	now there is a possibility a buidling have water above it that time we need to just minus the building
//	hight from total water :
//	example : 0,2,1,4,
//	here the water could not trap btw 0 and 2 
//	and it will also not trap bttw 2 & 1 
//	but it ccan trap btw 2 & 4 
//	so what we can do is if we find leftmax  and right max at height[2]
//	and use formula min(leftmax,rightmax)- height[i]
//	time complexity : o(n*n)
//	space complexit : o(1)
	
	public static int trapBruteForce(int[] height) {
    	if(height.length==0 || height==null) return  0;
    	int res=0;
    	int n = height.length;
    	for(int i =0;i<n;i++) {// for each i
    		int leftmax=height[i];// left max
    		int rightmax=height[i];// right max
    		for(int j = i-1;j>=0;j--) {// find left max
    			leftmax=Math.max(leftmax, height[j]);
    		}
    		for(int j = i+1;j<n;j++) {// find right max
    			rightmax=Math.max(rightmax, height[j]);
    		}//caculate water
    		int water = Math.min(leftmax, rightmax)-height[i];
    		res+=water;// add all water
    	}
    	return res;// ans
    	
    }
//	best force approch :
//	we can make 2 observation that the water will get trapped in btw 2  buildings with highet greater then 0
//	and the max hight of water which can be store int just the min(both buildings)
//	with that we can say the  max water btw 2 building is just distance btw them * min(of there heights)
//	now there is a possibility a buidling have water above it that time we need to just minus the building
//	hight from total water :
//	example : 0,2,1,4,
//	here the water could not trap btw 0 and 2 
//	and it will also not trap bttw 2 & 1 
//	but it ccan trap btw 2 & 4 
//	so what we can do is if we find leftmax  and right max at height[2]
//	and use formula min(leftmax,rightmax)- height[i]
//	every thing is same we just use a prefix sum  and suffix sum which will have max  till index i 
//	in it 
//	
//	time complexity : o(n)
//	space complexit : o(n)
	public static int trapBetter(int[] height) {
		if(height.length==0 || height==null) return  0;
		int res=0;
		int n = height.length;
		int [] prefixmax= new int [height.length];
		int [] suffixmax= new int [height.length];
		int prefmax=0;
		int suffmax=0;
		for(int i =0;i<n;i++) {
			prefmax= Math.max(prefmax, height[i]);
			prefixmax[i]=prefmax;
			suffmax= Math.max(suffmax, height[n-i-1]);
			suffixmax[n-i-1]=suffmax;
		}
	
		for(int i =0;i<n;i++) {// for each i
			int leftmax=prefixmax[i];// left max
			int rightmax=suffixmax[i];// right max			
			int water = Math.min(leftmax, rightmax)-height[i];
			res+=water;// add all water
		}
		return res;// ans
		
	}
//   best approch :
//    here we knows we only need to keep track
//    of left most and right most max and min  values we can use a single pointer to keep track of it
public static int trapBest(int[] height) {
    int n=height.length;
    int l =0;
    int r= n-1;
    int lmax= height[l];
    int rmax= height[r];
    int totalWater=0;
    while(l<=r){
        lmax= Math.max(lmax,height[l]);
        rmax= Math.max(rmax,height[r]);
        if(lmax<rmax){
            int water= lmax-height[l];
            totalWater+=water;
            l++;
        }else{
            int water= rmax-height[r];
            totalWater+=water;
            r--;
        }
    }
    return totalWater;
}
    public static void main(String[] args) {
    	//Example 1:
    	int [] height1 = {0,2,0,3,1,0,1,3,2,1};
    	int output1=9;
    	
		int ans1= trapBruteForce(height1);	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		
		

		System.out.println("Better Approch :");
		 	
		ans1= trapBetter(height1);	
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}

        System.out.println("Best Approch :");

        ans1= trapBest(height1);
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
//        {moussaka=greek, ramen=japanese, kimchi=korean, sushi=japanese, miso=japanese, bulgogi=korean}
//        {greek=[Dish{name='moussaka', cuisines='greek', rating=15}],
//        japanese=[Dish{name='ramen', cuisines='japanese', rating=14},
//        Dish{name='miso', cuisines='japanese', rating=12},
//        Dish{name='sushi', cuisines='japanese', rating=8}],
//        korean=[Dish{name='kimchi', cuisines='korean',
//        rating=9}, Dish{name='bulgogi', cuisines='korean', rating=7}]}
	}

}
