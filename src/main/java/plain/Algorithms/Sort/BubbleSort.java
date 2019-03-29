package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 14:16
 * @Description 冒泡排序 O(n^2) O(n)
 */
public class BubbleSort extends AbstractSort{

    @Override
    public int[] sort(int[] arr){
        int tmp ;
        for(int i=0;i<arr.length-1;i++){ //每次寻找最大值，需要寻找length-1次
            for(int j=0;j<=arr.length-2-i;j++){ // 每次比较到未排序的倒数第二个
                if(arr[j]>arr[j+1]){
                    tmp = arr[j] ;
                    arr[j]=arr[j+1] ;
                    arr[j+1] = tmp ;
                }
            }
        }
        return arr ;
    }

    //优化，当通过标志位判断此次冒泡是否发生交换，如果没有交换，说明已经排好序
    public int[] sort2(int[] arr){
        int tmp ;
        boolean flag = false ;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true;//标注着还在交换
                    tmp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1]= tmp ;
                }
            }
            if(!flag) {
                break;
            }
        }
        return arr ;
    }
    //鸡尾酒冒泡排序，每次循环冒泡两次，一次向右找最大，一次向左找最小
    public int[] sort3(int[] arr){
        int tmp ;
        boolean flag = false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true ;
                    tmp = arr[j];
                    arr[j] = arr[j+1] ;
                    arr[j+1] = tmp ;
                }
            }
            for(int j=arr.length-2-i;j>i;j--){
                if(arr[j]<arr[j-1]){
                    flag = true ;
                    tmp = arr[j] ;
                    arr[j] =arr[j-1] ;
                    arr[j-1] = tmp ;
                }
            }
            if(!flag){
                break;
            }
        }
        return arr ;
    }
}
