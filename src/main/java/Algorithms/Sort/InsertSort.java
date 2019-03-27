package Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 15:22
 * @Description 插入排序 O(n^2) O(n) 升序排列
 */
public class InsertSort extends AbstractSort{
    @Override
    public int[] sort(int[] arr) {
        int tmp ;
        for(int i=0;i<arr.length;i++){
            int currentIndex = i ;
            tmp = arr[currentIndex] ;
            while (currentIndex>0 && tmp<arr[currentIndex-1]){
                arr[currentIndex] = arr[currentIndex-1] ;
                currentIndex-- ;
            }
            if(currentIndex!=i){
                arr[currentIndex] = tmp ;
            }
        }
        return arr;
    }
   //使用二分法来查找插入位置
    public int[] binarySort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int left = 0;
            int right = i-1 ;
            while (left<=right){
                int mid = (left+right)/2 ;
                if(arr[mid]<arr[i]){
                    left = mid+1 ;
                }else {
                    right = mid -1 ;
                }
            }
            int tmp = arr[i];
            for(int j=i;j>left;j--){
                arr[j] = arr[j-1] ;
            }
            arr[left] = tmp ;
        }
        return arr ;
    }
}
