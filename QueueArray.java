public class QueueArray {
   int size;
   int [] arr;
   int rear = -1;
   int front;



   QueueArray(int size){
       this.size = size;
       arr = new int[size];
   }

   public void enqueue(int data){
       if(isFull()){
           System.out.println("Array is full");
       }
       rear++;
       arr[rear] = data;
   }

   public void dequeue(){
       if(isEmpty()){
           System.out.println("queue is empty");
       }
       for (int i = 0 ; i < rear ; i ++){
           arr[i] = arr[i + 1];
       }
       rear -- ;
   }


   public boolean isFull(){
       return rear == size - 1;
   }

   public boolean isEmpty(){
       return front == -1;
   }

   void display(){
       for(int i = 0 ; i < arr.length ; i ++){
           System.out.print(arr[i]+" ");
       }
   }

   public int peek(){
       if(isEmpty()){
           return -1;
       }
       else{
           return arr[0];
       }
   }


    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(12);
        q.enqueue(56);
        q.enqueue(90);
        q.enqueue(78);
        q.enqueue(77);

        q.display();
        q.dequeue();
        System.out.println("queue after delete :");
        q.display();
        System.out.println();
        int pk = q.peek();
        System.out.println("top element of queue is :"+pk);





    }

}
