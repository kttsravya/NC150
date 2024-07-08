package Trees;

public class ValidBinarySearchTree {
    public static void main(String[] args){
        ValidBinarySearchTree binarySearchTree = new ValidBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(binarySearchTree.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        Double left = Double.NEGATIVE_INFINITY;
        Double right = Double.POSITIVE_INFINITY;
        return isValidBSTHelper(root, left, right);
    }

    private boolean isValidBSTHelper(TreeNode current, Double left, Double right) {
        if(current == null){
            return true;
        }
        if(! (left < current.val && current.val < right)){
            return false;
        }
        return isValidBSTHelper(current.left, left, (double)current.val)
        && isValidBSTHelper(current.right, (double)current.val, right);
    }
}
