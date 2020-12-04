import java.util.*;

class CharStack {
    private char[] stackArray;
    private int size;
    private int top;

    public CharStack(int size) {
        this.size = size;
        stackArray = new char[size];
        top = -1;
    }

    public void push(char ch) {
        if (top == size - 1) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        } else {
            stackArray[++top] = ch;
        }
    }

    public char pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        } else {
            return stackArray[top--];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class StringReverser {
    private String input;
    private String output;

    public StringReverser(String s) {
        input = s;
        output = "";
    }

    public String reverse() {
        int size = input.length();
        CharStack cs = new CharStack(size);

        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);
            cs.push(ch);
        }

        while (!cs.isEmpty()) {
            char ch = cs.pop();
            output += ch;
        }

        return output;
    }
}

public class ReverseApp {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        input = in.nextLine();
        StringReverser sr = new StringReverser(input);
        System.out.println("Reversed string: " + sr.reverse());
    }
}
