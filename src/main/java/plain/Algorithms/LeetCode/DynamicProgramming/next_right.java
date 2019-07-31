package plain.Algorithms.LeetCode.DynamicProgramming;

/**
 * @author 13314
 * @date 2019/7/28
 * @time 14:58
 * @Description
 */
public class next_right {
    public static void main(String[] args) {

    }
    public void connect(TreeLinkNode root) {
        if(root==null){
            return ;
        }

        TreeLinkNode next = root ;
        while(next!=null){
            TreeLinkNode tmp = null ;
            while(next!=null){
                if(next.left!=null){
                    if(tmp==null){
                        tmp = next.left ;
                    }else{
                        tmp.next = next.left ;
                        tmp = tmp.next ;
                    }

                }
                if(next.right!=null){
                    if(tmp==null){
                        tmp = next.right ;
                    }else{
                        tmp.next = next.right ;
                        tmp = tmp.next ;
                    }

                }
                next = next.next ;
            }
            next = tmp ;
        }
    }
    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
}
