//744. Find Smallest Letter Greater Than Target
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
//
//Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//
//
//
//Example 1:
//
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
//Example 2:
//
//Input: letters = ["c","f","j"], target = "c"
//Output: "f"
//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
//Example 3:
//
//Input: letters = ["x","x","y","y"], target = "z"
//Output: "x"
//Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
//
//
//Constraints:
//
//2 <= letters.length <= 104
//letters[i] is a lowercase English letter.
//letters is sorted in non-decreasing order.
//letters contains at least two different characters.
//target is a lowercase English letter.
package BinarySearch;

public class FindSmallestLetterGreaterThanTarget_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int s=0;
        int e=letters.length-1;
        char res=letters[0];
        while(s<=e){
            int mid = (s+e)/2;
            if(letters[mid]<=target){
                s=mid+1;
            }else{
                res=letters[mid];
                e=mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        char [] letters1 = {'c','f','j'};
        char target1 = 'a';
        char output1= 'c';

        //Example 2:

        char [] letters2 = {'c','f','j'};
        char target2 = 'c';
        char output2= 'f';

        //Example 3:

        char [] letters3 = {'x','x','y','y'};
        char target3 = 'z';
        char output3 = 'x';

        char ans1= nextGreatestLetter(letters1,target1);
        char ans2= nextGreatestLetter(letters2,target2);
        char ans3= nextGreatestLetter(letters3,target3);

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
    }
}
