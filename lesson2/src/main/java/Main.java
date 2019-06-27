import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 100; i++) {
            arr.add(new Random().nextInt(1000));
        }
        arr.show();
        //Arrays.sort();
        //arr.sort(Comparator.comparingInt(o -> o));
        arr.show();
    }
}
