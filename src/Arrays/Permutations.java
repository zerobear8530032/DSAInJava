package Arrays;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, result);
        
        // Print all permutations
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static void generatePermutations(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Swap current index with i
            swap(nums, index, i);
            // Recurse for the next index
            generatePermutations(nums, index + 1, result);
            // Backtrack (undo the swap)
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
