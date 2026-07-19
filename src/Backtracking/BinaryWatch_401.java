//401. Binary Watch
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
//
//For example, the below binary watch reads "4:51".
//
//
//Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
//
//The hour must not contain a leading zero.
//
//For example, "01:00" is not valid. It should be "1:00".
//The minute must consist of two digits and may contain a leading zero.
//
//For example, "10:2" is not valid. It should be "10:02".
//
//
//Example 1:
//
//Input: turnedOn = 1
//Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
//Example 2:
//
//Input: turnedOn = 9
//Output: []
//
//
//Constraints:
//
//0 <= turnedOn <= 10
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BinaryWatch_401 {

//    approch : we can create a timemap where on each index we have same label as watch
//    now we can have a boolean array of same size which tell which led are on
//    now we recusively do each bit either turn it on of not
//    and if the turnedOn become 0 we compute the time
//    if time is valid we add it in res
//    time complexity : O(1)
//    Space complexity : O(n)
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res= new ArrayList<>();
        if(turnedOn>=9){
            return res;
        }
        int [] timeMap = {8,4,2,1,32,16,8,4,2,1};
        boolean [] onLed= new boolean [timeMap.length];
        helper(timeMap,res,turnedOn,onLed,0);
        return res;
    }

    public static void helper(int [] timeMap , List<String> res, int turnedOn ,boolean [] onLed, int idx){

        if(turnedOn==0 && idx==timeMap.length){
            int hour= 0;
            int minutes=0;
            for(int i =0;i<4;i++){
                if(onLed[i]){
                    hour=hour+timeMap[i];
                }
            }
            if(hour>=12){return;}
            for(int i =4;i<timeMap.length;i++){
                if(onLed[i]){
                    minutes+=timeMap[i];
                }
            }
            if(minutes>=60){return;}
            StringBuilder output= new StringBuilder();
            output.append(hour);
            output.append(":");
            if(minutes<10){
                output.append("0"+minutes);
            }else{
                output.append(minutes);
            }
            res.add(output.toString());
            return ;
        }

        if(idx==timeMap.length){
            return;
        }
        // dont turn on:
        helper(timeMap,res,turnedOn,onLed,idx+1);
        // turn on:
        onLed[idx]=true;
        helper(timeMap,res,turnedOn-1,onLed,idx+1);
        onLed[idx]=false;
    }

    private static boolean check(List<String> res, List<String> output){
        if(res.size()!=output.size()) {
            return false;
        }
        HashSet<String> set1= new HashSet<>(res);
        HashSet<String> set2= new HashSet<>(output);
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        //Example 1:

        int turnedOn1 = 1;
        List<String>  output1= Arrays.asList("0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00");

        //Example 2:

        int turnedOn2 = 9;
        List<String>  output2= Arrays.asList();


        List<String>  ans1= readBinaryWatch(turnedOn1);
        List<String>  ans2= readBinaryWatch(turnedOn2);

        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ (output1));
            System.out.println("Your Output : "+ (ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }

    }
}
