class Solution(object):
    def merge (self, nums1, m, right, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        
        left = nums1[:m]
        lid, rid, kid = (0, 0, 0)
        while lid < len (left) and rid < len (right):
            if left[lid] <= right[rid]:
                nums1[kid] = left[lid]
                lid += 1
            else:
                nums1[kid] = right[rid]
                rid += 1;
            kid += 1

        while lid < len (left):
            nums1[kid] = left[lid]
            kid += 1
            lid += 1

        while rid < len (right):
            nums1[kid] = right[rid]
            kid += 1
            rid += 1