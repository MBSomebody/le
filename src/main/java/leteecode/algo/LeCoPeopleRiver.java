package leteecode.algo;

import java.util.*;

class Solution {

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean rf0 = false;
        boolean cf0 = false;

        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                rf0 = true;
                break;
            }
        }

        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                cf0 = true;
                break;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rf0) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
        if (cf0) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }


    }


}
