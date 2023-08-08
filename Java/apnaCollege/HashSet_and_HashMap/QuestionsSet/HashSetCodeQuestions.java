package Java.apnaCollege.HashSet_and_HashMap.QuestionsSet;

import java.util.HashSet;

public class HashSetCodeQuestions {

    public static int UnionOf2Sets(int[] a, int[] b){
        HashSet<Integer> set=new HashSet<>();

        for(int i=0; i<a.length; i++){
            set.add(a[i]);
        }

        for(int i=0; i<b.length; i++){
            set.add(b[i]);
        }

        return set.size();
    }

    public static int IntersectionOf2Array(int[] a, int[] b){
        HashSet<Integer> set=new HashSet<>();

        for(int i=0; i<a.length; i++){
            set.add(a[i]);
        }

        int count=0;

        for(int i=0; i<b.length; i++){
            if(set.contains(b[i])){
                count++;
                set.remove(b[i]);
            }
        }

        return count;
    }
    public static void main(String[] args) {

        //Union of 2 Arrays
        // int a[]={7, 3, 9, 5};
        // int b[]={6, 3, 9, 2, 9, 4, 5};

        // System.out.println(UnionOf2Sets(a, b));

        //Intersection of 2 Array
        int a[]={7, 3, 9};
        int b[]={6, 3, 9, 2, 9, 4};
        System.out.println(IntersectionOf2Array(a, b));
    }
}
