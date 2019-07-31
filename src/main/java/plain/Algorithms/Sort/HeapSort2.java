package plain.Algorithms.Sort;

/**
 * @author 13314
 * @date 2019/7/5
 * @time 17:34
 * @Description
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,81,33,53,42} ;
        HeapSort2.sort(arr) ;
    }
    public static int[] sort(int[] arr){
        int n = arr.length ;
        //建最小堆
        for(int i=n/2-1;i>=0;i--){
            ajust(arr,i,n);
        }
        for(int i=n-1;i>0;i--){
            //取堆顶
            int tmp = arr[i] ;
            arr[i] = arr[0] ;
            arr[0] = tmp ;
            ajust(arr,0,i);
        }
        for (int i : arr) {
            System.out.println(i+" ");
        }
        return arr ;
    }
    public static void ajust(int[] arr,int target,int n){
        while((target+1)*2<=n){
            //和左子节点比较
            if(arr[(target+1)*2-1]<arr[target]){
                int tmp = arr[target] ;
                arr[target] = arr[(target+1)*2-1] ;
                arr[(target+1)*2-1] = tmp ;
                target = (target+1)*2-1 ;
            }else if((target+1)*2+1<=n && arr[(target+1)*2]<arr[target]){
                //和右子节点比较
                int tmp = arr[target] ;
                arr[target] = arr[(target+1)*2] ;
                arr[(target+1)*2] = tmp ;
                target = (target+1)*2 ;
            }else {
                break;
            }
        }
    }
}
