package Java.College.Lab_Exam_Practice.Practice;
import java.util.Scanner;

//A-1-4, 1-5, 1-6, 1-7, 1-10, 3-6, 3-7, 3-8, 3-9, 
//HW-1-5, 3-3, 3-4, 3-5, 

class Q_1_4{
    static Scanner sc=new Scanner(System.in);
    public static void method(){
        String s=sc.next();
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                for(int k=0; k<s.length(); k++){
                    if(i!=j && i!=k && j!=k){
                        System.out.println("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                    }
                }
            }
        }
    }
}

class Q_1_5{
    static Scanner sc=new Scanner(System.in);
    public static int sum_Of_Digits(int n){
        int sum=0;
        System.out.println("Number is " + n);
        while(n!=0){
            int r=n%10;
            sum+=r;
            n=n/10;
        }
        
        System.out.println("While complete with " + sum);
        
        if(sum>9){
            return sum_Of_Digits(sum);
        }
        System.out.println("sum is " + sum);
        return sum;
    }

    public static void main(){
        int n=sc.nextInt();
        System.out.println(sum_Of_Digits(n));
    }
}

class Q_1_6{
    static Scanner sc=new Scanner(System.in);

    public static boolean isOdd(int n){
        int b=n&1;

        if(b==1){
            return true;
        }
        return false;
    }

    public static void main(){
        int n=sc.nextInt();
        System.out.println(isOdd(n));
    }
}

class Q_1_7{
    static Scanner sc=new Scanner(System.in);

    public static int findMax(int n[]){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n.length; i++){
            if(max<n[i]){
                max=n[i];
            }
        }

        return max;
    }

    public static int findMin(int n[]){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n.length; i++){
            if(min>n[i]){
                min=n[i];
            }
        }

        return min;
    }

    public static int countEle(int n[], int ele){
        int count=0;
        for(int i=0; i<n.length; i++){
            if(n[i]==ele){
                count++;
            }
        }

        return count;
    }

    public static void position(int n[], int max, int min){
        for(int i=0; i<n.length; i++){
            if(n[i]==max){
                System.out.println("First occurrence of maximum element is at position " + (i+1));
                break;
            }
        }

        for(int i=n.length-1; i>=0; i--){
            if(n[i]==min){
                System.out.println("Last occurrence of minimum element is at position " + (i+1));
                break;
            }
        }
    }

    public static void main(){
        int n[]={12, 14, 12, 14, 13};

        int max=findMax(n);
        int min=findMin(n);
        System.out.println("Maximum element of Array is " + max + " and occurs " + countEle(n, max));
        System.out.println("Minimum element of Array is " + min + " and occurs " + countEle(n, min));
        position(n, max, min);
        
    }
}

class Q_1_10{
    static Scanner sc=new Scanner(System.in);

    public static void main(){
        double n[][]=new double[3][4];

        for(int i=0; i<n.length; i++){
            for(int j=0; j<n[0].length; j++){
                n[i][j]=sc.nextDouble();
            }
        }

        double sum=0;

        for(int i=0; i<n[0].length; i++){
            sum=0;
            for(int j=0; j<n.length; j++){
                sum+=n[j][i];
            }
            System.out.println("Sum of the elements at column 0 is " + sum);
        }
        
    }
}

class Box<T>{
    T var;

    Box(T var){
        this.var=var;
    }

    void set(T var){
        this.var=var;
    }

    T get(){
        return var;
    }
}

class Q_3_6{
    static Scanner sc=new Scanner(System.in);

    public static void main(){
        Box<String> b1=new Box<String>("BOX STRING");
        Box<String> b2=b1;
        System.out.println("b1 : " + b1.get() + "\nb2 : " + b2.get());
        b2.set("CHANGED");
        System.out.println("b1 : " + b1.get() + "\nb2 : " + b2.get());
    }
}

class Q_3_7{
    static Scanner sc=new Scanner(System.in);

    public static int findGCD(int a, int b){
        if(b==0){
            return a;
        }

        return findGCD(b, a%b);
    }

    public static int binaryEquivalent(int a){
        if(a==1){
            return 1;
        }
        else if(a==0){
            return 0;
        }

        return (a%2) + 10*binaryEquivalent(a/2); 
    }

    public static void main(){
        System.out.println(findGCD(sc.nextInt(), sc.nextInt()));
        System.out.println(binaryEquivalent(sc.nextInt())); //10011111
    }
}

class Q_3_8{
    static Scanner sc=new Scanner(System.in);

    public static String reverse(int a){
        if(a<=9){
            return ""+a;
        }

        return "" + a%10 + reverse(a/10);
    }

    public static void main(){
        System.out.println("Reverse of " + sc.nextInt() + " is " + reverse(sc.nextInt()));
    }
}

class Q_3_H3{
    static Scanner sc=new Scanner(System.in);

    public static boolean isPalindrome(String s){
        String str="";

        for(int i=s.length()-1; i>=0; i--){
            str+=s.charAt(i);
        }

        return str.equalsIgnoreCase(s);
    }

    public static void main(){
        System.out.println("checking Pallindromic : " + isPalindrome(sc.next()));
    }
}

class Q_1_H5{
    static Scanner sc=new Scanner(System.in);

    public static int largeRow(int n[][]){
        int large=-1;
        int count=0, max=0;

        for(int i=0; i<n.length; i++){
            count=0;
            for(int j=0; j<n[0].length; j++){
                count+=n[i][j];
            }
            System.out.println(count + " " + max);
            if(max<count && count!=max){
                max=count;
                large=i;
            }
        }

        return large;
    }

    public static int largeColumn(int n[][]){
        int large=-1;
        int count=0, max=0;

        for(int i=0; i<n[0].length; i++){
            count=0;
            for(int j=0; j<n.length; j++){
                count+=n[j][i];
            }
            System.out.println(count + " " + max);
            if(max<count && max!=count){
                max=count;
                large=i;
            }
        }

        return large;
    }

    public static void main(){
        int n[][]=new int[4][4];
        for(int i=0; i<n.length; i++){
            for(int j=0; j<n[0].length; j++){
                n[i][j]=(int)(Math.random()*2) ;
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Largest row index: " + largeRow(n));
        System.out.println("Largest column index: " + largeColumn(n));
        
    }
}

class Q_3_H4{
    static Scanner sc=new Scanner(System.in);
    
    public static void main(){
        
    }
}

public class Main {
    public static void main(String[] args) {
        // Q_1_4 q1=new Q_1_4();
        // q1.method();

        // Q_1_5 q2=new Q_1_5();
        // q2.main();

        // Q_1_6 q3=new Q_1_6();
        // q3.main();

        // Q_1_7 q4=new Q_1_7();
        // q4.main();

        // Q_1_10 q5=new Q_1_10();
        // q5.main();

        // Q_3_6 q6=new Q_3_6();
        // q6.main();

        // Q_3_7 q7=new Q_3_7();
        // q7.main();

        // Q_3_8 q8=new Q_3_8();
        // q8.main();

        // Q_3_H3 q9=new Q_3_H3();
        // q9.main();

        // Q_1_H5 q10=new Q_1_H5();
        // q10.main();

        Q_3_H4 q11=new Q_3_H4();
        q11.main();

        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(i==3)
                    break;
                    System.out.println(i + " " + j);
            }
        }
    }
}
