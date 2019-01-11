package Algorithms.DynamicProgramming;

import java.util.*;

/**
 * @author 13314409603@163.com
 * @date 2019/1/8
 * @time 9:22
 * @Description
 * 给定一个长度为m的区间，再给出n条线段的起点和终点（开区间和闭区间处理的方法是不同，这里以开区间为例），
 * 问题是从中选取尽量多的线段，使得每个线段都是独立的，就是不和其它有任何线段有相交的地方
 * 区间长度8，可选的覆盖线段[2,6],[1,4],[3,6],[3,7],[6,8],[2,4],[3,5]
 */
public class MaximumDisjoint {
    public static void main(String[] args) {
        Pair[] ps = {new Pair(2,6),new Pair(1,4),new Pair(3,6),new Pair(3,7),new Pair(6,8),new Pair(2,4),new Pair(3,5) };
        System.out.println(md(ps));
    }
    public static int md(Pair[] ps){
        Arrays.sort(ps,(p1,p2)->{
            return Integer.compare(p1.right,p2.right) ;
        });
        Map<Integer,Integer> indexMap = new HashMap<>() ;
        for(int i=ps.length;i>0;i--){
            int j = i-1 ;
            while(j>0&&ps[j-1].right>=ps[i-1].left){
                j-- ;
            }
            indexMap.put(i,j) ;
        }
        //存储最大值
        List<Pair> result = new ArrayList<>(ps.length) ;
        int[] tabu = new int[ps.length+1] ;
        for(int i=1;i<=ps.length;i++){
            tabu[i] = Math.max(tabu[indexMap.get(i)]+1 ,tabu[i-1]) ;
        }
        return tabu[ps.length] ;
    }
}

class Pair{
    public int left ;
    public int right ;
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
