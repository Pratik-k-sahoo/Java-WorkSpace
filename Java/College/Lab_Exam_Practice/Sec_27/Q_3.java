package Java.College.Lab_Exam_Practice.Sec_27;
import java.util.Scanner;

class InvalidDimensionException extends Exception{
    public String toString(){
        return "InvalidDimensionException : Dimension cannot be negative.";
    }
}

class Rectangle {
    int length, width;

    int area(int l, int b) throws InvalidDimensionException{
        try{
            if(l<0 || b<0){
                throw new InvalidDimensionException();
            }
            this.length=l; 
            this.width=b;
            System.out.print("Area of rectangle is : ");
        }catch(InvalidDimensionException e){
            System.out.println(e);
        }
        
        
        return length*width;  
    }
}

public class Q_3 {

    public static void main(String[] args) throws InvalidDimensionException {
        Scanner sc=new Scanner(System.in);
        Rectangle r=new Rectangle();
        System.out.println(r.area(sc.nextInt(), sc.nextInt()));
    }
}
