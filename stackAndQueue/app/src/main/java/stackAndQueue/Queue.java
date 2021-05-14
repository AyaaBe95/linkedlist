package stackAndQueue;

public class Queue {
    Node rear;
    Node front;



    public void enqueue(int d){
        Node  node = new Node(d);
        if (front==null){
            front=node;
            rear=front;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public void dequeue(){
        Node current = front;
        front=front.next;
        current.next=null;
    }

    public int peek(){
        return front.data;
    }
}
