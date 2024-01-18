package sort.merge;

import java.util.Arrays;

public class MergeSort {
    public static int[] split(int[]arr){
        int length = arr.length;
        if(arr.length<=1){
            return arr;
        }
        int mid = arr.length/2;
        int []left = Arrays.copyOfRange(arr,0,mid);
        int []right  = Arrays.copyOfRange(arr,mid,arr.length);
        int []reL = split(left);
        int []reR = split(right);
        return merge(reL,reR,length);
    }
    public static int[] merge(int[]arr1,int[]arr2,int length){
        int []answer = new int[length];
        int i=0, j = 0,cnt=0;
        while (i< arr1.length&&j< arr2.length){
            if(arr1[i]<arr2[j]){
                answer[cnt++]=arr1[i];
                i++;
            }
            else{
                answer[cnt++]=arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            answer[cnt++]=arr1[i];
            i++;
        }
        while(j<arr2.length){
            answer[cnt++]=arr2[j];
            j++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int []a={4, 6, 2, 9, 1};
        int []b={3, 2, 1, 5, 3, 2, 3};
        System.out.println(Arrays.toString(split(a)));
        System.out.println(Arrays.toString(split(b)));
    }
}
