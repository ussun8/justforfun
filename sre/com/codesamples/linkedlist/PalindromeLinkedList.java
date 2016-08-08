//Leetcode-234

public class Solution {
    public boolean isPalindrome(ListNode head) {
        
       if(head == null || head.next == null) {return true;}
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        slow = slow.next;
        
        while(slow != null) {
            if(head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    
   public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        
        while(cur != null) {
            node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = node;
        }
        return prev;
    }
}
