package Java.College.Assignment.Queue_7;

public class ArrayImplementation {
    
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;

        Queue(int size){
            this.size=size;
            arr=new int[size];
        }
    
        static boolean isEmpty(){
            return rear==-1;
        }

        static boolean isFull(){
            return rear==size-1;
        }

        static void add(int data){
            if(isFull()){
                System.out.println("Queue is full.");
                return;
            }

            rear++;
            arr[rear]=data;
        }

        static void delete(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }

            for(int i=0; i<rear; i++){
                arr[i]=arr[i+1];
            }
            rear--;
        }
        
        static void display(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }

            for(int i=0; i<=rear; i++){
                System.out.print(arr[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.display();
        q.delete();
        System.out.println();
        q.display();
    }
}
