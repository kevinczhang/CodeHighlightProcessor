public class Solution {
    public int findMaxGuests(int[] arrivals, int[] exits) {
        // Sort arrival and exit arrays
        Arrays.sort(arrivals);
        Arrays.sort(exits);

        // guests_in indicates number of guests at a time
        int guests_in = 1, max_guests = 1, time = arrivals[0];
        int i = 1, j = 0, n = arrivals.length;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of guests
            if (arrivals[i] <= exits[j]) {
                guests_in++;
                // Update max_guests if needed
                if (guests_in > max_guests) {
                    max_guests = guests_in;
                    time = arrivals[i];
                }
                i++;  //increment index of arrival array
            } else {// If event is exit, decrement count
                // of guests.
                guests_in--;
                j++;
            }
        }
        return max_guests;
    }
}