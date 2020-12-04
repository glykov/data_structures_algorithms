class Deque {
    private final int MAX_SIZE = 100;
    private int[] dequeArray;
    private int front;
    private int rear;
    int size;

    // constructor
    public Deque(int size) {
        dequeArray = new int[MAX_SIZE];
        front = -1;
        rear = 0;
        this.size = size;
    }

    // check if deque is full
    public boolean isFull() {
        return ((front == 0 && rear == -1) || front == rear + 1);
    }

    // check if deque is empty
    public boolean isEmpty() {
        return (front == -1);
    }

    // insert at front
    public void insertFront(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque is full");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }

        dequeArray[front] = item;
    }

    // insert at back
    public void insertRear(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque is full");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == -1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }

        dequeArray[rear] = item;
    }

    // remove from front
    public int removeFront() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        int temp = dequeArray[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }

        return temp;
    }

    // remove from back
    public int removeRear() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        int temp = dequeArray[rear];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }

        return temp;
    }
}

public class DequeApp {
    public static void main(String[] args) {
        Deque dq = new Deque(5);

        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : " + dq.removeRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);

        System.out.println("get front element: " + dq.removeFront());
    }
}
