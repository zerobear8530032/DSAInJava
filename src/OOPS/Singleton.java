package OOPS;

// create a singleton class which will have a single instance of object
public class Singleton {
    private Singleton(){
    }
    public  String name;
    static Singleton instance;
    public static Singleton getInstance (){
        if(instance==null){
            instance= new Singleton();
        }
        return instance;
    }
}
