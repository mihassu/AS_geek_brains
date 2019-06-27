
import java.lang.Object;
import java.util.Comparator;

public class MyArray<T> {

    private Integer[] data;
    private int size, capacity, q;

    public MyArray() {
        size = 0;
        capacity = 1000;
        data = new Integer[capacity];
    }

    void getQ(){
        System.out.println(q);
    }

    void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //вставка в конец массива
    void add(Integer element){
        if(size < capacity){
            data[size] = element;
            size++;
        }
        else {
            reallocate();
            data[size] = element;
            size++;
        }
    }

    void set(int index, Integer value){
        data[index] = value;
    }

    T get(int index){
        return null;
    }

    int size(){
        return size;
    }

    //вставка по индексу
    void add(int index, T element){
        //TODO
    }

    //перевыделение памяти можно увеличить вместимость
    //на константу либо в константное количество раз
    //подумайте как лучше
    private void reallocate(){
        capacity *= 2;
        Integer[] tmp = new Integer[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    //удаление последнего
    boolean remove(){
        size--;
        return false;
    }
    //удаление по индексу
    boolean remove(int index){
        //TODO
        return false;
    }

    T [] toArray(){
        //TODO
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return (T[]) tmp;
    }

    void sort(){
        int left = 0, right = size;
        qs(data, left, right-1);
    }

    private void qs(Integer[] data, int left, int right) {
        if(left < right){
            int i = left, j = right;
            int p = data[(i+j) / 2];
            do{
                while (data[i] < p) i++;
                while (data[j] > p) j--;
                if(i <= j){
                    Integer tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                    i++; j--;
                }
            }while (i <= j);
            qs(data, left, j);
            qs(data, i, right);
        }
    }

}
