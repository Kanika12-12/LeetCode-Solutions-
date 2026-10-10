class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            graph[u].add(new int[] {v, 1});
            graph[v].add(new int[] {u, 0}); 
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;
        
        for (int[] neighborInfo : graph[node]) {
            int neighbor = neighborInfo[0];
            int cost = neighborInfo[1];
            
            if (!visited[neighbor]) {
                changes += cost; 
                changes += dfs(neighbor, graph, visited);
            }
        }
        
        return changes;
    }
}