package Java.College.Assignment.Queue_7;
import java.util.Scanner;

public class llQueue {

    Scanner sc=new Scanner(System.in);
    
    class Node{
        Node front, rear, next;
        int info;

        Node(int info){
            this.info=info;
            next=null;
        }

        Node(Node front, Node rear){
            this.front=front;
            this.rear=rear;
        }
    }

    Node add(Node front, Node rear){
        Node newNode=new Node(sc.nextInt());
        if(rear==null){
            rear=front=newNode;
            return new Node(front, rear);
        }

        rear.next=newNode;
        rear=newNode;

        return new Node(front, rear);
    }

    void display(Node front, Node rear){
        if(rear==null && front==null){
            System.out.println("Queue is empty.");
            return;
        }

        Node curr=front;
        while(curr!=rear){
            System.out.print(curr.info + " -> ");
            curr=curr.next;
        }
        System.out.println(curr.info);
    }

    public static void main(String[] args) {
        Node front=null;
        Node rear=null;
        llQueue q=new llQueue();
        Node update=q.add(front, rear);
        rear=update.rear;
        front=update.front;

        update=q.add(front, rear);
        rear=update.rear;
        front=update.front;
        q.display(front, rear);
        update=q.add(front, rear);
        rear=update.rear;
        front=update.front;
        update=q.add(front, rear);
        rear=update.rear;
        front=update.front;
        update=q.add(front, rear);
        rear=update.rear;
        front=update.front;
        q.display(front, rear);
    }
}
