package tree.example.fixedpoint;

public class FixedPoint {
    public static int fixed(int[]arr){
        int left=0;
        int right= arr.length;
        while(left<right){
           int mid = (left+right)/2;
           if(arr[mid]>mid){
               right=mid-1;
           }else{
               left = mid+1;
           }
        }
        if(left>= arr.length||left!=arr[left]){
            return -1;
        }
        return left;
    }
    public static void main(String[] args) {
        int[]arr={3, 4, 5, 6, 7};
        System.out.println(fixed(arr));


    }
}
