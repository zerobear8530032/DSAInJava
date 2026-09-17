// 139. Word Break
// Solved
// Medium
// Topics
// Companies
//
// Given a string s and a dictionary of strings wordDict, return true if s
// can be segmented into a space-separated sequence of one or more dictionary words.
//
// The same word may be reused multiple times.
//
// Example 1:
// s = "neetcode", wordDict = ["neet","code"]
// Output = true
//
// Example 2:
// s = "applepenapple", wordDict = ["apple","pen","ape"]
// Output = true
//
// Example 3:
// s = "catsincars", wordDict = ["cats","cat","sin","in","car"]
// Output = false

package DynamicProgramming;

public class WordBreak_139 {


// approach :
//    initially we can think of this as a backtracking problem.
//    from every index we try every word from the dictionary.
//    if a word matches at the current index, we move forward by its length.
//
//    however, the same index can be reached through different paths.
//    therefore the remaining problem is the same whenever we reach the
//    same index.
//
//    so we can memorize the answer for every index.
//
//    dp/index represents:
//    "can the substring starting from this index be segmented?"
//
//    time complexity : O(n * m * k)
//    space complexity : O(n)
//
//    n = length of string
//    m = number of words in dictionary
//    k = maximum length of a dictionary word

    public static boolean wordBreakMemo(
            String s,
            java.util.List<String> dict) {

        Boolean[] memo = new Boolean[s.length() + 1];

        return helper(s, 0, dict, memo);
    }


    public static boolean helper(
            String s,
            int idx,
            java.util.List<String> dict,
            Boolean[] memo) {

        // already solved this state
        if (memo[idx] != null) {
            return memo[idx];
        }

        // successfully consumed the entire string
        if (idx == s.length()) {
            return true;
        }

        boolean ans = false;

        // try every dictionary word
        for (String w : dict) {

            // word must start at current index
            if (s.startsWith(w, idx)) {

                // solve the remaining substring
                ans |= helper(
                        s,
                        idx + w.length(),
                        dict,
                        memo
                );
            }
        }

        memo[idx] = ans;

        return ans;
    }


// approach :
//    we can convert the above recursive memoization into bottom-up DP.
//
//    top-down state:
//    helper(idx)
//    = can s[idx...n-1] be segmented?
//
//    for bottom-up, we instead define:
//
//    dp[i]
//    = can the prefix s[0...i-1] be segmented?
//
//    dp[0] = true because an empty prefix is considered valid.
//
//    for every position i, we try every dictionary word.
//    if the word ends at i and the prefix before that word is valid,
//    then the current prefix is also valid.
//
//    transition:
//
//    dp[i] = dp[i - word.length()]
//
//    when word matches the substring ending at i.
//
//    time complexity : O(n * m * k)
//    space complexity : O(n)

    public static boolean wordBreakTopDown(
            String s,
            java.util.List<String> dict) {

        Boolean[] dp = new Boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {

            boolean res = false;

            for (String w : dict) {

                // word cannot be longer than current prefix
                if (w.length() <= i
                        && s.startsWith(w, i - w.length())) {

                    res |= dp[i - w.length()];
                }
            }

            dp[i] = res;
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {

        // Example 1

        String s1 = "neetcode";

        java.util.List<String> dict1 =
                java.util.Arrays.asList(
                        "neet",
                        "code"
                );

        boolean output1 = true;


        // Example 2

        String s2 = "applepenapple";

        java.util.List<String> dict2 =
                java.util.Arrays.asList(
                        "apple",
                        "pen",
                        "ape"
                );

        boolean output2 = true;


        // Example 3

        String s3 = "catsincars";

        java.util.List<String> dict3 =
                java.util.Arrays.asList(
                        "cats",
                        "cat",
                        "sin",
                        "in",
                        "car"
                );

        boolean output3 = false;


        System.out.println("Recursive Memorization Solution:");

        boolean ans1 =
                wordBreakMemo(s1, dict1);

        boolean ans2 =
                wordBreakMemo(s2, dict2);

        boolean ans3 =
                wordBreakMemo(s3, dict3);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }


        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }


        System.out.println("Bottom Up Solution:");

        ans1 =
                wordBreakTopDown(s1, dict1);

        ans2 =
                wordBreakTopDown(s2, dict2);

        ans3 =
                wordBreakTopDown(s3, dict3);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }


        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }
    }
}