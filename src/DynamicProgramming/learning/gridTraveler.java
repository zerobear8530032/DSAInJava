package DynamicProgramming.learning;

import java.util.HashMap;

public class gridTraveler {

    public int travel(int r,int c){
        if(r==1 && c==1){return 1;}
        if(r==0 || c==0){return 0;}
        int down = travel(r-1,c);
        int right = travel(r,c-1);
        return down+right;
    }


    public long travel(int r,int c, HashMap<String,Long> memo){
        String key1 = r+","+c;
        if(memo.containsKey(key1)){
            return memo.get(key1);
        }
        String key2 = c+","+r;
        if(memo.containsKey(key2)){
            return memo.get(key2);
        }

        if(r==1 && c==1){return 1;}
        if(r==0 || c==0){return 0;}
        long down = travel(r-1,c,memo);
        long right = travel(r,c-1,memo);
        memo.put(key1,down+right);
        memo.put(key2,down+right);
        return down+right;
    }

    public static void main(String[] args) {
        gridTraveler main = new gridTraveler();
        System.out.println(main.travel(2,3));
        System.out.println(main.travel(3,2));
        System.out.println(main.travel(2,2));
        System.out.println(main.travel(3,3));
        System.out.println(main.travel(4,4));
//        System.out.println(main.travel(18,18));
        System.out.println("Memo Solutions :");
        System.out.println(main.travel(2,3,new HashMap<>()));
        System.out.println(main.travel(3,2,new HashMap<>()));
        System.out.println(main.travel(2,2,new HashMap<>()));
        System.out.println(main.travel(3,3,new HashMap<>()));
        System.out.println(main.travel(4,4,new HashMap<>()));
        System.out.println(main.travel(18,18,new HashMap<>()));


    }
}
