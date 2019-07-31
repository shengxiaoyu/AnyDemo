package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314
 * @date 2019/7/9
 * @time 18:05
 * @Description输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * {1,2,3,4,5,3,5,#,2,#}
 */
public class _25 {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1) ;
        RandomListNode node2 = new RandomListNode(2) ;
        RandomListNode node3 = new RandomListNode(3) ;
        RandomListNode node4 = new RandomListNode(4) ;
        RandomListNode node5 = new RandomListNode(5) ;
        node1.next=node2 ;
        node1.random = node3 ;
        node2.next = node3 ;
        node2.random = node5 ;
        node3.next = node4 ;
        node4.next = node5 ;
        node4.random = node2 ;
        System.out.println(Clone(node1));
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null ;
        }
        RandomListNode cursor = pHead ;
        //在每个节点后面加一个复制节点
        while(cursor!=null){
            RandomListNode newNode = new RandomListNode(cursor.label) ;
            newNode.next = cursor.next ;
            cursor.next = newNode ;

            //更新游标
            cursor = newNode.next ;
        }
        //复制特殊指针
        cursor = pHead ;
        while(cursor!=null){
            if(cursor.random!=null){
                RandomListNode newNode = cursor.next ;
                newNode.random = cursor.random.next ;
            }
            cursor = cursor.next.next ;
        }

        //拆分为两个链表
        RandomListNode newPHead = null ;
        RandomListNode newCursor = null ;
        cursor = pHead ;
        while(cursor!=null){
            RandomListNode newNode = cursor.next ;
            //拆分
            cursor.next = newNode.next ;
            newNode.next = null ;

            if(newCursor==null){
                newPHead = newNode ;
                newCursor = newNode ;
            }else{
                newCursor.next = newNode ;
                newCursor = newNode ;
            }
        }
        return newPHead ;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
