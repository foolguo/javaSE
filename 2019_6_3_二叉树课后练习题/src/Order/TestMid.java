package Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/6/3 17:05
 * @Version 1.0
 */
public class TestMid {
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                TreeNode temp=stack.pop();
                list.add(temp.val);
                curr=curr.right;
            }
        }
        return  list;

    }
}

