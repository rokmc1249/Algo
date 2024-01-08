package tree.binaryTree;

import tree.basicTreeNode.TreeNode;
import java.util.*;

public class BinaryTree {

    public static TreeNode sortedArrayToBST(int[] lst) {
        if (lst.length == 0) {
            return null;
        }

        int mid = lst.length / 2;
        TreeNode root1 = new TreeNode(lst[mid]);
        root1.setLeft(sortedArrayToBST(Arrays.copyOfRange(lst, 0, mid)));
        root1.setRight(sortedArrayToBST(Arrays.copyOfRange(lst, mid + 1, lst.length)));
        return root1;
    }

    public static List<Integer> makeListByBST(TreeNode root, int limit) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            if (result.size() > limit) {
                break;
            }

            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.getVal());
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            } else {
                result.add(null);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(arr);
        List<Integer> result = makeListByBST(root, arr.length);
        System.out.println(result);
    }
}