import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add(new Random().nextInt(100));
        }
//        arr.add(87);
//        arr.add(55);
//        arr.add(41);
//        arr.add(57);
//        arr.add(78);
//        arr.add(6);
//        arr.add(1);
//        arr.add(5);
//        arr.add(0);
//        arr.add(4);
//        arr.add(2);
//        arr.add(75);
//        arr.add(15);

        arr.show();
        arr.sort(Comparator.comparingInt(o -> o));
        //ArrayUtility.sort(arr);
//        ArrayUtility.insertSort(arr);
//        ArrayUtility.selectSort(arr);
//        arr.show();
//        arr.add(6, 6);
//        arr.show();
//        arr.remove(7);
//        arr.show();

//        System.out.println(ArrayUtility.binarySearch(arr, 3));
//        System.out.println(ArrayUtility.linearSearch(arr, 3));
//        System.out.println(ArrayUtility.partition(arr, 0, arr.size() - 1, arr.get(arr.size() - 1)));
        ArrayUtility.quickSort(arr);
        arr.show();

    }
}
