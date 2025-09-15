package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllConstructTabulation {
    public static List<List<String>> allConstruct(String target, String [] words){
        List<List<List<String>>> table = new ArrayList<>();
        for(int i =0;i<target.length()+1;i++) {
            table.add(new ArrayList<List<String>>());
        }
        table.get(0).add(new ArrayList<>());
        for(int i =0;i<=target.length();i++){
            if(table.get(i).size()!=0){
                for(String word:words){
                    if(target.startsWith(word,i)){
                        List<List<String>> combinations = table.get(i);
                        List<List<String>> nextCombinations= table.get(i+word.length());
                        for(List<String> combination:combinations){
                            List<String> copycomb= new ArrayList<>(combination);
                            copycomb.add(word);
                            nextCombinations.add(copycomb);
                        }
                    }
                }
            }
        }

        return table.get(target.length());
    }

    public static List<List<String>> deepCopy(List<List<String>> combinations){
        List<List<String>> copy = new ArrayList<>();
        for(List<String> combination:combinations){
            List<String> copylist= new ArrayList<>();
            for(String e:combination){
                copylist.add(e);
            }
            copy.add(copylist);
        }
        return copy;
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
//        System.out.println(allConstruct(target5,strs5));

    }
}
