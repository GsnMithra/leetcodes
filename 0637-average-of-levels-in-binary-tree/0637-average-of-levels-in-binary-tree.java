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
    List <Double> result;
    List <Integer> currLevel;
    
    public int height (TreeNode root) {
        if (root == null)
            return 0;
        
        int leftHeight = 1 + height (root.left);
        int rightHeight = 1 + height (root.right);
        
        return Math.max (leftHeight, rightHeight);
    }
    
    public void levelOrder (TreeNode root) {
        int n = height (root);
        for (int i = 1; i <= n; i += 1) {
            this.currLevel = new ArrayList <>();
            currLevel (root, i);
            
            double sumValue = 0;
            for (int s = 0; s < this.currLevel.size (); s += 1)
                sumValue += this.currLevel.get (s);
            this.result.add ((double) sumValue / this.currLevel.size ());
        }
    }
    
    public void currLevel (TreeNode root, int curr) {
        if (root == null)
            return;
        if (curr == 1)
            this.currLevel.add (root.val);
        else {
            currLevel (root.left, curr - 1);
            currLevel (root.right, curr - 1);
        }
    }
    
    public List <Double> averageOfLevels (TreeNode root) {
        this.result = new ArrayList <>();
        levelOrder (root);
        
        return this.result;
    }
}