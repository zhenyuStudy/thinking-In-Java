package structure.leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        return l1;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

//        while (l1 != null) {
//
//            System.out.print(l1.val + " ");
//
//            // 继续下一个
//            l1 = l1.next;
//        }
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

