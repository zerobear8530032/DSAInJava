//875. Koko Eating Bananas
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//
//
//
//Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//Output: 4
//Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
//Example 3:
//
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
//
//
//Constraints:
//
//1 <= piles.length <= 104
//piles.length <= h <= 109
//1 <= piles[i] <= 109
package BinarySearch;

public class KokoEatingBananas_875 {
//    approch : apply binary search :
//    we can check at most  we can eat max of piles number of bana in an hr
//    and min we can have 1 bana in 1 hr
//    so we can apply binary search in this range and try to find left side is we can eat all banana
//    other wise we cn search in right side
//    at the end we will return start because start is where we can eat the banans in mid time
//    time complexity : O(n* log n)
//    time complexity : O(1)
    public static int minEatingSpeed(int[] piles,int h) {
        int start=1;
        int end =0;
        for(int x:piles){
            end= Math.max(end,x);
        }
        while(start<=end){
            int mid= start+(end-start)/2;
            if(canEat(piles,mid,h)){
                // System.out.println("can eat"+mid);
                end=mid-1;
            }else{
                // System.out.println("cannot eat"+mid);
                start=mid+1;
            }
        }
        return start;
    }

    public static boolean canEat(int [] piles , long rate, long hrs){
        long totalTime =0;
        for(int x:piles){
            long time = x/rate;
            if(x%rate!=0){
                time+=1;
            }
            totalTime+=time;
        }
        return totalTime<=hrs;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] piles1 = {3,6,7,11};
        int h1 = 8;
        int output1= 4;

        //Example 2:

        int [] piles2 = {30,11,23,20};
        int h2 = 5;
        int output2= 30;

        //Example 3:

        int [] piles3 = {30,11,23,20};
        int h3 = 6;
        int output3= 30;


        int ans1 =
    }
}
