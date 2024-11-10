public class _876_MiddleLinkedList {
	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) return null;
		ListNode p = head;
		ListNode q = head;
		while(q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		return p;
	}
}
/**
 * while(q.next != null && q.next.next != null)不需要，因为这里无中生有了一个q.next.next，很可能是q.next == null，所以不要提及这点
 * 而且注意先后顺序，要先检测q的存在，才能检查q.next，重点
 */