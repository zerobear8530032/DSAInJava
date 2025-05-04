//556. Next Greater Element III
//Solved
//Medium
//Topics
//Companies
//Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
//
//Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
//
// 
//
//Example 1:
//
//Input: n = 12
//Output: 21
//Example 2:
//
//Input: n = 21
//Output: -1
// 
//
//Constraints:
//
//1 <= n <= 231 - 1



package Maths;

public class NextGreaterElementIII_556 {
//	approch:
//	first go from right to left until the desceneding order does not break
// if it goes till end of num   means number cannot be more greater
//	other wise get swap the just greater element with number at where descending order breat'
//	now just reverse entire array from swapped number index +1 till end
//	time complexity : O(n)
	public static int nextGreaterElement(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int i = chars.length - 2;

        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i < 0) return -1; // Entire number is descending, no greater number possible

        // Step 2: Find the next greater digit to swap with chars[i]
        int j = chars.length - 1;
        while (j >= 0 && chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap them
        swap(chars, i, j);

        // Step 4: Reverse the rest (from i+1 to end)
        reverse(chars, i + 1, chars.length - 1);

        try {
            long val = Long.parseLong(new String(chars));
            return (val > Integer.MAX_VALUE) ? -1 : (int) val;
        } catch (Exception ex) {
            return -1;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
	

	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 12;
		int output1=21;
		
		//Example 2:

		int n2 = 21;
		int output2=-1;
		
		//Example 3:
		
		int n3 = 3432765;
		int output3=3435267;
		
		


		int ans1=nextGreaterElement(n1);
		int ans2=nextGreaterElement(n2);
		int ans3=nextGreaterElement(n3);
		
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
