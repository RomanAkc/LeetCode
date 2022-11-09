import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        head.val = (int)1E+6;
        var next = head.next;
        while(next != null) {
            if(next.val == (int)1E+6)
                return true;
            next.val = (int)1E+6;
            next = next.next;
        }

        return false;
    }

    public boolean hasCycle_right(ListNode head) {
        if (head == null) {
            return false;
        }        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle_Simple(ListNode head) {
        if(head == null)
            return false;

        HashSet<Object> set = new HashSet<>();
        set.add(head);

        while (head.next != null) {
            if(set.contains(head.next))
                return true;

            set.add(head.next);
            head = head.next;
        }

        return false;
    }
}
