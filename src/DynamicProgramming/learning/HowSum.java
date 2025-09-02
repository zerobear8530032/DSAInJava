package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {

// time complexity : O(m^n)
// Space complexity : O(m)
    public static List<Integer> howSum(int [] nums,int target){
        if(target==0){
            return new ArrayList<>();
        }
        if(target<0){
            return null;
        }
        for(int x:nums){
            int remainder= target-x;
            List<Integer> res= howSum(nums,remainder);
            if(res!=null){
                res.add(x);
                return res;
            }
        }
        return null;
    }

// time complexity : O(n*m^2)
// Space complexity : O(m*n)
    public static List<Integer> howSum(int [] nums, int target, HashMap<Integer,List<Integer>> memo){
        if(memo.containsKey(target)){return memo.get(target);}
        if(target==0){return new ArrayList<>();}
        if(target<0){return null;}

        for(int x:nums){
            int remainder= target-x;
            List<Integer> res= howSum(nums,remainder,memo);
            if(res!=null){
                res.add(x);
                memo.put(target,new ArrayList<>(res));
                return res;
            }
        }
        memo.put(target,null);
        return null;
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
        System.out.println(howSum(nums1,target1));
        System.out.println(howSum(nums2,target2));
        System.out.println(howSum(nums3,target3));
//        System.out.println(howSum(nums4,target4));

        System.out.println("Better Approch ");

        System.out.println(howSum(nums1,target1, new HashMap<>()));
        System.out.println(howSum(nums2,target2, new HashMap<>()));
        System.out.println(howSum(nums3,target3, new HashMap<>()));
        System.out.println(howSum(nums4,target4, new HashMap<>()));


    }
}
