package tree.example.fixedpoint;

public class SpecificNum {
    public static int countNumber(int[]arr,int target){
        int leftIdx = searchLeft(arr, target);

        if (leftIdx < 0) {
            // Target not found
            return -1;
        }

        int rightIdx = leftIdx;
        while (rightIdx < arr.length && arr[rightIdx] == target) {
            rightIdx++;
        }

        // Return the count of occurrences
        return rightIdx - leftIdx;
    }
    public static int searchLeft(int[]lst,int target){
        int low = 0;
        int high = lst.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (lst[mid] < target) {
                low = mid + 1;
            } else if (lst[mid] > target) {
                high = mid - 1;
            } else {
                // target found, return left index
                return mid;
            }
        }

        // target not found, return -(insertion point + 1)
        return -(low + 1);
    }

    public static void main(String[] args) {
        int[]arr={1, 1, 2, 2, 2, 2, 3};
        int target=2;//4
        System.out.println(countNumber(arr,target));
    }
}
