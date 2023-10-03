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
    List <String> result;
    
    public void pathsUtil (TreeNode root, String curr) {
        if (root != null && root.left == null && root.right == null) {
            String currPath = curr + String.valueOf (root.val);
            currPath = currPath.replaceAll (" ", "->");
            this.result.add (currPath);
        }
        if (root != null) {
            pathsUtil (root.left, curr + String.valueOf (root.val) + " ");
            pathsUtil (root.right, curr + String.valueOf (root.val) + " ");
        }
    }
    
    public List <String> binaryTreePaths (TreeNode root) {
        this.result = new LinkedList <>();
        
        pathsUtil (root, "");
        
        return this.result;
    }
}