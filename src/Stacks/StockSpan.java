package Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class StockSpan {
//     approch :
//    here we can see one thing where the consicutive smaller elements will be all element to left before
//    any greater element are there
//      {100,80,60,70,60,75,85}
//    here if we want element from 85 then the next greater element to left of 85 is
//    100 which is at index 0 :
//    so 85 is at index 6 and 100 index is 0 we can just do 6-0 = 6 all elements btw that are smaller
//    similarly we are gonna do this for every number
//    here a variation is where we gonna put index of nums in stack not the values
//    so we can find next greater element to left and store that index in output array
//    now we can find distance btw the greater element then current indexes and get it in the output array
//    time complexity : O(n)
//    space complexity : O(n)
    public static int [] stockSpan(int [] nums ){
        int [] output= new int[nums.length];
        Stack<Integer> stk= new Stack<>();
        for(int i =0;i<nums.length;i++){
            if(stk.isEmpty()){
                stk.push(i);
                output[i]=-1;
            }else{
                while (!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    output[i]=-1;
                }else{
                    output[i]= stk.peek();
                }
            }
        }
        for(int i=0;i<output.length;i++){
            output[i]= i-output[i];
        }
        return output;
    }

    public static void main(String[] args) {
        int [] arr= {100,80,60,70,60,75,85};
        int [] output= stockSpan(arr);
        System.out.println(Arrays.toString(output));
    }
}
