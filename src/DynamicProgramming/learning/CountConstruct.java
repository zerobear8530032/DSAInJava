package DynamicProgramming.learning;

import java.util.HashMap;

public class CountConstruct {
//    you are given a String Target and a Array of Strings return the number of ways we can
//    create target using the strings in array

    public static int countConstruct(String target, String[] strs){
        if(target.equals("")){return 1;}
        int total=0;
        for(String s:strs) {
            if (target.startsWith(s)) {
                int ways= countConstruct(target.substring(s.length()), strs);
                total+=ways;
            }
        }
        return total;
    }

    public static int countConstruct(String target, String[] strs, HashMap<String,Integer> memo){
        if(memo.containsKey(target)){return memo.get(target);}
        if(target.equals("")){return 1;}
        int total=0;
        for(String s:strs) {
            if (target.startsWith(s)) {
                int ways= countConstruct(target.substring(s.length()), strs,memo);
                total+=ways;
            }
        }
        memo.put(target,total);
        return total;
    }

    public static void main(String[] args) {
        String target1= "purple";
        String [] strs1= {"purp","p","ur","le","purpl"};

        String target2= "abcdef";
        String [] strs2= {"ab","abc","cd","def","abcd"};

        String target3= "skateboard";
        String [] strs3= {"bo","rd","ate","t","ska","sk","boar"};

        String target4= "enterapotentpot";
        String [] strs4= {"a","p","ent","enter","ot","o","t"};

        String target5= "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String [] strs5= {"e","ee","eee","eeee","eeeee","eeeeee","eeeeeee"};

        System.out.println(countConstruct(target1,strs1));
        System.out.println(countConstruct(target2,strs2));
        System.out.println(countConstruct(target3,strs3));
        System.out.println(countConstruct(target4,strs4));
        System.out.println(countConstruct(target5,strs5, new HashMap<>()));
    }
}
