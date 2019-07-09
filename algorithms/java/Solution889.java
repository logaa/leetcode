/**
 * 
 * 根据前序和后序遍历构造二叉树
 * 
 * 返回与给定的前序和后序遍历匹配的任何二叉树。 pre 和 post 遍历中的值是不同的正整数。
 * 
 * 示例：
 * 
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1] 输出：[1,2,3,4,5,6,7]  
 * 
 * 提示：
 * 1 <= pre.length == post.length <= 30 pre[] 和 post[] 都是 1, 2, ...,
 * pre.length 的排列 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * 
 */
public class Solution889 {

	TreeNode treeNode;
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return helper(pre, post, 0, 0, post.length);
	}
	
	TreeNode helper(int[] pre, int[] post, int i0, int i1, int n) {
		if (n == 0) return null;
        TreeNode root = new TreeNode(pre[i0]);
        if (n == 1) return root;
        int l = 0, next = i0 + 1;
        while(++l < n) {
        	if (post[i1 + l - 1] == pre[next]) {
            	break;
            }   
        }
        root.left = helper(pre, post, next, i1, l);
        root.right = helper(pre, post, next + l, i1 + l, n - 1 - l);
        return root;
	}
	
	public class TreeNode {	
		
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
}
