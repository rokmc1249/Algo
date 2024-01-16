package tree.example.rotatedTree;

public class RotatedSortedArraySearch {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        // Find the rotation point
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        // Apply binary search
        int index = binarySearch(nums, left, nums.length - 1, target);
        if (index == nums.length) {
            return 0;
        } else if (index == -1) {
            return -1;
        }

        // Adjust the index to account for the rotation
        return index % nums.length;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return nums.length;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(search(nums, target)); // Output: 4
    }
}

