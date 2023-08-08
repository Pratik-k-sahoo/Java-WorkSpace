package Java.apnaCollege.HashSet_and_HashMap.Internal_Implementation;

import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapCode {

    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n, N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.buckets=new LinkedList[4];
            this.N=buckets.length;

            for(int i=0; i<N; i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)%N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll=buckets[bi];
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            n=0;
            LinkedList<Node> oldBuckets[]=buckets;
            N*=2;
            buckets=new LinkedList[N];
            for(int i=0; i<N; i++){
                buckets[i]=new LinkedList<>();
            }

            for(int i=0; i<oldBuckets.length; i++){
                LinkedList<Node> ll=oldBuckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node=ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);

            if(di==-1){
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node data=buckets[bi].get(di);
                data.value=value;
            }

            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }

        public V get(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);

            if(di==-1){
                return null;
            }
            else{
                Node data=buckets[bi].get(di);
                return data.value;
            }
        }

        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);

            if(di==-1){
                return false;
            }
            else{
                return true;
            }
        }

        public V remove(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);

            if(di==-1){
                return null;
            }
            else{
                Node data=buckets[bi].remove(di);
                n--;
                return data.value;
            }
        }

        public boolean isEmpty(){
            return n==0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll=buckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public int size(){
            return n;
        }

        public int bucketSize(){
            return N;
        }
    }
    public static void main(String[] args) {
        
        HashMap<String, Integer> map=new HashMap<>();
        map.put("India", 120);
        map.put("Chine", 180);
        map.put("US", 50);
        map.put("Nepal", 15);
        map.put("Singapore", 5);
        map.put("Japan", 10);
        map.put("Australia", 12);
        map.put("Korea", 6);
        map.put("America", 8);
        map.put("Americ", 13);
        map.put("Ameri", 13);
        map.put("Amer", 13);
        map.put("Ame", 13);
        map.put("Am", 13);
        map.put("A", 13);
        map.put("Aca", 13);
        map.put("Aica", 13);

        System.out.println(map.size());
        System.out.println(map.bucketSize());
        // System.out.println(map);

        ArrayList<String> keys=map.keySet();
        for(int i=0; i<keys.size(); i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
    }
}
