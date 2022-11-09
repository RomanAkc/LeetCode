public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hasCycle(CreateList(new int[]{3,2,0,-4}, 1)));
        System.out.println(s.hasCycle(CreateList(new int[]{3,2,0,-4}, -1)));
        System.out.println(s.hasCycle(CreateList(new int[]{1,2}, 0)));
        System.out.println(s.hasCycle(CreateList(new int[]{1}, -1)));
    }

    private static ListNode CreateList(int[] values, int index) {
        if(values.length == 0)
            return null;

        ListNode prev = new ListNode(values[values.length - 1]);
        ListNode last = prev;
        if(index == values.length - 1)
            last.next = last;

        for(int i = values.length - 2; i >= 0; --i) {
            ListNode curr = new ListNode(values[i], prev);

            if(index >= 0 && index == i) {
                last.next = curr;
            }

            prev = curr;
        }

        return prev;
    }
}