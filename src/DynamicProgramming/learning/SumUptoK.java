package DynamicProgramming.learning;

import java.util.HashMap;

public class SumUptoK {

// time complexity : O(m^n)
// space complexity : O(m)
    public static boolean sumUptoTarget(int [] nums, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int x : nums) {
            int remainder = target - x;
            if (sumUptoTarget(nums, remainder)) {
                return true;
            }
        }
        return false;
    }
    // time complexity : O(m*n)
    // space complexity : O(m)
    public  static boolean sumUptoTarget(int [] nums, int target, HashMap<Integer,Boolean> memo){
        if(target==0){return true;}
        if(target<0){return false;}
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        for(int x:nums){
            int remainder= target-x;
            boolean res = sumUptoTarget(nums,remainder,memo);
            memo.put(target,res);
            if(res){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int target1= 7;
        int [] nums1= {1,2,4,8,5};

        int target2= 7;
        int [] nums2= {2,4};

        int target3= 7;
        int [] nums3= {5,3,4,7};

        int target4= 300;
        int [] nums4= {7,14};

        System.out.println(sumUptoTarget(nums1,target1));
        System.out.println(sumUptoTarget(nums2,target2));
        System.out.println(sumUptoTarget(nums3,target3));
//        System.out.println(sumUptoTarget(nums4,target4));

        System.out.println("Optimize Approch :");
        System.out.println(sumUptoTarget(nums1,target1,new HashMap<>()));
        System.out.println(sumUptoTarget(nums2,target2, new HashMap<>()));
        System.out.println(sumUptoTarget(nums3,target3,new HashMap<>()));
        System.out.println(sumUptoTarget(nums4,target4, new HashMap<>()));

    }
}
