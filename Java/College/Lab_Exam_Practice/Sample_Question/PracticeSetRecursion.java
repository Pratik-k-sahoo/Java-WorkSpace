package Java.College.Lab_Exam_Practice.Sample_Question;

public class PracticeSetRecursion {

    public static int findFact(int num){
        if(num==0 || num==1){
            return 1;
        }

        return num*findFact(num-1);
    }

    public static int findGCD(int a, int b){
        if(b==0){
            return a;
        }

        return findGCD(b, a%b);
    }

    public static int findProduct(int a, int b){
        if(a==1){
            return b;
        }
        if(b==1){
            return a;
        }
        if(a==0 || b==0){
            return 0;
        }
        return a + findProduct(a, b-1);
    }
    
    public static String findBinaryEquivalent(int a){
        if(a==0){
            return "";
        }
        return findBinaryEquivalent(a/2) + a%2;
    }

    public static int findFibonacci(int a, int b, int idx, int pos){
        int c=a+b;
        if(idx==pos){
            return c;
        }
        return findFibonacci(b, c, idx+1, pos);
    }

    public static boolean isPalindrom(String s, int idx, int pos){
        if(idx==s.length()-1 && pos==0){
            if(s.charAt(idx)==(s.charAt(pos))){
                return true;
            }
            else{
                return false;
            }
        }
        boolean flag=false;
        if(s.charAt(idx)==s.charAt(pos)){
            flag=true;
        }
        return flag && isPalindrom(s, idx+1, pos-1);
    }

    public static boolean linearSearch(int arr[], int a, int idx){
        if(idx==arr.length-1){
            if(arr[idx]==a){
                return true;
            }else{
                return false;
            }
        }
        boolean flag=false;

        if(arr[idx]==a){
            flag=true;
            return flag;
        }

        return linearSearch(arr, a, idx+1);
    }

    public static int findPower(int X, int N){
        if(N==0){
            return 1;
        }

        if(N==1){
            return X;
        }

        if(X==1){
            return 1;
        }

        return X * findPower(X, N-1);
    }

    public static void main(String[] args) {
        System.out.println(findFact(5));
        System.out.println(findGCD(366, 60));
        System.out.println(findProduct(50, 2));
        System.out.println(findBinaryEquivalent(7));
        System.out.println(findFibonacci(0, 1, 3, 5));
        String s="malam";
        System.out.println(isPalindrom(s, 0, s.length()-1));
        int arr[]={1, 2, 3, 4, 5, 6};
        System.out.println(linearSearch(arr, 4, 0));
        System.out.println(linearSearch(arr, 7, 0));
        System.out.println(linearSearch(arr, 1, 0));
        System.out.println(linearSearch(arr, 9, 0));
        System.out.println(findPower(2, 2));
        System.out.println(findPower(1, 2));
        System.out.println(findPower(2, 1));
        System.out.println(findPower(2, 0));
        System.out.println(findPower(4, 3));
    }
}
