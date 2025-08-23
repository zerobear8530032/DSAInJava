package HashMap.HashmapUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class myHashMap<k,v> {
    private float lf=0.5f;
    private List<List<Entities<k,v>>> entries;
    int size;
    public myHashMap(){
        entries= new ArrayList<>();
        size=0;
        for(int i =0;i<10;i++){
            entries.add(new LinkedList<>());
        }
    }
    public myHashMap(float lf){
        this.lf=lf;
        entries= new ArrayList<>();
        for(int i =0;i<10;i++){
            entries.add(new LinkedList<>());
        }
    }

    public void put(k key, v value){
        int hashcode = Math.abs(key.hashCode()%entries.size());
        List<Entities<k,v>> entry = entries.get(hashcode);
        for(Entities<k,v> e:entry) {
            if (e.key.equals(key)) {
                e.value = value;
                return ;
            }
        }
        if((float)(size)/entries.size()>lf){
            reHash();
        }
        entry.add(new Entities(key,value));
        size++;
    }
    public void justPut(k key, v value){
        int hashcode = Math.abs(key.hashCode()%entries.size());
        List<Entities<k,v>> entry = entries.get(hashcode);
        for(Entities<k,v> e:entry) {
            if (e.key.equals(key)) {
                e.value = value;
                return ;
            }
        }
        entry.add(new Entities(key,value));
        size++;
    }


    static class Entities<K,V>{
        K key;
        V value;
        public Entities(K key , V val){
            this.key=key;
            this.value=val;
        }
    }


    private void reHash(){
        System.out.println("re Hashing ");
        List<List<Entities<k,v>>> old = entries;
        entries= new ArrayList<>();
        for(int i =0;i<old.size()*2;i++){
            entries.add(new LinkedList<>());
        }
        size=0;
        for(List<Entities<k,v>> entry:old){
            for(Entities<k,v> entity:entry){
                justPut(entity.key,entity.value);
            }
        }
    }

    public v get(k key){
        int hashcode = Math.abs(key.hashCode()%entries.size());
        List<Entities<k,v>> entities = entries.get(hashcode);
        for(Entities<k,v> e:entities){
            if(e.key.equals(key)){
                return e.value;
            }
        }
        throw new RuntimeException("key Does not Exists");
    }

    public void remove(k key){
        int hashcode = Math.abs(key.hashCode()%entries.size());
        List<Entities<k,v>> entities = entries.get(hashcode);
        Entities<k,v> target =null;
        for(Entities<k,v> e:entities){
            if(e.key.equals(key)){
                target=e;

                break;
            }
        }
        if (target != null) {
            entities.remove(target);
            size--;
        }
    }


    public boolean containsKey(k key){
        int hashcode = Math.abs(key.hashCode()%entries.size());
        List<Entities<k,v>> entities = entries.get(hashcode);
        for(Entities<k,v> e:entities){
            if(e.key.equals(key)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (List<Entities<k,v>> bucket : entries) {
            for (Entities<k,v> e : bucket) {
                builder.append("[").append(e.key).append(",").append(e.value).append("],");
            }
        }
        if (builder.length() > 1) {
            builder.setCharAt(builder.length()-1,'}');
        } else {
            builder.append('}');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        myHashMap<String,String> map = new myHashMap();
        map.put("apple","red fruit");
        map.put("mango","yellow fruit");
        map.put("orange","orange fruit");
        map.put("1","23");
        map.put("2","23");
        map.put("3","23");
        map.put("4","23");
        map.put("5","23");
        map.put("6","23");
        map.put("7","23");
        map.put("8","23");
        map.put("9","23");
        map.put("0","23");
        map.put("1","23");
        System.out.println(map);
    }
}
