//355. Design Twitter
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

package LinkedList.Learning;

import java.util.*;

class Tweet {
    int time;
    int tweetId;

    public Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }
}

class Twitter {
    private Map<Integer, List<Tweet>> tweets;         // userId -> list of tweets
    private Map<Integer, Set<Integer>> followers;      // userId -> set of followees
    private int time;                                  // global time counter

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(time, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets from followees
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                pq.addAll(tweets.get(followeeId));
            }
        }

        // Get the 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot follow self

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
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
		twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2
	}

}
