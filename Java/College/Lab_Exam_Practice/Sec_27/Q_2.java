package Java.College.Lab_Exam_Practice.Sec_27;

public class Q_2 {

    static void printPerm(String s, int idx, String newString){

        if(idx==s.length()){
            System.out.println(newString);
            return;
        }
        char currChar=s.charAt(idx);

        //to be
        printPerm(s, idx+1, newString+currChar);

        //not to be
        printPerm(s, idx+1, newString);
    }
    
    public static void main(String[] args) {
        String s="CAR";
        printPerm(s, 0, "");
    }
}
