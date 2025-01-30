class DoubleEndedQueue{
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;

        }


    }



    Node front, rear;
    void AddREAR(int data){
        Node newnode = new Node(data);

        if( front == null){
            front = rear = newnode;
        }else {
            rear.next = newnode;
            rear = newnode;

        }
    }

    void addFront(int data){
        Node newnode = new Node(data);

        newnode.next = front;
        front = newnode;
    }

    void DelFront(){
        front = front.next;
    }


    void DelRear(){
        Node current = front;

        while(current.next.next != null){
            current = current.next;
        }

        current.next = null;
    }
    void display(){
        Node current = front;

        while(current != null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleEndedQueue q = new DoubleEndedQueue();
       q.addFront(2);
       q.addFront(3);
       q.addFront(4);
       q.addFront(5);
       q.display();
        System.out.println();
       q.DelFront();
       q.DelRear();
       q.display();

    }

}

