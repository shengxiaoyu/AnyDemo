package Algorithms.DynamicProgramming;

import org.omg.CORBA.INTERNAL;

/**
 * @author 13314409603@163.com
 * @date 2019/1/15
 * @time 11:11
 * @Description
 *
Given a string, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome.
For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for
palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are
“a|babbbab|b|ababa”.
 */
public class PalindromicPatitioning {
    public static void main(String[] args) {
        System.out.println(dynamic3("aab"));
    }

    /**
     * 最简形式
     * 先计算任意i到j字符是否为回文
     * 然后定义函数F(i)为0到i字符的最小切割次数，则
     * 1、若0到i为回文，则为0
     * 2、否则查找一个位置j，使得j到i为回文，则结果为F(j)+1;遍历所有可能的j，求最小值
     * 时间复杂度为O(n^2)
     * @param s
     * @return
     */
    public static int dynamic3(String s){
        char[] chars = s.toCharArray();
        int[] tabu = new int[chars.length] ;
        boolean[][] isPalin = new boolean[chars.length][chars.length];
        for(int i=chars.length-1;i>=0;i--){
            for(int j=i;j<chars.length;j++){
                if(i==j){
                    isPalin[i][j] = true ;
                }else if(i==j-1){
                    isPalin[i][j] = chars[i]==chars[j] ;
                }else {
                    isPalin[i][j] = (chars[i]==chars[j]&&isPalin[i+1][j-1]) ;
                }
            }
        }
        for(int i=0;i<chars.length;i++){
            if(isPalin[0][i]){
                tabu[i]=0 ;
            }else {
                tabu[i]= Integer.MAX_VALUE ;
                for(int j=0;j<i;j++){
                    if(isPalin[j+1][i]&&1+tabu[j]<tabu[i]){
                        tabu[i]=1+tabu[j] ;
                    }
                }
            }
        }
        return tabu[chars.length-1] ;
    }
    /**
     *定义函数F(i,j)表示i到j的最小切割次数，若该字符串为回文，则为0，
     * 否则将字符串切割，在不同位置切割获得两个子字符串，两个子字符串的最小切割次数相加再加1即为结果
     *
     *
     * 改进使用一个二维数组记录该字符串是否为回文，减少isValid判断的一次遍历，时间复杂度为O(n^3)
     * @param s
     * @return
     */
    public static int dynamic2(String s){
        int[][] tabu = new int[s.length()][s.length()] ;
        boolean[][] isPalin = new boolean[s.length()][s.length()] ;
        char[] chars = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    isPalin[i][j] = true ;
                    tabu[i][j]=0;
                }else {
                    if(i==j-1){
                        isPalin[i][j] = chars[i]==chars[j] ;
                    }else {
                        isPalin[i][j] = (chars[i]==chars[j]&&isPalin[i+1][j-1]) ;
                    }
                    if(isPalin[i][j]){
                        tabu[i][j] = 0;
                    }else {
                        tabu[i][j] = Integer.MAX_VALUE ;
                        for(int h=i;h<j;h++){
                            tabu[i][j] = Math.min(tabu[i][j],tabu[i][h]+1+tabu[h+1][j]) ;
                        }
                    }
                }
            }
        }
        return tabu[0][s.length()-1] ;
    }

    /**
     * 没有timeout，但是特别慢，时间复杂度为O(n^4)
     * 定义函数F(i,len)为字符索引i，len为以i字符开始的字符串长度的最小切割次数
     * 则F(i,len):
     * 1、该字符串为回文，则为0；
     * 2、将该字符串再次切割为两段，则结果为F(i,subLen)+1+F(i+subLen,len-subLen)的最小值（考虑不同切割方式）
     *
     * 改进：使用一个二位数组来存储i到j字符是否是回文，减少一次遍历操作
     * 时间复杂度为O(n^3)
     * @param s
     * @return
     */
    public static int dynamic(String s){
        boolean[][] isPalindromic = new boolean[s.length()][s.length()+1] ;
        int[][] tabu = new int[s.length()][s.length()+1] ;
        char[] chars = s.toCharArray();
        for(int len=1;len<=s.length();len++){
            for(int i=0;i<=s.length()-len;i++){
                if(len==1){
                    isPalindromic[i][len] = true ;
                    tabu[i][len]=0;
                }else {
                    if(len==2){
                        isPalindromic[i][len] = chars[i]==chars[i+1] ;
                    }else {
                        isPalindromic[i][len] = (chars[i]==chars[i+len-1]&&isPalindromic[i+1][len-2]) ;
                    }
                    if(isPalindromic[i][len]){
                        tabu[i][len]=0;
                    }else {
                        tabu[i][len] = Integer.MAX_VALUE ;
                        for(int subLen=1;subLen<len;subLen++){
                            tabu[i][len] = Math.min(tabu[i][len],tabu[i][subLen]+1+tabu[i+subLen][len-subLen]) ;
                        }
                    }
                }
            }
        }
        return tabu[0][s.length()] ;
    }
    /**
     * 递归调用
     * @param s
     * @return
     */
    public static int minCut(String s){
        if(isValid(s)){
            return 0 ;
        }
        int result = Integer.MAX_VALUE ;
        for(int i=1;i<s.length();i++){
            result = Math.min(result,minCut(s.substring(0,i))+minCut(s.substring(i))+1) ;
        }
        return result ;
    }
    public static boolean isValid(String s){
        if(s==null){
            return false ;
        }
        if(s.length()<2){
            return true ;
        }
        char[] chars = s.toCharArray();
        for(int i=0,j=chars.length-1;i<j;i++,j--){
            if(chars[i]!=chars[j]){
                return false ;
            }
        }
        return true ;
    }
}
