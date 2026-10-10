class Solution {
    private static class Edge {
        String dest;
        double weight;
        
        public Edge(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Edge>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            
            graph.get(u).add(new Edge(v, val));
            graph.get(v).add(new Edge(u, 1.0 / val));
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, 1.0, graph, visited);
            }
        }
        
        return results;
    }
    
    private double dfs(String current, String target, double currentProduct, Map<String, List<Edge>> graph, Set<String> visited) {
        if (current.equals(target)) {
            return currentProduct;
        }
        
        visited.add(current);
        
        for (Edge edge : graph.get(current)) {
            if (!visited.contains(edge.dest)) {
                double result = dfs(edge.dest, target, currentProduct * edge.weight, graph, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0;
    }
}