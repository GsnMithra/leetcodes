class DSU {
    int [] ids;
    DSU (int n) {
        this.ids = new int [n];
        for (int i = 0; i < n; i += 1)
            this.ids[i] = i;
    }
    
    int find (int v) {
        if (this.ids[v] != v)
            this.ids[v] = find (this.ids[v]);
        return this.ids[v];
    }
    
    void union (int p, int q) {
        int pid = find (p);
        int qid = find (q);
        if (pid != qid)
            this.ids[pid] = qid;
    }
}

class Solution {
    public int findCircleNum (int [] isConnected []) {
        Set <Integer> roots = new HashSet <>();
        DSU uf = new DSU (isConnected.length);
        
        for (int i = 0; i < isConnected.length; i += 1) {
            for (int j = 0; j < isConnected[i].length; j += 1) {
                if (isConnected[i][j] == 1)
                    uf.union (i, j);
            }
        }
        
        for (int i = 0; i < isConnected.length; i += 1)
            roots.add (uf.find (i));
        
        return roots.size ();
    }
}