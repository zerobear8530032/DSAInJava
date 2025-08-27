package OOPS;

public class Main {



    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.name="zerobear";
        System.out.println(singleton.name);
        Singleton singleton2 = Singleton.getInstance();
        singleton2.name="saboor";
        System.out.println(singleton.name);// here also the name is saboor cause the instance was same in both variables
        System.out.println(singleton2.name);

    }
}
