//1079. Letter Tile Possibilities
//Medium
//Topics
//Companies
//Hint
//You have n  tiles, where each tile has one letter tiles[i] printed on it.
//
//Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
//
// 
//
//Example 1:
//
//Input: tiles = "AAB"
//Output: 8
//Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
//Example 2:
//
//Input: tiles = "AAABBC"
//Output: 188
//Example 3:
//
//Input: tiles = "V"
//Output: 1
// 
//
//Constraints:
//
//1 <= tiles.length <= 7
//tiles consists of uppercase English letters.


package Recursion;

import java.util.HashSet;
public class LetterTilePossibilities_1079 {

    public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }
        return backtrack(freq);
    }

    private static int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            count++;
            freq[i]--;
            count += backtrack(freq);  // recursive call
            freq[i]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));     // 8
        System.out.println(numTilePossibilities("AAABBC"));  // 188
        System.out.println(numTilePossibilities("V"));       // 1
    }
}

