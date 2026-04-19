
package multithreading;


import java.util.Random;

class SharedResource{
    boolean hasValue=false;
    boolean exhaustValue=false;
    int data;
    Random random= new Random();
    public synchronized void produce()  {
            try {
                if(exhaustValue){
                    System.out.println("Exhausted of values");
                    notifyAll();
                    return;
                }
                while (hasValue) {
                    System.out.println("No one consumed The value yet");
                    wait();
                }
                this.data=random.nextInt(1,100);
                System.out.println("Produced : "+data);
                hasValue=true;
                notifyAll();
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }

    }
    public synchronized void consume(){
        try {
            if(exhaustValue){
                System.out.println("Producer Does not have more values ");
                notifyAll();
                return;
            }
            while (!hasValue && !exhaustValue) {
                System.out.println("No Value Produced Yet");
                wait();
            }
            if(exhaustValue){return;}
            System.out.println(Thread.currentThread().getName() + " consume " + data);
            hasValue=false;
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
    }
}

class Producer implements  Runnable{

    SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce();
        }
        synchronized (sharedResource) {
            sharedResource.exhaustValue = true;
            sharedResource.notifyAll(); // wake all waiting threads
        }

    }
}
class Consumer implements  Runnable{

    SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.consume();
        }
    }
}
public class Question6 {
    public static void main(String[] args) {
        SharedResource resource= new SharedResource();
        Thread producer= new Thread(new Producer(resource),"Producer");
        Thread consumer1= new Thread(new Consumer(resource),"Consumer1");
        Thread consumer2= new Thread(new Consumer(resource),"Consumer2");

        producer.start();
        consumer1.start();
        consumer2.start();

    }
}
