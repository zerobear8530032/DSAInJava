//752. Open the Lock
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
//
//The lock initially starts at '0000', a string representing the state of the 4 wheels.
//
//You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
//
//Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
//
//
//
//Example 1:
//
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//because the wheels of the lock become stuck after the display becomes the dead end "0102".
//Example 2:
//
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
//Example 3:
//
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
//Output: -1
//Explanation: We cannot reach the target without getting stuck.
//
//
//Constraints:
//
//1 <= deadends.length <= 500
//deadends[i].length == 4
//target.length == 4
//target will not be in the list deadends.
//target and deadends[i] consist of digits only.
package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock_752 {
//    approch:
//    use BFS to go to different state by moving dial once up once down for every dial
//    and keep track of dead end in a hashset and cntinue of the visited state are their
//    note their is a possibility inital state been in dead end so we can return -1 initially
//    time complexity : O(10^4)
//    space complexity : O(10^4)
//

    public static int openLock(String[] deadends, String target) {
        HashSet<String> visited= new HashSet<>();
        for(String s:deadends){
            visited.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        if(visited.contains("0000")){
            return -1;
        }
        visited.add("0000");
        queue.add("0000");
        int depth=0;
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int s=0;s<size;s++){
                String poped= queue.poll();
                if(poped.equals(target)){
                    return depth;
                }
                char [] state= poped.toCharArray();
                for(int i =0;i<state.length;i++){
                    char ch = state[i];
                    int up = state[i]+1;
                    // go up
                    if(up>='0' && up<='9'){
                        state[i]=(char)up;
                    }else{
                        state[i]='0';
                    }
                    String str=new String(state);
                    if(!visited.contains(str)){
                        visited.add(str);
                        queue.add(str);
                    }
                    state[i]=ch;

                    // go down
                    int down = state[i]-1;
                    if(down>='0' && down<='9'){
                        state[i]=(char)down;
                    }else{
                        state[i]='9';
                    }
                    str= new String(state);
                    if(!visited.contains(str)){
                        visited.add(str);
                        queue.add(str);
                    }
                    state[i]=ch;
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        //Example 1:

        String [] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        int output1= 6;

        //Example 2:

        String [] deadends2 = {"8888"};
        String target2 = "0009";
        int output2 =1;
        //Example 3:

        String [] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        int output3=-1;

        int ans1= openLock(deadends1,target1);
        int ans2= openLock(deadends2,target2);
        int ans3= openLock(deadends3,target3);


        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }





    }
}
