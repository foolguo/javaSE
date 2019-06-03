package SameTree;

/**
 * @Author: yd
 * @Date: 2019/6/3 17:34
 * @Version 1.0
 */
public class isSameChildren {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(s.val==t.val){
           return isSameTree(s,t);
        }
        if(isSubtree(s.left,t)){
            return true;
        }else{
            return isSubtree(s.right,t);
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
