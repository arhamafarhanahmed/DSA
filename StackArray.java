public class StackArray {
    int size;
    int[] arr;
    int index = 0;

    StackArray(int size) {
        this.size = size;
        arr = new int[size];
    }

    //LIFO

    void push(int el) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        arr[index] = el;
        index++;
    }

    int search(int el){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == el){
                return i;

            }
        }

        return -1;
    }


    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        return arr[--index];
    }

    public String reverse() {
        String el = " ";

        while (!isEmpty()) {
            el += pop();
        }
        return el;

    }

    int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
        }
        return arr[0];
    }



    boolean isEmpty(){
      if(index == 0){
          return true;
      }
      return false;

    }


    boolean isFull(){
      if(index == size){
          return true;
      }
      return false;
    }


    void display(){
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void main(String[] args) {

        StackArray s = new StackArray(4);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
       s.display();
        System.out.println();
        String reversed = s.reverse();
        System.out.println("reverse elemenet"+reversed+"");

        int Searchelement = s.search(40);
        if(Searchelement!= -1){
            System.out.println("search element is :"+Searchelement);
        }
        else {
            System.out.println("not found");
        }

        int peek = s.peek();
        System.out.println(peek);


    }


}
