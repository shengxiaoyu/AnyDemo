package Algorithms.DynamicProgramming;

import java.util.Objects;
import java.util.Stack;

/**
 * @author 13314409603@163.com
 * @date 2019/1/10
 * @time 10:13
 * @Description
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String str = ")(((((()())()()))()(()))(" ;
//        System.out.println(recursive(str));
//        System.out.println(plain(str));
        System.out.println(stack("(()"));
    }

    /**
     * 暴力解决 time out
     * @param s
     * @return
     */
    public static int plain(String s){
        int result = 0 ;
        for(int i=0;i<s.length()-1;i++){
            int tmp = 0 ;
            for(int j=i+1;j<s.length();j++){
                if(isValid(s.substring(i,j+1))){
                    tmp = j-i+1 ;
                }
            }
            if(tmp>result){
                result = tmp ;
            }
        }
        return result ;
    }
    /**判断一个字符串是否是有效
     * @param s
     * @return
     */
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>() ;
        char[] array = s.toCharArray() ;
        for(int i=0;i<array.length;i++){
            if(array[i]=='('){
                stack.add(array[i]) ;
            }else {
                if (!stack.isEmpty()){
                    stack.pop() ;
                }else {
                    return false ;
                }
            }
        }
        return stack.isEmpty() ;
    }
    /**
     * 动态规划
     * tabu[i]表示以第i个字符为结尾的有效括号组长度
     * 转移方程为tabu[i]分三种情况：
     *  1、第i个字符为（，则tabu[i]=0;
     *  2、第i个字符为）,再看第i-1个字符，
     *      1.1、第i-1个字符为（，则i和i-1凑成一组，并加上以i-2个字符结尾的有效字符组长度，相邻字符组都有效的情况
     *      1.2、第i-1个字符为），则考虑除掉以i-1为结尾的有效字符组的前一个是否为（，
     *          1.2.1、如果是则说明扩展了2,tabu[i]=tabu[i-1]+2,同理考虑加上相邻字符组有效的情况
     *          1.2.2、如果不是则tabu[i]=0
     * @param
     * @return
     */
    public static int lvp(String s){
        int[] tabu = new int[s.length()+1] ;
        tabu[0] = 0;
        for(int i=1;i<s.length()+1;i++){
            //i代表第几个字符，从1开始
            if(s.charAt(i-1)=='('){
                tabu[i]=0 ;
            }else {
                //当前字符是‘)’
                if(i-1>0){
                    if(s.charAt(i-2)=='('){
                        //考虑前一个字符为(

                        //凑成一组有效字符长度为2
                        tabu[i]=2;
                        //考虑有效字符连在一起
                        tabu[i]=tabu[i]+tabu[i-2] ;
                    }else {
                        //前一个字符为）

                        //考虑前一个字符所在结尾的有效字符组前一个字符，
                        if(i-1-tabu[i-1]-1>=0&&s.charAt(i-1-tabu[i-1]-1)=='('){
                            //为（

                            //则扩展了子有效字符，扩展了2个长度
                            tabu[i]=tabu[i-1]+2 ;
                            //考虑有效字符组连在一起
                            tabu[i]=tabu[i-tabu[i]]+tabu[i] ;
                        }else {
                            //为(,则说明没有凑成有效字符组
                            tabu[i]=0;
                        }
                    }
                }else {
                    //考虑第一个字符就是')'
                    tabu[i]=0 ;
                }
            }
        }
        int result = 0 ;
        for(int i:tabu){
            if(i>result){
                result = i ;
            }
        }
        return result ;
    }


    /**
     * 使用栈结构解决
     * @param s
     * @return
     */
    public static int stack(String s){
        Stack<Object> stack = new Stack<>() ;
        char[] chars = s.toCharArray() ;
        for(int i=0;i<chars.length;i++){
            //考虑当前字符
            if(chars[i]=='('){
                stack.add(chars[i]) ;
            }else {
                //当前字符是）
                if(stack.isEmpty()){
                    continue ;
                }else {
                    //考虑栈顶字符
                    Object pop = stack.pop();
                    if(pop instanceof Character && (char)pop=='('){
                        //栈顶字符是(
                        if(stack.isEmpty()){
                            //如果此时栈内为空，则直接入栈2
                            stack.add(2) ;
                        }else {
                            //如果栈内不为空，则再次考虑栈顶元素
                            Object pop1 = stack.pop();
                            if(pop1 instanceof Integer){
                                //如果栈顶元素为数字，则相加在入栈，避免两个数字在栈内相邻，即解决相邻字符组有效情况
                                stack.add((int)pop1+2) ;
                            }else {
                                //否则重新入栈
                                stack.add(pop1) ;
                                stack.add(2) ;
                            }
                        }
                    }else if((pop instanceof Character && (char)pop==')')){
                        //栈顶元素为)直接入栈
                        stack.add(pop) ;
                        stack.add(chars[i]) ;
                    }else {
                        //栈顶元素为数字，再次考虑栈顶元素
                        if(stack.isEmpty()){
                            stack.add(pop) ;
                            stack.add(chars[i]) ;
                            continue;
                        }
                        Object pop1 = stack.pop();
                        //此时栈顶元素不可能再为数字
                        if((char)pop1=='('){
                            //此时是从两次扩展有效字符的情况
                            int len = (int)pop+2 ;
                            //再次考虑栈顶元素，如果是数字则解决相邻字符组有效问题
                            if(stack.isEmpty()){
                                stack.add(len) ;
                                continue;
                            }
                            Object pop2 = stack.pop();
                            if(pop2 instanceof Integer){
                                stack.add((int)pop2+len) ;
                            }else {
                                stack.add(pop2) ;
                                stack.add(len) ;
                            }
                        }else {
                            stack.add(pop1);
                            stack.add(pop) ;
                            stack.add(chars[i]) ;
                        }
                    }
                }
            }
        }
        int result = 0 ;
        for(Object item:stack){
            if(item instanceof Integer){
                if((int)item>result){
                    result = (int)item ;
                }
            }
        }
        return result ;
    }


    /**
     * 丧尽天良的解决
     */
    public static int spaceLast(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0 ;
        int result =0 ;
        for(int i=0;i<chars.length;i++){
            if (chars[i] == '(') {
                left++ ;
            }
            if(chars[i]==')'){
                right++ ;
            }
            if(left==right){
                result = Math.max(result,left*2) ;
            }
            if(right>left){
                left = 0 ;
                right = 0 ;
            }
        }
        left=0;
        right = 0 ;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] ==')'){
                right++ ;
            }
            if(chars[i]=='('){
                left++ ;
            }
            if(left==right){
                result = Math.max(result,left*2) ;
            }
            if(left>right){
                left = 0;
                right = 0;
            }
        }
        return result ;
    }

    /**
     * 丧尽天良的解决2
     */
    public static int stack2(String s){
        int result = 0 ;
        Stack<Integer> stack = new Stack<>() ;
        char[] chars = s.toCharArray();
        stack.add(-1) ;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i) ;
            }else {
                stack.pop() ;
                if(stack.isEmpty()){
                    stack.push(i) ;
                }else {
                    result = Math.max(result,i-stack.peek()) ;
                }
            }
        }
        return result ;
    }
}
