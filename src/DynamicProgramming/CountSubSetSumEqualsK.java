//  find count of subset whose sum equals target k

package DynamicProgramming;

public class CountSubSetSumEqualsK {
    public  static int countSubsetBruteForce(int [] nums , int target) {
        return helperBruteForce(nums.length,target,nums);
    }
    public  static int helperBruteForce(int idx,int target, int [] nums){
        if(target==0 && idx==0){return 1;}
        if(idx==0){return 0;}
        if(target>=nums[idx-1]){
            int take= helperBruteForce(idx-1,target-nums[idx-1],nums);
            int notTake= helperBruteForce(idx-1,target,nums);
            return  take+notTake;
        }
        return helperBruteForce(idx-1,target,nums);
    }

    public  static int countSubsetMemo(int [] nums , int target) {
        Integer [][] memo = new Integer [nums.length+1][target+1];
        return helperMemo(nums.length,target,nums,memo);
    }
    public  static int helperMemo(int idx,int target, int [] nums, Integer [][] memo){
        if(memo[idx][target]!=null){
            return memo[idx][target];
        }
        if(target==0 && idx==0){return 1;}
        if(idx==0){return 0;}
        if(target>=nums[idx-1]){
            int take= helperMemo(idx-1,target-nums[idx-1],nums,memo);
            int notTake= helperMemo(idx-1,target,nums,memo);
            memo[idx][target]=take+notTake;
            return memo[idx][target];
        }
        memo[idx][target]= helperBruteForce(idx-1,target,nums);
        return memo[idx][target];
    }

    public  static int countSubsetTopDown(int [] nums , int target) {
        int [][] table = new int [nums.length+1][target+1];
        table[0][0]=1;
        for(int idx=1;idx<=nums.length;idx++){
            for(int t=0;t<=target;t++){
                    if(t>=nums[idx-1]){
                        int take= table[idx-1][t-nums[idx-1]];
                        int notTake= table[idx-1][t];
                        table[idx][t]=take+notTake;
                    }else{
                        int notTake= table[idx-1][t];
                        table[idx][t]=notTake;
                    }
            }
        }
        return table[nums.length][target];
    }



    public static void main(String[] args) {

//        Example 1 :
        int [] nums1 = {1, 2, 3};
        int target1=4;
        int output1=1;

//        Example 2 :
        int [] nums2 = {0, 0, 1};
        int target2=1;
        int output2=4;

//        Example 3 :
        int [] nums3 = {2, 3, 5, 6, 8, 10};
        int target3 = 10;
        int output3 =3;

        int ans1= countSubsetBruteForce(nums1,target1);
        int ans2= countSubsetBruteForce(nums2,target2);
        int ans3= countSubsetBruteForce(nums3,target3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

        System.out.println("Top Down DP");

        ans1= countSubsetTopDown(nums1,target1);
        ans2= countSubsetTopDown(nums2,target2);
        ans3= countSubsetTopDown(nums3,target3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }System.out.println("Memorize DP");

        ans1= countSubsetMemo(nums1,target1);
        ans2= countSubsetMemo(nums2,target2);
        ans3= countSubsetMemo(nums3,target3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
