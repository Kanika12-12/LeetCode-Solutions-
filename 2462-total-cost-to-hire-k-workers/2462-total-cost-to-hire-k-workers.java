class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        
        int left = 0;
        int right = n - 1;
        long totalCost = 0;
        
        for (int i = 0; i < k; i++) {
            while (pqLeft.size() < candidates && left <= right) {
                pqLeft.add(costs[left++]);
            }
            while (pqRight.size() < candidates && left <= right) {
                pqRight.add(costs[right--]);
            }
            
            int top1 = pqLeft.isEmpty() ? Integer.MAX_VALUE : pqLeft.peek();
            int top2 = pqRight.isEmpty() ? Integer.MAX_VALUE : pqRight.peek();
            
            if (top1 <= top2) {
                totalCost += pqLeft.poll();
            } else {
                totalCost += pqRight.poll();
            }
        }
        
        return totalCost;
    }
}