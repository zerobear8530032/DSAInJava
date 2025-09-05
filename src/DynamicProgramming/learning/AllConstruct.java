package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllConstruct {
//    you are given a String Target and a Array of Strings return the number of ways we can
//    create target using the strings in array
//        public static List<List<String>> allConstruct(String target, String[] strs){
//            List<List<String>>res= new ArrayList<>();
//            helper(res,target,new ArrayList<>(),strs);
//            return res;
//        }
//        public static void helper(List<List<String>> res, String target,List<String> curr, String [] strs){
//            if(target.equals("")){
//                res.add(new ArrayList<>(curr));
//                return ;
//            }
//            for(String s:strs){
//                if(target.startsWith(s)){
//                    curr.add(s);
//                    helper(res,target.substring(s.length()),curr,strs);
//                    curr.remove(s);
//                }
//            }
//        }


    public static List<List<String>> allConstruct(String target, String[] strs) {
        if (target.equals("")) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>()); // [[]]
            return base;
        }

        List<List<String>> finalRes = new ArrayList<>();

        for (String s : strs) {
            if (target.startsWith(s)) {
                String suffix = target.substring(s.length());
                List<List<String>> suffixWays = allConstruct(suffix, strs);

                for (List<String> way : suffixWays) {
                    List<String> newWay = new ArrayList<>(way);
                    newWay.add(0, s); // prepend s
                    finalRes.add(newWay);
                }
            }
        }
        return finalRes;
    }
//    time : O(N^M)
//    SPACE : O(N^M)
    public static List<List<String>> allConstruct(String target, String[] strs, HashMap<String,List<List<String>>>memo) {
        if(memo.containsKey(target)){
            return  memo.get(target);
        }
        if (target.equals("")) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>()); // [[]]
            return base;
        }

        List<List<String>> finalRes = new ArrayList<>();

        for (String s : strs) {
            if (target.startsWith(s)) {
                String suffix = target.substring(s.length());
                List<List<String>> suffixWays = allConstruct(suffix, strs,memo);

                for (List<String> way : suffixWays) {
                    List<String> newWay = new ArrayList<>(way);
                    newWay.add(0, s); // prepend s
                    finalRes.add(newWay);
                }
            }
        }
        memo.put(target,new ArrayList<>(finalRes));
        return finalRes;
    }



        public static void main(String[] args) {
            String target1= "purple";
            String [] strs1= {"purp","p","ur","le","purpl"};

            String target2= "abcdef";
            String [] strs2= {"ab","abc","cd","def","abcd","ef","c"};

            String target3= "skateboard";
            String [] strs3= {"bo","rd","ate","t","ska","sk","boar"};

            String target4= "enterapotentpot";
            String [] strs4= {"a","p","ent","enter","ot","o","t"};

            String target5= "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeF";
            String [] strs5= {"e","ee","eee","eeee","eeeee","eeeeee","eeeeeee"};

            System.out.println(allConstruct(target1,strs1));
            System.out.println(allConstruct(target2,strs2));
            System.out.println(allConstruct(target3,strs3));
            System.out.println(allConstruct(target4,strs4));
            System.out.println(allConstruct(target5,strs5, new HashMap<>()));
        }

}
