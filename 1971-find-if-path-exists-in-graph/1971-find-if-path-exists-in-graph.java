import java.util.ArrayList;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        return dfs(adjList, source, destination, visited);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int curNode, int destination, boolean[] visited) {
        if (curNode == destination) {
            return true;
        }
        
        visited[curNode] = true;

        for (int neighbour : adjList.get(curNode)) {
            if (!visited[neighbour]) {
                if (dfs(adjList, neighbour, destination, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}