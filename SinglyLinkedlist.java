public class SinglyLinkedlist {
    class node{
        node next;
        int data;
        node prev;

        node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    node head,tail;


    void addNodeAtbegining(int data){
        node newnode = new node(data);
        newnode.next = head;
        head = newnode;
    }

    void addNodeAtlast(int data){
        node newnode = new node(data);

        if(head == null){
            head = tail = newnode;
        }

        tail.next  = newnode;
        tail = newnode;

    }

    void insertAtspecificPosition(int position,int data){
        node newnode = new node(data);
        node current = head;
               int count = 0;
                   while(current != null && count < position - 1){
                       current = current.next;
                       count++;
                  }
                   newnode.next = current.next;
                   current.next = newnode;
    }




    void deletenodeAtbegining(){
        if(head == null){
            return;
        }
            head = head.next;
    }

    void deletenodeAtspecificposition(int position){

        node current = head;
        int count = 0;
        while(current != null && count < position - 1){
            current = current.next;
            count++;
        }
        current.next = current.next.next;


    }

    void deletenodeAtlast(){
        if(head == null){
            System.out.println("list  has no space ");
        }
        node current = head;

        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;


    }


    void displayLinkedlist(){
        node current = head;
        while(current !=  null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedlist l = new SinglyLinkedlist();
        l.addNodeAtlast(20);
        l.addNodeAtlast(30);
        l.addNodeAtlast(40);
        l.addNodeAtlast(50);
        System.out.println("all insertion has been added by the end of linkedlist :");
        l.displayLinkedlist();
        l.addNodeAtbegining(60);
        l.addNodeAtbegining(70);
        System.out.println("all insertion has been added by the begining of linkedlist :");
        l.displayLinkedlist();
        l.insertAtspecificPosition(5,55);
        l.displayLinkedlist();
        l.deletenodeAtbegining();
        System.out.println("delete at begining :");
        l.displayLinkedlist();
        l.deletenodeAtspecificposition(5);
        System.out.println("delete At specific position :");
        l.displayLinkedlist();
        l.deletenodeAtlast();
        System.out.println("node delete at last :");
        l.displayLinkedlist();



    }




}
