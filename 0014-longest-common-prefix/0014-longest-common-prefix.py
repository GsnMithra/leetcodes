class Solution:
    def longestCommonPrefix (self, strs: List[str]) -> str:
        strs = sorted (strs)
        
        prefix = ''
        for i in range (len (strs[0])):
            start = strs[0][i]
            for j in range (len (strs)):
                if strs[j][i] != start:
                    return prefix
            prefix += start
        
        return prefix