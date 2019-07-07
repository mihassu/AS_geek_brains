
import java.lang.Object;
import java.util.Comparator;

public class MyArray<T> {

    private Object[] data;
    private int size, capacity, q;

    public MyArray() {
        size = 0; //количество находящихся в массиве элементов
        capacity = 1000;
        data = new Object[capacity];
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
    void add(T element){
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

    void set(int index, T value){
        data[index] = value;
    }

    T get(int index){
        return (T)data[index];
    }

    int size(){
        return size;
    }

    //вставка по индексу
    void add(int index, T element){
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    //перевыделение памяти можно увеличить вместимость
    //на константу либо в константное количество раз
    //подумайте как лучше
    private void reallocate(){
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    //удаление последнего
    boolean remove(){
        size--;
        if (size < 0) {
            size = 0;
        }
        return false;
    }
    //удаление по индексу
    boolean remove(int index){

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size < 0) {
            size = 0;
        }
        return false;
    }

    T [] toArray(){
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return (T[]) tmp;
    }

//    void sort(Comparator<T> c){
//        //int q = 0;
//        for (int i = 0; i < size; i++) {
//            //int swaps = 0;
//            for (int j = 0; j < size-i-1; j++) {
//                if(c.compare((T)data[j], (T)data[j+1]) > 0){
//                    //swaps++;
//                    Object tmp = data[j+1];
//                    data[j+1] = data[j];
//                    data[j] = tmp;
//                } else continue;
//                //q++;
//            }
//            //if(swaps == 0) break;
//        }
//    }

    void sort(Comparator<T> c) {
        Object temp;
        int len = size - 1;

        while (len > 0) {
            for (int i = 1; i <= len; i++) {
                if (c.compare((T)data[i - 1], (T)data[i]) > 0) {
                    temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                } else continue;

            }
            len--;
        }
    }

}
