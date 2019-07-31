package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 18:25
 * @Description 快速排序
 * 优化：1、当已经排好序时，取第一个或是最后一个做base都回退化，所以取用第一个、中间个、最后一个三个值的中间值作为base
 * 2、当待排序长度小于阈值时，直接使用插入排序
 */
public class QuickSort extends AbstractSort {
    @Override
    public int[] sort(int[] arr) {
        printArr(arr);
        partition(arr,0,arr.length-1);
        return arr ;
    }

    private void partition(int[] arr,int begin,int end){
        //一定是大于等于，有大于的情况
        if(begin>=end){
            return;
        }
        //挖第一个坑，缓存base
        int base = arr[begin] ;
        int leftIndex = begin ;
        int rightIndex = end ;

        while (leftIndex<rightIndex){
            //右侧第一个比base小
            while (rightIndex>leftIndex && arr[rightIndex]>=base){
                rightIndex-- ;
            }
            //swap to right
            //将右边第一个小的去填左边的坑位
            arr[leftIndex] = arr[rightIndex];

            //左侧第一个比base大
            while (leftIndex<rightIndex && arr[leftIndex]<=base){
                leftIndex++ ;
            }
            //将左边第一个大的去填右边的坑位
            //swap to left
            arr[rightIndex] = arr[leftIndex] ;
        }

        arr[rightIndex] = base ;

        printArr(arr);

        partition(arr,begin,rightIndex-1);
        partition(arr,rightIndex+1,end);

    }
}
