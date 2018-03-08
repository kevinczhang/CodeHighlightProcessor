class Solution {
    public int minMutation(String start, String end, String[] bank) {
        List<Integer>[] graph = new List[bank.length];
        for (int i = 0; i < bank.length; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < bank.length; j++)
                if (canMutate(bank[i], bank[j])) graph[i].add(j);
        }

        int targetIdx = -1;
        for (int i = 0; i < bank.length; i++) {
            if (bank[i].equals(end)) {
                targetIdx = i;
                break;
            }
        }
        if (targetIdx == -1) return -1;

        // endXXX means something calculated from end to start
        int[] endDist = new int[bank.length];
        Arrays.fill(endDist, -1);
        endDist[targetIdx] = 0;
        Queue<Integer> endQ = new ArrayDeque<>();
        for (int idx : graph[targetIdx]) {
            endQ.add(idx);
            endDist[idx] = 1;
        }

        // startXXX means something calculated from start to end
        int[] startDist = new int[bank.length];
        Arrays.fill(startDist, -1);
        Queue<Integer> startQ = new ArrayDeque<>();
        for (int i = 0; i < bank.length; i++) {
            if (canMutate(start, bank[i])) {
                if (bank[i].equals(end)) return 1;
                startQ.add(i);
                startDist[i] = 1;
            }
        }

        while (!startQ.isEmpty() && !endQ.isEmpty()) {
            int startIdx = startQ.poll();
            for (int nextIdx : graph[startIdx]) {
                if (startDist[nextIdx] != -1) continue;
                else if (endDist[nextIdx] >= 0) return startDist[startIdx] + endDist[nextIdx] + 1;
                else {
                    startDist[nextIdx] = startDist[startIdx] + 1;
                    startQ.add(nextIdx);
                }
            }

            int endIdx = endQ.poll();
            for (int nextIdx : graph[endIdx]) {
                if (endDist[nextIdx] != -1) continue;
                else if (startDist[nextIdx] > 0) return startDist[nextIdx] + endDist[endIdx] + 1;
                else {
                    endDist[nextIdx] = endDist[endIdx] + 1;
                    endQ.add(nextIdx);
                }
            }
        }

        return -1;
    }

    private boolean canMutate(String gen1, String gen2) {
        int diff = 0;
        for (int i = 0; i < gen1.length(); i++)
            diff += gen1.charAt(i) == gen2.charAt(i) ? 0 : 1;
        return diff == 1;
    }
}