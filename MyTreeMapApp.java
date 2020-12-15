import java.util.NoSuchElementException;
import java.util.Random;

class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    /**
     * функции для проверки сбалансирванности дерева
     */

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        int leftHeight;
        int rightHeight;

        if (node == null) {
            return true;
        }

        leftHeight = height(node.left);
        rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            // delete
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + " " + toString(node.right);
    }
}


/*
*1. Создать и запустить программу для построения двоичного дерева. 
* В цикле построить двадцать деревьев с глубиной в 6 уровней. 
* Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. 
* Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
*2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
*
* Не могу понять, где у меня ошибка, у меня все время получается 0% сбалансированных деревьев 
*/
public class MyTreeMapApp {
    private static Random rand = new Random();

    public static MyTreeMap makeTree(int height) {
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        while (map.height() < height) {
            int key = rand.nextInt(200) - 100;
            int value = rand.nextInt();
            map.put(key, value);
        }
        return map;
    }

    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> map;
        int totalMaps = 20;
        int balancedMaps = 0;
        for (int i = 0; i < totalMaps; i++) {
            map = makeTree(6);
            // System.out.println(map);
            // System.out.println("Balanced: " + map.isBalanced());
            if (map.isBalanced()) {
                balancedMaps++;
            }
        }
        System.out.printf("Percentage of balanced maps generated: %.2f\n", (double) balancedMaps / totalMaps * 100);
    }
}
