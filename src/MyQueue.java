import java.util.Arrays;

public class MyQueue {
    private Object[] values = new Object[2];
    private int size = 0;

    public void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public void add(Object value) {
        rebalance();
        values[size] = value;
        size++;
    }

    public void clear() {
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return values[0];
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }

        Object firstElement = values[0];

        System.arraycopy(values, 1, values, 0, size - 1);
        size--;

        return firstElement;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.size());
    }
}

