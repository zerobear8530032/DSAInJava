//3433. Count Mentions Per User
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer numberOfUsers representing the total number of users and an array events of size n x 3.
//
//Each events[i] can be either of the following two types:
//
//Message Event: ["MESSAGE", "timestampi", "mentions_stringi"]
//This event indicates that a set of users was mentioned in a message at timestampi.
//The mentions_stringi string can contain one of the following tokens:
//id<number>: where <number> is an integer in range [0,numberOfUsers - 1]. There can be multiple ids separated by a single whitespace and may contain duplicates. This can mention even the offline users.
//ALL: mentions all users.
//HERE: mentions all online users.
//Offline Event: ["OFFLINE", "timestampi", "idi"]
//This event indicates that the user idi had become offline at timestampi for 60 time units. The user will automatically be online again at time timestampi + 60.
//Return an array mentions where mentions[i] represents the number of mentions the user with id i has across all MESSAGE events.
//
//All users are initially online, and if a user goes offline or comes back online, their status change is processed before handling any message event that occurs at the same timestamp.
//
//Note that a user can be mentioned multiple times in a single message event, and each mention should be counted separately.
//
//
//
//Example 1:
//
//Input: numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
//
//Output: [2,2]
//
//Explanation:
//
//Initially, all users are online.
//
//At timestamp 10, id1 and id0 are mentioned. mentions = [1,1]
//
//At timestamp 11, id0 goes offline.
//
//At timestamp 71, id0 comes back online and "HERE" is mentioned. mentions = [2,2]
//
//Example 2:
//
//Input: numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","12","ALL"]]
//
//Output: [2,2]
//
//Explanation:
//
//Initially, all users are online.
//
//At timestamp 10, id1 and id0 are mentioned. mentions = [1,1]
//
//At timestamp 11, id0 goes offline.
//
//At timestamp 12, "ALL" is mentioned. This includes offline users, so both id0 and id1 are mentioned. mentions = [2,2]
//
//Example 3:
//
//Input: numberOfUsers = 2, events = [["OFFLINE","10","0"],["MESSAGE","12","HERE"]]
//
//Output: [0,1]
//
//Explanation:
//
//Initially, all users are online.
//
//At timestamp 10, id0 goes offline.
//
//At timestamp 12, "HERE" is mentioned. Because id0 is still offline, they will not be mentioned. mentions = [0,1]
//
//
//
//Constraints:
//
//1 <= numberOfUsers <= 100
//1 <= events.length <= 100
//events[i].length == 3
//events[i][0] will be one of MESSAGE or OFFLINE.
//1 <= int(events[i][1]) <= 105
//The number of id<number> mentions in any "MESSAGE" event is between 1 and 100.
//0 <= <number> <= numberOfUsers - 1
//It is guaranteed that the user id referenced in the OFFLINE event is online at the time the event occurs.
package Sorting;

import java.util.*;

public class CountMentionsPerUser_3433{
//    approch :
//    here first this we make sure
//    time stemp is not sorted so we need to sort events by time stemp
//    and offline should be process first if there is any mention and people goes offline
//    cause if people goes offline and it mentions the offline people are not included in HERE
//    how to track offline we can just find when user will come online
//    initally every one is online 0 so when a user user go offline
//    we will make it online time eventtime+60 means it will come after current time + 60
//    means when checking offline we can just check usertime is <=curr time
//    because if user come online as the time it mentions we can include that user in mention
//    time complexity : O(E log E + E* ID);
//    space complexity : O(ID);
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events,new Comparator<List<String>>(){
            public int compare(List<String> e1,List<String> e2){
                if(!e1.get(1).equals(e2.get(1))){
                    return Integer.parseInt(e1.get(1))-Integer.parseInt(e2.get(1));
                }
                return e2.get(0).compareTo(e1.get(0));
            }
        });
        long [] userToOnlineTime = new long[numberOfUsers];
        int [] users= new int [numberOfUsers];
        for(int i =0;i<events.size();i++){
            List<String> event= events.get(i);
            if(event.get(0).equals("OFFLINE")){
                int curr_time = Integer.parseInt(event.get(1));
                int user_id = Integer.parseInt(event.get(2));
                userToOnlineTime[user_id]=curr_time+60L;
            }else{
                int curr_time= Integer.parseInt(event.get(1));
                if(event.get(2).equals("HERE")){
                    // increase all online people :
                    for(int j=0;j<userToOnlineTime.length;j++){
                        int user_id= j;
                        long timeToOnline= userToOnlineTime[j];
                        if(curr_time>=timeToOnline){
                            users[user_id]++;
                        }
                    }
                }else if(event.get(2).equals("ALL")){
                    // all users get mentioned:
                    for(int j =0;j<users.length;j++){
                        users[j]++;
                    }
                }else{
                    // specified user mentions:
                    String ids= event.get(2);
                    for(String id: ids.split(" ")){
                        int user_id = Integer.parseInt(id.substring(2));
                        users[user_id]++;
                    }
                }
            }
        }
        return users;
    }
    public static void main(String[] args) {
        //Example 1:

        int numberOfUsers1 = 2;
        List<List<String>> events1 = new ArrayList<>(Arrays.asList(Arrays.asList("MESSAGE","10","id1 id0"),Arrays.asList("OFFLINE","11","0"),Arrays.asList("MESSAGE","71","HERE")));
        int [] output1= {2,2};

        //Example 2:

        int numberOfUsers2 = 2;
        List<List<String>> events2 = new ArrayList<>(Arrays.asList(Arrays.asList("MESSAGE","10","id1 id0"),Arrays.asList("OFFLINE","11","0"),Arrays.asList("MESSAGE","12","ALL")));
        int [] output2= {2,2};

        //Example 3:

        int numberOfUsers3 = 2;
        List<List<String>> events3 = new ArrayList<>(Arrays.asList(Arrays.asList("OFFLINE","10","0"),Arrays.asList("MESSAGE","12","HERE")));
        int [] output3= {0,1};

        int [] ans1= countMentions(numberOfUsers1,events1);
        int [] ans2= countMentions(numberOfUsers2,events2);
        int [] ans3= countMentions(numberOfUsers3,events3);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }
        if(Arrays.equals(output3,ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans3));
        }

    }
}
