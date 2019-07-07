import java.util.Comparator;

public class ArrayUtility<T> {

    private MyArray<T> myArray;

    static <T extends Comparable<? super T>>
    void sort(MyArray<T> array) {
        int q = 0;
        for (int i = 0; i < array.size(); i++) {
            int swaps = 0;
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    swaps++;
                    T tmp = array.get(j + 1);
                    array.set(j + 1, array.get(j));
                    array.set(j, tmp);
                }
                q++;
            }
            if (swaps == 0) break;
        }
    }


    static <T extends Comparable<? super T>>
    void insertSort(MyArray<T> array) {
        T temp;
        int size = array.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (array.get(j - 1).compareTo(array.get(j)) > 0) {
                    temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                } else break;
            }
        }
    }

    static <T extends Comparable<? super T>>
    void selectSort(MyArray<T> array) {
        int len = array.size();
        int min;
        T temp;

        for (int i = 0; i < len - 2; i++) {
            min = i;

            for (int j = i + 1; j < len; j++) {
                if (array.get(min).compareTo(array.get(j)) > 0) {
                    min = j;
                }
            }

            if (array.get(i).compareTo(array.get(min)) > 0) {
                temp = array.get(i);
                array.set(i, array.get(min));
                array.set(min, temp);
            }
        }
    }

    static <T extends Comparable<? super T>>
    void quickSort(MyArray<T> array) {

        recQuickSort(array, 0, array.size() - 1);
    }

    static <T extends Comparable<? super T>>
    void recQuickSort(MyArray<T> array, int left, int right) {
        if (right - left <= 0) {
            return;

        } else {
            T someValue = array.get(right);
            int partition = partition(array, left, right, someValue);
            recQuickSort(array, left, partition - 1);
            recQuickSort(array, partition + 1, right);
        }

    }

    static <T extends Comparable<? super T>>
    int partition(MyArray<T> array, int left, int right, T someValue) {
        int leftVal = left - 1;
        int rightVal = right;
        T temp;

        while (true) {
            while (leftVal < right && array.get(++leftVal).compareTo(someValue) < 0) ;

            while (rightVal > 0 && array.get(--rightVal).compareTo(someValue) > 0) ;

            if (leftVal >= rightVal) {
                break;

            } else {
                temp = array.get(leftVal);
                array.set(leftVal, array.get(rightVal));
                array.set(rightVal, temp);
            }
        }

        return leftVal;
    }

    static <T extends Comparable<? super T>>
    int binarySearch(MyArray<T> array, T value) {

        int size = array.size();
        int topBound = size - 1;
        int lowBound = 0;
        int mid = -1;

        while (true) {
            mid = (lowBound + topBound) / 2;
            if (array.get(mid).compareTo(value) == 0) {
                break;

            } else if (lowBound > topBound) {
                return -1;

            } else {

                if (array.get(mid).compareTo(value) < 0) {

                    lowBound = mid + 1;

                } else {
                    topBound = mid - 1;

                }
            }
        }

        return mid;
    }

    static <T extends Comparable<? super T>>
    int linearSearch(MyArray<T> array, T value) {

        int size = array.size();
        int position = -1;

        for (int i = 0; i < size; i++) {
            if (array.get(i).compareTo(value) == 0) {
                position = i;
                break;
            }
        }
        return position;
    }
}
