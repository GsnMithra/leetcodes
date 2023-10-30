/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List <List <Integer>> levels;
    public int getHeight (Node root) {
        if (root == null)
            return 0;
        if (root.children.size () == 0)
            return 1;
        
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size (); i += 1)
            maxHeight = Math.max (maxHeight, 1 + getHeight (root.children.get (i)));
        
        return maxHeight;
    }
    
    public void levelOrderUtil (Node root, int heightTree) {
        if (root == null)
            return; 
        this.levels.get (heightTree - 1).add (root.val);
        
        for (int i = 0; i < root.children.size (); i += 1)
            levelOrderUtil (root.children.get (i), heightTree + 1);
    }
    
    public List <List <Integer>> levelOrder (Node root) {
        int heightTree = getHeight (root);
        this.levels = new ArrayList <>();
        for (int i = 0; i < heightTree; i += 1)
            this.levels.add (new ArrayList <Integer>());
            
        levelOrderUtil (root, 1);
        
        return this.levels;
    }
}