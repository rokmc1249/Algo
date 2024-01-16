package sort.bubble;
import java.util.Arrays;


public class BubbleSort {

    public static int[] bubble(int[]arr){
         int []answer=arr.clone();
         for(int i=0;i< arr.length-1;i++){
             int currentIdx=i;
             for(int j=1;j<arr.length-currentIdx;j++){
                 if(answer[j]<answer[j-1]){
                     int tmp=answer[j];
                     answer[j]=answer[j-1];
                     answer[j-1]=tmp;
                 }
             }

         }
         return answer;
    }
    public static void main(String[] args) {
        int []a={4,6,2,9,1};
        System.out.println(Arrays.toString(bubble(a)));
    }
}
