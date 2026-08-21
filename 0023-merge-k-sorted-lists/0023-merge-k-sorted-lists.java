import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put first node of every list into heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node to build answer
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode smallest = pq.poll();

            // Add it to result
            current.next = smallest;
            current = current.next;

            // Add next node from same list
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}