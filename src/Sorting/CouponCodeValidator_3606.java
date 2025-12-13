//3606. Coupon Code Validator
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:
//
//code[i]: a string representing the coupon identifier.
//businessLine[i]: a string denoting the business category of the coupon.
//isActive[i]: a boolean indicating whether the coupon is currently active.
//A coupon is considered valid if all of the following conditions hold:
//
//code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
//businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
//isActive[i] is true.
//Return an array of the codes of all valid coupons, sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and then by code in lexicographical (ascending) order within each category.
//
//
//
//Example 1:
//
//Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]
//
//Output: ["PHARMA5","SAVE20"]
//
//Explanation:
//
//First coupon is valid.
//Second coupon has empty code (invalid).
//Third coupon is valid.
//Fourth coupon has special character @ (invalid).
//Example 2:
//
//Input: code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]
//
//Output: ["ELECTRONICS_50"]
//
//Explanation:
//
//First coupon is inactive (invalid).
//Second coupon is valid.
//Third coupon has invalid business line (invalid).
//
//
//Constraints:
//
//n == code.length == businessLine.length == isActive.length
//1 <= n <= 100
//0 <= code[i].length, businessLine[i].length <= 100
//code[i] and businessLine[i] consist of printable ASCII characters.
//isActive[i] is either true or false.
package Sorting;

import java.util.*;

public class CouponCodeValidator_3606 {
    static class Entry{
        String code;
        String category;

        public Entry(String code , String category){
            this.code=code;
            this.category=category;
        }
    }
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Entry> res= new ArrayList();
        for(int i=0;i<code.length;i++){
            boolean validCode=validCode(code[i]);
            boolean validBusinessLine=validBusinessLine(businessLine[i]);
            boolean active=isActive[i];
            if(validCode && validBusinessLine && active){
                res.add(new Entry(code[i],businessLine[i]));
            }
        }
        Collections.sort(res,new Comparator<Entry>(){
            public int compare(Entry s1, Entry s2){
                if(s1.category.equals(s2.category)){
                    return s1.code.compareTo(s2.code);
                }
                return s1.category.compareTo(s2.category);
            }
        });

        List<String> finalres= new ArrayList<>();
        for(Entry e : res){
            finalres.add(e.code);
        }
        return finalres;
    }

    public static boolean validCode(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch=='_') || (ch>='0' && ch<='9'))){
                return false;
            }
        }
        return s.length()!=0;
    }
    public static boolean validBusinessLine(String s){
        return s.equalsIgnoreCase("electronics") || s.equalsIgnoreCase("grocery") || s.equalsIgnoreCase("pharmacy") || s.equalsIgnoreCase("restaurant");
    }
    public static void main(String[] args) {
        //Example 1:

        String []code1 ={"SAVE20","","PHARMA5","SAVE@20"}, businessLine1 = {"restaurant","grocery","pharmacy","restaurant"};
        boolean [] isActive1 = {true,true,true,true};
        List<String> output1= new ArrayList<>(Arrays.asList("SAVE20","PHARMA5"));

        //Example 2:

        String []code2 ={"GROCERY15","ELECTRONICS_50","DISCOUNT10"}, businessLine2 = {"grocery","electronics","invalid"};
        boolean [] isActive2 = {false,true,true};
        List<String> output2= new ArrayList<>(Arrays.asList("SAVE20","PHARMA5"));

        List<String> ans1=  validateCoupons(code1,businessLine1,isActive1);
        List<String> ans2=  validateCoupons(code2,businessLine2,isActive2);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+(output1) );
            System.out.println("Your Output :"+(ans1));
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+(output2) );
            System.out.println("Your Output :"+(ans2));
        }
    }
}
