package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/11
 * @time 15:52
 * @Description
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 * if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        String s = "BBABCBCAB" ;
        System.out.println(lps2(s));
    }

    /**
     * 动态规划，定义函数f(i,j)为第i个字符到第j个字符最长回文串，则转移方程：
     * 1、首尾相同，则f(i,j)=2+f(i+1,j-1)
     * 2、首尾不相同，则f(i,j)=Max(f(i+1,j),f(i,j-1));
     * @param s
     * @return
     */
    public static int lps2(String s){
        int[][] tabu = new int[s.length()][s.length()] ;
        char[] chars = s.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            for(int j=i;j<chars.length;j++){
                if(i==j){
                    tabu[i][j] = 1;
                }else {
                    if(chars[i]==chars[j]){
                        tabu[i][j] = 2+tabu[i+1][j-1];
                    }else {
                        tabu[i][j]=Math.max(tabu[i+1][j],tabu[i][j-1]) ;
                    }
                }
            }
        }
        return tabu[0][chars.length-1] ;
    }
    /**
     * 动态规划，定义函数f(i,L)表示从第i个开始，长度为L的字符串中最长回文，则：
     * 1、当首位字符相同时，f(i,L)=f(i+1,L-2)+2
     * 2、当首位字符不同时，则取舍弃首或尾部字符之后的最长字符串回文即：f(i,L)=Max(f(i+1,L-1),f(i,L-1)) ;
     * @param s
     * @return
     */
    public static int lps(String s){
        int[][] tabu = new int[s.length()+1][s.length()+1] ;
        char[] chars = s.toCharArray();
        for(int i=1;i<s.length()+1;i++){
            tabu[i][1]=1 ;
        }
        for(int len=2;len<=chars.length;len++){
            for(int i=1;i<=s.length()+1-len;i++){
                if(chars[i-1]==chars[i+len-2]){
                    tabu[i][len] = 2+tabu[i+1][len-2] ;
                }else {
                    tabu[i][len] = Math.max(tabu[i+1][len-1],tabu[i][len-1]) ;
                }
            }
        }
        return tabu[1][s.length()] ;
    }


    public static int recursive(char[] chars,int begin,int end){
        if(begin==end){
            return 1;
        }
        if(end<begin){
            return 0;
        }
        if(chars[begin]==chars[end]){
            return 2+recursive(chars,begin+1,end-1) ;
        }else {
            return Math.max(recursive(chars,begin+1,end),recursive(chars,begin,end-1)) ;
        }
    }
}
