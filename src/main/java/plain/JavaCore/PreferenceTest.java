package plain.JavaCore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author 13314409603@163.com
 * @date 2019/2/1
 * @time 13:09
 * @Description
 */
public class PreferenceTest {
    public static void main(String[] args) {
        Preferences rootPre = Preferences.systemRoot();
        Preferences userPre = Preferences.userRoot();
        System.out.println(rootPre.absolutePath());
        System.out.println(userPre.absolutePath());
        Preferences node = userPre.node("/plain/JavaCore/AnyDemo");

        node.put("rootNodeTest","rootNodeTest");
//        try {
//            node.flush();
//        } catch (BackingStoreException e) {
//            e.printStackTrace();
//        }
        System.out.println(node.get("rootNodeTest","default value"));
        try {
//            String[] keys = rootPre.keys();
            String[] keys = node.keys();
            System.out.println(keys.length);
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
        try {
            node.exportNode(new FileOutputStream("/resources/nodeExportNode.xml"));
            node.exportSubtree(new FileOutputStream("/resources/subTreeExport.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }
}
