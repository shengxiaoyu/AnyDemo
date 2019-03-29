package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 14:27
 * @Description
 */
public abstract class AbstractSort {
    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4,9 };
//        AbstractSort.printArr(new BubbleSort().sort(arr));
//        AbstractSort.printArr(new BubbleSort().sort2(arr));
//        AbstractSort.printArr(new BubbleSort().sort3(arr));
//        AbstractSort.printArr(new SelectSort().sort(arr));
//        AbstractSort.printArr(new InsertSort().sort(arr));
//        AbstractSort.printArr(new InsertSort().binarySort(arr));
//        AbstractSort.printArr(new ShellSort().sort(arr));
//        AbstractSort.printArr(new MergeSort().sort(arr));
//        AbstractSort.printArr(new HeapSort().sort(arr));
        AbstractSort.printArr(new QuickSort().sort(arr));
    }
    public abstract int[] sort(int[] arr);
    public static void printArr(int[] arr){
        for (int val:arr){
            System.out.print(val);
            System.out.print("\t");
        }
        System.out.println();
    }
}
