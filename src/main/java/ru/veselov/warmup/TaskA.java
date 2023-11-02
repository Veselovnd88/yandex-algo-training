package ru.veselov.warmup;

import java.util.Scanner;
//Passed
public class TaskA {

    private static final String NOT_FOUND = "NOT FOUND";

    private int queries;

    private Scanner sc;

    public void solution() {
        sc = new Scanner(System.in);
        int[] array = readArray();
        for (int i = 0; i < queries; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println(checkInterval(array, left, right));
        }
    }

    private int[] readArray() {
        int length = sc.nextInt();
        int[] array = new int[length];
        queries = sc.nextInt();
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public String checkInterval(int[] array, int left, int right) {
        int min = array[left];
        int notMin = -1;
        for (int i = left; i <= right; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int j=left; j<=right; j++){
            if (array[j] > min) {
                notMin = array[j];
            }
        }
        if (notMin != -1) {
            return String.valueOf(notMin);
        } else {
            return NOT_FOUND;
        }
    }

}
