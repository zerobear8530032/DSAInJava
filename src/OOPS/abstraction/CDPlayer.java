package OOPS.abstraction;

public class CDPlayer implements Media {

    @Override
    public void start(String music) {
        System.out.println("Music PLaying :"+music);
    }

    @Override
    public void stop() {
        System.out.println("Stop Music");
    }
}
