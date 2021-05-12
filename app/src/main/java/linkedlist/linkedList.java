package linkedlist;

public class linkedList {

    public  Node head;
    public Node tail;


    //insert first
    public void insert(int d){
        Node node = new Node(d);
        if(head==null){
          head=node; //for the first time the head is node
          node.next=null;
        } else {
            node.next = head;
            head = node;
        }

    }

    public String toString() {
        String msg = " ";
        while (head != null) {
            msg = msg + "{" + head.data + "}" + " -> ";
            head = head.next;
        }
        msg = msg + "NULL";
        System.out.print(msg);
        return msg;
    }

    public void insertLast(int d){
        Node newNode = new Node(d);
        if (head==null){
            head=tail=newNode;
            newNode.next=null;
        } else {
            tail.next=newNode;
            tail=newNode;
        }

    }

    public void insertAfter(int oldValue,int newValue){
        Node current = head;
        while (current.data!=oldValue){
            current=current.next;
        }
        if (current.data==oldValue){
            Node node = new Node(newValue);
            node.next=current.next; // position on new node is in the node that current point to
            current.next=node;
        }
    }

    public void insertBefore (int oldValue,int newValue){
        Node current = head;
        while (current.next.data!=oldValue){
            current=current.next;
        }
        if (current.next.data==oldValue){
            Node node = new Node(newValue);
            node.next=current.next;
            current.next=node;

        }


    }

    public boolean Includes(int d) {

        Node current = this.head;


        while (current.next !=null){
            if (current.data==d){
                System.out.print("true");
                return true;

            }

            current=current.next;
        } System.out.print("false");

        return false;
    }

    public void removeFirst(){
       head=head.next;
    }
    public void removeLast(){
        Node current=head.next;
        Node prev =head;
        while (current!=tail){
            prev=current;
            current=current.next;
        }
        prev.next=null;
        tail=prev;
    }

    public void remove(int d) {
        if (head==null){ //empty
            return;
        }
        if (head.data==d){ //remove first element
            head=head.next;
        } else {
            Node current =head.next;
            Node prev = head;
            while (current!=null){ // to loop over all nodes
                if (current.data==d)
                    break;
                    prev=current;
                    current=current.next;

            }
            if (current==null){
                System.out.println("Not Found");
            } else {
                prev.next=current.next;
            } if (tail==current){
                tail=prev;
            }
        }
    }

    public void removeAll(){
        Node current=head;
        while (head!=null){
            current=head;
            head=head.next;
        }
    }

    public int seqSearch(int d) {
        Node current = head;
        int loc = 0;
        while (head != null) {
            current = current.next;
            loc++;
            if (current.data==d)
                return loc;

        }
        return -1;
    }
}
