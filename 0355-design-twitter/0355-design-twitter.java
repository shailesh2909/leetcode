class Twitter {

    private static int time = 0;
    HashMap<Integer, List<int[]>> tweets;

    HashMap<Integer, HashSet<Integer>> followMap;

    public Twitter() {
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        // max heap based on time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int user : followMap.get(userId)) {
            if (tweets.containsKey(user)) {
                List<int[]> list = tweets.get(user);
                int lastIndex = list.size() - 1;

                pq.offer(new int[]{
                    list.get(lastIndex)[0],
                    list.get(lastIndex)[1],
                    user,
                    lastIndex
                });
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {

            int[] curr = pq.poll();
            res.add(curr[0]);

            int user = curr[2];
            int index = curr[3] - 1;

            if (index >= 0) {
                int[] nextTweet = tweets.get(user).get(index);
                pq.offer(new int[]{
                    nextTweet[0],
                    nextTweet[1],
                    user,
                    index
                });
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>())
                 .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}