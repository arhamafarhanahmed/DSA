
class DoubleEndedQueueArray {


    int size;
    int[] arr;
    int rear = -1;
    int front;


    DoubleEndedQueueArray(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void Addrear(int data) {
        if (isFull()) {
            System.out.println("Array is full");
        }
        rear++;
        arr[rear] = data;
    }


    public void addFront(int data) {
        if (isFull()) {
            System.out.println("Array is full");
            return;
        }
        // Shift elements to the right to make space at index 0
        for (int i = rear; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = data;
        rear++;
    }


    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("queue is empty");
        }
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        rear--;
    }


    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        DoubleEndedQueueArray q = new DoubleEndedQueueArray(4);
        q.addFront(2);
        q.Addrear(3);
        q.addFront(4);
        q.addFront(5);
        q.display();
        System.out.println();
        q.deleteFront();
        q.display();
    }
}

