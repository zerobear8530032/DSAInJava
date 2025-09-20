//3508. Implement Router
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:
//
//source: A unique identifier for the machine that generated the packet.
//destination: A unique identifier for the target machine.
//timestamp: The time at which the packet arrived at the router.
//Implement the Router class:
//
//Router(int memoryLimit): Initializes the Router object with a fixed memory limit.
//
//memoryLimit is the maximum number of packets the router can store at any given time.
//If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.
//bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.
//
//A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
//Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.
//int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.
//
//Remove the packet from storage.
//Return the packet as an array [source, destination, timestamp].
//If there are no packets to forward, return an empty array.
//int getCount(int destination, int startTime, int endTime):
//
//Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].
//Note that queries for addPacket will be made in increasing order of timestamp.
//
//
//
//Example 1:
//
//Input:
//["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
//[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]
//
//Output:
//[null, true, true, false, true, true, [2, 5, 90], true, 1]
//
//Explanation
//
//Router router = new Router(3); // Initialize Router with memoryLimit of 3.
//router.addPacket(1, 4, 90); // Packet is added. Return True.
//router.addPacket(2, 5, 90); // Packet is added. Return True.
//router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
//router.addPacket(3, 5, 95); // Packet is added. Return True
//router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
//router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
//router.addPacket(5, 2, 110); // Packet is added. Return True.
//router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.
//Example 2:
//
//Input:
//["Router", "addPacket", "forwardPacket", "forwardPacket"]
//[[2], [7, 4, 90], [], []]
//
//Output:
//[null, true, [7, 4, 90], []]
//
//Explanation
//
//Router router = new Router(2); // Initialize Router with memoryLimit of 2.
//router.addPacket(7, 4, 90); // Return True.
//router.forwardPacket(); // Return [7, 4, 90].
//router.forwardPacket(); // There are no packets left, return [].
//
//
//Constraints:
//
//2 <= memoryLimit <= 105
//1 <= source, destination <= 2 * 105
//1 <= timestamp <= 109
//1 <= startTime <= endTime <= 109
//At most 105 calls will be made to addPacket, forwardPacket, and getCount methods altogether.
//queries for addPacket will be made in increasing order of timestamp.
package HashMap;

import java.util.*;


//Final Summary
//
//addPacket() → O(1) average.
//
//forwardPacket() → O(1) average.
//
//getCount() → O(cap) worst case.
//
//Space → O(cap).
//class Router {
//    LinkedHashMap<String,int [] > router= new LinkedHashMap();
//    int cap;
//    public Router(int memoryLimit) {
//        cap=memoryLimit;
//    }
//
//    public boolean addPacket(int source, int destination, int timestamp) {
//        StringBuilder keybuilder = new StringBuilder();
//        keybuilder.append(source).append(",").append(destination).append(",").append(timestamp);
//        String key = keybuilder.toString();
//        if(router.containsKey(key)){//duplicate packet rejected
//            return false;
//        }
//        if(cap==router.size()){
//            router.pollFirstEntry();
//        }
//        router.put(key,new int [] {source,destination,timestamp});
//        return true;
//    }
//
//    public int[] forwardPacket() {
//        Map.Entry<String,int [] > e=router.pollFirstEntry();
//        return e==null?new int []{}:e.getValue();
//
//    }
//
//    public int getCount(int destination, int startTime, int endTime) {
//        int count =0;
//        for(Map.Entry<String,int []> e:router.entrySet()){
//            int [] packet= e.getValue();
//            int pdes= packet[1];
//            int time = packet[2];
//            if(pdes==destination && time>=startTime && time<=endTime){
//                count++;
//            }
//        }
//        return count;
//    }
//}

