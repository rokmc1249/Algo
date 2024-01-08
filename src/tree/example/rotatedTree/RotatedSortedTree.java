package tree.example.rotatedTree;

import java.util.Arrays;

public class RotatedSortedTree {

    public static int rotatedTree(int[]nums,int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int middleIdx = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
            middleIdx = mid;
        }
        int []newArr = new int[nums.length];
        int size = middleIdx;
        for(int i=0;i< nums.length;i++){
            if(size < nums.length) {
                newArr[i] = nums[size++];
            }else{
                newArr[i] = nums[i-middleIdx+1];
            }
        }

        return bs(newArr,0, newArr.length-1,target );
    }
    public static int bs(int[]nums,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(nums[mid]>target){
            return bs(nums,start,mid-1,target);
        }else if (nums[mid]<target) {
            return bs(nums,mid+1,end,target);
        }
        return mid;

    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4; //4
        System.out.println(rotatedTree(nums,target));
    }
}
