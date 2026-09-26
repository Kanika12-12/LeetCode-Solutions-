class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int curr : asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
                int top = stack.peek();
                if (top < Math.abs(curr)) {
                    stack.pop();
                } else if (top == Math.abs(curr)) {
                   
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                   
                    isDestroyed = true;
                    break;
                }
            }

            
            if (!isDestroyed) {
                stack.push(curr);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}