class Solution {
    public int numSquares (int n) {
        
        List <Integer> sqrts = new ArrayList <>();
        int sqrtN = (int) Math.sqrt (n);
        for (int i = 1; i <= sqrtN; i += 1)
            sqrts.add (i * i);
        
        int [] dp = new int [10001];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i += 1) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < sqrts.size (); j += 1) {
                if (sqrts.get (j) > i)
                    break;
                dp[i] = Math.min (dp[i], dp[i - sqrts.get (j)] + 1);
            }
        }
        
        return dp[n];
    }
}

//         for(int i=1;i<=n;i++){
//             dp[i]=INF;
//             for(int j=0;j<sz;j++){
//                 if(sq[j]>i)break;
//                 dp[i]=min(dp[i],1+dp[i-sq[j]]);
//             }
//         }
