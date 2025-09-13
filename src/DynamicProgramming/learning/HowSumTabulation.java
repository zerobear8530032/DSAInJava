package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.List;

public class HowSumTabulation {

    public  static List<Integer> howSum(int target, int [] elements){
        List<List<Integer>> table = new ArrayList<>();
        for(int i =0;i<target+1;i++){
            table.add(null);
        }
        table.set(0,new ArrayList<>());
        for(int i =0;i<target;i++){
            if(table.get(i)!=null){
                for(int x:elements){
                    List<Integer> currRes=new ArrayList<>(table.get(i));
                    if(i+x<=target){
                       currRes.add(x);
                       table.set(i+x,currRes);
                    }
                }
            }
        }
        return table.get(target);
    }
    public static void main(String[] args) {
        System.out.println(howSum(7,new int [] {2,3}));
        System.out.println(howSum(7,new int [] {5,3,4,7}));
        System.out.println(howSum(7,new int [] {2,4}));
        System.out.println(howSum(8,new int [] {2,3,5}));
        System.out.println(howSum(300,new int [] {7,14}));
    }
}
