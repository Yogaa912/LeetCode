
public class _21_ {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode root = new ListNode();
        ListNode newList = root;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                newList.val = list1.val;
                newList.next = new ListNode();
                newList = newList.next;
                list1 = list1.next;
            } else if(list1.val > list2.val) {
                newList.val = list2.val;
                newList.next = new ListNode();
                newList = newList.next;
                list2 = list2.next;
            }
        }
        if(list1 != null) {
        	newList.val = list1.val;
        	newList.next = list1.next;
        }
        if(list2 != null) {
        	newList.val = list2.val;
        	newList.next = list2.next;
        }
        return root;
    }
	public static void main(String[] args) {
		_21_ solution = new _21_();
		ListNode list1 = new ListNode(-9);
		list1.next = new ListNode(3);
		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(7);
		System.out.println(solution.mergeTwoLists(list1, list2));
	}
}
