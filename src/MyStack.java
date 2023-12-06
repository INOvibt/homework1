import java.util.Arrays;

public class MyStack {
    private Object[] values = new Object[2];
    private int size = 0;

    public void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public void push(Object value) {
        rebalance();
        values[size] = value;
        size++;
    }

    public void remove(int index){
        Object[] newArr = new Object[size - 1];

        System.arraycopy(values, 0, newArr, 0, index);
        System.arraycopy(values, index + 1, newArr, index, size - index - 1);
        size--;
        values = Arrays.copyOf(newArr, size);
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
        return values[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }

        Object firstElement = values[--size];
        values[size] = null;
        return firstElement;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");
        stack.push("eee");
        System.out.println(stack.size());

        stack.remove(3);
        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.clear();
        System.out.println(stack.size());
    }
}
