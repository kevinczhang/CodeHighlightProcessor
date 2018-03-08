public class Solution {
    // http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] pos = new ArrayList[s.length() + 1];
        pos[0] = new ArrayList<String>();
        // Construct a graph for positions with related words
        for (int i = 0; i < s.length(); i++) {
            if (pos[i] == null) continue;
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (!wordDict.contains(sub)) continue;
                if (pos[j] == null) {
                    pos[j] = new ArrayList<String>();
                }
                pos[j].add(sub);
            }
        }

        List<String> result = new ArrayList<String>();
        if (pos[s.length()] != null)
            dfs(pos, result, "", s.length());
        return result;
    }

    public void dfs(List<String>[] pos, List<String> result, String curr, int curInd) {
        if (curInd == 0) {
            result.add(curr.trim());
            return;
        }

        for (String s : pos[curInd]) {
            String combined = s + " " + curr;
            dfs(pos, result, combined, curInd - s.length());
        }
    }
}