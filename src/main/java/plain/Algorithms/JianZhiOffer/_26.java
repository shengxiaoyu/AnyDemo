package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314
 * @date 2019/7/12
 * @time 20:33
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _26 {
    private TreeNode head = null ;
    private TreeNode pre = null ;

    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null ;
        }
        inOrder(pRootOfTree);
        return head ;
    }
    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        root.left=pre ;
        if(pre!=null){
            pre.right = root ;
        }
        pre = root ;
        if(head==null){
            head = root ;
        }
        inOrder(root.right);
    }

    class TreeNode{
        int val = 0 ;
        TreeNode left ;
        TreeNode right ;
        public TreeNode(int val){
            this.val = val ;
        }
    }
}
