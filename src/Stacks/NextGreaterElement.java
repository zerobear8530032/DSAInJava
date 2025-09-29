package Stacks;

import java.util.Arrays;
import java.util.Stack;

// approch : here we neet to iterate from right to left
// and we push an element if stack is empty and output[i] =-1
//cause there is no left element which is greater
// if out stack is not empty then we will check the current element is greater then top or not
// if its is we will pop the element from stack and it all elements are smaller or equl in stack we can push current element
// and make the output -1 other wise we will put stk top element as output[i] and push the element we are currently seeing in the stack
public class NextGreaterElement {
    public static int [] nextGreaterElement(int [] arr){
        int n=arr.length;
       int [] output= new int [n];
        Stack<Integer> stk = new Stack<>();
       for(int i =n-1;i>=0;i--){
           if(stk.isEmpty()){
               output[i]=-1;
               stk.push(arr[i]);
           }else {
               while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                   stk.pop();
               }
               if (stk.isEmpty()) {
                   output[i] = -1;
               }else{
                   output[i]=stk.peek();
               }
               stk.push(arr[i]);
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
