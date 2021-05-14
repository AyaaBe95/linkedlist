package stackAndQueue;

public class Stack {
    Node top;

    public Stack(){}



    public void push(int d){
        Node newNode = new Node(d);
        newNode.next=top;
        top=newNode;
    }

    public void pop(){
        Node current = top;
        top=top.next;
        current.next=null;
    }

    public int peek(){
        return top.data;
    }

    public boolean isEmpty(){

        return top == null;
    }



    public void display(){
        Node current;
        current=top;
        if (isEmpty()){
            System.out.println(" stack is empty");
        } else {
            while (current!=null){
                System.out.println(current.data);
                current=current.next;

            }
        }

    }
}
