class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        int groupSize = 1;

        while (curr != null) {
            int count = 0;
            ListNode temp = curr;

            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {
                ListNode groupHead = curr;
                ListNode prevNode = temp;

                for (int i = 0; i < count; i++) {
                    ListNode next = curr.next;
                    curr.next = prevNode;
                    prevNode = curr;
                    curr = next;
                }

                prev.next = prevNode;
                prev = groupHead;
            } else {
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}
