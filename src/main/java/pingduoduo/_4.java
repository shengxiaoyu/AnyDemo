package pingduoduo;

import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/3
 * @time 18:56
 * @Description
 */
public class _4 {
    public static void main(String[] args) {
        String word1 ="horse";
        String word2 = "ros" ;
        char[] char1s = word1.toCharArray() ;
        char[] chars2 = word2.toCharArray() ;

        int[][]memo = new int[char1s.length+1][chars2.length+1] ;
        for(int i=0;i<=char1s.length;i++){
            for (int j=0;j<=chars2.length;j++){
                if(i==0){
                    memo[i][j]=j;
                    continue;
                }
                if(j==0){
                    memo[i][j] = i ;
                    continue;
                }
                if(char1s[i-1]==chars2[j-1]){
                    memo[i][j] = memo[i-1][j-1] ;
                }else {
                    memo[i][j] = Math.min(Math.min(1+memo[i][j-1],1+memo[i-1][j]),1+memo[i-1][j-1]) ;
                }
            }
        }
        System.out.println(memo[char1s.length][chars2.length]);
    }
}
