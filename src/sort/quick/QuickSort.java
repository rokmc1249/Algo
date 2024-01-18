package sort.quick;

import java.util.Arrays;

public class QuickSort {
    public static int[]quick(int[]arr,int start,int end){

        if(start < end){
            int p = partition(arr,start,end);
            quick(arr,start,p-1);
            quick(arr,p+1,end);
        }
        return arr;

    }
    public static int partition(int[]part,int ps,int pe){
        int pivot = part[pe];
        int i = ps - 1;
        for(int j=ps;j<pe;j++){
            if(part[j]<=pivot){
                i+=1;
                int temp = part[i];
                part[i] = part[j];
                part[j] = temp;
            }
        }
        int temp = part[i+1];
        part[i+1] = part[pe];
        part[pe] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        int []a={1, 6, 2, 9, 4};
        int []b={3, 2, 1, 5, 3, 2, 3};
        System.out.println(Arrays.toString(quick(a,0,a.length-1)));
        System.out.println(Arrays.toString(quick(b,0,b.length-1)));
    }
}
