package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {


    public static int [] nextsmallest(int [] nums){
        int [] output= new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        for(int i =nums.length-1;i>=0;i--){
            if(stk.isEmpty()){
                stk.push(nums[i]);
                output[i]=-1;
            }else {
                while (!stk.isEmpty() && stk.peek() >= nums[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stk.peek();
                }
                stk.push(nums[i]);
            }
        }
        return  output;
    }

    public static void main(String[] args) {
        int [] arr1= {2,5,1,5,7};
        int [] arr2= {2,3,1,5,7};
        int [] arr3= {1,5,2,5,1};

        System.out.println(Arrays.toString(nextsmallest(arr1)));
        System.out.println(Arrays.toString(nextsmallest(arr2)));
        System.out.println(Arrays.toString(nextsmallest(arr3)));

    }
}
