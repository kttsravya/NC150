package Trees;

public class SubTreeOfABinaryTree {

    public static void main(String[] args){
        SubTreeOfABinaryTree subTree = new SubTreeOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(4);
        subRoot.right = new TreeNode(5);
        boolean isSubTree = subTree.isSubtree(root, subRoot);
        System.out.println(isSubTree);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root == null && subRoot == null){
           return true;
       }
       if((root == null && subRoot != null)){
           return false;
       }
       if(root != null && subRoot == null){
           return true;
       }

       if(root.val == subRoot.val){
           boolean isSubTreeMatching =  isSubTreeMatching(root.left, subRoot.left) && isSubTreeMatching(root.right, subRoot.right);
           if(isSubTreeMatching){
               return true;
           }
       }

       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

   public boolean isSubTreeMatching(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null)){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return isSubTreeMatching(root.left, subRoot.left) &&
        isSubTreeMatching(root.right, subRoot.right);
    }
}
