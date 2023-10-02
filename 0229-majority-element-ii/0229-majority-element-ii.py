class Solution:
    def majorityElement (self, nums: List[int]) -> List[int]:
        majority = len (nums) / 3
        frequency = dict ()
        
        for num in nums:
            if num in frequency.keys ():
                frequency[num] += 1
            else:
                frequency[num] = 1
        
        results = list ()
        for K, V in frequency.items ():
            if V > majority:
                results.append (K)
        
        return results