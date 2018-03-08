public class Solution {
    public String getHint(String secret, String guess) {
        int bull, cow;
        bull = cow = 0;

        //store the digits of secrete
        int[] counter_secret = new int[10]; 
        //store the digits of guess
        int[] counter_guess = new int[10]; 

        int L = secret.length();
        for(int i=0; i<L; i++) {
            counter_secret[secret.charAt(i)-'0']++;
            // if meets a bull, secrete counter should not change
            if(secret.charAt(i)==guess.charAt(i)) {
                bull++;
                counter_secret[secret.charAt(i)-'0']--;
            } else {
                counter_guess[guess.charAt(i)-'0']++;
            }
        }

        // check the two arrays item by item and sum up the cows
        for(int i = 0; i <= 9; i++) {
            cow += counter_secret[i] >= counter_guess[i] ? 
            counter_guess[i]:counter_secret[i];
        } 
        return bull + "A" + cow + "B";
    }
}