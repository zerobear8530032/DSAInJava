package OOPS.abstraction;

public abstract class Parent {
    static int num;
    public Parent(int num){
        this.num=num;
    }

    public static void printVal(){
        System.out.println(num);
    }

    abstract void career();
    abstract void partner();
}
