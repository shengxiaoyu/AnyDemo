package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/7
 * @time 17:32
 * @Description
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

(ABC)D = (AB)(CD) = A(BCD) = ....
However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
Clearly the first parenthesization requires less number of operations.

Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain.

 解题思路：
 关键点：假设有矩阵链ABCD，添加第一个括号表示最后一次算的是那两个矩阵，即最后一次的计算次数。比如(A)(BCD)表示最后算A和BCD的结果。而A、BCD又可以
 看作一个新的矩阵链的最小计算次数。所以将原问题划分为两个小的子问题
 当 矩阵链长度为1时，计算次数为0

 */
public class MatrixChainMultipication {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3} ;
//        System.out.println(mcm1(arr, 0, 4));
        System.out.println(mcm(arr,4));
    }
    public static int  mcm(int[] p,int n){
        int[][] tabu = new int[n+1][n+1];//存储从i，到j的矩阵链的最小计算次数
        for(int i=0;i<n;i++){
            tabu[i][i] = 0 ;
        }
        for(int L = 2;L<=n;L++){//矩阵长度

            for(int i=1;i<=n-L+1;i++){
                //在原数组中，长度为L的矩阵链的起始矩阵编号

                //初始化该矩阵链最小值为Int_MAX
                tabu[i][i+L-1] = Integer.MAX_VALUE ;
                for(int j=i;j<i+L-1;j++){
                    //遍历不同划分求得的最小值，若小于当前最小则更新
                    int tmp = tabu[i][j]+tabu[j+1][i+L-1]+p[i-1]*p[j]*p[i+L-1] ;
                    if(tabu[i][i+L-1]>tmp){
                        tabu[i][i+L-1] = tmp ;
                    }
                }
            }
        }
        return tabu[1][n] ;
    }

    public static int mcm1(int[] p,int begin,int end){
        if(end-begin<2){
            return 0 ;
        }
        int result = Integer.MAX_VALUE ;
        for(int i=1;i<end-begin;i++){
            int tmp = mcm1(p,begin,begin+i)+mcm1(p,begin+i,end)+p[begin]*p[begin+i]*p[end] ;
            if(tmp<result){
                result = tmp ;
            }
        }
        return result ;
    }
}
