class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return binaryMaximum(arr, 0, arr.length - 1);
    }
    
    public static int binaryMaximum(int[] nums, int first, int last) {
        int mid = first + (last - first) / 2;
        if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
        if(nums[mid] > nums[mid + 1]) return binaryMaximum(nums, first, mid);
        if(nums[mid] < nums[mid + 1]) return binaryMaximum(nums, mid + 1, last);
        return -1;
    }
}