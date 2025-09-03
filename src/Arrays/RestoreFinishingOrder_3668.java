//3668. Restore Finishing Order
//Easy
//3 pt.
//You are given an integer array order of length n and an integer array friends.
//
//order contains every integer from 1 to n exactly once, representing the IDs of the participants of a race in their finishing order.
//friends contains the IDs of your friends in the race sorted in strictly increasing order. Each ID in friends is guaranteed to appear in the order array.
//Return an array containing your friends' IDs in their finishing order.
//
//
//
//Example 1:
//
//Input: order = [3,1,2,5,4], friends = [1,3,4]
//
//Output: [3,1,4]
//
//Explanation:
//
//The finishing order is [3, 1, 2, 5, 4]. Therefore, the finishing order of your friends is [3, 1, 4].
//
//Example 2:
//
//Input: order = [1,4,5,3,2], friends = [2,5]
//
//Output: [5,2]
//
//Explanation:
//
//The finishing order is [1, 4, 5, 3, 2]. Therefore, the finishing order of your friends is [5, 2].
//
//
//
//Constraints:
//
//1 <= n == order.length <= 100
//order contains every integer from 1 to n exactly once
//1 <= friends.length <= min(8, n)
//1 <= friends[i] <= n
//friends is strictly increasing

package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class RestoreFinishingOrder_3668 {
//    approch : here we can search from order in friends using binary search \
//    time complexity : O(order * log freinds)
//    space complexity : O(1)
    public static int[] recoverOrderBetterSpace(int[] order, int[] friends) {
        int [] res= new int [friends.length];
        int idx=0;
        for(int x:order){
            if(binarySearch(x,friends)){
                res[idx]=x;
                idx++;
            }
        }
        return res;
    }
    public static boolean binarySearch(int target, int[] arr){
        int s=0;
        int e= arr.length-1;
        while(s<=e){
            int m= s+(e-s)/2;
            if(arr[m]==target){
                return true;
            }else if(arr[m]<target){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return false;
    }
//     approch: using hashset we can look up in O(1)
//    so we can collect friends and check it position in order
//    time complexity : O(n)
//    space complexity : O(friends.length)
    public static int[] recoverOrderBetterTime(int[] order, int[] friends) {
        HashSet<Integer> friendSet= new HashSet<>();
        for(int x:friends){
            friendSet.add(x);
        }
        int [] res= new int [friends.length];
        int idx=0;
        for(int x:order){
            if(friendSet.contains(x)){
                res[idx]=x;
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        //Example 1:

        int [] order1 = {3,1,2,5,4}, friends1 = {1,3,4};
        int [] output1= {3,1,4};

        //Example 2:

        int [] order2 = {1,4,5,3,2}, friends2 = {2,5};
        int [] output2={5,2};

        System.out.println("Better Space Method :");
        int []ans1= recoverOrderBetterSpace(order1,friends1);
        int []ans2= recoverOrderBetterSpace(order2,friends2);

        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }

        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }
        System.out.println("Better Time Method :");
        ans1= recoverOrderBetterTime(order1,friends1);
        ans2= recoverOrderBetterTime(order2,friends2);

        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }



    }
}
