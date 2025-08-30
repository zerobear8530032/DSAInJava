package OOPS.abstraction;

public class CustomeCar {
    private Engine engine;
    private Media player;
    public CustomeCar(){
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Media getPlayer() {
        return player;
    }

    public void setPlayer(Media player) {
        this.player = player;
    }

    public CustomeCar(Engine engine, Media player) {
        this.engine = engine;
        this.player = player;
    }
    public CustomeCar(Engine engine) {
        this.engine = engine;
    }
    public CustomeCar(Media player) {
        this.player = player;
    }

    public void start(){
        if(engine!=null){
        engine.start();
        }else{
            System.out.println("No Enginer Available");
        }
    }
    public void stop(){
        if(engine!=null){
            engine.stop();
        }else{
            System.out.println("No Enginer Available");
        }
    }
    public void accelerate(){

        if(engine!=null){
            engine.accelerate();
        }else{
            System.out.println("No Enginer Available");
        }
    }
    public void playMusic(String name){
        if(player!=null){
        player.start(name);
        }else{
            System.out.println("No Player Available");
        }
    }
    public void pauseMusic(){
        if(player!=null){
        player.stop();
        }else{
            System.out.println("No Player Available");
        }
    }
}
