package DynamicProgramming;

public class PrintLongestCommonSubsequence {
//    approch : simple lcs code where instead of increasing size +1 just appnd the character and store output as string
    // time complexity : O(n*m)
    // space complexity : O(n*m)
    public static String printLCSMemo(String s1, String s2){
        String [][] memo = new String[s1.length()+1][s2.length()+1];
        return helper(s1,s2,s1.length(),s2.length(),memo);
    }

    public static String helper(String s1, String s2, int n1 , int n2,String [][] memo){
        if(memo[n1][n2]!=null){
            return  memo[n1][n2];
        }
        if(n1 ==0 || n2==0) {
            return "";
        }
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            String res= helper(s1,s2,n1-1,n2-1,memo)+ s1.charAt(n1-1);
            memo[n1][n2]= res;
            return res;
        }else{
            String reduceLeft= helper(s1,s2,n1-1,n2,memo);
            String reduceRight= helper(s1,s2,n1,n2-1,memo);
            if(reduceLeft.length()<reduceRight.length()){
            memo[n1][n2]= reduceRight;
                return reduceRight;
            }else{
            memo[n1][n2]= reduceLeft;
                return reduceLeft;
            }
        }

    }


    //    approch :convert above to tabulation
    // time complexity : O(n*m)
    // space complexity : O(n*m* min(n,m))
    public static String printLCSTabulation(String s1, String s2){
        String [][] dp = new String[s1.length()+1][s2.length()+1];
        for(int n1=0;n1<dp.length;n1++){
            for (int n2 = 0; n2 <dp[n1].length ; n2++) {
                if (n1 == 0 || n2 == 0) {
                    dp[n1][n2] = "";
                }
            }
        }
        for(int n1=1;n1<dp.length;n1++){
            for (int n2 = 1; n2 <dp[n1].length ; n2++) {
               if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                   dp[n1][n2]= dp[n1-1][n2-1]+s1.charAt(n1-1);
               }else{
                   String reduceLeft= dp[n1-1][n2];
                   String reduceRight= dp[n1][n2-1];
                   if(reduceLeft.length()<reduceRight.length()){
                       dp[n1][n2]=reduceRight;
                   }else{
                       dp[n1][n2]=reduceLeft;
                   }
               }
            }
        }
        return dp[s1.length()][s2.length()];
    }
//approch : here we first create a lcs length table then reverse trace back our step to build the lcs
//    time complexity : O(n*m)
//    space complexity : O(n*m)
     public  static  String printLCSOptimize(String s1, String s2){
        StringBuilder res= new StringBuilder();
        Integer[][] dp= new Integer[s1.length()+1][s2.length()+1];
         for(int n1=0;n1<dp.length;n1++){
             for (int n2 = 0; n2 <dp[n1].length ; n2++) {
                 if(n1==0 || n2==0){
                     dp[n1][n2]=0;
                 }
             }
         }
         for(int n1=1;n1<dp.length;n1++){
             for (int n2 = 1; n2 <dp[n1].length ; n2++) {
                 if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                     dp[n1][n2]= dp[n1-1][n2-1]+1;
                 }else{
                     dp[n1][n2]= Math.max(dp[n1-1][n2],dp[n1][n2-1]);
                 }
             }
         }

         int n1=s1.length();
         int n2=s2.length();
         while(n1>0 && n2>0){
             if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                 res.append(s1.charAt(n1-1));
                 n1--;
                 n2--;
             }else{
                 if(dp[n1][n2-1]>dp[n1-1][n2]){
                     n2--;
                 }else {
                     n1--;
                 }
             }
         }
        return res.reverse().toString();
     }

    public static void main(String[] args) {
        String x1 = "GeeksforGeeks";
        String y1 = "GeeksQuiz";
        String output1= "Geeks";

        String x2 = "zxabcdezy";
        String y2 = "yzabcdezx";
        String output2= "zabcdez";

        String ans1= printLCSMemo(x1,y1);
        String ans2= printLCSMemo(x2,y2);


        System.out.println("Top Down approch :");

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }

        System.out.println("Bottom Up Tabulation approch :");
        ans1= printLCSTabulation(x1,y1);
        ans2= printLCSTabulation(x2,y2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        System.out.println("Bottom Up Optimize approch :");
        ans1= printLCSOptimize(x1,y1);
        ans2= printLCSOptimize(x2,y2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }

    }
}
