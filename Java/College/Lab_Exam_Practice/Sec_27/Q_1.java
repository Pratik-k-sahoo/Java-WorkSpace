package Java.College.Lab_Exam_Practice.Sec_27;
import java.util.Scanner;

class Employee{
    int empId;
    String name;
    double salary;

    void getData(int empId, String name, double salary){
        this.empId=empId;
        this.name=name;
        this.salary=salary;
    }

    void showData(){
        System.out.println("Employee-ID : " + this.empId + 
                           "\nName : " + this.name + 
                           "\nSalary : " + this.salary);
    }
}

public class Q_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Employee emp[]=new Employee[10];

        for(int i=0; i<10; i++){
            emp[i]=new Employee();
            System.out.print("Enter details for Employee " + (i+1) + " : ");
            emp[i].getData(sc.nextInt(), sc.next(), sc.nextDouble());
        }

        for(int i=0; i<10; i++){
            System.out.println("Below is the detail of Employee " + (i+1) + " :");
            emp[i].showData();
        }
    }
}
