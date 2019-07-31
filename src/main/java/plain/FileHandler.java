//package plain;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.*;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class FileHandler {
//
//    public static void main(String[] args) {
//        classification();
//    }
//
//    public static void getDoc(){
//        String baseDirPath = "E://rawMaterial/天津市河东区人民法院/民事" ;
//        String newDirPath = "E://研二1/学术论文/准备材料2/离婚纠纷" ;
//        File baseDir = new File(baseDirPath) ;
//        if(!baseDir.isDirectory()){
//            System.out.println("基本文件夹路径错误！");
//            return;
//        }
//
//        FilenameFilter ajSubDirFilter = new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if(name.contains("裁判文书")||name.contains("立案相关材料")||name.contains("笔录类文书")||name.contains("庭审")){
//                    return true ;
//                }
//                return false;
//            }
//        } ;
//        FilenameFilter cpwsFiler = new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if(name.contains("判决")){
//                    return true ;
//                }
//                return false ;
//            }
//        } ;
//        for(String ajmc:baseDir.list()){
//
//            File file = new File(baseDir+"/"+ajmc+"/电子卷宗/正卷") ;
//            File[] files = file.listFiles(ajSubDirFilter);
//            if(files!=null){
//                //判断是否含有裁判文书
//                File wsFile = new File(baseDir+"/"+ajmc+"/电子卷宗/正卷/裁判文书") ;
//                File[] files1 = wsFile.listFiles(cpwsFiler);
//                if(files1==null||files1.length==0){
//                    System.out.println(ajmc+"不含判决书");
//                    continue;
//                }else{
//                    try {
//                        //判断是否是离婚纠纷案件
//                        FileInputStream fis = new FileInputStream(files1[0]) ;
//                        String content = "" ;
//                        if(files1[0].getName().endsWith(".doc")){
//                            HWPFDocument doc = new HWPFDocument(fis) ;
//                            content = doc.getDocumentText() ;
//                        }else if(files1[0].getName().endsWith(".docx")){
//                            XWPFDocument docx = new XWPFDocument(fis) ;
//                            XWPFWordExtractor extractor = new XWPFWordExtractor(docx) ;
//                            content = extractor.getText() ;
//                        }
//                        if(!content.contains("离婚纠纷")){
//                            System.out.println(ajmc+"不是离婚纠纷案件");
//                            continue;
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(ajmc+"开始拷贝文件夹");
//                File ajFile =new File(newDirPath+"/"+ajmc) ;
//                ajFile.mkdirs() ;
//                for(File subDir:files){
//                    try {
//                        FileUtils.copyDirectory(subDir,ajFile);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//
//    /**
//     * 过滤案件，不包含立案相关材料ocr识别结果的删掉
//     */
//    public static void filterDoc(){
//        String baseDir = "E:\\研二1\\学术论文\\准备材料2\\离婚纠纷第二批\\files" ;
//        String newDir = "E:\\研二1\\学术论文\\准备材料2\\离婚纠纷第二批整理" ;
//        List<String> fymcList = Arrays.asList("宁河区人民法院", "天津滨海法院", "天津市宝坻区人民法院", "天津市北辰区人民法院", "天津市大港区人民法院",
//                "天津市第二中级人民法院", "天津市东丽区人民法院", "天津市汉沽区人民法院", "天津市和平区人民法院", "天津市河北区人民法院",
//                "天津市河东区人民法院", "天津市河西区人民法院", "天津市红桥区人民法院", "天津市蓟州区人民法院", "天津市津南区人民法院",
//                "天津市经济技术开发区人民法院", "天津市静海区人民法院", "天津市南开区人民法院", "天津市塘沽区人民法院", "天津市武清区人民法院",
//                "天津市西青区人民法院");
//        fymcList.forEach(fymc -> {
//            String dirStr = baseDir+File.separator+fymc+File.separator+"民事" ;
//            File dir = new File(dirStr) ;
//            if(dir.exists()){
//                Arrays.asList(dir.listFiles()).forEach(aj->{
//                    String absolutePath = aj.getAbsolutePath();
//
//                    //立案相关材料
//                    File laxgclFile = new File(absolutePath+File.separator+"电子卷宗"+File.separator+"正卷"+File.separator+"立案相关材料") ;
//                    if(!laxgclFile.exists()){
//                        //没有立案相关材料文件夹，则直接删除当前案件
//                        forceDelete(aj);
//                        return;
//                    }
//                    //必须有ocr识别结果。ocr识别结果集
//                    File[] ocrList = laxgclFile.listFiles((f, name) -> {
//                        if (name.contains("_ocr.txt")) {
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    });
//                    if(ocrList==null||ocrList.length==0){
//                        //没用ocr识别结果则直接删除
//                        forceDelete(aj);
//                        return;
//                    }
//
//                    //图片集
//                    File[] jpgList = laxgclFile.listFiles((f,name)->{
//                        if(name.endsWith(".jpg")){
//                            return true ;
//                        }else {
//                            return false ;
//                        }
//                    }) ;
//                    //ocr识别结果文件名称和jpg图片的映射map
//                    Map<String, File> jpgMap = Arrays.asList(jpgList).stream().collect(
//                            Collectors.toMap(jpg -> jpg.getName().replace(".jpg", "_ocr.txt"), jpg -> jpg));
//
//                    //将案件裁判文书、起诉状、庭审、笔录 拷贝到 E:\研二1\学术论文\准备材料2\离婚纠纷第二批整理
//
//                    String newAjDirPath = newDir+ File.separator+aj.getName();
//                    String newAjTsblPath = newDir+File.separator+aj.getName()+File.separator+"庭审笔录";
//                    File newAjDir = new File(newAjDirPath) ;
//                    File newAjTsblDir = new File(newAjTsblPath) ;
//
//                    boolean haveCopied = false ;
//                    boolean copy =  false ;
//                    //从含有“民事诉状”关键字的文件开始拷贝，直到含有“此致”关键字（起诉状可能多个文件）
//                    int count = 0 ;
//                    for(File txt:ocrList){
//                        try {
//                            StringBuilder sb = new StringBuilder() ;
//                            Scanner scanner = new Scanner(txt) ;
//                            while (scanner.hasNextLine()){
//                                sb.append(scanner.nextLine()) ;
//                            }
//                            String content = sb.toString() ;
//                            if(content.contains("民事诉状")){
//                                copy = true ;
//                            }
//                            if(copy){
//                                if(!newAjDir.exists()){
//                                    if(!newAjDir.mkdirs()) {
//                                        System.out.println("创建新案件文件夹失败" + newAjDirPath);
//                                        return;
//                                    }
//                                }
//                                //拷贝ocr识别结果
//                                FileUtils.copyFileToDirectory(txt,newAjDir);
//                                //拷贝原图片
//                                if(jpgMap.containsKey(txt.getName())){
//                                    File jpg = jpgMap.get(txt.getName()) ;
//                                    FileUtils.copyFileToDirectory(jpg,newAjDir);
//                                }
//                                haveCopied = true ;
//                                if(content.contains("此致")){
//                                    copy = false ;
//                                }
//                            }
//
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    //拷贝裁判文书和庭审笔录
//                    File zqDir = new File(absolutePath+File.separator+"电子卷宗"+File.separator+"正卷") ;
//                    if(haveCopied){
//                        //裁判文书
//                        File[] cpws = zqDir.listFiles((f, name) -> {
//                            if (name.contains("裁判文书")) {
//                                return true;
//                            }
//                            return false;
//                        });
//                        Arrays.asList(cpws).forEach(srcDir->{
//                            try {
//                                FileUtils.copyDirectory(srcDir,newAjDir);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        });
//                        //庭审笔录
//                        if(!newAjTsblDir.exists()){
//                            File[] tsbl = zqDir.listFiles((f, name) -> {
//                                if (name.contains("庭审")||name.contains("笔录")) {
//                                    return true;
//                                }
//                                return false;
//                            });
//                            Arrays.asList(tsbl).forEach(srcDir->{
//                                try {
//                                    if(!newAjTsblDir.exists()){
//                                        if(!newAjTsblDir.mkdirs()){
//                                            System.out.println("创建庭审笔录文件夹失败"+newAjTsblPath);
//                                            return;
//                                        }
//                                    }
//                                    FileUtils.copyDirectory(srcDir,newAjTsblDir);
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            });
//                        }
//
//                    }
//                });
//            }
//        });
//    }
//
//
//    /**
//     * 强制删除文件，如果是文件夹则递归删除
//     * @param file
//     */
//    public static void forceDelete(File file){
//        if (file.isDirectory()) {
//            Arrays.stream(file.listFiles()).forEach(FileHandler::forceDelete);
//        }
//        System.out.println(file.getAbsolutePath()+":"+file.delete() );
//    }
//
//    /**
//     * 重命名文件，暂时不起用
//     * @param file
//     * @param newName
//     * @return
//     */
//    public static File reName(File file,String newName){
//        File newFile = new File(file.getAbsolutePath().replace(file.getName(),newName)) ;
//        file.renameTo(newFile) ;
//        return newFile ;
//    }
//
//    /**
//     * 分含庭审笔录和不含庭审笔录的
//     */
//    public static void classification(){
//        String basePath = "E:\\研二1\\学术论文\\准备材料2\\离婚纠纷第二批整理" ;
//        File htsbl = new File("E:\\研二1\\学术论文\\准备材料2\\离婚纠纷第二批（分庭审笔录）\\含庭审笔录") ;
//        File bhtsbl = new File("E:\\研二1\\学术论文\\准备材料2\\离婚纠纷第二批（分庭审笔录）\\不含庭审笔录") ;
//        File baseDir = new File(basePath)  ;
//        File[] ajArray = baseDir.listFiles((f, name) -> {
//            if (name.contains("民初")) {
//                return true;
//            } else {
//                return false;
//            }
//        });
//        Arrays.asList(ajArray).forEach(aj->{
//            File[] tsbl = aj.listFiles((f,name)->{
//                if(name.equals("庭审笔录")){
//                    return true ;
//                }else{
//                    return false ;
//                }
//            }) ;
//            if(tsbl!=null&&tsbl.length>0){
//                File file = new File(htsbl.getAbsolutePath()+File.separator+aj.getName()) ;
//                file.mkdir() ;
//                try {
//                    FileUtils.copyDirectory(aj,file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else {
//                File file = new File(bhtsbl.getAbsolutePath()+File.separator+aj.getName()) ;
//                file.mkdir() ;
//                try {
//                    FileUtils.copyDirectory(aj,file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}
//
