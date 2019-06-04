package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/4
 * @time 19:18
 * @Description
 * Given two sequences, find the length of longest subsequence present in both of them.
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 *  LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *  关键点：在于对于char数组m,n长度，从最后一个字符开始判断，如果相同则f(m,n)=1+f(m-1,n-1),如果不同则考虑舍掉第一个字符串的末尾还是
 *  舍掉第二个字符串的末尾。所有有f(m,n)=max(f(m-1,n),f(m,n-1)).针对末尾字符分情况讨论
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs( X, Y, m, n ) );
    }
    public static int lcs(char[] X ,char[] Y,int m,int n){
        int[][] tabu = new int[m+1][n+1] ;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X[i-1]==Y[j-1]){
                    tabu[i][j] = 1+tabu[i-1][j-1] ;
                }else {
                    tabu[i][j] = Math.max(tabu[i-1][j],tabu[i][j-1]) ;
                }
            }
        }
        return tabu[m][n] ;
    }

}
