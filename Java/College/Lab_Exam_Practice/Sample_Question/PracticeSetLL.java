package Java.College.Lab_Exam_Practice.Sample_Question;
import java.util.Scanner;

public class PracticeSetLL {

    Scanner sc=new Scanner(System.in);
    Single_list head;
    int size;

    class Single_list{
        public int marks;
        public char grade;
        public Single_list next;

        Single_list(int marks, char grade){
            this.marks=marks;
            this.grade=grade;
            next=null;
            size++;
        }
    }

    public void insFirst(){
        System.out.print("Enter the mark and grade: ");
        Single_list newNode=new Single_list(sc.nextInt(), sc.next().charAt(0));

        if(head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    void showData(){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }

        Single_list curr=head;
        System.out.println("Below are the marks: ");
        while(curr.next!=null){
            System.out.print(curr.marks + " -> ");
            curr=curr.next;
        }
        System.out.println(curr.marks);
        curr=head;
        System.out.println("Below are the grade: ");
        while(curr.next!=null){
            System.out.print(curr.grade + " -> ");
            curr=curr.next;
        }
        System.out.println(curr.grade);
    }

    void insLast(){
        System.out.print("Enter the mark and grade: ");
        Single_list newNode=new Single_list(sc.nextInt(), sc.next().charAt(0));
        if(head==null){
            head=newNode;
            return;
        }

        Single_list curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }

    void insAnyPos(){
        System.out.print("Enter the mark and grade: ");
        Single_list newNode=new Single_list(sc.nextInt(), sc.next().charAt(0));
        System.out.print("Enter the position: ");
        int pos=sc.nextInt();

        if(pos==1){
            insFirst();
            return;
        }

        Single_list curr=head;
        for(int i=2; i<pos; i++){
            curr=curr.next;
        }
        newNode.next=curr.next;
        curr.next=newNode;
    }

    void insByRedg(){
        System.out.print("Enter the mark and grade: ");
        Single_list newNode=new Single_list(sc.nextInt(), sc.next().charAt(0));
        System.out.print("Enter the mark number after to add: ");
        int tempMark=sc.nextInt();
        if(tempMark==head.marks){
            newNode.next=head.next;
            head.next=newNode;
            return;
        }

        Single_list curr=head;
        while(curr.marks!=tempMark){
            curr=curr.next;
        }
        newNode.next=curr.next;
        curr.next=newNode;
    }

    void delFirst(){
        if(head==null){
            System.out.println("Empty list.");
            return;
        }

        head=head.next;
        size--;
    }

    void delLast(){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }

        Single_list curr=head;
        while(curr.next.next!=null){
            curr=curr.next;
        }
        curr.next=null;
        size--;
    }

    boolean isMarkPresent(){
        System.out.print("Enter the mark to search: ");
        int tempMark=sc.nextInt();
        if(head==null){
            System.out.println("List is empty.");
            return false;
        }

        Single_list curr=head;
        while(curr!=null){
            if(curr.marks==tempMark){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        PracticeSetLL list=new PracticeSetLL();
        list.insFirst();
        list.insFirst();
        list.insFirst();
        list.insFirst();
        list.insFirst();
        list.showData();
        list.insLast();
        list.insAnyPos();
        list.showData();
        list.insByRedg();
        list.showData();
        System.out.println("Deleting first.....");
        list.delFirst();
        System.out.println("Deleting Last.....");
        list.delLast();
        list.showData();
        list.delLast();
        list.showData();
        System.out.println(list.isMarkPresent());
        System.out.println(list.isMarkPresent());
        System.out.println(list.size);
    }
}
