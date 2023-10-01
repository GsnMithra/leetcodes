class Solution:
    def networkDelayTime (self, times: List[List[int]], n: int, k: int) -> int:
        
        graph = dict ()
        for src, dest, weight in times:
            if src not in graph.keys ():
                graph[src] = set ()
            graph[src].add ((dest, weight))

        queue = list ()
        weights = [float ('inf') for _ in range (n + 1)]
        
        heapq.heappush (queue, ((k, 0)))
        weights[k] = 0
        
        while len (queue) != 0:
            currNode, currWeight = heapq.heappop (queue)
            if currNode not in graph:
                continue
            
            for node, weight in graph[currNode]:
                if weights[currNode] + weight < weights[node]:
                    weights[node] = weights[currNode] + weight
                    heapq.heappush (queue, (node, weights[node]))
                    
        weights = weights[1:]
        if float ('inf') in weights:
            return -1
        return max (weights)