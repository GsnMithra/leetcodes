/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node [] levelsPrevious;
    public int heightTree (Node root) {
        if (root == null)
            return 0;
        
        int leftTree = 1 + heightTree (root.left);
        int rightTree = 1 + heightTree (root.right);
        
        return Math.max (leftTree, rightTree);
    }
    
    // [n, n, n]
    
    public void connectUtil (Node root, int currLevel) {
        if (root == null)
            return;
        
        if (this.levelsPrevious[currLevel] != null) {
            this.levelsPrevious[currLevel].next = root;
            this.levelsPrevious[currLevel] = root;
        } else {
            this.levelsPrevious[currLevel] = root;
        }
        
        connectUtil (root.left, currLevel + 1);
        connectUtil (root.right, currLevel + 1);
    }
    
    public Node connect (Node root) {
        this.levelsPrevious = new Node [heightTree (root)];
        for (int i = 0; i < levelsPrevious.length; i += 1)
            levelsPrevious[i] = null;
        connectUtil (root, 0);
        
        return root;
    }
}