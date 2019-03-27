package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/9
 * @time 9:49
 * @Description
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized
 */
public class EggDroppingPuzzle {
    public static void main(String[] args) {
        System.out.println(recursive(2, 10));
        System.out.println(ep(2, 36));
    }
    public static int recursive(int n,int k){
        if(n==1){
            return k ;
        }
        if(k==0){
            return 0 ;
        }
        if(k==1){
            return 1 ;
        }
        int result = Integer.MAX_VALUE ;
        for(int i=1;i<=k;i++){
            int tmp = Math.max(recursive(n-1,i-1),recursive(n,k-i)) ;
            result = Math.min(result,tmp) ;
        }
        return result+1;
    }

    public static int ep(int n,int k){
        int[][] tabu = new int[n+1][k+1] ;
        int i,j,x ;
        int tmp ;
        for(i=1;i<=n;i++){
            for(j=1;j<=k;j++){
                if(i==1){
                    tabu[i][j]=j ;
                }else if(j==1||j==0){
                    tabu[i][j]= j ;
                }else {
                    tabu[i][j]=Integer.MAX_VALUE ;
                    for(x=1;x<=j;x++){
                        tmp = 1+Math.max(tabu[i-1][x-1],tabu[n][j-x]) ;
                        tabu[i][j]=Math.min(tabu[i][j],tmp) ;
                    }
                }
            }
        }
        return tabu[n][k] ;
    }
}
