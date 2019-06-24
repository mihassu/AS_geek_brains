import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    protected Duration timeout = Duration.ofSeconds(4);

    @Test
    void timeTestAdd(){
        Random rnd = new Random();
        assertTimeoutPreemptively(timeout, ()->{
            MyArray<Integer> array = new MyArray<>();
            for (int i = 0; i < 1000000; i++) {
                array.add(rnd.nextInt());
            }
        });
    }

    @Test
    void utilTest(){
        int [] data = new int[]{1,2,3,4,5,6,7,8,9,10};
        MyArray<Integer> arr = new MyArray<>();
        for(int i : data) arr.add(i);
        arr.remove();
        assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}
        , arr.toArray());
        arr.remove(2);
        assertArrayEquals(new Integer[]{1,2,4,5,6,7,8,9}
                , arr.toArray());
        assertEquals(-1, arr.find(20));
        assertEquals(2, arr.find(4));
        arr.add(0, 100);
        assertArrayEquals(new Integer[]{100, 1,2,4,5,6,7,8,9}
                , arr.toArray());
        arr.add(3, 100);
        assertArrayEquals(new Integer[]{100,1,2,100,4,5,6,7,8,9}
                , arr.toArray());
        for (int i = 0; i < 100; i++) {
            arr.remove();
        }
        assertEquals(0, arr.size());
        for (int i = 0; i < 10; i++) {
            arr.add(0, i);
        }
        assertArrayEquals(new Integer[]{9,8,7,6,5,4,3,2,1,0}
                , arr.toArray());
    }

    @Test
    void sortTests(){
        File in = new File("C:\\Users\\Mikhail\\Downloads\\lesson1\\lesson2\\src\\main\\resources\\sort.txt"),
                out = new File("C:\\Users\\Mikhail\\Downloads\\lesson1\\lesson2\\src\\main\\resources\\sort.ans");
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner ans = new Scanner(out);
            while (ans.hasNext()) list.add(ans.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(list.subList(0, 10));
        MyArray<Integer> array = new MyArray<>();
        assertTimeoutPreemptively(timeout, ()->{
            Scanner input = new Scanner(in);
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                array.add(input.nextInt());
            }
            array.quickSort();
        });
        assertArrayEquals(list.toArray(), array.toArray());

    }

}
