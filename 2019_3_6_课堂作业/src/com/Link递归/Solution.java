/*
package com.Link递归;

*/
/**
 * @Author: yd
 * @Date: 2019/3/6 19:01
 * @Version 1.0
 *//*



// * Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

*/
/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *//*

public class Solution {

    public static void main(String[] args) {

    }
    */
/*
    * 1-2-3-4-5
    * dummyhead-1-2-3-4-5
    *
    * m=n dummyhead-1-2-3-4-5
    * m!=n
    * m=1:
    * m!=1;
     * *//*

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        if(m==n){
            return dummyHead.next;
        }
        int k=n-m;
        ListNode prev=dummyHead;
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }
        ListNode f=prev.next;
        ListNode s=f.next;
        while((n-m)>=0){
            f.next=s.next;
            s.next=prev.next;
            prev.next=s;
            s=f.next;
        }
        return dummyHead.next;
    }

}
*/
