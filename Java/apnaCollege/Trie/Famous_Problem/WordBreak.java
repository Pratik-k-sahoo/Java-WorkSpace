package Java.apnaCollege.Trie.Famous_Problem;

public class WordBreak {

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

    //SEARCHING
    public static boolean search(String word){

        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }

            if(i == word.length() - 1 && curr.children[idx].endOfWord == false){
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            String firstWord = key.substring(0, i);
            String secondWord = key.substring(i);

            if(search(firstWord) && wordBreak(secondWord)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key1 = "ilikesamsung";
        String key2 = "ilikesam";
        String key3 = "ilikesung";

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(wordBreak(key1));
        System.out.println(wordBreak(key2));
        System.out.println(wordBreak(key3));
    }
}
