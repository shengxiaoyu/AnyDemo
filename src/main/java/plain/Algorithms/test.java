package plain.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author 13314409603@163.com
 * @date 2019/3/31
 * @time 19:54
 * @Description
 */
public class test {
    public static void main(String[] args) {
        int[] numbers = {2,2,2,2,8} ;
        int[] numbers2 = {1,2,3,6,8} ;
        System.out.println(new test().divide(numbers, 2));
    }
    public boolean divide(int[] numbers,int n){
        int total = 0 ;
        for(int val:numbers){
            total+=val ;
        }
        if(total%n!=0){
            return false ;
        }
        int mean = total/n ;
        while (n!=0){
            Arrays.sort(numbers);
            int max = numbers[numbers.length-1] ;
            if(max>mean){
                return false ;
            }
            if(max==mean){
                n--;
                int[] newNumbers = new int[numbers.length-1];
                System.arraycopy(numbers,0,newNumbers,0,newNumbers.length);
                numbers = newNumbers ;
                continue;
            }
            int[] others = findTarget(numbers,numbers.length-2,mean-max) ;
            if(others==null){
                return false ;
            }
            int[] newNumbers = new int[numbers.length-others.length-1] ;
            int k= 0;
            for(int i=0;i<numbers.length-1;i++){
                boolean in = false ;
                for(int j=0;j<others.length;j++){
                    if(i==others[j]){
                        in = true ;
                    }
                }
                if(!in){
                    newNumbers[k++] = numbers[i] ;
                }
            }
            n--;
            numbers = newNumbers ;
        }
        return true ;
    }
    private int[] findTarget(int[] numbers,int end,int n){
        if(end<0){
            return null ;
        }
        int i = 0;
        for(i=end;i>=0;i--){
            if(numbers[i]<=n){
                break;
            }
        }
        if(i<0){
            return null ;
        }
        if(numbers[i]==n){
            return new int[]{i} ;
        }
        int[] j = findTarget(numbers,i-1,n-numbers[i]) ;
        if(j==null){
            return null ;
        }else {
            int[] result = new int[j.length+1] ;
            System.arraycopy(j,0,result,0,j.length);
            result[j.length] = i ;
            return result ;
        }
    }
}
