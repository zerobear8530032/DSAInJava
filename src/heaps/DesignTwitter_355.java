//355. Design Twitter
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
//
//Implement the Twitter class:
//
//Twitter() Initializes your twitter object.
//void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
//List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
//void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
//void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
//
//
//Example 1:
//
//Input
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//Output
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//Explanation
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
//twitter.follow(1, 2);    // User 1 follows user 2.
//twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
//
//
//Constraints:
//
//1 <= userId, followerId, followeeId <= 500
//0 <= tweetId <= 104
//All the tweets have unique IDs.
//At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
//A user cannot follow himself.
package heaps;
import java.util.*;
class User {
    HashSet<Integer> following;
    int userId;
    List<Tweet> allTweets;
    LinkedList<Tweet> recentTweets;

    public User(int userId){
        this.userId= userId;
        following= new HashSet();
        allTweets= new ArrayList();
        recentTweets= new LinkedList();
    }
    @Override
    public String toString() {
        return "User{" +
                "following=" + following +
                ", userId=" + userId +
                ", allTweets=" + allTweets +
                ", recentTweets=" + recentTweets +
                '}';
    }
}
class Tweet {
    int tweetId;
    int time;
    public  Tweet (int tweetId, int time){
        this.tweetId= tweetId;
        this.time= time;
    }
    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", time=" + time +
                '}';
    }

}
// approch : we can create a seperate data structure or a class which can hold user dtails like
//setup :
// user id , following userids : hashset , tweets posted by user: list  , and recently posted 10 tweets: linkedlist
// twitter
// now : the entire twitter will be a hash map mapping userId tp user Object
// post operations :
// when post is perform we will check in hashmap this user id is present yes add the tweet inside user tweet and insert it in recent tweets
// if recent exceed 10 we will remove first inserted tweet
// if the user is new we will create a user object and put it in hashmap twitter
// time complexity : O(1)
// space complexity : O(n)


// follow : we can simply check follower id , followee id from hashmap if present we can just update the following hashset
// by taking teh user object of follower form hashmap and adding the follwee id inside it
// now if the foller, followee both are new users we have to added them as user inside the hashmap too
// time complexity : O(1)
// space complexity : O(1)

// unfollow : we just remove the follwee id from the following hashset from follwerid users
// time complexity : O(1)
// space complexity : O(1)

// getnewsfeed: here we can use a priority queue maxHeap which store tweets in decrement order by time ,tweet id (depends on implementation)
// and we can put all the tweets inside the heap of user , user followers
// and remove top 10 ones from queue to get our output
// time complexity : O(n log n)
// space complexity : O(1)
//
class Twitter {
    HashMap<Integer, User> twitter;
    int time =0;
    public Twitter() {
        twitter= new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time+=1;
        if(twitter.containsKey(userId)){
            User user=twitter.get(userId);
            Tweet newTweet= new Tweet(tweetId,time);
            user.allTweets.add(newTweet);
            LinkedList<Tweet> recent = user.recentTweets;
            recent.addFirst(newTweet);
        }else{
            User user = new User(userId);
            Tweet newTweet= new Tweet(tweetId,time);
            user.allTweets.add(newTweet);
            user.recentTweets.add(newTweet);
            twitter.put(userId,user);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed= new ArrayList();
        if(!twitter.containsKey(userId)){
            return newsFeed;
        }
        PriorityQueue<Tweet> recent= new PriorityQueue(new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2){
                return t2.time-t1.time;
            }
        });
        User user = twitter.get(userId);
        HashSet<Integer> following= user.following;
        for(Tweet tweet:user.recentTweets){
            recent.add(tweet);
        }
        for(int followingId:user.following){
            User followingUser= twitter.get(followingId);
            for(Tweet followingTweet : followingUser.recentTweets){
                recent.add(followingTweet);
            }
        }
        while(!recent.isEmpty()){
            Tweet t= recent.poll();
            newsFeed.add(t.tweetId);
            if(newsFeed.size()==10){break;}
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId){return ;}
        if(!twitter.containsKey(followerId) ){
            twitter.put(followerId, new User(followerId));
        }
        if(!twitter.containsKey(followeeId) ){
            twitter.put(followeeId, new User(followeeId));
        }
        User user=twitter.get(followerId);
        user.following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId){return ;}
        if(!twitter.containsKey(followerId) ){
            System.out.println("FollowerId ");
        }
        if(!twitter.containsKey(followeeId) ){
            System.out.println("FolloweeId ");
        }
        User user=twitter.get(followerId);
        user.following.remove(followeeId);
    }
}

