package HeapsAndPriorityQueue;

import java.util.*;

public class DesignTwitterFeed {
    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 101);
        //System.out.println(twitter.users.get(1).getTweetList().get(0).getTweetId());
        twitter.postTweet(1, 102);
        //System.out.println(twitter.users.get(1).getTweetList().get(0).getTweetId());
        //System.out.println(twitter.users.get(1).getTweetList().get(1).getTweetId());
        /*List<Integer> user1Tweets = twitter.getNewsFeed(1);
        System.out.println(user1Tweets.toString());*/
        /*List<Integer> user2Tweets = twitter.getNewsFeed(2);
        System.out.println(user2Tweets.toString());*/
        twitter.follow(2, 1);
        List<Integer> user2Tweets = twitter.getNewsFeed(2);
        System.out.println(user2Tweets.toString());
        twitter.unfollow(2, 1);
        user2Tweets = twitter.getNewsFeed(2);
        System.out.println(user2Tweets.toString());
    }
}

class Twitter {
    int globalTimestamp;
    Map<Integer, User> users;

    public Twitter() {
        globalTimestamp = 0;
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        globalTimestamp = globalTimestamp + 1;
        //create User with userId and add tweet to users tweet list
        if (users.get(userId) != null) {
            users.get(userId).getTweetList().add(new Tweet(tweetId, globalTimestamp));
        } else {
            User newUser = new User(userId);
            newUser.getTweetList().add(new Tweet(tweetId, globalTimestamp));
            users.put(userId, newUser);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        if(users.get(userId) == null){
            createUser(userId);
        }
        List<Integer> resultFeedIds = new ArrayList<>();
        // defining the comparator
        Comparator comparator = new Comparator<TopKFeedHelper>() {
            @Override
            public int compare(TopKFeedHelper follower1, TopKFeedHelper follower2) {
                return Integer.compare(follower2.getTweetList().get(follower2.index).getTimeStamp(),
                        follower1.getTweetList().get(follower1.index).getTimeStamp());
            }
        };
        //comparator.reversed();

        PriorityQueue<TopKFeedHelper> maxHeap = new PriorityQueue<>(comparator);
        int topNFeed = 10;
        User user = users.get(userId);
        // If userId account is present
        if (user != null) {
            // get all followers of user
            for (Integer followerId : user.getFollowerList()) {
                System.out.println("follower list is "+followerId);
                if (users.get(followerId) != null && users.get(followerId).getTweetList().size() > 0) {
                    List<Tweet> usersTweetList = users.get(followerId).getTweetList();
                    TopKFeedHelper topKFeederHelper = new TopKFeedHelper(usersTweetList);
                    topKFeederHelper.setIndex(usersTweetList.size() - 1);
                    maxHeap.offer(topKFeederHelper);
                }
            }
        }
        while (!maxHeap.isEmpty() && topNFeed > 0) {
            TopKFeedHelper feedHelper = maxHeap.poll();
            List<Tweet> tweetList = feedHelper.getTweetList();
            resultFeedIds.add(tweetList.get(feedHelper.getIndex()).getTweetId());
            // decrement index by 1
            if (feedHelper.getIndex() > 0) {
                // decrement index and add back to maxHeap
                feedHelper.setIndex(feedHelper.getIndex() - 1);
                maxHeap.offer(feedHelper);
            }
            topNFeed--;
        }
        return resultFeedIds;
    }

    public void follow(int followerId, int followeeId) {
        if(users.get(followerId) == null){
           createUser(followerId);
        }
        if (users.get(followeeId) == null) {
            createUser(followeeId);
        }
        users.get(followerId).addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(users.get(followerId) == null){
           createUser(followerId);
        }
        if (users.get(followeeId) == null) {
           createUser(followeeId);
        }
        users.get(followerId).removeFollower(followeeId);
    }

    public void createUser(int userId){
        User newUser = new User(userId);
        this.users.put(userId, newUser);
    }
}

class User {
    Integer userId;
    List<Tweet> tweetList;
    Set<Integer> followerList;

    public User(Integer userId) {
        this.userId = userId;
        this.tweetList = new ArrayList<>();
        this.followerList = new HashSet<>();
        followerList.add(userId);
    }

    public List<Tweet> getTweetList() {
        return this.tweetList;
    }

    public Set<Integer> getFollowerList() {
        return this.followerList;
    }

    public void addFollower(Integer followerId) {
        if (followerId != null) {
            this.followerList.add(followerId);
        }

    }

    public void removeFollower(Integer followerId) {
        if (followerList.contains(followerId) && ! this.userId.equals(followerId)) {
            this.followerList.remove(followerId);
        }
    }
}

class Tweet {
    Integer tweetId;
    int timeStamp;

    public Tweet(Integer tweetId, int timeStamp) {
        this.tweetId = tweetId;
        this.timeStamp = timeStamp;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public Integer getTweetId() {
        return this.tweetId;
    }
}

class TopKFeedHelper {
    List<Tweet> tweetList;
    int index;

    TopKFeedHelper(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public List<Tweet> getTweetList() {
        return this.tweetList;
    }
}