import com.sun.source.tree.WhileLoopTree;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr = null;
        int inMind = 0;

        while (l1 != null || l2 != null) {
            int sum = inMind;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum > 9) {
                int num = sum % 10;

                ListNode node = new ListNode(num);
                if(curr == null) {
                    result = node;
                    curr = node;
                } else {
                    curr.next = node;
                    curr = node;
                }

                inMind = 1;
            } else {
                ListNode node = new ListNode(sum);
                if(curr == null) {
                    result = node;
                    curr = node;
                } else {
                    curr.next = node;
                    curr = node;
                }

                inMind = 0;
            }
        }

        if(inMind > 0) {
            ListNode node = new ListNode(inMind);
            curr.next = node;
        }

        return result;
    }

}
