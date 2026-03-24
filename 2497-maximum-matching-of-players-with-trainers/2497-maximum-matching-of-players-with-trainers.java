class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);

        int l = 0, r = 0;

        while(l < trainers.length && r < players.length)
        {
            if(players[r] <= trainers[l])
            {
                r++;
            }
            l++;
        }

        return r;
    }
}