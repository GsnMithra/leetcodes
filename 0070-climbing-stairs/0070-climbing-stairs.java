class Solution {
    int[] cache;
    public void init_array(int size) {   
        cache = new int[size + 1];
        Arrays.fill(cache, -1);
    }
    
    public int helper (int n) {
        if (cache[n] != -1) { return cache[n]; }
        if (n <= 3) {
            return n;
        }
        else {
            cache[n] = helper(n - 1) + helper(n - 2);
            return cache[n];
        }
    }
    
    public int climbStairs(int n) {
        init_array(n);
        return helper (n);
    }
}