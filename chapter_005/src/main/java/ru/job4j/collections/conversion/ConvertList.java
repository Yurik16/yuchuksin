package ru.job4j.collections.conversion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 22.05.2017.
 */
public class ConvertList {

    /**
     * Default constructor for ConvertUser.
     */
    public ConvertList() {
    }

    /**
     * Convert int[][] to ArrayList.
     *
     * @param array source array
     * @return List
     */
    List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] line : array) {
            for (int x : line) {
                result.add(x);
            }
        }
        return result;
    }

    /**
     * Convert List to int[][].
     *
     * @param list source array
     * @param row number of rows in returned array
     * @return int[][]
     */
    int[][] toArray(List<Integer> list, int row) {
        int columns = list.size() / row;
        Iterator<Integer> it = list.iterator();
        if (list.size() % row != 0) {
            columns += 1;
        }
        int[][] result = new int[row][columns];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                if (it.hasNext()) {
                    result[i][j] = it.next();
                }
            }
        }
        return result;
    }

    /**
     * Makes List of int [1, 2, 3, ... ].
     *
     * @param num numver of elements in List
     * @return List of Integer
     */
    public List<Integer> initList(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Makes int array of the given length.
     *
     * @param length integer
     * @return int array
     */
    public int[] initIntArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Makes two dimension int array of the given length and width.
     *
     * @param row length
     * @param column width
     * @return two dimension int array
     */
    public int[][] initTwoDArray(int row, int column) {
        int[][] result = new int[row][column];
        int x = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = x;
                x++;
            }
        }
        return result;
    }

    /**
     * Convert list of int array to List of integer.
     *
     * @param list source list of int array
     * @return List of integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int[] elem : list) {
            for (int i : elem) {
                result.add(elem[i]);
            }
        }
        return result;
    }

    /**
     * Main method.
     *
     * @param args args
     */
    public static void main(String[] args) {

        ConvertList convert = new ConvertList();
        List<Integer> ar = convert.initList(30);
        int[][] startAr = convert.initTwoDArray(4, 4);
        System.out.println(String.format("ArrayList before toArray - %s", ar));
        int[][] twoDimAr = convert.toArray(ar, 4);
        System.out.println("ArrayList after toArray ");
        for (int i = 0; i < twoDimAr.length; i++) {
            for (int j = 0; j < twoDimAr[0].length; j++) {
                if (twoDimAr[i][j] < 10 && -1 < twoDimAr[i][j]) {
                    System.out.print(String.format(" %s ", twoDimAr[i][j]));
                } else {
                    System.out.print(String.format("%s ", twoDimAr[i][j]));
                }
            }
            System.out.println();
        }
        System.out.println("Two dimmension array before toList");
        for (int[] line : startAr) {
            for (int i : line) {
                System.out.print(String.format("%s ", i));
            }
            System.out.println();
        }
        System.out.println("Array after toList");
        System.out.println(convert.toList(startAr));
    }
}
