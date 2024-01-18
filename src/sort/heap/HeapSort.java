package sort.heap;

import java.util.Arrays;

public class HeapSort {

    public static int[] heap(int[]arr){
        int []answer = new int[arr.length];
        BinaryMinHeap minHeap = new BinaryMinHeap();
        for(int num:arr){
            minHeap.insert(num);
        }
        for(int i = 0;i< arr.length;i++){
            answer[i] = minHeap.extract();
        }
        return answer;
    }
    public static void main(String[] args) {
        int []a={4, 6, 2, 9, 1};
        int []b={3, 2, 1, 5, 3, 2, 3};
        System.out.println(Arrays.toString(heap(a)));
        System.out.println(Arrays.toString(heap(b)));
    }
}
