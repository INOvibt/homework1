import java.util.Arrays;

public class MyArrayList {
    private Object[] values = new Object[2];
    private int size = 0;

    public void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public void add(Object obj) {
        rebalance();
        values[size] = obj;
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

    public Object get(int index) {
        return (Object) values[index];
    }

    public static void main(String[] args) {
    MyArrayList arrayList = new MyArrayList();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");
        arrayList.add("fff");
        arrayList.add("ggg");

        System.out.println(arrayList.get(5));

        System.out.println(arrayList.size());

        arrayList.remove(5);
        System.out.println(arrayList.get(5));

        arrayList.clear();
        System.out.println(arrayList.size());

    }
}