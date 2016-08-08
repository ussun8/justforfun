/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode lastConnection = curr.next;
        ListNode preCurr = null;
        while(curr != null && curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = curr.next.next;
            preCurr = curr;
            curr = curr.next;
            if(curr != null) {
                tmp.next = curr.next;
            }
        }
        if(curr != null) {
            preCurr = curr;
        }
        preCurr.next = lastConnection;
        return head;
    }
}
