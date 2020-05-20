/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
   
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
 
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*/


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
    static int visited;
    public TreeNode inOrderTraversal(TreeNode node, int k){
        if(node == null)
            return null;
        
        TreeNode l = inOrderTraversal(node.left, k);
        
        if(l != null)
            return l;
        
        ++visited;
        if(visited == k)
            return node;
        
        return inOrderTraversal(node.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        visited = 0;
        
        TreeNode result = inOrderTraversal(root, k);        
        if(result == null)
            return 0;
        
        return result.val;
    }
}
