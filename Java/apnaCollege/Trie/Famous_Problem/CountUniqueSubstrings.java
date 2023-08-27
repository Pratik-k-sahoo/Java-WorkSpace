package Java.apnaCollege.Trie.Famous_Problem;

public class CountUniqueSubstrings {

    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26];
            for(int i=0; i<26; i++){
                children[i] = null;
            }

            endOfWord = false;
        }
    }

    static Node root = new Node();

    //INSERTION
    public static void insert(String word){

        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            if(i == word.length()-1){
                curr.children[idx].endOfWord = true;
            }

            curr = curr.children[idx];
        }
    }

    public static int countNode(Node root){

        if(root == null){
            return 0;
        }
        
        int count = 0;

        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }

        return count + 1;
    }

    
    
    public static void main(String[] args) {
        String s = "apple";

        //Making Suffix and inserting in Trie DS
        for(int i=0; i<s.length(); i++){
            insert(s.substring(i));
        }
        System.out.println(countNode(root));
    }
}
