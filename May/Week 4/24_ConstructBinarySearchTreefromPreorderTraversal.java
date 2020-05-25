/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

        8
       / \
      5   10
     / \    \
    1   7   12
    
Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.

*/

/* Intuition: https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/?ref=rp */


/**
 * Definition for a binary tree node.       //given as part of the question
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
    public TreeNode bstFromPreorder(int[] preorder) {            
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        for(int i=1;i<preorder.length;i++){
            TreeNode temp = null;
            
            while(!stack.isEmpty() && preorder[i] > stack.peek().val)
                temp = stack.pop();
        
            if(temp != null){
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            }
            
            else{
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }
        
        return root;
    }
}
