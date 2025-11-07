//2528. Maximize the Minimum Powered City
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed integer array stations of length n, where stations[i] represents the number of power stations in the ith city.
//
//Each power station can provide power to every city in a fixed range. In other words, if the range is denoted by r, then a power station at city i can provide power to all cities j such that |i - j| <= r and 0 <= i, j <= n - 1.
//
//Note that |x| denotes absolute value. For example, |7 - 5| = 2 and |3 - 10| = 7.
//The power of a city is the total number of power stations it is being provided power from.
//
//The government has sanctioned building k more power stations, each of which can be built in any city, and have the same range as the pre-existing ones.
//
//Given the two integers r and k, return the maximum possible minimum power of a city, if the additional power stations are built optimally.
//
//Note that you can build the k power stations in multiple cities.
//
//
//
//Example 1:
//
//Input: stations = [1,2,4,5,0], r = 1, k = 2
//Output: 5
//Explanation:
//One of the optimal ways is to install both the power stations at city 1.
//So stations will become [1,4,4,5,0].
//- City 0 is provided by 1 + 4 = 5 power stations.
//- City 1 is provided by 1 + 4 + 4 = 9 power stations.
//- City 2 is provided by 4 + 4 + 5 = 13 power stations.
//- City 3 is provided by 5 + 4 = 9 power stations.
//- City 4 is provided by 5 + 0 = 5 power stations.
//So the minimum power of a city is 5.
//Since it is not possible to obtain a larger power, we return 5.
//Example 2:
//
//Input: stations = [4,4,4,4], r = 0, k = 3
//Output: 4
//Explanation:
//It can be proved that we cannot make the minimum power of a city greater than 4.
//
//
//Constraints:
//
//n == stations.length
//1 <= n <= 105
//0 <= stations[i] <= 105
//0 <= r <= n - 1
//0 <= k <= 109
package prefixSum;

import java.util.Arrays;

public class MaximizeTheMinimumPoweredCity_2528 {
    public static long maxPower(int[] stations, int r, int k) {
        int [] diff= new int [stations.length+1];
        long high= 0;
        for(int i =0;i<stations.length;i++){
            high+=stations[i];
            int left = Math.max((i-r),0);
            int right = Math.min(diff.length-1,(i+r+1));
            System.out.println(left+"  "+right+" "+i);
            diff[left]+= stations[i];
            if(right<diff.length){
                diff[right]+= -stations[i];
            }
        }
        int sum =0;
        long low =Integer.MAX_VALUE;
        high= high+k;
        for(int i=0;i<diff.length;i++) {
            sum += diff[i];
            diff[i] = sum;
            low = Math.min(sum, low);
        }
        long res=low;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(canProduce(mid,diff,k,r)){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }

    public static boolean canProduce(long target, int [] arr, int currk , int range){
        int [] diff= Arrays.copyOfRange(arr,0,arr.length);
        int remaining= currk;
        int totalPower=0;
        for(int i =0;i<diff.length-1;i++){
            totalPower+= diff[i];
            if(totalPower<target){
                long required= target-totalPower;
                if(remaining<required){
                    return false;
                }
                remaining -= required;
                int end = Math.min(diff.length-1,i+range*2+1);
                diff[end]-=required;
                totalPower+=required;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] stations1 = {1,2,4,5,0};
        int r1 = 1, k1 = 2;
        int output1= 5;

        //Example 2:

        int [] stations2 = {4,4,4,4};
        int r2 = 0, k2 = 3;
        int output2= 4;

        long ans1 = maxPower(stations1,r1,k1);
        long ans2 = maxPower(stations2,r2,k2);


    }
}
