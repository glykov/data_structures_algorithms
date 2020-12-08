import lesson4.MyLinkedList;

/*
* Реалзовать класс стек используя MyLinkedList
*/
public class MyListStack<T> {
    private MyLinkedList<T> stackList = new MyLinkedList<>();

    public void push(T item) {
        stackList.insertFirst(item);
    }

    public T pop() {
        return stackList.removeFirst();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}
