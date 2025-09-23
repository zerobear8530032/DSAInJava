//165. Compare Version Numbers
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
//
//To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
//
//Return the following:
//
//If version1 < version2, return -1.
//If version1 > version2, return 1.
//Otherwise, return 0.
//
//
//Example 1:
//
//Input: version1 = "1.2", version2 = "1.10"
//
//Output: -1
//
//Explanation:
//
//version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.
//
//Example 2:
//
//Input: version1 = "1.01", version2 = "1.001"
//
//Output: 0
//
//Explanation:
//
//Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
//
//Example 3:
//
//Input: version1 = "1.0", version2 = "1.0.0.0"
//
//Output: 0
//
//Explanation:
//
//version1 has less revisions, which means every missing revision are treated as "0".
//
//
//
//Constraints:
//
//1 <= version1.length, version2.length <= 500
//version1 and version2 only contain digits and '.'.
//version1 and version2 are valid version numbers.
//All the given revisions in version1 and version2 can be stored in a 32-bit integer.
package Strings;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers_165 {
//  brute force:
//  here before checking we will process the string
//  and convert it the the integer list which does not have any trailing zeros
//  and we will convert then to integer for easy comparision then we can compare the values
//  one thing to be assure we need to process it in reverse order cause the preprocess remove any revision from the right hand side which are zeros
//  that means we will get the version in revese order
//  rest is jjust comparing the revision one by one
//   time complexity ; O(n)
//   space complexity ; O(n)
    public static int compareVersionBruteForce(String version1, String version2) {
        String [] v1= version1.split("\\.");
        String [] v2= version2.split("\\.");
        List<Integer> v1processed= preprocess(v1);
        List<Integer> v2processed= preprocess(v2);
        int v1size= v1processed.size();
        int v2size= v2processed.size();
        int i=0;
        int idx1=v1size-1;
        int idx2=v2size-1;
        int upperbound = Math.max(v1size,v2size);
        while(i<upperbound){
            int v1r= 0;
            int v2r= 0;
            if(idx1>=0){
                v1r=v1processed.get(idx1);
                idx1--;
            }
            if(idx2>=0){
                v2r=v2processed.get(idx2);
                idx2--;
            }
            if(v1r<v2r){
                return -1;
            }else if(v1r>v2r){
                return 1;
            }
            i++;
        }
        return 0;
    }

    public static List<Integer> preprocess(String [] strs){
        List<Integer> res= new ArrayList<>();
        int idx=strs.length-1;
        while(idx>=0 && Integer.parseInt(strs[idx])==0){
            idx--;
        }
        while(idx>=0){
            res.add(Integer.parseInt(strs[idx]));
            idx--;
        }
        return res;
    }


//     approch :
//    here we done not create extra list or any thing
//    we can use 2 pointer one 1  v1 , one at v2
//    and make the revision on the go while also checking the  v1 < v2 || v2>v1 if any where its true we can
//    return -1,1 at the end 0
//   time complexity ; O(n)
//   space complexity ; O(n)
    public static int compareVersion(String version1, String version2) {
        int v1idx=0;
        int v2idx=0;
        int v1size= version1.length();
        int v2size= version2.length();
        while(v1idx<v1size || v2idx<v2size){
            int v1revision=0;
            int v2revision=0;
            if(v1idx<v1size){
                int num =0;
                while(v1idx<v1size && version1.charAt(v1idx)!='.'){
                    int digit = version1.charAt(v1idx)-'0';
                    num= num*10 + digit;
                    v1idx++;
                }
                v1idx++;// SKIP THE DOT
                v1revision=num;
            }
            if(v2idx<v2size){
                int num =0;
                while(v2idx<v2size && version2.charAt(v2idx)!='.'){
                    int digit = version2.charAt(v2idx)-'0';
                    num= num*10 + digit;
                    v2idx++;
                }
                v2idx++;// SKIP THE DOT
                v2revision=num;
            }

            if(v1revision<v2revision){
                return -1;
            }
            if(v1revision>v2revision){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        //Example 1:

        String version11 = "1.2", version12 = "1.10";
        int output1= -1;

        //Example 2:

        String version21 = "1.01", version22 = "1.0001";
        int output2= 0;

        //Example 3:

        String version31 = "1.0", version32 = "1.0.0.0";
        int output3= 0;

        //Example 4:

        String version41 = "1.0.0.1", version42 = "1.0";
        int output4= 1;

        int ans1=compareVersionBruteForce(version11,version12);
        int ans2=compareVersionBruteForce(version21,version22);
        int ans3=compareVersionBruteForce(version41,version32);
        int ans4=compareVersionBruteForce(version41,version42);

        System.out.println("Brute Force Approch :");

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4==ans4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }

        ans1=compareVersion(version11,version12);
        ans2=compareVersion(version21,version22);
        ans3=compareVersion(version41,version32);
        ans4=compareVersion(version41,version42);

        System.out.println("Better Approch :");

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4==ans4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }




    }
}
