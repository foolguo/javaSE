package Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/6/3 16:54
 * @Version 1.0
 */
public class TestPre {

}



class Main{
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);//将根节点入栈
        while(!stack.isEmpty()){
            //由于前序遍历是更节点先出队
            TreeNode temp=stack.pop();
            list.add(temp.val);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        return list;
    }
}