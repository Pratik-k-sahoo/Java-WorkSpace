package Java.apnaCollege.Trie.PreRequisite;

public class PrefixSufix {
    
    public static void main(String[] args) {
        String s = "apple";
        System.out.println("PREFIX ARE : ");
        for(int i=0; i<s.length(); i++){
            System.out.print(s.substring(0, i+1) + " ");
        }
        System.out.println();
        System.out.println("SUFIX ARE : ");
        for(int i=0; i<s.length(); i++){
            System.out.print(s.substring(i) + " ");
        }
    }
}
