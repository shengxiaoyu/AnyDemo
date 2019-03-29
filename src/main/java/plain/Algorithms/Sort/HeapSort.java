package plain.Algorithms.Sort;

/**
 * @author 13314409603@163.com
 * @date 2019/3/17
 * @time 16:43
 * @Description 堆排序
 * 证明完全二叉树的叶子节点编号y为父节点编号x的：y=2x 或y = 2x+1(编号从1开始）（注意，在代码中是编号从0开始）
 * 先证明
（1）完全二叉树中任何一层最左的节点编号n,则其左子树为2n,右子树为2n+1.
显然，每个节点的编号N = 按层遍历位于该节点前面的节点数目+1.
对于第L层的最左节点，在它之前的节点即为第1层到第L-1层的所有节点，共
2^0+2^1+...+2^(L-2) = 2^(L-1)-1个（注意第i层共有2^(i-1)个节点）。
则第L层最左节点编号为2^(L-1)，其左子树为第L+1层的最左节点，故编号为2^L。这样，（1）被证明了。
再证明
（2）完全二叉树中任一节点编号n,则其左子树为2n,右子树为2n+1.
任取一节点N，其编号为n。设N所在的这一层L的最左节点为M，编号为m。
显然，L层中位于N左边的节点数为n-m个。N的左子树NL位于第L+1层，由于是完全二叉树，
第L+1层中位于NL之前的节点数为2(n-m).由(1)可知第L+1层的最左节点编号为2m，那么NL的编号为2m+2(n-m)=2n.
 */
public class HeapSort extends AbstractSort {
    @Override
    public int[] sort(int[] arr) {
        //build heap
        int len = arr.length ;
        for(int i=(len-1)/2;i>=0;i--){
            heapify(arr,i,len) ;
        }
        //sort
        for(int i=0;i<len-1;i++){
            int max = arr[0] ;
            arr[0] = arr[len-1-i] ;
            arr[len-1-i] = max;
            heapify(arr,0,len-1-i) ;
        }

        return arr ;
    }

    //调整节点 最大完全二叉树
    private int[] heapify(int[] arr,int node,int len){
        //find max
        int max_node = node ;
        //left node
        if(node*2+1<len && arr[max_node]<arr[node*2+1]){
            max_node = node*2+1 ;
        }
        if(node*2+2<len && arr[max_node]<arr[node*2+2]){
            max_node = node*2+2 ;
        }
        if(max_node!=node){
            //swap
            int tmp = arr[node] ;
            arr[node] = arr[max_node] ;
            arr[max_node] = tmp ;

            //heapify new node
            heapify(arr,max_node,len) ;
        }
        return arr ;
    }
}
