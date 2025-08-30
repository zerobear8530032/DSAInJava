package OOPS.abstraction;

public class Main {

    public static void main(String[] args) {

//        Son son = new Son(123);
//        son.career();
//        son.partner();
//        son.printVal();
//
//        Daughter daughter = new Daughter(12);
//        daughter.career();
//        daughter.partner();
//        daughter.printVal();

        Car car = new Car();
        car.start();
        car.accelerate();
        car.brake();
        car.stop();

        System.out.println("Total Cost :"+car.getCost());

        CustomeCar customeCar = new CustomeCar(new PowerEngine(),new CDPlayer());
        customeCar.start();
        customeCar.accelerate();
        customeCar.stop();
        customeCar.playMusic("XYZ");
        customeCar.pauseMusic();
    }
}
