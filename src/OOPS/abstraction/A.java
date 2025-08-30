package OOPS.abstraction;

public interface A {
//    this function can remain as its implementation in interface cause its default
//    it is not always necceasary to override it like abstract methods\
//    this can cause ambiguity it there are same default method s in different interface
    public default void fun(){
        System.out.println(" i am default fuction");
    }
//    these function can also be here and these cannot be override also because static cannot be override
//    and static methods always have a body;
    public static void fun2(){
        System.out.println(" i am static fuction");
    }
}
