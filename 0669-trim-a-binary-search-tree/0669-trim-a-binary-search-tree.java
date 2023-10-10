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
    public TreeNode insertNode (TreeNode root, int value) {
        if (root == null) 
            return new TreeNode (value);
        
        if (root.val < value)
            root.right = insertNode (root.right, value);
        else if (root.val > value)
            root.left = insertNode (root.left, value);
        
        return root;
    }
    
    public int heightTree (TreeNode root) {
        if (root == null)
            return 0;
        
        int leftHeight = 1 + heightTree (root.left);
        int rightHeight = 1 + heightTree (root.right);
        
        return Math.max (leftHeight, rightHeight);
    }
    
    public void levelOrderUtil (TreeNode root, int currLevel, List <Integer> curr) {
        if (root == null)
            return;
        if (currLevel == 1)
            curr.add (root.val);
        else {
            levelOrderUtil (root.left, currLevel - 1, curr);
            levelOrderUtil (root.right, currLevel - 1, curr);
        }
    } 
    
    public List <List <Integer>> levelOrder (TreeNode root) {
        int height = heightTree (root);
        List <List <Integer>> levels = new LinkedList <>();
        List <Integer> currLevel;
        
        for (int i = 1; i <= height; i += 1) {
            currLevel = new LinkedList <>();
            levelOrderUtil (root, i, currLevel);
            levels.add (currLevel);
        }
        
        return levels;
    }
    
    public TreeNode trimBST (TreeNode root, int low, int high) {
        List <List <Integer>> levels = levelOrder (root);
        TreeNode newRoot = null;
        
        for (List <Integer> level : levels) {
            for (int n : level) {
                if (n >= low && n <= high) 
                    newRoot = insertNode (newRoot, n);
            }
        }
        
        return newRoot;
    }
}