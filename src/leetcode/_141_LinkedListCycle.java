package leetcode;
public class _141_LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
		// 在初始化时添加一个 null 检查，以处理传入空链表的情况
		if (head == null || head.next == null) {
		    return false;
		}
		ListNode p = head;
		ListNode q = head.next;
		while(q != null && q.next != null) {
			q = q.next.next;
			p = p.next;
			if(p == q) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		_141_LinkedListCycle list = new _141_LinkedListCycle();
		ListNode head = list.new ListNode(3);
		head.next = list.new ListNode(2);
		head.next.next = list.new ListNode(0);
		head.next.next.next = list.new ListNode(-4);
		head.next.next.next.next = head;
		System.out.println(list.hasCycle(head));
	}
}
/**
 * 我想的是for(int i = 0; i < 10000; i ++)
 * 但其实根本用不着，因为没有环的自然在next是null就停下来了
 * 别忘了指针的next也要提前进行判断，要不然会报错
 * 别忘记处理空链表的情况，同样也要包含head.next == null;
 * */
