/**
 * @Author: yd
 * @Date: 2019/5/31 14:37
 * @Version 1.0
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 Definition for a binary tree node.*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(Integer x) { val = x; }
 }

/*class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null){

            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                curr=stack.pop();
                list.add(curr.val);
                curr=curr.right;
            }
        }
        return list;
    }
}*/


/*
class Solution {
    ArrayList<Integer> list=new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr=stack.peek();
            if(curr.left!=null){
                TreeNode left=curr.left;
                curr.left=null;
                stack.push(left);
            }else if(curr.right!=null){
                TreeNode right=curr.right;
                curr.right=null;
                stack.push(right);
            }else if(curr.left==null&&curr.right==null){
                curr=stack.pop();
                list.add(curr.val);
            }
        }
        return list;
    }
}
public class Tesr {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
       ArrayList<Integer> list= (ArrayList<Integer>) solution.postorderTraversal(root);
        System.out.println(list);
    }
}
*/
/*public class Tesr{
    public static void main(String[] args) {
        Thread t=new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName());
                pong();
            }
        };
        t.start();
        System.out.println("ping");
    }
    static void pong(){
        System.out.println("pong");
    }
}*/

/*
public class Tesr {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        if(str.equals("0")){
            System.out.print(0+":"+1);
        }
        int[] count=new int[10];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            count[c-'0']+=1;
        }
        int n=0;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0)n++;
        }
        int m=0;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                if(++m==n){
                    System.out.print(i+":"+count[i]);
                }else{
                    System.out.print(i+":"+count[i]+"<br/>");
                }

            }

        }




    }
}*/

public class Tesr{
    public String[] getGray(int n){
            String[] str1=new String[(int) Math.pow(2,n)];
            if (n==1){
                str1[0]="0";
                str1[1]="1";
                return str1;
            }
            String[] str2=getGray(n-1);
            for(int i=0;i<str2.length;i++){
                str1[i]="0"+str2[i];
                str1[str1.length-1-i]="1"+str2[i];
            }
            return str1;
    }

    public static void main(String[] args) {
        /*Scanner in=new Scanner(System.in);
        int n=in.nextInt();*/
        int n=2;
        Tesr t=new Tesr();
        String[]str=t.getGray(n);
        for(String i:str){
            System.out.println(i+" ");
        }
    }
}