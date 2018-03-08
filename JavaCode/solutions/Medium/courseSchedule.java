public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        // 先初始化图，每个赋一个空列表
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        // 根据边建立图，并计算入度
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        // 找到有向图的入口
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        // 按照拓扑排序的顺序，进行广度优先搜索
        int cnt = 0;
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            cnt++;
            ArrayList<Integer> nexts = graph[curr];
            for(int i = 0; i < nexts.size(); i++){
                int next = nexts.get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return cnt == numCourses;
    }
}