class Solution:
    def findDuplicate (self, nums: List[int]) -> int:
        nums = sorted (nums)
        
        prev = -1
        for val in nums:
            if val == prev:
                return val
            
            prev = val
        
        return prev
        