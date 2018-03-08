public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Map task to number of tasks
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        // Sort tasks based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ?
                        b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );
        pq.addAll(map.entrySet());

        int count = 0;
        while(!pq.isEmpty()){
            int cycle = n + 1; // total time to execute a task
            List<Map.Entry<Character, Integer>> remainingTasks = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()){
                Map.Entry<Character, Integer> top = pq.poll();
                // Update count of this task if still has left
                if(top.getValue() - 1 > 0){
                    top.setValue(top.getValue() - 1);
                    remainingTasks.add(top);
                }
                cycle--; // Update time left in this cycle
                count++; // Successfully executed task
            }
            for(Map.Entry<Character, Integer> t : remainingTasks){
                pq.add(t);
            }
            if(pq.isEmpty()) break;
            count += cycle;
        }
        return count;
    }
}