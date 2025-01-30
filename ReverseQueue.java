public class ReverseQueue {
    class Node {
          int data;
          Node next;

          Node(int data){
              this.data = data ;
              this.next = null;
          }

    }

    // enqueue means to add the element in list by using FIFI method

    Node head, tail;


    void enqueue(int data){
        Node newnode = new Node(data);

        if(head == null){
            head = tail = newnode;
        }else {
            tail.next = newnode;
            tail = newnode;

        }
    }

    void reverse(int n){
        Node next;
        Node front = head;
        Node prev = null;
        int count = 0;

        while(front != null && count < n ){
            next = front.next;
            front.next = prev;
            prev = front;
            front = next;
            count++;
        }
        if(head != null){
            head.next = front;
        }
        head = prev;

    }

    void display(){
        Node current = head;

        while(current != null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println();
    }

// dequeue to remove a element from first

    void dequeue(){
        head = head.next;
    }

    public int  getMinimun() {
        int min = head.data;
        Node current = head;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }









    public static void main(String[] args) {
        ReverseQueue kew = new ReverseQueue();
        kew.enqueue(10);
        kew.enqueue(20);
        kew.enqueue(30);
        kew.enqueue(40);
        kew.enqueue(50);
        System.out.println("original queue :");
        kew.display();
        System.out.println("queue after reverse :");
        kew.reverse(3);
        kew.display();
        kew.dequeue();
        System.out.println("queue after delete :");
        kew.display();
       int min = kew.getMinimun();
        System.out.println("min value is "+min);
    }
}
