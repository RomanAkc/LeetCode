public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        printList(s.addTwoNumbers(createListNode(new int[]{2,4,3}), createListNode(new int[]{5,6,4})));
        printList(s.addTwoNumbers(createListNode(new int[]{9,9,9}), createListNode(new int[]{9,9,9})));
        printList(s.addTwoNumbers(createListNode(new int[]{9,9,9}), createListNode(new int[]{9})));

    }

    private static ListNode createListNode(int[] arr) {
        ListNode result = new ListNode(arr[0]);
        ListNode curr = result;
        for(int i = 1; i < arr.length; ++i) {
            ListNode node = new ListNode(arr[i]);
            curr.next = node;
            curr = node;
        }
        return result;
    }

    private static void printList(ListNode l) {
        System.out.print('[');
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.print(']');
    }
}