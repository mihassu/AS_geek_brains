import javafx.util.Pair;

import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RFunctions {

    private BigInteger[] memo = new BigInteger[1000];
    private List<Integer> stackArr = new LinkedList<>();


    //функция должна находить число Фибоначчи с номер н
    BigInteger fib(int n) {

        if (n == 1) {
            return new BigInteger("0");
        }
        if (n == 2) {
            return new BigInteger("1");
        }

        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = fib(n - 1).add(fib(n - 2));
        return memo[n];
    }

    //функция должна считать факториал числа
    BigInteger factor(int n) {

        BigInteger result;
        BigInteger nBig = new BigInteger(n + "");

        if (n == 1) {
            return new BigInteger("1");
        }
        result = nBig.multiply(factor(n - 1));

        return result;
    }

    //функция должна вводить числа из in до тех пор пока не будет введен 0
    //и вывести в out все числа в обратном порядке без 0
    void reverse(Scanner in, PrintWriter out) {
        int n;
        n = in.nextInt();
        if (n == 0) {
            out.println(stackArr.toString());
            return;
        }
        ((LinkedList<Integer>) stackArr).addFirst(n);
        out.println(n);

        reverse(in, out);

        //        while (true){
//            n = in.nextInt();
//            if (n == 0) {
//                System.out.println(stackArr.toString());
//                break;
//            }
//            ((LinkedList<Integer>) stackArr).addFirst(n);
//            out.println(((LinkedList<Integer>) stackArr).peekFirst());
//        }
    }

//    //функция должна отсортировать массив слиянием
//    ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
//
//        sortingArr = list;
//        sortedArr = new ArrayList<>();
//
//        mergeSortRec(sortedArr, 0, list.size());
//        return sortedArr;
//
//    }

    //функция должна отсортировать массив слиянием
    ArrayList<Integer> mergeSort(ArrayList<Integer> list) {

        if(list.size() == 1 || list.size() == 0) {return list;}

        return merge(mergeSort(split(list).getKey()), mergeSort(split(list).getValue()));
    }


    //функция должна разбить список пополам (2 2 для 4 или 3 2 для 5)
    Pair<ArrayList<Integer>, ArrayList<Integer>> split(ArrayList<Integer> list) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.addAll(list); //копируем list, чтобы не изменять его

        int len = list1.size();
        for (int i = len - 1; i >= len / 2; i--) {
            list2.add(list1.remove(i));
        }
        return new Pair<>(list1, list2);
    }

    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int l = 0, r = 0;

        /*берем один массив и начинаем сравнивать его элементы с другим. Чйе элемент меньше - записаваем его в
        третий масси и итерируемся (итерируемся только по тому массиву, из которого переносим элемент!)*/
        while (l < left.size() && r < right.size()) {
            if (left.get(l) < right.get(r)) {
                mergedList.add(left.get(l));
                l++;
            } else {
                mergedList.add(right.get(r));
                r++;
            }
        }
        // переносим оставшиеся в ОДНОМ из массивов элементы
        while (l < left.size()) {
            mergedList.add(left.get(l));
            l++;
        }
        while (r < right.size()) {
            mergedList.add(right.get(r));
            r++;
        }
        return mergedList;
    }

    //функция должна вернуть К-ую перестановку n-элементного множества
    //уникальных целых чисел дата
    int[] permutation(int[] data, int n, int k, int index, PrintWriter out) {
        //TODO
        return null;
    }

    //функция должна вернуть максимальную массу из предметов в дата, но не превышающую
    //лимит
    long knackPack(int[] data, long limit) {

        return knackPack(data, limit, 0, 0);
    }

    private long knackPack(int[] data, long limit, long sum, int index) {

        if (limit < 0) {return Long.MIN_VALUE;}
        if (index == data.length) {return sum;}

        return Math.max(knackPack(data, limit - data[index], sum + data[index], index + 1),
                knackPack(data, limit, sum, index + 1));

    }

}
