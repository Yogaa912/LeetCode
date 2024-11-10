public class _142_LinkedListCycleII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		ListNode p = head;
		ListNode q = head;
		while(q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if(p == q) {
				p = head;
				while(p != q) {
					p = p.next;
					q = q.next;
				}
				return p;
			}
		}
		return null;
    }
}
/**
 * 上一题可以直接将fast初始化为head.next，但是这一题不行，因为计算环开始点需要准确的都从head开始
 * head -> cycle start = a
 * start -> meet point = b
 * meet -> start = c
 * cycle length = L = b + c
 * when they meet, slow go a + b, fast go a + b + n*L
 * fast = 2*slow
 * a + b + n*L = 2*a + 2*b
 * a = n*L - b
 * 当指针走完a的时候，另一个也走完n*L - b, 相当于从相遇点开始走到cycle start
 */