package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElementInLeft {
//     approch : is same as other approches:
    // here we traverse from left and is stk is empty we will push curr element in stk and output will have -1
//    if stk is not empty we will pop elemnts from stk if stk top is >= current element
//    if stk is empty we will put output[i]=-1
//    other wise we will put stk top wihtout poping
//    at the end we will push the current element in stk;
    public static int [] nextsmallestToLeft(int [] nums){
        int [] output = new int [nums.length];
        Stack<Integer> stk =  new Stack<>();
        for(int i =0;i< nums.length;i++){
            if(stk.isEmpty()){
                output[i]=-1;
                stk.push(nums[i]);
            }else{
                while(!stk.isEmpty() && stk.peek()>= nums[i]){
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
        return  output;
    }

    public static void main(String[] args) {
        int [] arr1= {2,5,1,5,7};
        int [] arr2= {2,3,1,5,7};
        int [] arr3= {2,5,1,5,1};

        System.out.println(Arrays.toString(nextsmallestToLeft(arr1)));
        System.out.println(Arrays.toString(nextsmallestToLeft(arr2)));
        System.out.println(Arrays.toString(nextsmallestToLeft(arr3)));

    }
}