// approch : we can create a seperate data structure or a class which can hold user dtails like
//setup :
// user id , following userids : hashset , tweets posted by user: list  , and recently posted 10 tweets: linkedlist
// twitter
// now : the entire twitter will be a hash map mapping userId tp user Object
// post operations :
// when post is perform we will check in hashmap this user id is present yes add the tweet inside user tweet and insert it in recent tweets
// if recent exceed 10 we will remove first inserted tweet
// if the user is new we will create a user object and put it in hashmap twitter
// time complexity : O(1)
// space complexity : O(n)


// follow : we can simply check follower id , followee id from hashmap if present we can just update the following hashset
// by taking teh user object of follower form hashmap and adding the follwee id inside it
// now if the foller, followee both are new users we have to added them as user inside the hashmap too
// time complexity : O(1)
// space complexity : O(1)

// unfollow : we just remove the follwee id from the following hashset from follwerid users
// time complexity : O(1)
// space complexity : O(1)

// getnewsfeed: here we can use a priority queue minHeap which store tweets in increasing order by time ,tweet id (depends on implementation)
// and we can put all the tweets inside the heap of user but we check each time a new tweet come the size of heap become greater then 10 if that happen we remove smallest entry which is top of heap
// we apply this operation while pushsing all tweet of user and its followings at the end top 10 recent tweets will be present in the heap
// we can remove all 10 post and reverse them cause they are in increasing order but we want recent one first
// time complexity : O(n log k): k will be <= 10
// space complexity : O(1)

class Twitter2 {
    HashMap<Integer, User> twitter;
    int time =0;
    public Twitter2() {
        twitter= new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time+=1;
        if(twitter.containsKey(userId)){
            User user=twitter.get(userId);
            Tweet newTweet= new Tweet(tweetId,time);
            user.allTweets.add(newTweet);
            LinkedList<Tweet> recent = user.recentTweets;
            recent.addFirst(newTweet);
            if(recent.size()>10){
                recent.removeLast();
            }
        }else{
            User user = new User(userId);
            Tweet newTweet= new Tweet(tweetId,time);
            user.allTweets.add(newTweet);
            user.recentTweets.add(newTweet);
            twitter.put(userId,user);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed= new ArrayList();
        if(!twitter.containsKey(userId)){
            return newsFeed;
        }
        PriorityQueue<Tweet> recent= new PriorityQueue(new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2){
                return t1.time-t2.time;
            }
        });
        User user = twitter.get(userId);
        HashSet<Integer> following= user.following;
        for(Tweet tweet:user.recentTweets){
            recent.add(tweet);
            if(recent.size()>10){
                recent.remove();
            }
        }
        for(int followingId:user.following){
            User followingUser= twitter.get(followingId);
            for(Tweet followingTweet : followingUser.recentTweets){
                recent.add(followingTweet);
                if(recent.size()>10){
                    recent.remove();
                }
            }
        }
        while(!recent.isEmpty()){
            Tweet t= recent.poll();
            newsFeed.add(t.tweetId);
        }
        Collections.reverse(newsFeed);
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId){return ;}
        if(!twitter.containsKey(followerId) ){
            twitter.put(followerId, new User(followerId));
        }
        if(!twitter.containsKey(followeeId) ){
            twitter.put(followeeId, new User(followeeId));
        }
        User user=twitter.get(followerId);
        user.following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId){return ;}
        if(!twitter.containsKey(followerId) ){
            System.out.println("FollowerId ");
        }
        if(!twitter.containsKey(followeeId) ){
            System.out.println("FolloweeId ");
        }
        User user=twitter.get(followerId);
        user.following.remove(followeeId);
    }
}
public class DesignTwitter_355 {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

        Twitter2 twitter2 = new Twitter2();
        twitter2.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter2.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter2.follow(1, 2);    // User 1 follows user 2.
        twitter2.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter2.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter2.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter2.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}
