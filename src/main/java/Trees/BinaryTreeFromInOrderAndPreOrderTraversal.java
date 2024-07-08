package Trees;

import java.util.Arrays;

public class BinaryTreeFromInOrderAndPreOrderTraversal {
    public static void main(String[] args){
        BinaryTreeFromInOrderAndPreOrderTraversal btree = new BinaryTreeFromInOrderAndPreOrderTraversal();
        TreeNode root = btree.buildTree(new int[]{1,2,3,4}, new int[]{2,1,3,4});
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i = 0; i < inorder.length; i ++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInOrder = Arrays.copyOfRange(inorder,0, mid);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder,mid+1, inorder.length);
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }
}
