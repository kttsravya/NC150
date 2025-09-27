package Trees;


public class LowestCommonAncestor {

    public static void main(String[] args){
        LowestCommonAncestor lcs = new LowestCommonAncestor();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(4);
        tree.left.left.right = new TreeNode(2);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        TreeNode p= new TreeNode(3);
        TreeNode q = new TreeNode(8);
        TreeNode lcsNode = lcs.lowestCommonAncestor_Revision(tree, p, q);
        System.out.println(lcsNode.val);
    }

    public TreeNode lowestCommonAncestor_Revision(TreeNode root, TreeNode p, TreeNode q){
        return lowestCommonAncestor_RevisionHelper(root, p, q);

    }


    public TreeNode lowestCommonAncestor_RevisionHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val || ((p.val < root.val || q.val < root.val) && (p.val > root.val || q.val > root.val))){
            return root;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor_RevisionHelper(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor_RevisionHelper(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor_Iterative_BST(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if((p.val < root.val || q.val < root.val) && (p.val > root.val || q.val > root.val)){
                return root;
            }
            if(p.val == root.val || q.val == root.val){
                return root;
            }
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor_Recusrive_BST(TreeNode root, TreeNode p, TreeNode q) {
       if(root.val == p.val || root.val == q.val){
           return root;
       }
       if((p.val < root.val || q.val < root.val) && (p.val > root.val || q.val > root.val)){
           return root;
       }
       TreeNode node = null;
       if(p.val < root.val && q.val < root.val){
           node = lowestCommonAncestor_Recusrive_BST(root.left, p, q);
       }
       if(p.val > root.val && q.val > root.val){
           node = lowestCommonAncestor_Recusrive_BST(root.right, p, q);
       }
       return node;
    }

    public TreeNode lowestCommonAncestor_BinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor_BinaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestor_BinaryTree(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        } else{
           return right;
        }
    }

    /*class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;

            if(root.val == p.val) return p;
            if(root.val == q.val) return q;

            TreeNode node = root;

            if(p.val < root.val && q.val < root.val){
                node = lowestCommonAncestor(root.left, p,q);
            }

            if(p.val > root.val && q.val > root.val){
                node = lowestCommonAncestor(root.right, p,q);
            }

            return node;

        }
    }*/
}
