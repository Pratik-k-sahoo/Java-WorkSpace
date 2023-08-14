package GFG.POTD;


//Non Repeating Numbers

import java.util.Arrays;
import java.util.HashMap;

public class August_14{

    public static int[] singleNumber(int[] nums)
    {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int find[]=new int[2];
        int i=0;

        /* mapSet here can't be used as its time-complexity more overally so use for loop of nums array and check it as follows
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                find[i++]=key;
            }
        }
        */

        for(int j=0; j<nums.length; j++){
            if(map.get(nums[j])==1){
                find[i++]=nums[j];
            }
        }

        Arrays.sort(find);

        return find;
    }

    public static int[] singleNumbers(int[] nums){
        int find[]=new int[2];
        int a=0;
        for(int i=0; i<nums.length; i++){
            int count=0;
            for(int j=0; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count==1){
                find[a++] = nums[i];
            }
        }

        Arrays.sort(find);

        return find;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 2};
        int find[]=singleNumber(arr);
        System.out.println(find[0] + " " + find[1]);
        int find1[]=singleNumbers(arr);
        System.out.println(find1[0] + " " + find1[1]);

    }
}