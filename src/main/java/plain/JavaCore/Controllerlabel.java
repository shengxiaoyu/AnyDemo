package plain.JavaCore;

/**
 * @author 13314
 * @date 2019/7/3
 * @time 12:03
 * @Description
 */
public class Controllerlabel {
    public static void main(String[] args) {
        label1:
            for (int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(j==2){
                        break label1;
                    }
                    System.out.println(j);
                }
            }
    }
}
