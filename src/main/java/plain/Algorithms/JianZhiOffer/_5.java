package plain.Algorithms.JianZhiOffer;

import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 13314409603@163.com
 * @date 2019/3/30
 * @time 0:11
 * @Description
 */
public class _5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node) ;
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop() ;
        }
        if(stack1.isEmpty()){
            throw new NoSuchElementException() ;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop()) ;
        }
        return stack2.pop() ;
    }
}
