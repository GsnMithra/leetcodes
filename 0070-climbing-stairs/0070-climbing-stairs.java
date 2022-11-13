class Solution {
    int[] cache;
    public void init_array(int size) {   
        cache = new int[size + 1];
        Arrays.fill(cache, -1);
    }
    
    public int helper (int n) {
        if (cache[n] != -1) { return cache[n]; }
        if (n <= 1) {
            return n;
        }
        if (n > 2) {
            cache[n] = helper(n - 1) + helper(n - 2);
            return cache[n];
        }
        else {
            cache[n] = 1 + helper(n - 1) + helper(n - 2);
            return cache[n];
        }
    }
    
    public int climbStairs(int n) {
        init_array(n);
        return helper (n);
    }
}