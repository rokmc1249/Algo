package tree.example.searchIndex;

public class SearchTree {

    public static int search(int[]arr,int start,int end,int target){
       if(start>end){
           return -1;
       }
       int mid = (start+end)/2;
       if(arr[mid]>target){
         return search(arr,start,mid-1,target);
       }else if (arr[mid]<target) {
         return search(arr,mid+1,end,target);
       }
        return mid;
    }

    public static void main(String[] args) {
        int[]arr = {-1, 0, 3, 5, 9, 12};
        int target = -7;
        System.out.println(search(arr,0,arr.length-1,target));
    }
}
