class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        visited.put(node, new Node(node.val,new ArrayList<>()));
        q.add(node);
        while(!q.isEmpty()){
            Node t = q.remove();
            for(Node n:t.neighbors){
                if(!visited.containsKey(n)){
                    visited.put(n,new Node(n.val,new ArrayList<>()));
                    q.add(n);

                }
                visited.get(t).neighbors.add(visited.get(n));

            }
        }
        return visited.get(node);
        
    }
}