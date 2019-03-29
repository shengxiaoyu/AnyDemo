package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 14:51
 * @Description 选择排序 O(n^2) O(n^2)
 * //不能每次遍历检索最大值和最小值，当最小值在最后一个位置的时候，在将最大值交换到最后一个位置，就把最小值位置改变了
 *
 */
public class SelectSort extends AbstractSort{

    @Override
    public int[] sort(int[] arr) {
        int maxIndex = 0 ;
        int tmp ;
        for(int i=0;i<arr.length-1;i++){
            maxIndex = 0;//必须置为0，因为这个会指向了上一个发现最大值的索引，如果上一个最大值没有发生交换，则此时指向的索引是已经排序的索引，一定比剩余的大
            for(int j=0;j<arr.length-i;j++){
                if(arr[maxIndex]<arr[j]){
                    maxIndex = j ;
                }
            }
            tmp = arr[maxIndex] ;
            arr[maxIndex] = arr[arr.length-1-i] ;
            arr[arr.length-1-i] = tmp ;
        }
        return arr;
    }


}
