package OOPS.abstraction;

public class Son extends  Parent{

    public Son(int num){
        super(num);
    }

    @Override
    public void career() {
        System.out.println("I will be a Coder");
    }

    @Override
    public void partner() {
        System.out.println("I love zara");
    }

}
