public class Solution {

    class WordNode {
        String word;
        int numSteps;
        WordNode pre;

        public WordNode(String word, int numSteps, WordNode pre) {
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }
    }

    // Single direction BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1, null));
        int minStep = 0;

        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);
        int preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if (word.equals(endWord)) {
                if (minStep == 0) {
                    minStep = top.numSteps;
                }

                if (top.numSteps == minStep && minStep != 0) {
                    ArrayList<String> t = new ArrayList<>();
                    t.add(top.word);
                    while (top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }

            // The used word is only removed when steps change.
            // Start of the next level
            if (preNumSteps < currNumSteps) {
                unvisited.removeAll(visited);
            }
            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return result;
    }

    // Bi-direction BFS
    //flag of whether we have connected two parts
    boolean isConnected = false;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        //we use bi-directional BFS to find shortest path
        Set<String> fwd = new HashSet<>();
        fwd.add(beginWord);
        Set<String> bwd = new HashSet<>();
        bwd.add(endWord);

        Map<String, List<String>> hs = new HashMap<>();
        BFS(fwd, bwd, wordList, false, hs);
        List<List<String>> result = new ArrayList<>();
        //if two parts cannot be connected, then return empty list
        if(!isConnected) return result;

        //we need to add start node to temp list as there is no other node can get start node
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        DFS(result, temp, beginWord, endWord, hs);
        return result;
    }

    public void BFS(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap, Map<String, List<String>> hs){
        //boundary check
        if(forward.isEmpty() || backward.isEmpty()){
            return;
        }

        //we always do BFS on direction with less nodes
        //here we assume forward set has less nodes, if not, we swap them
        if(forward.size() > backward.size()){
            BFS(backward, forward, dict, !swap, hs);
            return;
        }

        //remove all forward/backward words from dict to avoid duplicate addition
        dict.removeAll(forward);
        dict.removeAll(backward);

        //new set contains all new nodes from forward set
        Set<String> set3 = new HashSet<String>();

        //do BFS on every node of forward direction
        for(String str : forward){
            //try to change each char of str
            for(int i = 0; i < str.length(); i++){
                //try to replace current char with every chars from a to z
                char[] ary = str.toCharArray();
                for(char j = 'a'; j <= 'z'; j++){
                    ary[i] = j;
                    String temp = new String(ary);

                    //we skip this string if it is not in dict nor in backward
                    if(!backward.contains(temp) && !dict.contains(temp)){
                        continue;
                    }

                    //we follow forward direction
                    String key = !swap? str : temp;
                    String val = !swap? temp : str;

                    if(!hs.containsKey(key))
                        hs.put(key, new ArrayList<String>());
                    //if temp string is in backward set, then it will connect two parts
                    if(backward.contains(temp)){
                        hs.get(key).add(val);
                        isConnected = true;
                    }

                    //if temp is in dict, then we can add it to set3 as new nodes in next layer
                    if(!isConnected && dict.contains(temp)){
                        hs.get(key).add(val);
                        set3.add(temp);
                    }
                }

            }
        }

        //to force our path to be shortest, we will not do BFS if we have found shortest path(isConnected = true)
        if(!isConnected){
            BFS(set3, backward, dict, swap, hs);
        }
    }

    public void DFS(List<List<String>> result, List<String> temp, String start, String end, Map<String, List<String>> hs){
        //we will use DFS, more specifically backtracking to build paths
        //boundary case
        if(start.equals(end)){
            result.add(new ArrayList<String>(temp));
            return;
        }

        //not each node in hs is valid node in shortest path, if we found current node does not have children node,
        //then it means it is not in shortest path
        if(!hs.containsKey(start)){
            return;
        }

        for(String s : hs.get(start)){
            temp.add(s);
            DFS(result, temp, s, end, hs);
            temp.remove(temp.size()-1);

        }
    }
}