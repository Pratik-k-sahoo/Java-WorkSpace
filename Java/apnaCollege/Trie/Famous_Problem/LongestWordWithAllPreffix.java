package Java.apnaCollege.Trie.Famous_Problem;

public class LongestWordWithAllPreffix {

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

    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){

        if(root == null){
            return;
        }


        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].endOfWord == true){
                temp.append((char)(i + 'a'));
                if(ans.length() < temp.length()){
                    ans = temp.toString();
                }
                // System.out.println("ans:" + ans);

                longestWord(root.children[i], temp);

                // System.out.println("temp:" + temp);

                temp.deleteCharAt(temp.length() - 1);

                // System.out.println("temp:" + temp);
            }

        }
    }
    
    public static void main(String[] args) {
        
        String[] word = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i=0; i<word.length; i++){
            insert(word[i]);
        }

        longestWord(root, new StringBuilder(""));

        System.out.println(ans);
    }
}
