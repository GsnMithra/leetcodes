struct DSU {
    ids: Vec <usize>
}

impl DSU {
    fn new (n: usize) -> Self {
        let mut nums = vec! [0; n];
        for i in 0..n {
            nums[i] = i;
        }
        DSU { ids: nums }
    }
    
    fn find (self: &mut Self, v: usize) -> usize {
        if self.ids[v] != v {
            self.ids[v] = self.find (self.ids[v]);
        }
        self.ids[v]
    }
    
    fn connected (self: &mut Self, p: usize, q: usize) -> bool {
        self.find (p) == self.find (q)
    }
    
    fn union (self: &mut Self, p: usize, q: usize) {
        let pid = self.find (p);
        let qid = self.find (q);
        
        if pid != qid {
            self.ids[pid] = qid;
        }
    }
}

impl Solution {
    pub fn valid_path (
        n: i32, 
        edges: Vec<Vec<i32>>, 
        source: i32, 
        destination: i32
    ) -> bool {
        let mut dsu: DSU = DSU::new (n as usize);
        
        for edge in edges {
            let (src, dest) = (edge[0], edge[1]);
            dsu.union (src as usize, dest as usize);
        }
        
        dsu.connected (source as usize, destination as usize)
    }
}