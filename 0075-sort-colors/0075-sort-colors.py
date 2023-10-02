class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        countSort = dict ()
        for n in nums:
            if n in countSort.keys ():
                countSort[n] += 1
            else:
                countSort[n] = 1
        
        currDigit = 0
        for i in range (len (nums)):
            while currDigit not in countSort.keys () or countSort[currDigit] == 0:
                currDigit += 1
            nums[i] = currDigit
            countSort[currDigit] -= 1