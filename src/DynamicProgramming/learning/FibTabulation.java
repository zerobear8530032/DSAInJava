package DynamicProgramming.learning;

import java.util.HashMap;

public class FibTabulation {

    public static long fibonacci(int n){
        long [] table= new long [n+3];
        table[1]=1;
        for(int i =0;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(50));

    }

    public static class CanConstruct {
    //    given a string and a array of strings try to find weather its possible to create the target
    //    string using string from array any amount of time
    //    here n is the number of strings
    //    here m is the length of string
    //    time complexity : O(n^m * m)

    //    space complexity : O(m *m)
        public static boolean canConstruct(String target, String []str){
            if(target.equals("") || target==null){
                return true;
            }
            boolean res= false;
            for(String s:str){
                if(target.startsWith(s)){
                    if(canConstruct(target.substring(s.length()),str)){
                        return true;
                    }
                }
            }
            return res;
        }

    //    memo
    //    time complexity : O(n*m^2)
    //    space complexity : O(m^2)
        public static boolean canConstruct(String target, String []str, HashMap<String,Boolean> memo){
            if(memo.containsKey(target)){return  memo.get(target);}
            if(target.equals("") || target==null){return true;}
            for(String s:str){
                if(target.startsWith(s)){
                    if(canConstruct(target.substring(s.length()),str,memo)){
                        memo.put(target,true);
                        return true;
                    }
                }
            }
            memo.put(target,false);
            return false;
        }

        public static void main(String[] args) {
            String target1= "abcdef";
            String [] strs1= {"ab","abc","cd","def","abcd"};

            String target2= "skateboard";
            String [] strs2= {"bo","rd","ate","t","ska","sk","boar"};

            String target3= "enterapotentpot";
            String [] strs3= {"a","p","ent","enter","ot","o","t"};

            String target4= "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
            String [] strs4= {"e","ee","eee","eeee","eeeee","eeeeee","eeeeeee"};

            System.out.println(canConstruct(target1,strs1));
            System.out.println(canConstruct(target2,strs2));
            System.out.println(canConstruct(target3,strs3));
            System.out.println(canConstruct(target4,strs4, new HashMap<>()));
        }

    }
}
