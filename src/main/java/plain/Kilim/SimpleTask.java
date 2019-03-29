package plain.Kilim;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

import java.util.Arrays;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 17:00
 * @Description
 * 四种方式织入kilim增强
        during compilation by using the maven plugin
        during compilation by running kilim.tools.Weaver
        at runtime by invoking kilim.tools.Kilim com.yourcompany.yourclass
        at runtime by including if (kilim.tools.Kilim.trampoline(false,args)) return; at the start of main()
 */
public class SimpleTask extends Task {
    static Mailbox<String> mb = new Mailbox<>() ;

    public static void main(String[] args) throws InterruptedException {
        if (kilim.tools.Kilim.trampoline(false,args)) {//检查并织入增强
            return;
        }
        new SimpleTask().start() ;
        Thread.sleep(10);
        mb.putnb("Hello ") ;
        mb.putnb("World ") ;
        mb.putnb("Kilim\n") ;
        mb.putnb("done") ;
        idledown();
    }
    @Override
    public void execute() throws Pausable{
        while (true){
            String s = mb.get() ;
            if(s.equals("done")){
                break;
            }
            System.out.println(s);
        }
    }
}
