class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        
        // nums2 ke basis par descending order mein sort karo
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            minHeap.add(pairs[i][0]);
            sum += pairs[i][0];
            
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * (long)pairs[i][1]);
            }
        }
        
        return maxScore;
    }
}