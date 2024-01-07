package tree.binaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {

    public static TreeNode sortedArrayToBST(int[] lst) {
        if (lst.length == 0) {
            return null;
        }

        int mid = lst.length / 2;
        TreeNode root1 = new TreeNode(lst[mid]);
        root1.left = sortedArrayToBST(Arrays.copyOfRange(lst, 0, mid));
        root1.right = sortedArrayToBST(Arrays.copyOfRange(lst, mid + 1, lst.length));
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
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add(null);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {-10,-3,0,5,9};
        TreeNode root1 = sortedArrayToBST(arr1);
        List<Integer> result1 = makeListByBST(root1, arr1.length);
        System.out.println(result1);

        int[] arr2 = {-10, -7, -3, -1, 0, 1, 4, 5, 7, 9};
        TreeNode root2 = sortedArrayToBST(arr2);
        List<Integer> result2 = makeListByBST(root2, arr2.length);
        System.out.println(result2);
    }
}