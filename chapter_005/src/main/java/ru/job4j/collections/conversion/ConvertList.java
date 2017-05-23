package ru.job4j.collections.conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 22.05.2017.
 */
public class ConvertList {

    public ConvertList() {
    }

    List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>(array.length * array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    int[][] toArray(List<Integer> list, int row) {
        int colums = list.size() / row;
        int addingZerro = 0;
        int count = 0;
        if (list.size() % row != 0) {
            colums += 1;
            addingZerro = (colums * row) - list.size();
            for (int i = 0; i < addingZerro; i++) {
                list.add(0);
            }
        }
        int[][] result = new int[row][colums];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colums; j++) {
                result[i][j] = list.get(count);
                count++;
            }
        }
        return result;
    }
    
    public List<Integer> initList(List<Integer> list, int num) {
        for (int i = 0; i < num; i++) {
            list.add(i);            
        }
        return list;
    }

    public static void main(String[] args) {

        ConvertList convert = new ConvertList();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int[][] startAr = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        convert.initList(ar, 30);
        System.out.println(String.format("ArrayList before toArray - %s", ar));
        int[][] twoDimAr = convert.toArray(ar, 4);
        System.out.println(String.format("ArrayList after toArray - %s", ar));
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
        for (int i = 0; i < startAr.length; i++) {
            for (int j = 0; j < startAr[0].length; j++) {
                System.out.print(String.format("%s ", startAr[i][j]));
            }
            System.out.println();
        }
        System.out.println("Array after toList");
        System.out.println(convert.toList(startAr));
    }
}
