package challenges;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    ArrayList<String> paths;

    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        pathsRecDFS(root, "");
        return paths;
    }

    //Time comp: O(Vertices)
    public void pathsRecDFS(TreeNode node, String path){
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            if(!path.equals("")) {
                path = path + "->" + node.val;
            } else {
                path = path + node.val;
            }
            paths.add(path);
        } else {
            if(!path.equals("")) {
                path = path + "->";
            }
        }

        path = path + node.val;

        if(node.left != null) {
            pathsRecDFS(node.left, path);
        }

        if(node.right != null) {
            pathsRecDFS(node.right, path);
        }
    }
}
