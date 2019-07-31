package plain.Algorithms.JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * @author 13314
 * @date 2019/7/1
 * @time 12:08
 * @Description
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意:
 * 在返回值的list中，数组长度大的数组靠前)
 */
public class _24 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10) ;
        TreeNode left1 = new TreeNode(5) ;
        TreeNode right1 = new TreeNode(12) ;
        root.left = left1 ;
        root.right = right1 ;
        TreeNode left2 = new TreeNode(4) ;
        TreeNode right2 = new TreeNode(7) ;
        left1.left = left2 ;
        left1.right = right2 ;
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(root, 22);
        System.out.println(arrayLists.size());
    }
    static ArrayList<ArrayList<Integer>> allList = new ArrayList<>() ;
    static ArrayList<Integer> list = new ArrayList<>() ;
    public static ArrayList<ArrayList<Integer>> dfs(TreeNode root, int target){
        if(root==null){
            return allList ;
        }
        list.add(root.val) ;
        target -= root.val ;
        if(0==target && root.left==null&&root.right==null){
            allList.add(new ArrayList<>(list)) ;
        }
        dfs(root.left,target) ;
        dfs(root.right,target) ;
        list.remove(list.size()-1) ;
        return allList ;
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return null ;
        }else if(root.val==target && root.left==null && root.right==null){
            ArrayList<Integer> steps = new ArrayList<>() ;
            steps.add(root.val) ;
            ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;
            result.add(steps) ;
            return result ;
        }else if(root.val<target){
            ArrayList<ArrayList<Integer>> result = null ;
            if(root.left!=null){
                result = FindPath(root.left,target-root.val) ;
            }
            if(root.right!=null){
                if(result==null){
                    result = FindPath(root.right,target-root.val) ;
                }else{
                    result.addAll(FindPath(root.right,target-root.val)) ;
                }
            }
            if(result!=null){
                for(ArrayList<Integer> steps:result){
                    steps.add(0,root.val) ;
                }
                result.sort((ArrayList a,ArrayList b)->Integer.compare(a.size(),b.size())) ;
            }
            return result ;
        }else{
            return null ;
        }
    }
}
class TreeNode{
    int val = 0 ;
    TreeNode right ;
    TreeNode left ;
    public TreeNode(int val){
        this.val = val ;
    }
}
