package Java.College.Assignment.Queue_7;
import java.util.Scanner;

public class LinkedListImplementation {

    Scanner sc=new Scanner(System.in);
    
    class Node{
        Node next;
        int info;
        int size;

        Node(int info){
            this.info=info;
            next=null;
            size++;
        }
    }


    Node front=null;
    Node rear=null;

    boolean isEmpty(){
        return front==null && rear==null;
    }

    void add(int info){
        Node newNode=new Node(info);
        if(rear==null){
            rear=front=newNode;
            return;
        }

        rear.next=newNode;
        rear=newNode;

    }

    void delete(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }

        if(front==rear){
            rear=null;
        }
        front=front.next;
    }

    void display(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }

        Node currNode=front;
        while(currNode!=rear){
            System.out.print(currNode.info + " -> ");
            currNode=currNode.next;
        }
        System.out.println(currNode.info);
    }
    

    public static void main(String[] args) {
        LinkedListImplementation e=new LinkedListImplementation();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(4);
        e.add(5);
        e.display();
        e.delete();
        e.display();
        LinkedListImplementation q=new LinkedListImplementation();
        q.add(9);
        q.add(10);
        q.add(11);
        q.add(12);
        q.display();
    }

    
}
