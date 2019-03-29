package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 16:04
 * @Description 归并排序
 */
public class MergeSort extends AbstractSort{
    @Override
    public int[] sort(int[] arr) {
        for(int len=2;len<=arr.length;len *= 2){
            for(int i=0;i<arr.length;i+=len){
                int left = i ;
                int right = (i+len-1>arr.length-1)?arr.length-1:i+len-1 ;
                int mid = (left+right) /2 ;
                merge(arr,left,mid,right) ;
            }
        }
        return arr ;
    }

    private int[] merge(int[] arr,int left,int mid,int right){
        int[] bak= new int[right-left+1] ;
        int count = 0;
        int index1 = left ;
        int index2 = mid+1 ;
        while (index1<=mid && index2<=right){
            if(arr[index1]<arr[index2]){
                bak[count++] = arr[index1++];
            }else {
                bak[count++] = arr[index2++];
            }
        }
        while (index1<=mid){
            bak[count++] = arr[index1++] ;
        }
        while (index2<=right){
            bak[count++] = arr[index2++] ;
        }
        for(int i=0;i<bak.length;i++){
            arr[i+left] = bak[i] ;
        }
        return arr;
    }
}
