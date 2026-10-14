class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            long target = (success + spells[i] - 1) / spells[i];
            int left = 0, right = m, idx = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= target) {
                    idx = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - idx;
        }
        return ans;
    }
}