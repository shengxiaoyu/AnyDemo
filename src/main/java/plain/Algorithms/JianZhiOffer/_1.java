package plain.Algorithms.JianZhiOffer;

import java.util.Arrays;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 21:42
 * @Description
 */
public class _1 {
    public boolean Find(int target, int [][] array) {
        if(array==null || array.length==0){
            return false ;
        }
        int len1 = array.length;
        int len2 = array[0].length ;
        for(int i=0;i<len1;i++){
            if(array[i][len2]<target){
                continue ;
            }
            if(array[i][0]>target){
                return false ;
            }
            if(Arrays.binarySearch(array[i],target)>=0){
                return true ;
            }
        }
        return false ;
    }
}
