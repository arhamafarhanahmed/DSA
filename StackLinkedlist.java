public class StackLinkedlist {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        //LIFO
        Node head , tail;
        void push(int data){
            Node newnode = new Node(data);
            newnode.next = head;
            head = newnode;

        }

        void pop(){
            head = head.next;
        }

        int peek(){
            return head.data;
        }


        void reverse(){



            Node prev = null;
            Node next = null;
            Node current = head;
            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }


            head = prev;


        }

        void display(){
            Node current = head;
            while(current != null){
                System.out.print(current.data+"->");
                current = current.next;
            }
            System.out.println("null");
        }



    public static void main(String[] args) {
        StackLinkedlist l = new StackLinkedlist();
        l.push(10);
        l.push(20);
        l.push(30);
        l.push(40);
        l.push(50);
        l.display();
        l.reverse();
        l.display();
        l.pop();
        l.display();
        System.out.println(l.peek());






    }

    }


