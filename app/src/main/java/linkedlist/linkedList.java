package linkedlist;

import java.util.HashSet;

public class linkedList {

    public Node head;
    public Node tail;


    //insert first
    public void insert(int d) {
        Node node = new Node(d);
        if (head == null) {
            head = node; //for the first time the head is node
            node.next = null;
        } else {
            node.next = head; // newNode point to the head
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

    public void insertLast(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = tail = newNode;
            newNode.next = null;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void insertAfter(int oldValue, int newValue) {
        Node current = head;
        while (current.data != oldValue) {
            current = current.next;
        }
        if (current.data == oldValue) {
            Node node = new Node(newValue);
            node.next = current.next; // position on new node is in the node that current point to
            current.next = node;
        }
    }

    public void insertBefore(int oldValue, int newValue) {
        Node current = head;
        while (current.next.data != oldValue) {
            current = current.next;
        }
        if (current.next.data == oldValue) {
            Node node = new Node(newValue);
            node.next = current.next;
            current.next = node;

        }


    }

    public boolean Includes(int d) {

        Node current = this.head;


        while (current.next != null) {
            if (current.data == d) {
                System.out.print("true");
                return true;

            }

            current = current.next;
        }
        System.out.print("false");

        return false;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node current = head.next;
        Node prev = head;
        while (current != tail) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
    }

    public void remove(int d) {
        if (head == null) { //empty
            return;
        }
        if (head.data == d) { //remove first element
            head = head.next;
        } else {
            Node current = head.next;
            Node prev = head;
            while (current != null) { // to loop over all nodes
                if (current.data == d)
                    break;
                prev = current;
                current = current.next;

            }
            if (current == null) {
                System.out.println("Not Found");
            } else {
                prev.next = current.next;
            }
            if (tail == current) {
                tail = prev;
            }
        }
    }

    public void removeAll() {
        Node current = head;
        while (head != null) {
            current = head;
            head = head.next;
        }
    }

    public int seqSearch(int d) {
        Node current = head;
        int loc = 0;
        while (head != null) {
            current = current.next;
            loc++;
            if (current.data == d)
                return loc;

        }
        return -1;
    }

    public void removeDupilcate() {
        HashSet<Integer> values = new HashSet();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int temp = current.data; //to save current data
            if (values.contains(temp)) {
                prev.next = current.next; // remove the relation
            } else {
                values.add(temp);
                prev = current; //move prev to current
            }
            current = current.next; //current point to the next node
        }
    }

    public void swapElements() {
        Node current = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (current != null && current.next != null) {

            /* Swap the data */
            int k = current.data;
            current.data = current.next.data;
            current.next.data = k;
            current = current.next.next;
        }

    }

    public void swapNodes(){
        Node current = head;
        while (current != null && current.next != null) {
            Node nCurrent=current.next;
            Node temp = nCurrent.next;
            nCurrent.next=current;
            current.next=temp.next;
            current=temp;
        }

        }

        public void removeDup(){
        Node current = head;
        Node nextNode;
        while (current!=null&&current.next!=null){
            if (current.data==current.next.data){
                nextNode=current.next.next; // save the value
                current.next=nextNode; //current point to saved value

            }
            current=current.next;
        }
        }

    public Node getHead() {
        return head;
    }

    public Node mergeSorted(linkedList q, linkedList p){
        Node current=null;
        Node newnode=;

        Node n1=q.getHead();
        Node n2=p.getHead();

        if (n1==null){
            return n2; }
        if (n2==null){
            return n1; }
        //
        if (n1!=null&&n2!=null) {

            if (n1.data <= n2.data) {
                current = n1;
                n1 = current.next;
            } else {
                current = n2;
                n2 = current.next;
            }
        }
        newnode=current;

        while (n1!= null && n2!=null){
            if (n1.data<=n2.data){
                current.next=n1;
                current=n1;
                n1=current.next;
            } else {
                current.next=n2;
                current=n2;
                n2=current.next;

            }
        }
            if (n1==null) current.next=n2;
            if (n2==null) current.next=n1;

            return newnode;


        }

        public int findKth(int n){
        Node current=head;
        Node end=head;
        int ctr=1;
        while (ctr<=n-1){
            end=end.next;
            ctr=ctr+1;
        }
        while (end.next!=null){
            end=end.next;
            current=current.next;
        }
        return current.data;
        }

    public void removeKth(int n){
        Node current=head;
        Node end=head;
       for (int i = 0; i<n; i++){
           current=current.next;
       }

       while (current.next!=null){
           current=current.next;
           end=end.next;
       }
       end.next=end.next.next;
    }

    public void removeD(int d){

        if(head==null){
            return;
        }
        if (head.data==d){
            head=head.next;
        } else {
            Node current = head.next;
            Node prev = head;
            while (current.data!=d){
                current=current.next;
                prev=prev.next;
                }
            if (current.next==null){
                prev.next=null;
            } else {
                prev.next=current.next;
            }

        }

    }

    public void reverse(){
        Node current=head;
        Node prev=null;
        Node nextNode=head;
        while (nextNode!=null){
            nextNode=nextNode.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }
       head=prev;
    }
}

