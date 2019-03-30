package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/3/30
 * @time 19:44
 * @Description
 * 801. Minimum Swaps To Make Sequences Increasing
User Accepted: 187
User Tried: 848
Total Accepted: 189
Total Submissions: 2626
Difficulty: Medium
We have two integer sequences A and B of the same non-zero length.

We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.

At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.

Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation:
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
Note:

A, B are arrays with the same length, and that length will be in the range [1, 1000].
A[i], B[i] are integer values in the range [0, 2000].
 */
public class MinimumSwapToMakeSequencesIncreasing {
    public static void main(String[] args) {
        int[] A ={0,7,8,10,10,11,12,13,19,18};
        int[] B= {4,4,5,7,11,14,15,16,17,20};
        int[] A1 = {0,4,4,5,9} ;
        int[] B1 = {0,1,6,8,10} ;
//        System.out.println(new MinimumSwapToMakeSequencesIncreasing().minSwap(A, B));
//        System.out.println(new MinimumSwapToMakeSequencesIncreasing().memo(A, B));
        System.out.println(new MinimumSwapToMakeSequencesIncreasing().memo(A1, B1));
    }
    public int minSwap(int[]A,int[]B){
        int min = swapNum(A,B,A[0],B[0],1,A.length) ;
        min = Math.min(1+swapNum(A,B,A[0],B[0],1,A.length),min) ;
        return min ;
    }
    //在A队列上一次值为lastA，B队列上一次值为lastB的情况下，且以满足严格递增。这一次想要达到严格递增需要交换的次数
    public int swapNum(int[]A,int[]B,int lastA,int lastB,int begin,int len){
        if(begin==len){
            return 0 ;
        }
        int min = Integer.MAX_VALUE ;
        if(A[begin]>lastA && B[begin]>lastB){
            min = Math.min(swapNum(A,B,A[begin],B[begin],begin+1,len),min) ;
        }
        if(A[begin]>lastB && B[begin]>lastA){
            min = Math.min(1+swapNum(A,B,B[begin],A[begin],begin+1,len),min) ;
        }
        return min ;
    }
    public int memo(int[]A,int[]B){
        //存储的是上一次没交换和交换的情况下，下一次要达到严格递增的最小交换次数
        int[][] memo = new int[A.length+1][2] ;
        for(int i=A.length-1;i>=0;i--){
            if(i==0){
                memo[i][0] = Math.min(memo[i+1][0],1+memo[i+1][1]) ;
                memo[i][1] = Math.min(memo[i+1][0],1+memo[i+1][1]) ;
                continue;
            }
            //前面没变
            memo[i][0]=Integer.MAX_VALUE ;
            //前面变了
            memo[i][1]=Integer.MAX_VALUE ;
            if(A[i]>A[i-1]&&B[i]>B[i-1]){
                memo[i][0] = Math.min(memo[i+1][0],memo[i][0]) ;
                memo[i][1] = Math.min(memo[i][1],1+memo[i+1][1]) ;
            }
            if(A[i]>B[i-1]&&B[i]>A[i-1]){
                memo[i][0] = Math.min(memo[i][0],1+memo[i+1][1]) ;
                memo[i][1] = Math.min(memo[i][1],memo[i+1][0]) ;
            }
        }
        return Math.max(memo[0][0],memo[0][1]) ;
    }
}
