package OOPS.abstraction;

public class Car implements Engine,Brakes{

    @Override
    public void brake() {
        System.out.println("Applying Brakes...");
    }

    @Override
    public void start() {
        System.out.println("Starting Car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping car !");
    }

    @Override
    public void accelerate() {
        System.out.println("Speeding car !");
    }


    public int getCost(){
        return Engine.PRICE+ Media.PRICE+Brakes.PRICE;
    }
}
