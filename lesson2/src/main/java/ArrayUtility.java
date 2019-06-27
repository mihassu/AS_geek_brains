public class ArrayUtility {

//    static <T extends Comparable<? super T>>
//    void sort(MyArray<T> array){
//        int q = 0;
//        for (int i = 0; i < array.size(); i++) {
//            int swaps = 0;
//            for (int j = 0; j < array.size()-i-1; j++) {
//                if(array.get(j).compareTo(array.get(j+1)) > 0){
//                    swaps++;
//                    T tmp = array.get(j+1);
//                    array.set(j+1, array.get(j));
//                    array.set(j, tmp);
//                }
//                q++;
//            }
//            if(swaps == 0) break;
//        }
//    }

    static <T extends Comparable<? super T>>
    void insertSort(MyArray<T> array){
        //TODO
    }

    static <T extends Comparable<? super T>>
    void selectSort(MyArray<T> array){
        //TODO
    }

    static <T extends Comparable<? super T>>
    void quickSort(MyArray<T> array){
        //TODO
    }

    static <T extends Comparable<? super T>>
    int binarySearch(MyArray<T> array, T value){
        //TODO
        return -1;
    }

    static <T extends Comparable<? super T>>
    int linearSearch(MyArray<T> array, T value){
        //TODO
        return -1;
    }
}
