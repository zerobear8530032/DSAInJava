//960. Delete Columns to Make Sorted III
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//You are given an array of n strings strs, all of the same length.
//
//We may choose any deletion indices, and we delete all the characters in those indices for each string.
//
//For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].
//
//Suppose we chose a set of deletion indices answer such that after deletions, the final array has every string (row) in lexicographic order. (i.e., (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]), and (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]), and so on). Return the minimum possible value of answer.length.
//
//
//
//Example 1:
//
//Input: strs = ["babca","bbazb"]
//Output: 3
//Explanation: After deleting columns 0, 1, and 4, the final array is strs = ["bc", "az"].
//Both these rows are individually in lexicographic order (ie. strs[0][0] <= strs[0][1] and strs[1][0] <= strs[1][1]).
//Note that strs[0] > strs[1] - the array strs is not necessarily in lexicographic order.
//Example 2:
//
//Input: strs = ["edcba"]
//Output: 4
//Explanation: If we delete less than 4 columns, the only row will not be lexicographically sorted.
//Example 3:
//
//Input: strs = ["ghi","def","abc"]
//Output: 0
//Explanation: All rows are already lexicographically sorted.
//
//
//Constraints:
//
//n == strs.length
//1 <= n <= 100
//1 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.
//
package DynamicProgramming;

public class DeleteColumnsToMakeSortedIII_960 {
//     approch: we can find LIS of each string column wise
//    and we will get the incrasing part then we can just remove
//    take difference between LIS and strs[0].length is our answer
//    time complexity : O(n * M^2)
//    space complexity : O(M^2)

    public  static int minDeletionSizeMemo(String[] strs) {
        Integer[][] memo = new Integer[strs[0].length()+1][strs[0].length()+1];
        return strs[0].length()-helperMemo(0,strs,-1,memo);
    }
    public static int helperMemo( int curr,String [] strs, int prev,Integer [][] memo){
        if(prev!=-1 && memo[curr][prev]!=null){
            return memo[curr][prev];
        }
        if(curr==strs[0].length()){
            return 0;
        }
        int res=0;
        boolean valid = true;
        for(String s:strs){
            if(prev==-1){continue;}
            valid = valid  && (s.charAt(prev)<= s.charAt(curr));
        }
        int take = 0;
        if(valid){
            take=helperMemo(curr+1,strs,curr,memo)+1;
        }
        int skip =helperMemo(curr+1,strs,prev,memo);
        int curr_res=Math.max(skip,take);
        res=Math.max(res,curr_res);
        if(prev!=-1){
            memo[curr][prev]=res;
        }
        return res;
    }

    //     approch: same approch just bottom up
//    and we will get the incrasing part then we can just remove
//    take difference between LIS and strs[0].length is our answer
//    time complexity : O(n * M^2)
//    space complexity : O(M^2)

    public static int minDeletionSizeBottomUp(String[] strs) {
        int [] table= new int [ strs[0].length()+1];
        int res=1;
        for(int i =0;i<table.length;i++){
            table[i]=1;
        }
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<i;j++){
                if(isIncreasing(strs, i, j)){
                    table[i]= Math.max(table[i],table[j]+1);
                    res=Math.max(table[i],res);
                }
            }
        }
        // System.out.println(res);
        return strs[0].length()-res;
    }

    public static boolean isIncreasing(String [] strs, int curr , int prev ){
        for(int i =0;i<strs.length;i++){
            if(strs[i].charAt(curr)<strs[i].charAt(prev)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        String [] strs1 = {"babca","bbazb"};
        int output1=3;

        //Example 2:

        String [] strs2 = {"edcba"};
        int output2=4;

        //Example 3:

        String [] strs3 = {"ghi","def","abc"};
        int output3=0;

        System.out.println("Memorize Approch :");
        int ans1= minDeletionSizeMemo(strs1);
        int ans2= minDeletionSizeMemo(strs2);
        int ans3= minDeletionSizeMemo(strs3);

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
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Bottom Up Approch :");
        ans1= minDeletionSizeBottomUp(strs1);
        ans2= minDeletionSizeBottomUp(strs2);
        ans3= minDeletionSizeBottomUp(strs3);

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
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
