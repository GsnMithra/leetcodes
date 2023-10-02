class Union:
    def __init__ (self, N):
        self.N = N
        self.ids = [i for i in range (self.N)]
    
    def find (self, V):
        return self.find (self.ids[V]) if self.ids[V] != V else self.ids[V]
    
    def union (self, T, R):
        T = self.find (T)
        R = self.find (R)
        if T != R:
            self.ids[T] = R

    def connected (self, T, R):
        return self.find (T) == self.find (R)
    
class Solution:
    def equationsPossible (self, equations: List[str]) -> bool:
        nodes = set ()
        equations = list (reversed (sorted (equations, key=lambda edge: edge[1])))
        
        currNode = 0
        for eqn in equations:
            nodes.add (ord (eqn[0]) - 97)
            nodes.add (ord (eqn[-1]) - 97)
        
        union = Union (max (nodes) + 1)
        
        for eqn in equations:
            first = ord (eqn[0]) - 97
            second = ord (eqn[-1]) - 97
            
            if '==' in eqn:
                union.union (first, second)
            else:
                if union.connected (first, second):
                    return False
        
        return True
        