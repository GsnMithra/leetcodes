class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
            
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int returner[] = {map.get(target - nums[i]), i};
                return returner;
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
}