//981. Time Based Key-Value Store
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
//
//Implement the TimeMap class:
//
//TimeMap() Initializes the object of the data structure.
//void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
//String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
//
//
//Example 1:
//
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//Explanation
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//timeMap.get("foo", 1);         // return "bar"
//timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//timeMap.get("foo", 4);         // return "bar2"
//timeMap.get("foo", 5);         // return "bar2"
//
//
//Constraints:
//
//1 <= key.length, value.length <= 100
//key and value consist of lowercase English letters and digits.
//1 <= timestamp <= 107
//All the timestamps timestamp of set are strictly increasing.
//At most 2 * 105 calls will be made to set and get.
package BinarySearch;

// approch : use hashmap with key as given key and a list or linked list as key with time temp pairs
//use binary search for finding the values in the list
// time complexity : O(log n)
// space complexity : O(n)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    class Pair {
        String value;
        int time;

        public Pair(String val, int time){
            this.value=val;
            this.time=time;
        }

        public String toString(){
            return "["+value+","+time+"]";
        }
    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(value,timestamp));
        }else{
            List<Pair> pair = new ArrayList<>();
            Pair p = new Pair(value,timestamp);
            pair.add(p);
            map.put(key,pair);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> pairs = map.get(key);
            int s=0;
            int e= pairs.size()-1;
            while(s<=e){
                int mid= s+(e-s)/2;
                if(pairs.get(mid).time<timestamp){
                    s=mid+1;
                }else if(pairs.get(mid).time>timestamp){
                    e=mid-1;
                }else{
                    return pairs.get(mid).value;
                }
            }
            if(e<0){return "";}
            return pairs.get(e).value;
        }

        return "";
    }
}


public class TimeBasedKeyValueStore_981 {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"

    }
}
