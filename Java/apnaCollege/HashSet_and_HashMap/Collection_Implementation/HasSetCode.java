package Java.apnaCollege.HashSet_and_HashMap.Collection_Implementation;

import java.util.*;
public class HasSetCode {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
