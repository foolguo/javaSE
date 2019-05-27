import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/5/23 17:29
 * @Version 1.0
 */

//*****************题目****************
//合法括号序列判断
//()()()  true
//() a ()()  false;
/*public class Test{
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }

            }else{
                return false;
            }

        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}*/











//************题目**********************
//找出数组中所有的逆序对
//1 2 3 4 5 6 7 8 9 0
//[1 0] [2 0]  [3,0] [4,0] [5,0] [6,0] [7,0] [8,0] [9,0]


/*
 * 思路1：暴力拆解法  将数组中的每两对进行比较，如果符合逆序对，计数器+1；
 *
 * 思路2：使用归并排序的思想，将大的放在前面，小的放在后面，并且在有前大于后的情况下，统计当前数到
 * 分区数的个数，因为全是逆序对，
 *
 * */


//思路1
/*
public class Test{

    public int count(int[] A, int n) {
        // write code here
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;

    }
    public static void main(String[] args) {
        Test test=new Test();
        System.out.println(test.count(new int[]{1,2,3,4,5,6,7,8,9,0},10));
    }

}
*/


//思路1
/*public class Test {
    public int count(int[] A, int n) {
        // write code here
        if(A==null||n==0){
            return 0;
        }
        return mergeInternal(A,0,A.length-1);

    }
    public int mergeInternal(int[] A,int left,int right){
        if(left>=right){
            return 0;
        }
        ArrayDeque
        int mid=(right-left)/2+left;

        return mergeInternal(A,0,mid)+mergeInternal(A,mid+1,right)+merge(A,left,mid,right);

    }
    //  1 3 5  2 4 6  mid 2   i=1     mid-i+1 =2    mid-i+1=2;
    // 1 2  3  4
    public int merge(int[] A,int l,int mid,int r){
        int[] temp=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        int count=0;
        while(i<=mid&&j<=r){
            if(A[i]<=A[j]){
                temp[k++]=A[i++];
            }else{
               count+= (mid - i + 1);
               //这个个计数的方法的思想是这样的   如果 前面的序列的一个数大于后面序列的，呢么我们就可以
                //得知一个结果 由于 局部序列是升序的，i—mid的数都大于后面序列的该数  所以要
                //mid-i+1,得知i—mid的元素个数
                temp[k++]=A[j++];
            }
        }
        int start=i,end=mid;
        if(j<=r){
            start=j;
            end=r;
        }
        while (start<=end){
            temp[k++]=A[start++];
        }
        for(start=0;start<temp.length;start++){
            A[start+l]=temp[start];
        }
        return count;



    }

    public static void main(String[] args) {
        Test test=new Test();
        System.out.println(test.count(new int[]{1,2,3,4,5,6,7,0},8));
    }



    //1 2 3 4 5  / 6 7 8 9 0
    //1 2 3   /  4  5
}*/




/*

class MyQueue {
    ArrayDqueue<Integer> stack=new ArrayDeque();
    */
/** Initialize your data structure here. *//*

    public MyQueue() {

    }

    */
/** Push element x to the back of queue. *//*

    public void push(int x) {
        stack.addFirst(x);

    }

    */
/** Removes the element from in front of queue and returns that element. *//*

    public int pop() {
        stack.removeLast();

    }

    */
/** Get the front element. *//*

    public int peek() {
        stack.peekLast();
    }

    */
/** Returns whether the queue is empty. *//*

    public boolean empty() {
        return stack.isEmpty();
    }
}*/


