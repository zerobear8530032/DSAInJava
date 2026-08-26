//Partition Into 2 Subsets with Min Sum Diff
//Solved
//Difficulty: HardAccuracy: 38.97%Submissions: 196K+Points: 8
//Given an array arr[]  containing non-negative integers, divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.
//
//Examples:
//
//Input: arr[] = [1, 6, 11, 5]
//Output: 1
//Explanation:
//Subset1 = [1, 5, 6], sum of Subset1 = 12
//Subset2 = [11], sum of Subset2 = 11
//Hence, minimum difference is 1.
//Input: arr[] = [1, 4]
//Output: 3
//Explanation:
//Subset1 = [1], sum of Subset1 = 1
//Subset2 = [4], sum of Subset2 = 4
//Hence, minimum difference is 3.
//Input: arr[] = [1]
//Output: 1
//Explanation:
//Subset1 = [1], sum of Subset1 = 1
//Subset2 = [], sum of Subset2 = 0
//Hence, minimum difference is 1.
//Constraints:
//1 ≤ arr.size()*|sum of array elements| ≤ 105
//1 ≤ arr[i] ≤ 105
package DynamicProgramming;

public class PartitionIntoTwoSubsetsWithMinSumDiff_GFG {
// approch: use  take not take approch
//    and use memorization
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int minDifference(int arr[]) {
        int sum=0;
        for(int x:arr){sum+=x;}
        Integer [][] memo = new Integer [arr.length+1][sum+1];
        return helper(arr,arr.length,0,sum,memo);
    }

    public static int helper(int [] arr , int n , int curr, int total, Integer [][] memo){
        if(memo[n][curr]!=null){return memo[n][curr];}
        if(n==0){
            return Math.abs((curr*2)-total);
        }
        int skip =helper(arr,n-1,curr,total,memo);
        int take =helper(arr,n-1,curr+arr[n-1],total,memo);
        int res=Math.min(take,skip);
        memo[n][curr]=res;
        return res;
    }

//    using top down dp:
//    here we can create a tablulation table where we find every single subset sum at
//    index we can get and at last row we can check which possible subset we can get and
//    by checking (sum of subset*2) - total and take min of that is our answer
//    time complexity : O(n*m)
//    space complexity : O(n*m)
public static int minDifferenceTopDown(int arr[]) {
    int sum =0;
    for(int x:arr){
        sum+=x;
    }
    Boolean [][] memo = new Boolean [arr.length+1][sum+1];
    for(int n =0;n<memo.length;n++){
        for(int s=0;s<memo[n].length;s++){
            if(s==0){
                memo[n][s]=true;
            }else if(n==0){
                memo[n][s]=false;
            }
        }
    }

    for(int n =1;n<memo.length;n++){
        for(int s=1;s<memo[n].length;s++){
            if(arr[n-1]<=s){
                boolean take =memo[n-1][s-arr[n-1]];
                boolean skip =memo[n-1][s];
                memo[n][s]=skip || take;
            }else{
                memo[n][s]= memo[n-1][s];
            }
        }
    }
    int row=memo.length-1;
    int res= Integer.MAX_VALUE;
    for(int col=0;col<memo[0].length;col++){
        if(memo[row][col]){
            res= Math.min(res,Math.abs(col*2-sum));
        }
    }

    return res;
}


    public static void main(String[] args) {
        //Examples:

        int [] arr1 = {1, 6, 11, 5};
        int output1= 1;

        int [] arr2 = {1, 4};
        int output2 =3;

        int [] arr3 = {1};
        int output3 =1;

        int ans1= minDifference(arr1);
        int ans2= minDifference(arr2);
        int ans3= minDifference(arr3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
