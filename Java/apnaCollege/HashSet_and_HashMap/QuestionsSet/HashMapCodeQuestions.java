package Java.apnaCollege.HashSet_and_HashMap.QuestionsSet;

import java.util.HashMap;

public class HashMapCodeQuestions {

    public static void MajorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static int IntersectionOf2Array(int[] a, int[] b) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                map.put(b[i], map.get(b[i]) + 1);
            } else {
                map.put(b[i], 1);
            }
        }
        int count = 0;

        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key);
                count++;
            }
        }

        return count;
    }

    public static void findItinerary(HashMap<String, String> tickets){
        String start=findStart(tickets);

        while(tickets.containsKey(start)){
            System.out.print(start + " -> ");
            start=tickets.get(start);
        }

        System.out.println(start);
    }

    public static String findStart(HashMap<String, String> tickets){

        //Forming Reverse of Tickets HashMap
        // tickets key-> revMap value and tickets value-> revMap key
        HashMap<String, String> revMap=new HashMap<>();
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        //Finding if tickets key present in revMap key?
        //If not present then that is the start point of itinerary
        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Majority Element of Array having more than n/3 times.
        // int nums[]={1, 3, 2, 3, 3, 3, 1, 3, 1};
        // int nums[] = { 1, 2 };
        // MajorityElement(nums);

        // Intersection of 2 Array
        // int a[] = { 7, 3, 9 };
        // int b[] = { 6, 3, 9, 2, 9, 4 };
        // System.out.println(IntersectionOf2Array(a, b));

        //Find Itinerary from Tickets
        HashMap<String, String> tickets=new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        findItinerary(tickets);

    }
}
