package Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 15:44
 * @Description 希尔排序
 */
public class ShellSort extends AbstractSort{
    @Override
    public int[] sort(int[] arr) {
        printArr(arr);
        int len = arr.length ;
        int gap = len/2 ;
        while (gap>0){
            for(int i=0;i<gap;i++){
                for(int j=gap+i;j< arr.length;j+=gap){
                    int tmp = arr[j] ;
                    int currentIndex = j ;
                    while (currentIndex-gap>=0 && arr[currentIndex-gap]>tmp){
                        arr[currentIndex] = arr[currentIndex-gap] ;
                        currentIndex -= gap ;
                    }
                    arr[currentIndex] = tmp ;
                }
                gap /= 2 ;
            }
            printArr(arr);
        }
        return arr ;
    }
}
