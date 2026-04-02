package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class MinMaxSubArray {
    public static int minValue(int [] nums , int k){
        int l=0;
        int r =0;
        if(k==1){// if k ==1 return mx of entire rray
            return  Arrays.stream(nums).max().getAsInt();}
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        while(r<k){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            r++;
        }
        min = map.firstKey();
        max=Math.max(min,max);
        while(r<nums.length){
            map.put(nums[l],map.get(nums[l])-1);
            if(map.get(nums[l])==0){map.remove(nums[l]);}
            l++;
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            min = map.firstKey();
            max=Math.max(min,max);
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int k =2;

        System.out.println(minValue(nums,k));



    }
}
