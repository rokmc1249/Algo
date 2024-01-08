package tree.InvertBinaryTree;
import tree.basicTreeNode.TreeNode;

import java.util.*;

public class InvertTree {

    public static List<Integer> invertTree(TreeNode root, int size){
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            if (result.size() > size) {
                break;
            }
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.getVal());
                //invert ChildNode
                TreeNode right = node.getLeft();
                TreeNode left = node.getRight();
                queue.add(left);
                queue.add(right);
            }
        }
        return result;

    }
    public static TreeNode makeTree(int[]arr,int idx){
        if(idx>=arr.length){
            return null;
        }
        int val = arr[idx];

        TreeNode treeNode = new TreeNode(val);
        treeNode.setLeft(makeTree(arr,2*idx+1));
        treeNode.setRight(makeTree(arr,2*idx+2));
        return treeNode;
    }
    public static void main(String[] args) {
        int [] arr1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode treeNode = makeTree(arr1,0);
        System.out.println(invertTree(treeNode, arr1.length));
    }
}
