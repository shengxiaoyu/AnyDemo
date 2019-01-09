package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2018/12/23
 * @time 16:30
 * @Description
 */
public class LongestIncreasingSubsequence {
    public static int[] f(int [] arr){
        int[] result = new int[arr.length] ;
        int len = -1 ;
        for(int i=0;i<arr.length;i++){
            int[] tmp = new int[arr.length] ;
            int len_tmp = 0 ;
            tmp[0]=arr[i] ;
            len_tmp++ ;
            int index = 0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>tmp[index]){
                    tmp[++index] = arr[j] ;
                    len_tmp++ ;
                }
            }
            if(len_tmp>len){
                result = tmp ;
                len = len_tmp ;
            }
        }
        return result ;
    }
}
