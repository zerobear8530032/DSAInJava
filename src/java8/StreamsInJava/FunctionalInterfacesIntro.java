package java8.StreamsInJava;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesIntro {
//     java 8 features : minimal code , functional programing , lambda , streams, date and time api
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("hello !");
        });// lambd function
        MathOperation addOperation= (int x,int y)->  x + y;
        MathOperation subOperation= (int x,int y)->  x - y;
        MathOperation mulOperation= (int x,int y)->  x * y;
        MathOperation divOperation= (int x,int y)->  x / y;

        System.out.println(addOperation.add(2,4));
        System.out.println(subOperation.add(2,4));
        System.out.println(mulOperation.add(2,4));
        System.out.println(divOperation.add(2,4));

        Function<Integer,Integer> doubleIt= x -> {
            System.out.println("double");
           return x + x;
        };
        Function<Integer,Integer> tripleIt= x -> {
            System.out.println("triple");
            return x + x + x;
        };
        System.out.println(doubleIt.andThen(tripleIt).apply(3));// run double it first then triple it
        System.out.println(doubleIt.compose(tripleIt).apply(3));// run triple it first then double it

        Consumer<Integer> consumer= (Integer x)->System.out.println(x);
        consumer.andThen( (x)-> System.out.println(x)).andThen((c)-> System.out.println(c)).accept(67);
        List<Integer> l = Arrays.asList(23,34,2);
        Consumer<List<Integer>> showlist = (List<Integer> list)-> System.out.println(list);
        showlist.andThen((list)->{
            for(int i=0;i<list.size();i++){
                list.set(i,list.get(i)*2);
            }
            System.out.println(list);
        }).andThen((list)->{
            for(int i=0;i<list.size();i++){
                list.set(i,list.get(i)*2);
            }
            System.out.println(list);
        }
        ).accept(l);
     Supplier<String> giveRandomId = ()-> UUID.randomUUID().toString();
        System.out.println(giveRandomId.get());
        System.out.println(giveRandomId.get());
        System.out.println(giveRandomId.get());
        System.out.println(giveRandomId.get());
    Predicate<String> startsWithA= s->{return s.toLowerCase().startsWith("a");};
    Predicate<String> endsWithP= s->{return s.toLowerCase().endsWith("p");};
    Predicate<String> startEndWith= startsWithA.and(endsWithP);
        System.out.println(startsWithA.test("Ankit"));
        System.out.println(endsWithP.test("pnkip"));
        System.out.println(startEndWith.test("Ankip"));

    }



}


interface MathOperation{

    public int add(int x , int y);
}
