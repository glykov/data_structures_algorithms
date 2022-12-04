class LowArray {
    private long[] arr;

    public LowArray(int size) {
        arr = new long[size];
    }

    public void setElement(int index, long value) {
        arr[index] = value;
    }

    public long getElement(int index) {
        return arr[index];
    }
}

public class LowArrayApp {
    public static void main(String[] args) {
        LowArray larr;
        larr = new LowArray(100);
        int numElems = 0;
        int i;

        larr.setElement(0, 77);
        larr.setElement(1, 99);
        larr.setElement(2, 44);
        larr.setElement(3, 55);
        larr.setElement(4, 22);
        larr.setElement(5, 88);
        larr.setElement(6, 11);
        larr.setElement(7, 00);
        larr.setElement(8, 66);
        larr.setElement(9, 33);
        numElems = 10;

        for (i = 0; i < numElems; i++) {
            System.out.println(larr.getElement(i));
        }
        System.out.println();

        // searching for element
        int searchKey = 26;
        for (i = 0; i < numElems; i++) {
            if (searchKey == larr.getElement(i)) break;
        }
        if (i == numElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        // removing element
        for (i = 0; i < numElems; i++) {
            if (larr.getElement(i) == 55) break;
        }
        for (int j = i; j < numElems - 1; j++) {
            larr.setElement(j, larr.getElement(j + 1));
        }
        numElems--;

        for (i = 0; i < numElems; i++) {
            System.out.println(larr.getElement(i));
        }
        System.out.println();
    }    
}
