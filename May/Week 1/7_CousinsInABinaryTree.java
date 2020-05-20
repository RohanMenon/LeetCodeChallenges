/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 
Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

*/


/**
 * Definition for a binary tree node.  [This class definition is already given.]
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
    
    class Result{
        int level;
        TreeNode parent;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
	
	Result xNode = checkParentAndLevel(root, root, x, 0);
	Result yNode = checkParentAndLevel(root, root, y, 0);

	if (xNode == null || yNode == null) return false;

	if (xNode.parent != yNode.parent && xNode.level == yNode.level) return true;
        
	return false;
    }
    
    private Result checkParentAndLevel(TreeNode node, TreeNode parent, int target, int level){
        if (node.val == target) {  
            Result obj = new Result();
            obj.level = level;
            obj.parent = parent;
            return obj;
        }

        else if (node.left == null && node.right == null) return null;

        parent = node;
        Result l = null;
        if (node.left!= null)   l = checkParentAndLevel(node.left, parent, target, level + 1);

        if (l != null) return l;

        else if (node.right != null) return checkParentAndLevel(node.right, parent, target, level+1);
        
	return null;
    }
}
