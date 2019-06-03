package Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/6/3 17:16
 * @Version 1.0
 */
public class last {
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(node.left!=null){
                TreeNode temp=node.left;
                node.left=null;
                stack.push(temp);
            }else if(node.right!=null){
                TreeNode temp=node.right;
                node.right=null;
                stack.push(temp);
            }else{
                stack.pop();
                list.add(node.val);
            }

        }
        return list;
    }
}
