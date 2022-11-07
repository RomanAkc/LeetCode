import java.util.ArrayList;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> tmp = new ArrayList<>();

        for(var list : lists) {
            while (list != null) {
                tmp.add(list.val);
                list = list.next;
            }
        }

        tmp.sort(Integer::compare);

        ListNode next = null;
        if(tmp.size() > 0)
            next = new ListNode(tmp.get(tmp.size() - 1));
        for(int i = tmp.size() - 2; i >= 0; i--) {
            ListNode node = new ListNode(tmp.get(i), next);
            next = node;
        }

        return next;
    }

}
