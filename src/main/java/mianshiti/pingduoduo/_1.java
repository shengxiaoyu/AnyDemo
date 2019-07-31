package mianshiti.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/3
 * @time 18:55
 * @Description
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine() ;
        line = line.substring(1,line.length()-1) ;
        String[] numbers = line.split(",") ;
        int[] ints = new int[numbers.length] ;
        for(int i=0;i<numbers.length;i++){
            ints[i]= Integer.parseInt(numbers[i].trim()) ;
        }
        if(numbers.length<2){
            System.out.println(0.000000);
            return;
        }
        Arrays.sort(ints);
        int d = in.nextInt() ;

        int fm = ints.length*(ints.length-1)/2 ;
        int count = 0 ;
        for(int i=0;i<ints.length-1;i++){
            for(int j=i+1;j<ints.length;j++){
                if(Math.abs(ints[i]-ints[j])<=d){
                    count++ ;
                    System.out.println(ints[i]+" "+ints[j]);
                }
            }
        }
        double result = count*1.0/fm ;
        System.out.println(result);
        String str = result+"" ;
        int pos = str.indexOf('.') ;
        if(pos==-1){
            str = str+".000000" ;
        }else {
            String xs = str.substring(pos+1) ;
            if(xs.length()<=6){
                for(int i=xs.length();i<6;i++){
                    str = str+"0" ;
                }
            }else {
                char tail = xs.charAt(5) ;
                char last = xs.charAt(6) ;
                int tailNumber = Integer.parseInt(tail+"") ;
                int lastNumber = Integer.parseInt(last+"");
                if(lastNumber>=5){
                    tailNumber++ ;
                }
                str = str.substring(0,pos+6)+tailNumber ;
            }
        }
        System.out.println(str);
    }
}
