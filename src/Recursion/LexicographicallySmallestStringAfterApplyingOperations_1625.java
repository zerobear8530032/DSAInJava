//1625. Lexicographically Smallest String After Applying Operations
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.
//
//You can apply either of the following two operations any number of times and in any order on s:
//
//Add a to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456" and a = 5, s becomes "3951".
//Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".
//Return the lexicographically smallest string you can obtain by applying the above operations any number of times on s.
//
//A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "0158" is lexicographically smaller than "0190" because the first position they differ is at the third letter, and '5' comes before '9'.
//
//
//
//Example 1:
//
//Input: s = "5525", a = 9, b = 2
//Output: "2050"
//Explanation: We can apply the following operations:
//Start:  "5525"
//Rotate: "2555"
//Add:    "2454"
//Add:    "2353"
//Rotate: "5323"
//Add:    "5222"
//Add:    "5121"
//Rotate: "2151"
//Add:    "2050"​​​​​
//There is no way to obtain a string that is lexicographically smaller than "2050".
//Example 2:
//
//Input: s = "74", a = 5, b = 1
//Output: "24"
//Explanation: We can apply the following operations:
//Start:  "74"
//Rotate: "47"
//​​​​​​​Add:    "42"
//​​​​​​​Rotate: "24"​​​​​​​​​​​​
//There is no way to obtain a string that is lexicographically smaller than "24".
//Example 3:
//
//Input: s = "0011", a = 4, b = 2
//Output: "0011"
//Explanation: There are no sequence of operations that will give us a lexicographically smaller string than "0011".
//
//
//Constraints:
//
//2 <= s.length <= 100
//s.length is even.
//s consists of digits from 0 to 9 only.
//1 <= a <= 9
//1 <= b <= s.length - 1

package Recursion;

public class LexicographicallySmallestStringAfterApplyingOperations_1625 {
    public static String findLexSmallestString(String s, int a, int b) {
        String minstr = applyAddition(s,a);
        if(b%2==0){
            return applyRotate(minstr,b);
        }
        for(int i =0;i<s.length()/b;i++){
            s=rotateString(s,b);
            String addition = applyAddition(s,a);
            String rotation=applyRotate(addition,b);
            if(minstr.compareTo(rotation)>0){
                minstr=rotation;
            }
        }
        return minstr;
    }

    public static String rotateString(String str, int b){
        return str.substring(b)+str.substring(0,b);
    }
    public static String applyAddition(String str, int a){
        String smalleststr= str;
        char [] charstr= str.toCharArray();
        for(int i =1;i<10;i++){
            StringBuilder processed= new StringBuilder();
            for(int idx=0;idx+1<charstr.length;idx+=2){
                int num= charstr[idx+1]-'0';
                num= (num+(i*a))%10;
                processed.append(charstr[idx]);
                processed.append(num);
            }
            String afterprocess= processed.toString();
            if(smalleststr.compareTo(afterprocess)>0){
                smalleststr=afterprocess;
            }
        }
        return smalleststr;
    }
    public static String applyRotate(String str, int b){
        int idx =0;
        String smallest = str.substring(0,b);
        for(int i=b;i<str.length();i+=b){
            int m = Math.min(str.length(),b+i);
            String substr= str.substring(i,m);
            if(smallest.compareTo(substr)>0){
                smallest=substr;
                idx=i;
            }
        }
        String head= str.substring(idx,str.length());
        String tail= str.substring(0,idx);
        return head+tail;
    }

    public static void main(String[] args) {
        //Example 1:

        String s1 = "5525";
        int a1 = 9, b1 = 2;
        String output1= "2050";

        //Example 2:

        String s2 = "74";
        int a2 = 5, b2 = 1;
        String output2= "24";

        //Example 3:

        String s3 = "0011";
        int a3 = 4, b3 = 2;
        String output3= "0011";

        //Example 4:

        String s4 = "43987654";
        int a4 = 7, b4 = 3;
        String output4= "00553311";

        String ans1= findLexSmallestString(s1,a1,b1);
        String ans2= findLexSmallestString(s2,a2,b2);
        String ans3= findLexSmallestString(s3,a3,b3);
        String ans4= findLexSmallestString(s4,a4,b4);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);

    }
}
