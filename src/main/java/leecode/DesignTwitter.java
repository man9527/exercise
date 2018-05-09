package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DesignTwitter {

    HashMap<Integer, List<Integer>> followers = new HashMap<>();
    HashMap<Integer, LinkedList<Integer>> tweets = new HashMap<>();


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        addTweet(userId, tweetId);

        followers.putIfAbsent(userId, new ArrayList<>());
        List<Integer> fs = followers.get(userId);

        for(Integer followerId:fs) {
            addTweet(followerId, tweetId);
        }
    }

    private void addTweet(int userId, int tweetId) {
        if (tweets.get(userId)==null) {
            tweets.put(userId, new LinkedList<>());
        }

        LinkedList<Integer> tw = tweets.get(userId);

        tw.addFirst(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> ts = tweets.getOrDefault(userId, new LinkedList<>());

        if (ts.size()<=10) {
            return ts;
        } else {
            return ts.subList(0, 9);
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        if (followeeId==followeeId) {
            return;
        }

        followers.putIfAbsent(followeeId, new ArrayList<>());
        List<Integer> fs = followers.get(followeeId);
        fs.add(followerId);

        tweets.putIfAbsent(followerId, new LinkedList<>());
        tweets.putIfAbsent(followeeId, new LinkedList<>());
        LinkedList<Integer> followeets = tweets.get(followeeId);
        LinkedList<Integer> followerts = tweets.get(followerId);
        for (Integer tsid : followeets) {

            followerts.add(tsid);

        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId==followeeId) {
            return;
        }

        followers.putIfAbsent(followeeId, new ArrayList<>());
        List<Integer> fs = followers.get(followeeId);
        fs.remove(new Integer(followeeId));

        tweets.putIfAbsent(followerId, new LinkedList<>());
        tweets.putIfAbsent(followeeId, new LinkedList<>());
        LinkedList<Integer> followeets = tweets.get(followeeId);

        ArrayList<Integer> todelete = new ArrayList<>();

            for (Integer tsid : followeets) {

                todelete.add(tsid);

            }

        LinkedList<Integer> followerts = tweets.get(followerId);
        for (Integer tsid : todelete) {

            followerts.remove(new Integer(tsid));
        }

    }

}
