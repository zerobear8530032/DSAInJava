package Arrays;

public class NumberOfZeroFilledSubarrays_2348 {

//     approch :
//    here we just find consicutive groups and take sum of n natrual number of each size group
//    and just sum all that
//     why it works
//     because if arr= [0,0,0,1,0,0]
//    here if we consider sub array [0,0,0]
//     this first 0 can come in 3 different sub arrays
//    [0,0,0]
//    [0,0]
//    [0]
//    so for each zero it can comes times of how much its conscutive groups it
//    so we just take  sum of natural number till group size and return sum of all of that
//    time complexity : O(n)
//    space complexity : O(1)
    public long zeroFilledSubarray(int[] nums) {
        long res=0;
        int i =0;
        while(i<nums.length){
            int zerocount =0;
            while(i<nums.length && nums[i]==0){
                zerocount++;
                i++;
            }
            res+=sumN(zerocount);
            while(i<nums.length && nums[i]!=0){
                zerocount++;
                i++;
            }
        }
        return res;
    }

    public long sumN(long n){
        return (n*(n+1))/2;
    }
}
