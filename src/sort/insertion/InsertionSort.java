package sort.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertion(int[]arr){
        int []answer = arr.clone();
        for(int i=0;i < answer.length-1;i++){
            for(int j=0;j < i+1;j++){
                int curIdx=i+1-j;
                int val=answer[curIdx];
                if(answer[curIdx-1]>val){
                    answer[curIdx]=answer[curIdx-1];
                    answer[curIdx-1]=val;
                }else{
                    break;
                }
            }
            System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        }
        return answer;
    }

    public static int[]insertion2(int[]arr){
        int []answer = arr.clone();
        for(int i=0;i < answer.length-1;i++){
            int curIdx = i;
            int val = answer[i+1];
            while(curIdx>=0&&answer[curIdx]>val){
                answer[curIdx+1]=answer[curIdx];
                curIdx--;
            }
            answer[curIdx+1]=val;
            System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        }
        return answer;
    }
    public static void main(String[] args) {
        int []a={4, 6, 2, 9, 1};
        int []b={3, 2, 1, 5, 3, 2, 3};
        System.out.println(Arrays.toString(insertion(a)));
        System.out.println(Arrays.toString(insertion2(b)));
    }
}
