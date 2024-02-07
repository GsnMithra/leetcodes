/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map <Integer, Stack <Integer>> levelMap;
    private void reverseLevelUtil (TreeNode root, int levelKey, boolean put) {
        if (root == null)
            return;
        
        reverseLevelUtil (root.left, levelKey + 1, put);
        if (levelKey % 2 != 0) {
            if (put) 
                root.val = levelMap.get (levelKey).pop ();   
            else {
                levelMap.putIfAbsent (levelKey, new Stack <>());
                levelMap.get (levelKey).push (root.val);
            }
        }
        reverseLevelUtil (root.right, levelKey + 1, put);
    }
    
    public TreeNode reverseOddLevels (TreeNode root) {
        this.levelMap = new HashMap <>();
        reverseLevelUtil (root, 0, false);
        reverseLevelUtil (root, 0, true);
        return root;
    }
}