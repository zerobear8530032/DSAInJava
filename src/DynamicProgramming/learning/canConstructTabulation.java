package DynamicProgramming.learning;

public class canConstructTabulation {
//     time complexity : O(m *n )*m
//    space complexity : O(m)
    public static boolean canConstruct(String target, String [] words){
        boolean [] table= new boolean [target.length()+1];
        table[0]=true;

        for(int i =0;i<=target.length();i++){
            if(table[i]){
                for(String word : words){
                    String remaining=target.substring(i);
                    if(remaining.startsWith(word)){
                        table[i+word.length()]=true;
                    }
                }

            }
        }
        return table[target.length()];
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String [] {"ab","abc","cd","def","abcd"}));
        System.out.println(canConstruct("skateboard", new String []{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(canConstruct("enterapotentpot", new String []{"a","p","ent","enter","ot","o","t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String []{"e","ee","eee","eeee","eeeee","eeeeee","eeeeeeeee"}));


    }
}
