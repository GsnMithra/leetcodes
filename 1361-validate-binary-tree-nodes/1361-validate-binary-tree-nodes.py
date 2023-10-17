class Solution:
    def validateBinaryTreeNodes (self, N: int, leftChild: List[int], rightChild: List[int]) -> bool:
        graph = [set () for _ in range (N)]
        
        root = { i for i in range (N) }
        for i in range (N):
            left = leftChild [i]
            right = rightChild [i]
            if left != -1:
                graph[i].add (left)
            if right != -1:
                graph[i].add (right)
        
        visited = [False for _ in range (N)]
        for i in range (N):
            if leftChild [i] in root:
                root.remove (leftChild[i])
            if rightChild [i] in root:
                root.remove (rightChild[i])
            
        if len (root) == 0:
            return False
        
        queue = [root.pop ()]
        visited [queue[0]] = True
        
        while queue:
            currNode = queue.pop (0)
            
            for neigh in graph[currNode]:
                if visited[neigh]:
                    return False
                
                visited[neigh] = True
                queue.append (neigh)
        
        return not False in visited