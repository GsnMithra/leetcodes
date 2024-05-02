// public int findMaxK (int [] nums) {
//         int i = 0, j = nums.length - 1;
//         Arrays.sort (nums);
        
//         while (i < j) {
//             int first = Math.abs (nums[i]);
//             int second = Math.abs (nums[j]);
            
//             if (nums[i] < 0 && nums[j] > 0 && first == second)
//                 return first;
//             if (first < second)
//                 j -= 1;
//             else
//                 i += 1;
//         }
        
//         return -1;
//     }

impl Solution {
    pub fn find_max_k (mut nums: Vec <i32>) -> i32 {
        let (mut i, mut j) = (0, nums.len () - 1);
        nums.sort ();
        
        while (i < j) {
            let first = nums[i].abs ();
            let second = nums[j].abs ();
            
            if nums[i] < 0 && nums[j] > 0 && first == second {
                return first;
            }
            
            if first < second {
                j -= 1;
            } else {
                i += 1;
            }
        }
        
        -1
    }
}