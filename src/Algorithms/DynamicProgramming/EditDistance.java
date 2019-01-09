package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/4
 * @time 19:57
 * @Description
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
    Insert
    Remove
    Replace
 */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(edit(str1, str2, str1.length(), str2.length()));

    }
    public static int edit(String str1,String str2,int m,int n){
        char[] char1 = str1.toCharArray() ;
        char[] char2 = str2.toCharArray() ;
        int[][] tabu = new int[m+1][n+1] ;
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 ){
                    tabu[i][j] = j ;
                    continue;
                }
                if(j==0){
                    tabu[i][j] = i ;
                    continue;
                }
                if(char1[i-1]==char2[j-1]){
                    tabu[i][j]=tabu[i-1][j-1] ;
                }else {
                    tabu[i][j]=Math.min(tabu[i-1][j]+1,Math.min(tabu[i][j-1]+1,tabu[i-1][j-1]+1)) ;
                }
            }
        }
        return tabu[m][n] ;
    }
}
