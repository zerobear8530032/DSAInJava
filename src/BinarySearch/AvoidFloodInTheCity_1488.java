//1488. Avoid Flood in The City
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.
//
//Given an integer array rains where:
//
//rains[i] > 0 means there will be rains over the rains[i] lake.
//rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
//Return an array ans where:
//
//ans.length == rains.length
//ans[i] == -1 if rains[i] > 0.
//ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
//If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
//
//Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.
//
//
//
//Example 1:
//
//Input: rains = [1,2,3,4]
//Output: [-1,-1,-1,-1]
//Explanation: After the first day full lakes are [1]
//After the second day full lakes are [1,2]
//After the third day full lakes are [1,2,3]
//After the fourth day full lakes are [1,2,3,4]
//There's no day to dry any lake and there is no flood in any lake.
//Example 2:
//
//Input: rains = [1,2,0,0,2,1]
//Output: [-1,-1,2,1,-1,-1]
//Explanation: After the first day full lakes are [1]
//After the second day full lakes are [1,2]
//After the third day, we dry lake 2. Full lakes are [1]
//After the fourth day, we dry lake 1. There is no full lakes.
//After the fifth day, full lakes are [2].
//After the sixth day, full lakes are [1,2].
//It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
//Example 3:
//
//Input: rains = [1,2,0,1,2]
//Output: []
//Explanation: After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
//After that, it will rain over lakes [1,2]. It's easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
//
//
//Constraints:
//
//1 <= rains.length <= 105
//0 <= rains[i] <= 109

package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodInTheCity_1488 {
//     approch :
//     we have to find a lake which have rained twice and btw that ther eis a day in which we can dry it
//    if that possible we will do it other wise return emtpy array
//    time complexity : O(n  * log n)
//    space complexity : O(n)
    public  static int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> rainyDays = new HashMap<Integer,Integer>();
        TreeSet<Integer> dryDays = new TreeSet<Integer>();
        int [] output= new int [rains.length];
        for(int i =0;i<rains.length;i++){
            if(rains[i]!=0){
                if(rainyDays.containsKey(rains[i])){
                    int lastRainedDay = rainyDays.get(rains[i]);
                    Integer lastDryDay = dryDays.higher(lastRainedDay);
                    if(lastDryDay==null){
                        return new int [] {};
                    }else{
                        output[lastDryDay]= rains[i];
                        dryDays.remove(lastDryDay);
                        rainyDays.put(rains[i],i);
                        output[i]=-1;
                    }
                }else{
                    output[i]=-1;
                    rainyDays.put(rains[i],i);
                }
            }else{
                dryDays.add(i);
                output[i]=1;// by default we consider we will dry 1 lake for not
            }
        }
        return output;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] rains1 = {1,2,3,4};
        int [] output1 = {-1,-1,-1,-1};

        //Example 2:

        int [] rains2 = {1,2,0,0,2,1};
        int [] output2 = {-1,-1,2,1,-1,-1};

        //Example 3:

        int [] rains3 = {1,2,0,1,2};
        int [] output3 = {};

        int [] ans1  = avoidFlood(rains1);
        int [] ans2  = avoidFlood(rains2);
        int [] ans3  = avoidFlood(rains3);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output1));
            System.out.println("Your Answer :"+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output2));
            System.out.println("Your Answer :"+ Arrays.toString(ans2));
        }
        if(Arrays.equals(output3,ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output2));
            System.out.println("Your Answer :"+ Arrays.toString(ans3));
        }


    }
}
