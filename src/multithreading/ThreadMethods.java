package multithreading;

public class ThreadMethods {
    public static void main(String[] args) {
        try {
            MyThread th1 = new MyThread("MY Thread 1");
            MyThread th2 = new MyThread("MY Thread 2");
            th1.start();
            th2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class MyThread extends  Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
        super();
    }

    //    @Override
//    public void run() {
//        for(int i =0;i<5;i++){
//            System.out.println("Thread is running");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    @Override
//    public void run() {
//        for(int i =0;i<5;i++){
//            try {
//                    String a="a";
//                for(int j=0;j<1000;j++) {
//                    a+="a";
//                }
//                System.out.println("Thread is running "+Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }
    public void run() {
        try{
            for(int i =0;i<10;i++) {
                System.out.println("Thread is running "+Thread.currentThread().getName());
                Thread.yield();
            }
        } catch (Exception e) {
            System.out.println("Thread is intrupted "+e);
        }
    }
}
