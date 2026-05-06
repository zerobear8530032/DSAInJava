//
package Stacks;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack();
        for(String op:operations){
            if(op.equals("C")){
                stk.pop();
            }else if(op.equals("D")){
                stk.push(stk.peek()*2);
            }else if(op.equals("+")){
                int x1= stk.pop();
                int x2 = stk.pop();
                stk.push(x2);
                stk.push(x1);
                stk.push(x1+x2);
            }else{
                stk.push(Integer.parseInt(op));
            }
            System.out.println(op);
            System.out.println(stk);
        }
        int sum =0;
        while(!stk.isEmpty()){
            sum+=stk.pop();
        }
        return sum;
    }
}