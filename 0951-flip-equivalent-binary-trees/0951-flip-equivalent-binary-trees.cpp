/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void swapUtil (TreeNode * a) {
        TreeNode * tmp = a -> left;
        a -> left = a -> right;
        a -> right = tmp;
    }
    
    bool flipEquiv (TreeNode * a, TreeNode * b) {
        if (a == nullptr && b == nullptr)
            return true;
        if (a == nullptr || b == nullptr || a -> val != b -> val)
            return false;
        
        bool result = flipEquiv (a -> left, b -> left) && flipEquiv (a -> right, b -> right);
        if (!result)
            swapUtil (a);
        return flipEquiv (a -> left, b -> left) && flipEquiv (a -> right, b -> right);
    }
};