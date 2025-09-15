package DynamicProgramming.learning;

import java.util.HashMap;

public class countConstructTabulation {
    public static int countConstruct(String target, String[] words) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;// for null string take nothing
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                for (String word : words) {
//                    this will check it startwith word where it check from i
                    if (target.startsWith(word,i)) {
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args) {
        String target1 = "purple";
        String[] strs1 = {"purp", "p", "ur", "le", "purpl"};

        String target2 = "abcdef";
        String[] strs2 = {"ab", "abc", "cd", "def", "abcd"};

        String target3 = "skateboard";
        String[] strs3 = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};

        String target4 = "enterapotentpot";
        String[] strs4 = {"a", "p", "ent", "enter", "ot", "o", "t"};

        String target5 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] strs5 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"};

        System.out.println(countConstruct(target1, strs1));
        System.out.println(countConstruct(target2, strs2));
        System.out.println(countConstruct(target3, strs3));
        System.out.println(countConstruct(target4, strs4));
        System.out.println(countConstruct(target5, strs5));
    }
}
