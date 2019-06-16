/**
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 */
public class Solution21 {

	ListNode listNode1;
	ListNode listNode2;
	ListNode listNode3;
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode newListNode(int val) {
		return new ListNode(val);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode cur = new ListNode(0), ln = cur;
		while(l1 != null || l2 != null) {
			if(l2 != null && (l1 == null || l1.val >= l2.val)) {
				ln.next = l2;
				l2 = l2.next;
			}else if(l1 != null && (l2 == null || l1.val < l2.val)) {
				ln.next = l1;
				l1 = l1.next;
			}
			ln = ln.next;
		}
		return cur.next;
	}
}
