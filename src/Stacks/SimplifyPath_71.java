//71. Simplify Path
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
//
//The rules of a Unix-style file system are as follows:
//
//A single period '.' represents the current directory.
//A double period '..' represents the previous/parent directory.
//Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
//Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
//The simplified canonical path should follow these rules:
//
//The path must start with a single slash '/'.
//Directories within the path must be separated by exactly one slash '/'.
//The path must not end with a slash '/', unless it is the root directory.
//The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
//Return the simplified canonical path.
//
//
//
//Example 1:
//
//Input: path = "/home/"
//
//Output: "/home"
//
//Explanation:
//
//The trailing slash should be removed.
//
//Example 2:
//
//Input: path = "/home//foo/"
//
//Output: "/home/foo"
//
//Explanation:
//
//Multiple consecutive slashes are replaced by a single one.
//
//Example 3:
//
//Input: path = "/home/user/Documents/../Pictures"
//
//Output: "/home/user/Pictures"
//
//Explanation:
//
//A double period ".." refers to the directory up a level (the parent directory).
//
//Example 4:
//
//Input: path = "/../"
//
//Output: "/"
//
//Explanation:
//
//Going one level up from the root directory is not possible.
//
//Example 5:
//
//Input: path = "/.../a/../b/c/../d/./"
//
//Output: "/.../b/d"
//
//Explanation:
//
//"..." is a valid name for a directory in this problem.
//
//
//
//Constraints:
//
//1 <= path.length <= 3000
//path consists of English letters, digits, period '.', slash '/' or '_'.
//path is a valid absolute Unix path.
package Stacks;

import java.util.Stack;

public class SimplifyPath_71 {
//    approch :
//    split the path using /
//    now every / becomes qmpty string so we can skip those
//    every .. means we can pop the current dir name if present
//    rest every thing can be push in stack
//    at the end just reverse every thing create a answer
//    by appending / on it
//    time complexity : O(n)
//    space complexity : O(n)
    public static String simplifyPath(String path) {
        String [] tokens= path.split("/");
        Stack<String> stk = new Stack<>();
        for(String token:tokens){
            token=token.trim();
            if(token.equals("") || token.equals(".")){
                continue;
            }else{
                if(token.equals("..")){
                    if(!stk.isEmpty()){stk.pop();}
                }else{
                    stk.push(token);
                }
            }
        }
        String [] data= new String[stk.size()];
        int i = data.length-1;
        while(!stk.isEmpty()){
            data[i--]=stk.pop();
        }
        StringBuilder res= new StringBuilder("/");
        for(i =0;i<data.length;i++){
            if(i==data.length-1){
                res.append(data[data.length-1]);
            }else{
                res.append(data[i]).append("/");
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String path1 = "/home/";
        String output1= "/home";

        //Example 2:

        String path2 = "/home//foo/";
        String output2= "/home/foo";

        //Example 3:

        String path3 = "/home/user/Documents/../Pictures";
        String output3= "/home/user/Pictures";

        //Example 4:

        String path4 = "/../";
        String output4= "/";

        //Example 5:

        String path5 = "/.../a/../b/c/../d/./";
        String output5= "/.../b/d";

        String ans1 = simplifyPath(path1);
        String ans2 = simplifyPath(path2);
        String ans3 = simplifyPath(path3);
        String ans4 = simplifyPath(path4);
        String ans5 = simplifyPath(path5);

        if (output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
        if (output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
        if (output4.equals(ans4)) {
            System.out.println("Case 4 Passed");
        } else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :" + output4);
            System.out.println("Your Output :" + ans4);
        }
        if (output5.equals(ans5) ) {
            System.out.println("Case 5 Passed");
        } else {
            System.out.println("Case 5 Failed");
            System.out.println("Actual Output :" + output4);
            System.out.println("Your Output :" + ans4);
        }

    }
}
