package LEETCODE.POTD;

import java.util.HashSet;
// import java.util.function.IntFunction;
import java.util.Arrays;
import java.util.Collections;

public class August_14 {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        int ans=nums[nums.length-k];

        return ans;

        
    }

    // public static int[] findArray(int nums[]){
        
    // }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
