class Solution:
    def isMonotonic (self, nums: List[int]) -> bool:
        leftMono = True
        rightMono = True
        
        for i in range (len (nums) - 1):
            if nums[i] > nums[i + 1]:
                leftMono = False
                break
        
        for i in range (len (nums) - 1):
            if nums[i] < nums[i + 1]:
                rightMono = False
                break
                
        return leftMono or rightMono