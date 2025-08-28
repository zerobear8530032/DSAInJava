package OOPS.polymorphism;

public class Numbers {

    public static int sum(double a , double b){
        System.out.println("doulbe sum");
        return (int)(a+b);
    }

    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static float sum(float a, float b){
        return a+b;
    }

//    not  a valid polymorphism
//    public static double sum(int a, int b){
//        return a+b;
//    }

    public static void main(String[] args) {
        System.out.println(sum(1,3));
        System.out.println(sum(1.f,3.f));
        System.out.println(sum(1.,3.));
    }
}
