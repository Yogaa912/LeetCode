package Tree;

public class _2_addTwoNumbers {
	// 答题代码框架
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int plus = 0;
        ListNode result = new ListNode();
        ListNode point = result;
        ListNode newList = null;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + plus;
            if(sum >= 10) {
                sum -= 10;
                plus = 1;
            } else {
                plus = 0;
            }
            point.val = sum;
            if(l1.next != null || l2.next != null) {
                point.next = new ListNode();
            } else if(plus != 0) {
                point.next = new ListNode(plus);
            }
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 != null) {
            newList = l2;
        }
        if(l1 != null) {
            newList = l1;
        }
        while(newList != null) {
            sum = newList.val + plus;
            if(sum >= 10) {
            	plus = 1;
            	sum -= 10;
            	point.val = sum;
            } else {
            	point.val = sum;
            	plus = 0;
            }
            if(newList.next != null) {
                point.next = new ListNode();
            } else if(plus != 0) {
                point.next = new ListNode(plus);
            }
            point = point.next;
            newList = newList.next;
        }
        return result;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_2_addTwoNumbers solution = new _2_addTwoNumbers();
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(1);
		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
    	System.out.println("测试结果：" + solution.addTwoNumbers(l1,l2));
	}
}
