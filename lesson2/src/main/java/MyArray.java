public class MyArray<T> {

    private T [] data;
    private int size, capacity;

    //вставка в конец массива
    void add(T element){
        //TODO
    }

    int size(){
        //TODO
        return -1;
    }

    //вставка по индексу
    void add(int index, T element){
        //TODO
    }

    //перевыделение памяти можно увеличить вместимость
    //на константу либо в константное количество раз
    //подумайте как лучше
    void reallocate(){
        //TODO
    }

    //удаление последнего
    boolean remove(){
        //TODO
        return false;
    }
    //удаление по индексу
    boolean remove(int index){
        //TODO
        return false;
    }

    T [] toArray(){
        //TODO
        return null;
    }

    //возвращает индекс найденного элемента или -1 если
    //не найден
    int find(T element){
        return -1;
    }

    void bubbleSort(){
        //TODO
    }

    void insertSort(){
        //TODO
    }

    void selectSort(){
        //TODO
    }

    void quickSort(){
        //TODO
    }

}
