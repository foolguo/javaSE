package LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yd
 * @Date: 2019/6/3 17:59
 * @Version 1.0
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res=new ArrayList<>();
        List<TreeNode> queue=new LinkedList<TreeNode>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while(size>0){
                TreeNode temp=queue.remove(0);
                list.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                size--;
            }
            res.add(list);

        }
        ArrayList
        return res;

    }
}
