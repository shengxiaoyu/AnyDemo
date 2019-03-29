package plain.Algorithms.JianZhiOffer;

import java.util.ArrayList;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 22:26
 * @Description
 */
public class _3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<>() ;
        }

        ListNode last = null ;
        ListNode current = listNode ;
        ListNode next = null ;
        int len = 0 ;
        do{
            len++ ;
            next = current.next ;
            current.next = last ;
            last = current ;
            current = next ;
        }while(current!=null);
        ArrayList result = new ArrayList<>(len) ;

        do{
            result.add(last.val) ;
            last = last.next ;
        }while(last!=null);
        return result ;
    }
}
 class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
   }