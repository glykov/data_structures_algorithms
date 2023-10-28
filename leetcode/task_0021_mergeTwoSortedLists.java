package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode result = current;
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            } else if (list1 == null) {
                current.next = list2;
                break;
            } else if (list2 == null) {
                current.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    current.next = list1;
                    current = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    current = list2;
                    list2 = list2.next;
                }
            }
        }
        return result.next;
    }
}

public class task_0021_mergeTwoSortedLists {
}
