package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToLeft {
// this question is similar to next greater element to left
//     just change the direction and no need to reverse the res
//    approch : here we go from left to right and add element in the stack  if stk is empty if its empty we also set index i to -1 cause no element are on left
//    if stk is not empty we will pop all elements which are smaller then nums[i] or equal
//    if stk becomes empty we will put output[i]=-1 other wise we will peek the element and set int output[i]
//    and the end we will push the element in stack
//    time complexity : O(n)
//    space complexity : O(n)
    public static int [] nextGreaterElement(int [] nums){
        int [] output= new int [nums.length];
        Stack<Integer> stk = new Stack<>();
        for(int i =0;i<nums.length;i++){
            if(stk.isEmpty()){
                stk.push(nums[i]);
                output[i]=-1;
            }else{
                while(!stk.isEmpty() && stk.peek() <=nums[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    output[i]=-1;
                }else{
                    output[i]= stk.peek();
                }
                stk.push(nums[i]);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int [] arr1= {2,5,1,5,7};
        int [] arr2= {2,3,1,5,7};
        int [] arr3= {2,5,1,5,1};

        System.out.println(Arrays.toString(nextGreaterElement(arr1)));
        System.out.println(Arrays.toString(nextGreaterElement(arr2)));
        System.out.println(Arrays.toString(nextGreaterElement(arr3)));

    }

}
