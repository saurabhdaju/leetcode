package leetcode;
//https://leetcode.com/problems/sort-the-matrix-diagonally/


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LC1329 {
    public static void main(String[] args) {
        int[][] arr = {
                {11,25,66,1,69,7},
                {23,55,17,45,15,52},
                {75,31,36,44,58,8},
                {22,27,33,25,68,4},
                {84,28,14,11,5,50}
        };
        diagonalSort(arr);
        for(int[] array : arr) {
            System.out.println(Arrays.toString(array));
        }
    }

    static public int[][] diagonalSort(int[][] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int rows = arr.length;
        int cols = arr[0].length;
        if (rows == 1) return arr;

        //Sorting the upper triangle of the matrix
        for(int count = 0; count < cols; count++) {

            //storing diagonal elements in priority queue
            for(int i = 0, j = count; i < rows && j < cols; i++, j++) {
                q.offer(arr[i][j]);
            }

            //replacing the diagonal element in sorted way by using the peek
            for(int i = 0, j = count; i < rows && j < cols; i++, j++) {
                arr[i][j] = q.peek();
                q.poll();
            }
        }

        //sorting the lower triange of the matrix
        for(int count=1; count < rows; count++) {

            //storing diagonal elements in priority queue
            for(int i = count, j = 0; i < rows && j < cols; i++, j++) {
                q.offer(arr[i][j]);
            }

            //replacing the diagonal element in sorted way by using the peek
            for(int i = count, j = 0; i < rows && j < cols; i++, j++) {
                arr[i][j] = q.peek();
                q.poll();
            }
        }

        return arr;

    }
}
