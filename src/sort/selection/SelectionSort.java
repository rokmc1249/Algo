package sort.selection;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selection(int[]arr){
        int []answer=arr.clone();
        for(int i=0;i< answer.length-1;i++){
            int min=answer[i];
            int idx=i;
            for(int j=i+1;j< answer.length;j++){
                if(min>answer[j]){
                    min=answer[j];
                    idx=j;
                }
            }
            if(min!=answer[i]){
                answer[idx]=answer[i];
                answer[i]=min;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int []a={3, 2, 1, 5, 3, 2, 3};
        System.out.println(Arrays.toString(selection(a)));
    }
}
