package Java.College.Lab_Exam_Practice.Sample_Question;
import java.util.Scanner;

public class Practice {

    static void subArrays(char a[]){
        int size=a.length;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(i!=j && i!=k  && j!=k ){
                                    System.out.println("" + a[i] + a[j] + a[k]);
                                }
                    // for(int l=0; l<size; l++){
                    //     for(int m=0; m<size; m++){
                    //         for(int n=0; n<size; n++){
                    //             if(i!=j && i!=k && i!=l && i!=m && i!=n && j!=k && j!=l && j!=m && j!=n && k!=l && k!=m && k!=n && l!=m && l!=n && m!=n){
                    //                 System.out.println("" + a[i] + a[j] + a[k] + a[l] + a[m] + a[n]);
                    //             }
                    //         }
                    //     }
                    // }
                }
            }
        }
    }

    public static void subarrayRecursion(String s, int idx, String newString){
        if(idx==s.length()){
            System.out.println(newString);
            return;
        }

        char currChar=s.charAt(idx);

        //to be added
        subarrayRecursion(s, idx+1, newString+currChar);

        //not to be added
        subarrayRecursion(s, idx+1, newString);
    }

    public static String swapString(String s, int i, int j){
        char b[]=s.toCharArray();
        char ch;
        ch=b[i];
        b[i]=b[j];
        b[j]=ch;

        return String.valueOf(b);
    }

    public static void printPerm(String s, int start, int end){
        if(start==end){
            System.out.println(s);
        }

        for(int i=start; i<end; i++){
            s=swapString(s, start, i);
            printPerm(s, start+1, end);
            s=swapString(s, start, i);
        }
    }

    public static double sum(double m[][]){
        double sum=0;
        for(int i=0; i<m[0].length; i++){
            sum=0;
            for(int j=0; j<m.length; j++){
                sum+=m[j][i];
            }
            System.out.println(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char a[]={'a', 'b', 'c'};
        subArrays(a);
        subarrayRecursion("abc", 0, "");
        printPerm("abc", 0, 3);
        double arr[][]=new double[3][4];
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                arr[i][j]=sc.nextDouble();
            }
        }
        sum(arr);
    }
}
