public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), cnt = words.length;
        if (n <= 0 || cnt <= 0) {
            return ans;
        }

        // init word occurence
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < cnt; ++i) {
            if (dict.containsKey(words[i])) {
                dict.put(words[i], dict.get(words[i]) + 1);
            } else {
                dict.put(words[i], 1);
            }
        }

        // travel all sub string combinations
        int wl = words[0].length();
        for (int i = 0; i < wl; ++i) {
            int left = i, count = 0;
            Map<String, Integer> tdict = new HashMap<>();
            for (int j = i; j <= n - wl; j += wl) {
                String str = s.substring(j, j + wl);
                // a valid word, accumulate results
                if (dict.containsKey(str)) {
                    if (tdict.containsKey(str)) {
                        tdict.put(str, tdict.get(str) + 1);
                    } else {
                        tdict.put(str, 1);
                    }
                    if (tdict.get(str) <= dict.get(str))
                        count++;
                    else {
                        // a more word, advance the window left side possiablly
                        while (tdict.get(str) > dict.get(str)) {
                            String str1 = s.substring(left, left + wl);
                            tdict.put(str1, tdict.get(str1) - 1);
                            if (tdict.get(str1) < dict.get(str1)) {
                                count--;
                            }
                            left += wl;
                        }
                    }
                    // come to a result
                    if (count == cnt) {
                        ans.add(left);
                        // advance one word
                        tdict.put(s.substring(left, left + wl), dict.get(s.substring(left, left + wl)) - 1);
                        count--;
                        left += wl;
                    }
                } else {
                    tdict.clear();
                    count = 0;
                    left = j + wl;
                }
            }
        }
        return ans;
    }
}