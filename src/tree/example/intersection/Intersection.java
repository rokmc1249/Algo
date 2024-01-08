package tree.example.intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

    public static Set<Integer> inter(int[]n1, int[]n2){
        Set<Integer>blank=new HashSet<>();
        if(n1.length==0||n2.length==0){
            return blank;
        }
        Set<Integer> result = new HashSet<>();
        Arrays.sort(n2);

        for(int num:n1){ // n1의 요소를 하나씩 추출한 것을 정렬된 n2 배열에서 탐색
            int idx = search(n2,0,n2.length-1,num);
            if(n2.length>idx&&idx>=0){
                result.add(n2[idx]);
            }
        }
        return result;

    }
    public static int search(int[]n2,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(n2[mid]>target){
            return search(n2,start,mid-1,target);
        }else if (n2[mid]<target) {
            return search(n2,mid+1,end,target);
        }
        return mid;
    }
    public static void main(String[] args) {
        int[]nums1 = {4,9,5};
        int[]nums2 = {9,4,9,8,4};
        System.out.println(inter(nums1,nums2));
    }
}
