//1935. Maximum Number of Words You Can Type
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
//
//Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
//
//
//
//Example 1:
//
//Input: text = "hello world", brokenLetters = "ad"
//Output: 1
//Explanation: We cannot type "world" because the 'd' key is broken.
//Example 2:
//
//Input: text = "leet code", brokenLetters = "lt"
//Output: 1
//Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
//Example 3:
//
//Input: text = "leet code", brokenLetters = "e"
//Output: 0
//Explanation: We cannot type either word because the 'e' key is broken.
//
//
//Constraints:
//
//1 <= text.length <= 104
//0 <= brokenLetters.length <= 26
//text consists of words separated by a single space without any leading or trailing spaces.
//Each word only consists of lowercase English letters.
//brokenLetters consists of distinct lowercase English letters.

package Arrays;

import java.util.HashSet;

public class MaximumNumberOfWordsYouCanType_1935 {
//    approch check for every stirng it contains any broken key
//    time complexity : O(n)
//    space complexity : O(n) //split of stirng will create a array of strings
    public static int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> brokenKeys = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            brokenKeys.add(brokenLetters.charAt(i));
        }
        int count = 0;
        int idx = 0;
        while (idx < text.length()) {
            boolean cantype = true;
            while (idx < text.length() && text.charAt(idx) != ' ') {
                if (brokenKeys.contains(text.charAt(idx))) {
                    cantype = false;
                }
                idx++;
            }
            if (cantype) {
                count++;
            }
            idx++;
        }
        return count;
    }

// better approch:
// here we  just do same thing as above but here we skip spaces and does not break the string to not create extra objects
//    time complexity : O(n)
//    space complexity : O(1)
//  another optimization above this is that  we can use a integer of 32 bit to mark the letters of alphabet
//
    public static int canBeTypedWordsBetter(String text, String brokenLetters) {
        HashSet<Character> brokenKeys= new HashSet();
        for(int i =0;i<brokenLetters.length();i++){
            brokenKeys.add(brokenLetters.charAt(i));
        }
        int count =0;
        int idx=0;
        while(idx<text.length()){
            boolean cantype=true;
            while(idx<text.length() && text.charAt(idx)!=' '){
                if(brokenKeys.contains(text.charAt(idx))){
                    cantype=false;
                }
                idx++;
            }
            if(cantype){
                count++;
            }
            idx++;
        }

        return count;
    }

    public static void main(String[] args) {
        //Example 1:

        String text1 = "hello world", brokenLetters1 = "ad";
        int output1=1;

        //Example 2:

        String text2 = "leet code", brokenLetters2 = "lt";
        int output2=1;

        //Example 3:

        String text3 = "leet code", brokenLetters3 = "e";
        int output3=0;

        int ans1= canBeTypedWords(text1,brokenLetters1);
        int ans2= canBeTypedWords(text2,brokenLetters2);
        int ans3= canBeTypedWords(text3,brokenLetters3);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

        System.out.println("Better  Approch :");

        ans1= canBeTypedWordsBetter(text1,brokenLetters1);
        ans2= canBeTypedWordsBetter(text2,brokenLetters2);
        ans3= canBeTypedWordsBetter(text3,brokenLetters3);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }



    }
}
