package ArrayList;
import java.util.Arrays;

public class MyArrayList<T> {

    private Object[] values = new Object[10];

    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public void remove(int index){
        for(int i = index; i < size; i++){
            values[i] = values[i+1];
        }
    }

    public void clear(){
        values = new Object[10];
    }

    public int size(){
        return size;
    }

    public T get(int index) {
        if(index<size) {
            return (T) values[index];
        }
        else{
            return (T) "out of boundary";
        }
    }

    private void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList();
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd8");
        arrayList.add("asd9");
        arrayList.add("asd10");

        System.out.println("arrayList.get(10) = " + arrayList.get(10));
        System.out.println("arrayList.get(11) = " + arrayList.get(11));

        System.out.println("size: " + arrayList.size());

        arrayList.remove(8);
        System.out.println("arrayList.get(8) = " + arrayList.get(8));

        arrayList.clear();
        System.out.println("arrayList.get(9) = " + arrayList.get(9));
    }
}
