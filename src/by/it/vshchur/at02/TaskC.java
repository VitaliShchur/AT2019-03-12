package by.it.vshchur.at02;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = new int[n][n];
        step1(n);
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {

        int[][] matrix = new int[n][n];
        int nPreseceInMatrix = 0;
        while (nPreseceInMatrix < 2) {
            nPreseceInMatrix = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (int) (Math.random() * (2 * n + 2) - n - 1);
                    if (matrix[i][j] == n) nPreseceInMatrix++;
                    if (matrix[i][j] == -1 * n) nPreseceInMatrix++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
        return matrix;
    }


    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int rowPositiveElemCounter = 0;
            int sumRow = 0;
            for (int j = 0; j < mas.length; j++) {
                int sumGroup = 0;
                if (mas[i][j] > 0) rowPositiveElemCounter++;
                if (rowPositiveElemCounter == 1 && mas[i][j] < 0) sumGroup =sumGroup+mas[i][j];
                if (rowPositiveElemCounter == 2) sumRow=sumRow+sumGroup;
            }
            sum=sum+sumRow;
        }
        System.out.println("Сумма значений между 1-м и 2-м полож числами в каждом ряду:"+sum);
        return sum;
    }



    static int[][] step3(int[][] arr) {

        //Ищем MAX value
        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (element > max)
                    max = element;
            }
        }
        //Arrays with indicators about rows/columns deletion
        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
        int rowCount = 0;
        for (boolean del : delRow) if (!del) rowCount++;

        int colCount = 0;
        for (boolean del : delCol) if (!del) rowCount++;

        int[][] res = new int[rowCount][colCount];
        int ires = 0;
        for (int i = 0; i < arr.length; i++) {
            if (delRow[i] == false) {
                int jres = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (delCol[j] == false) {
                        res[ires][jres] = arr[i][j];
                        jres++;
                    }
                }
                ires++;
            }
        }
        return res;
    }
}


