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
    List <List <Integer>> levelOrderList;
    List <Integer> currLevel;
    
    public void findCurrLevel (TreeNode root, int curr) {
        if (root == null)
            return;
        if (curr == 1)
            currLevel.add (root.val);
        else {
            findCurrLevel (root.left, curr - 1);
            findCurrLevel (root.right, curr - 1);
        }
    }
    
    public void levelOrder (TreeNode root, int n) {
        for (int i = n; i > 0; i -= 1) {
            this.currLevel = new LinkedList <>();
            findCurrLevel (root, i);
            this.levelOrderList.add (this.currLevel);
        }
    }
    
    public int height (TreeNode root) {
        if (root == null)
            return 0;
        
        int leftHeight = 1 + height (root.left);
        int rightHeight = 1 + height (root.right);
        
        return Math.max (leftHeight, rightHeight);
    }
    
    public List <List <Integer>> levelOrderBottom (TreeNode root) {
        this.levelOrderList = new LinkedList <>();
        levelOrder (root, height (root));
        return this.levelOrderList;
    }
}