package com.core;

import java.util.Scanner;

//   Write a program to perform matrix addition and subtraction using 2D arrays
public class P16_MatrixOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of row: ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number or columns: ");
        int columns = scanner.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] sum = new int[rows][columns];
        int[][] differance = new int[rows][columns];

        System.out.println("Enter elements of first matrix");
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.println("Elements ["+i+"]["+j+"]");
                matrix1[i][j]=scanner.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix");
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.println("Elements ["+i+"]["+j+"]");
                matrix2[i][j]=scanner.nextInt();
            }
        }

        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                sum[i][j]=matrix1[i][j]+matrix2[i][j];
                differance[i][j]=matrix1[i][j]-matrix2[i][j];
            }
        }

        System.out.println("Sum of the matrix: ");
        displayMatrix(sum);
        System.out.println();
        System.out.println("Differance of the matrix: ");
        displayMatrix(differance);



    }
    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
