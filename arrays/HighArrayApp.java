class HighArray {
    private long[] arr;
    private int numElems;

    public HighArray(int size) {
        arr = new long[size];
        numElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < numElems; j++) {
            if (arr[j] == searchKey) break;
        }
        if (j == numElems) {
            return false;
        }
        return true;
    }

    public void insert(long value) {
        arr[numElems] = value;
        numElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < numElems; j++) {
            if (arr[j] == value) break;
        }
        if (j == numElems) {
            return false;
        }
        for (int k = j; k < numElems - 1; k++) {
            arr[k] = arr[k + 1];
        }
        numElems--;
        return true;
    }

    public void display() {
        for (int i = 0; i < numElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class HighArrayApp {
    public static void main(String[] args) {
        int arrSize = 10;
        HighArray harr;
        harr = new HighArray(arrSize);

        harr.insert(77);
        harr.insert(99);
        harr.insert(44);
        harr.insert(55);
        harr.insert(22);
        harr.insert(88);
        harr.insert(11);
        harr.insert(00);
        harr.insert(66);
        harr.insert(33);

        harr.display();

        int searchKey = 35;
        if (harr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        harr.delete(00);
        harr.delete(55);
        harr.delete(99);

        harr.display();
    }
}
