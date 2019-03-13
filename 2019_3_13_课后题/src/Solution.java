/**
 * @Author: yd
 * @Date: 2019/3/13 10:22
 * @Version 1.0
 */

//  Definition for singly-linked list.
//------------------------------------------------------------
//合并两个有序数组
/*
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        //输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        ListNode dummyHead=new ListNode(-1);
        ListNode temp=dummyHead;
        ListNode temp1=l1,temp2=l2;
        for(;temp1!=null&&temp2!=null;){
            if(temp1.val<=temp2.val){
                dummyHead.next=temp1;
                temp1=temp1.next;
            }else{
                dummyHead.next=temp2;
                temp2=temp2.next;
        }
            dummyHead=dummyHead.next;

        }
        while(temp1!=null){
            dummyHead.next=temp1;
            dummyHead=dummyHead.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            dummyHead.next=temp2;
            dummyHead=dummyHead.next;
            temp2=temp2.next;
        }
        return temp.next;
    }
}
*/

//----------------------------------------------------------------

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

//给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
// 注意：分割以后保持原来的数据顺序不变。

/*
* 思路：1.找到值为x的结点，
* 2.创建一个虚拟头结点连接在头结点前
* 如果比X小，就插入到虚拟头结点后  比他大就插入到x结点后
* x=4，
* 1,5,7,4,3,2,6
* 排列后的顺序
* 1,3,2,4,5,7
*
* null->4
*
* 向里面插入数据
*
*
* */
/*public class Solution {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null){
            return pHead;
        }
        // write code here
        //找到X结点；

        ListNode nodeX=pHead;
        for(;nodeX!=null;nodeX=nodeX.next){
            if(x==nodeX.val){
                break;
            }
        }
        ListNode dummyHeadL=new ListNode(-1);
        ListNode dummyHeadR=new ListNode(-1);
        ListNode prevLeft=dummyHeadL;
        ListNode prevRight=dummyHeadR;
        dummyHeadL.next=dummyHeadR;
        for(ListNode node=pHead;pHead!=null;pHead)

    }
}*/
//1-2-3-3-3-3-4-4-5
//f s
//1-2-5
//1-2-3-2-3-2-3;

public class Solution {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=pHead;
        ListNode prev=dummyHead;
        ListNode f=prev.next;
        for(;f.next!=null;f=f.next){
            ListNode s=f.next;
            int temp=0;
            for(;s!=null;s=s.next){
                if(s.val==f.val){
                     temp=s.val;
                     break;
                }
            }
            for(ListNode node=pHead; node!=null;){
                if(node.val==temp){
                    ListNode p=node.next;
                    prev.next=node.next;
                    node=p;
                }else{
                    prev=prev.next;
                    node=node.next;
                }
            }
            prev=dummyHead;

        }

        return dummyHead.next;
    }
}