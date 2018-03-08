public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < houses.length) {
            // if house is located after some heater
            if (houses[i] > heaters[j]) {
                // then find a heater that stands after the house
                while (j != heaters.length - 1 && heaters[j] < houses[i]) {
                    j++;
                }
            }
            // corner case when the heater is the first  one
            if (j == 0 || heaters[j] < houses[i]) {
                ans = Math.max(ans, Math.abs(heaters[j] - houses[i]));
                i++;
                continue;
            }
            // if house is located between jth and j-1th heaters
            int dist = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]);
            ans = Math.max(ans, dist);
            i++;
        }
        return ans;
    }
}