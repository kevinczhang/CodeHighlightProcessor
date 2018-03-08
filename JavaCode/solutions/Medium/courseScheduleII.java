public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            if(graph[prerequisites[i][1]] == null){
                graph[prerequisites[i][1]] = new ArrayList<Integer>();
            }
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        // 用idx记录输出数组的下标
        int idx = 0;
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            res[idx++] = curr;
            if(graph[curr] == null) continue;
            for(Integer next : graph[curr]){
                if(--indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        // 如果有环则返回空数组
        return idx != numCourses ? new int[0] : res;
    }
}