class Router {
//3️⃣ Algorithm / Approach
//Add Packet
//
//Encode packet as "source,destination,timestamp".
//
//If it exists in seen, return false (duplicate).
//
//If queue.size() == capacity, call forwardPacket() to free space.
//
//Add packet to queue and seen.
//
//Append timestamp to destinationMap[destination].
//
//Initialize startMap[destination] = 0 if new destination.
//
//Return true.
//
//Forward Packet
//
//If queue is empty, return [].
//
//Remove first packet from queue.
//
//Remove from seen.
//
//Increment startMap[destination] (logical removal).
//
//If all timestamps for this destination are gone (startMap == list.size()), reset the list and start index.
//
//Return the removed packet [source,destination,timestamp].
//
//Get Count
//
//Get timestamp list for destination.
//
//Get start = startMap[destination] (logical start).
//
//Use binary search to find indices:
//    | Operation       | Complexity                                                                                            |
//| --------------- | ----------------------------------------------------------------------------------------------------- |
//| `addPacket`     | O(1) amortized for queue & set + O(1) append to ArrayList → **O(1)**                                  |
//| `forwardPacket` | O(1) for queue, set, startMap → **O(1)**                                                              |
//| `getCount`      | Binary search on timestamps → O(log n) per query, where n = number of timestamps for that destination |
//| Overall memory  | O(capacity) for queue + O(capacity) for timestamps + O(capacity) for set → **O(capacity)**            |

    ArrayDeque<int []> queue;
    List<Integer,List<Integer>> destinationMap;
    HashMap<Integer,Integer> startMap;
    HashSet<String> seen;
    int capacity;
    public Router(int memoryLimit) {
        queue= new ArrayDeque<>();
        destinationMap= new HashMap<>();
        startMap= new HashMap();
        seen = new HashSet();
        capacity=memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String encoded= encode(source,destination,timestamp);
        if(seen.contains(encoded)){return false;}
        if(capacity==queue.size()){
            forwardPacket();
        }

        //  adding the packet :
        int [] newpacket= {source,destination,timestamp};
        queue.addLast(newpacket);
        seen.add(encoded);
        if(destinationMap.containsKey(destination)){
            destinationMap.get(destination).add(timestamp);
        }else{
            List<Integer> list= new ArrayList();
            list.add(timestamp);
            destinationMap.put(destination,list);
            startMap.put(destination,0);
        }
        return true;
    }

    public int[] forwardPacket() {
        if(queue.size()==0){
            return new int []{};
        }
        int [] removePacket = queue.removeFirst();
        int rdes= removePacket[1];
        String removeencoded= encode(removePacket[0],removePacket[1],removePacket[2]);
        seen.remove(removeencoded);
        startMap.put(rdes,startMap.get(rdes)+1);
        if(startMap.get(rdes)==destinationMap.get(rdes).size()){
            destinationMap.put(rdes,new ArrayList<>());
            startMap.put(rdes,0);
        }
        return removePacket;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timeStamps= destinationMap.get(destination);
        if(timeStamps == null || timeStamps.size() == 0) return 0;

        int start= startMap.get(destination);
        int low= binarySearch(timeStamps,start,timeStamps.size()-1,startTime);
        int high= binarySearch(timeStamps,start,timeStamps.size()-1,endTime+1);
        return high-low;
    }

    private String encode(int source,int destination, int time){
        StringBuilder builder= new StringBuilder();
        builder.append(source).append(",").append(destination).append(",").append(time);
        return builder.toString();
    }


    public int binarySearch(List<Integer> time, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(time.get(mid)<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
public class ImplementRouter_3508 {
    public static void main(String[] args) {
        Router router1 = new Router(3); // Initialize Router with memoryLimit of 3.
        router1.addPacket(1, 4, 90); // Packet is added. Return True.
        router1.addPacket(2, 5, 90); // Packet is added. Return True.
        router1.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
        router1.addPacket(3, 5, 95); // Packet is added. Return True
        router1.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
        router1.forwardPacket(); // Return [2, 5, 90] and remove it from router.
        router1.addPacket(5, 2, 110); // Packet is added. Return True.
        router1.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105].


        Router router2 = new Router(2); // Initialize Router with memoryLimit of 2.
        router2.addPacket(7, 4, 90); // Return True.
        router2.forwardPacket(); // Return [7, 4, 90].
        router2.forwardPacket(); // There are no packets left, return [].

    }
}
