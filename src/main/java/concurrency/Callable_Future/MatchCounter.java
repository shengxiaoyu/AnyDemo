package concurrency.Callable_Future;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 13314409603@163.com
 * @date 2019/3/27
 * @time 23:22
 * @Description
 */
public class MatchCounter implements Callable<Integer> {
    private File baseFile ;
    private String keyWord ;
    public MatchCounter(File baseFile,String keyWord){
        this.baseFile = baseFile ;
        this.keyWord = keyWord ;
    }
    @Override
    public Integer call() throws Exception {
        int count = 0 ;
        if(baseFile.isFile()){
            count =searchFile(baseFile,keyWord) ;
        }else {
            //存储每个文件搜索任务的引用
            List<FutureTask<Integer>> tasks = new ArrayList<>() ;

            for (File file1 : baseFile.listFiles()) {
                //遍历为每个文件创建一个任务
                MatchCounter matchCounter = new MatchCounter(file1,keyWord) ;
                FutureTask<Integer> task = new FutureTask<Integer>(matchCounter) ;
                new Thread(task).start();
                tasks.add(task) ;
            }
            for(FutureTask<Integer> task:tasks){
                count += task.get() ;
            }
        }
        return count;
    }

    //搜查单个文件
    private int searchFile(File file,String keyWord) throws FileNotFoundException {
        int count = 0;
        Scanner sc = new Scanner(file) ;
        while (sc.hasNextLine()){
            String line = sc.nextLine() ;
            if(line.contains(keyWord)){
                count++ ;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\13314\\Desktop\\Bi-LSTM+CRF\\labeled") ;
        MatchCounter matchCounter = new MatchCounter(file,"结婚") ;
        FutureTask<Integer> task = new FutureTask<Integer>(matchCounter) ;
        new Thread(task).start();

        try {
            Integer integer = task.get();
            System.out.println("共："+integer+"个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
