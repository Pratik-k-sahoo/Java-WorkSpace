package Java.apnaCollege.HashSet_and_HashMap.Collection_Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCode {
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();

        //Insertion
        map.put("India", 120);
        map.put("China", 180);
        map.put("US", 50);
        map.put("Nepal", 15);
        map.put("Singapore", 5);

        //Print elements
        System.out.println(map);

        //Updating
        map.put("India", 200);

        //Searching
        if(map.containsKey("India")){
            System.out.println("Exist");
        }
        else{
            System.out.println("Doesn't Exist");
        }

        //Get Value
        System.out.println(map.get("China"));
        System.out.println(map.get("Antarctica"));

        //Iteration
        //PART-I
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e.getKey() + "->" + e.getValue());
        }

        //PART-II
        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println(key + "->" + map.get(key));
        }
    }
}
