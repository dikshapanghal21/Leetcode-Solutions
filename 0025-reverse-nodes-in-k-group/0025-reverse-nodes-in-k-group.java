class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = prev;

            for (int i = 0; i < k; i++) {
                kth = kth.next;

                // Fewer than k nodes remaining
                if (kth == null) {
                    return dummy.next;
                }
            }

            // Node after the current group
            ListNode nextGroup = kth.next;

            // Reverse current group
            ListNode previous = nextGroup;
            ListNode current = prev.next;

            while (current != nextGroup) {
                ListNode next = current.next;

                current.next = previous;
                previous = current;
                current = next;
            }

            // Connect previous part to reversed group
            ListNode oldStart = prev.next;
            prev.next = kth;

            // oldStart is now the tail of reversed group
            prev = oldStart;
        }
    }
}