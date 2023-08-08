package Java.apnaCollege.DSA_SHEET.String.Easy;

public class Q_1 {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        s=s.toLowerCase();
        String str="";
        for(int i=0; i<s.length(); i++){
            boolean b1=Character.isDigit(s.charAt(i));
            boolean b2=Character.isAlphabetic(s.charAt(i));

            if(b1 || b2){
                str += s.substring(i, i+1);
            }
        }
        System.out.println(str);
    }
}
