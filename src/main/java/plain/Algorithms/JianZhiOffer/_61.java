package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314
 * @date 2019/7/13
 * @time 16:28
 * @Description
 */
public class _61 {
    String deserializeStr ; //序列化的结果，先序遍历
    //先序遍历
    String Serialize(TreeNode root) {
        if(root==null){
            return "#" ;
        }
        String serializeStr = root.val+"" ;
        serializeStr += (" "+Serialize(root.left)) ;
        serializeStr += (" "+Serialize(root.right)) ;
        return serializeStr ;
    }
    TreeNode Deserialize(String str) {
        this.deserializeStr = str ;
        return deserializer() ;
    }
    private TreeNode deserializer(){
        //看是否还有流
        if(deserializeStr==null||deserializeStr.length()==0){
            return null ;
        }
        int index = deserializeStr.indexOf(" ");
        //取出当前节点val
        String val = index==-1?deserializeStr:deserializeStr.substring(0,1) ;
        //更新流
        deserializeStr = index==-1?"":deserializeStr.substring(index+1) ;
        //判断该点是否为空
        if(val.equals("#")){
            return null ;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val)) ;
        node.left = deserializer() ;
        node.right = deserializer() ;
        return node ;
    }
}
