# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues (self, root: Optional[TreeNode]) -> List[int]:
        results = list ()
        
        def getHeight (root):
            if not root:
                return 0
            leftHeight = 1 + getHeight (root.left)
            rightHeight = 1 + getHeight (root.right)
            return max (leftHeight, rightHeight)
        heightTree = getHeight (root)
        
        def largestValuesUtil (root, currLevel, currMax):
            if not root:
                return
            if currLevel == 1:
                currMax[0] = max (currMax[0], root.val)
            else:
                largestValuesUtil (root.left, currLevel - 1, currMax)
                largestValuesUtil (root.right, currLevel - 1, currMax)
        
        for i in range (1, heightTree + 1):
            maxValue = [(-1) * float ('inf')]
            largestValuesUtil (root, i, maxValue)
            results.append (maxValue[0])
        
        return results