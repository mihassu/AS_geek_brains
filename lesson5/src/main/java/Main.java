import javafx.util.Pair;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        RFunctions functions = new RFunctions();

        //Фибоначчи
        BigInteger fib = functions.fib(8);
        System.out.println("fib(8): " + fib.toString());

        //Факториал
        BigInteger fac = functions.factor(7);
        System.out.println("fac(7): " + fac.toString());

//        //числа в обратном порядке
//        functions.reverse(new Scanner(System.in), new PrintWriter(System.out, true));

//        //Список пополам
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(15);
        list.add(8);
        list.add(9);
        list.add(3);
        list.add(0);

//        System.out.println("list:" + list);
//        Pair<ArrayList<Integer>, ArrayList<Integer>> pair = functions.split(list);
//        System.out.print("split(list) 1: ");
//        System.out.println(pair.getKey());
//        System.out.print("split(list) 2: ");
//        System.out.println(pair.getValue());
//
//        //Вернуть отсортированный список, сливаемый из двух отсортированных
//        ArrayList<Integer> sortList1 = new ArrayList<>();
//        sortList1.add(1);
//        sortList1.add(3);
//        sortList1.add(7);
//        sortList1.add(10);
//        sortList1.add(12);
//        ArrayList<Integer> sortList2 = new ArrayList<>();
//        sortList2.add(0);
//        sortList2.add(4);
//        sortList2.add(6);
//        sortList2.add(9);
//        sortList2.add(15);
//        System.out.println(functions.merge(sortList1, sortList2));

        //Сортировка слиянием
        System.out.println("Массив: " + list);
        System.out.print("Сортировка слиянием: ");
        System.out.println(functions.mergeSort(list));

        //максимальное число не превышающее лимит
        int[] data = {5, 2, 1, 7, 4, 8, 3};
        System.out.println("max: " + functions.knackPack(data, 3));


    }


//    BigInteger fib(int n){
//        return null;
//    }
//
//    BigInteger factor(int n){
//        return null;
//    }
//
//    void reverse(Scanner in, PrintWriter out){
//
//    }
//
//    void mergeSort(ArrayList<Integer> list){
//
//    }
//
//    Pair<ArrayList<Integer>, ArrayList<Integer>> split(ArrayList<Integer> list){
//
//        return null;
//    }
//
//    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
//
//        return null;
//    }
//
//    void permutation(int [] data, int n, int k, int index){
//
//    }
//
//    long knackPack(int [] data, long limit, long  start, int index, ArrayList<Integer> list){
//        return 0;
//    }
}
