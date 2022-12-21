import javax.sql.rowset.serial.SerialArray;

class OrdArray {
    private long[] data;
    private int numElems;

    public OrdArray(int size) {
        data = new long[size];
        numElems = 0;
    }

    public int size() {
        return numElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = numElems - 1;
        int mid;

        while (true) {
            mid = (lowerBound + upperBound) / 2;
            if (data[mid] == searchKey) {
                return mid;
            } else if (lowerBound > upperBound) {
                return numElems;
            } else if (data[mid] < searchKey) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < numElems; j++) {
            if (data[j] > value) break;
        }
        for (int k = numElems; k > j; k--) {
            data[k] = data[k - 1];
        }
        data[j] = value;
        numElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == numElems) {
            return false;
        } else {
            for (int k = j; k < numElems - 1; k++) {
                data[k] = data[k + 1];
            }
            numElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < numElems; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

public class OrdArrayApp {  
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray ordArray;
        ordArray = new OrdArray(maxSize);

        ordArray.insert(77);
        ordArray.insert(99);
        ordArray.insert(44);
        ordArray.insert(55);
        ordArray.insert(22);
        ordArray.insert(88);
        ordArray.insert(11);
        ordArray.insert(00);
        ordArray.insert(66);
        ordArray.insert(33);

        int serchKey = 55;
        if (ordArray.find(serchKey) != ordArray.size()) {
            System.out.println("Found " + serchKey);
        } else {
            System.out.println("Can't find " + serchKey);
        }

        ordArray.display();

        ordArray.delete(00);
        ordArray.delete(55);
        ordArray.delete(99);

        ordArray.display();
    }
}
