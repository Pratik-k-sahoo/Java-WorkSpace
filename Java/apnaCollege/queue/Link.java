package Java.apnaCollege.queue;
//301-Check the expression has valid or Balanced parenthesis or not.
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Link {

    public static boolean isPar(String x){
        if(x.length()%2!=0){
            return false;
        }
        Stack<Character> s=new Stack<>();
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i)=='(' || x.charAt(i)=='{' || x.charAt(i)=='['){
                s.push(x.charAt(i));
                continue;
            }

            if(s.isEmpty()){
                return false;
            }

            char check;
            switch(x.charAt(i)){
                case ')':   check=s.pop();
                            System.out.println(check);
                            if(check=='{' || check=='['){
                                return false;
                            }
                            break;
                case '}':   check=s.pop();
                            System.out.println(check);
                            if(check=='(' || check=='['){
                                return false;
                            }
                            break;
                case ']':   check=s.pop();
                            System.out.println(check);
                            if(check=='(' || check=='{'){
                                return false;
                            }
                            break;
                
            }
            
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x=sc.next();
        System.out.println(isPar(x));
    }
}
