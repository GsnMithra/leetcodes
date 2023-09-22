class Solution {
    public int kthFactor (int n, int k) {
        int currK = 0;
        
        for (int i = 1; i <= n; i += 1) {
            if (n % i == 0)
                currK += 1;
            if (currK == k)
                return i;
        }
        
        return -1;
    }
}