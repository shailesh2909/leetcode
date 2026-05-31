class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        for (int i = 0; i < asteroids.length; i++) {
            if (mass >= asteroids[i])

            {
                mass += asteroids[i];
            }
            if (mass >= asteroids[asteroids.length - 1])
                return true;
            if (mass < asteroids[i])
                return false;

        }

        return true;
    }
}