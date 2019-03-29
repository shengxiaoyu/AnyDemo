package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 23:46
 * @Description
 */
public class _4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return subTree(pre,0,pre.length-1,in,0,in.length-1) ;
    }
    private TreeNode subTree(int[] pre,int preBegin,int preEnd,int[] in,int inBegin,int inEnd){
        if(preBegin>preEnd){
            return null ;
        }
        TreeNode root = new TreeNode(pre[preBegin]) ;
        if(preBegin==preEnd && inBegin==inEnd){
            return root ;
        }else{
            //找左侧key值
            int i = 0;
            while(in[inBegin+i]!=pre[preBegin]){
                i++ ;
            }
            root.left = subTree(pre,preBegin+1,preBegin+i,in,inBegin,inBegin+i-1) ;

            root.right = subTree(pre, preBegin + i + 1, preEnd, in, inBegin + i + 1, inEnd);

            return root;
        }

    }
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
