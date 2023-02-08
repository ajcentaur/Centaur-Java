package com.ajcentaur.leetcode.arraygroup;

/**
 * 矩阵
 */
public class Matrx {
    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }

    /**
     * leetcode59
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        //声明矩阵上下左右四个边界
        int up = 0, down = n - 1, left = 0, right = n - 1;
        /**
         * 00 01 02 03
         * 10 11 12 13
         * 20 21 22 23
         * 30 31 32 33
         */
        int cnt = 1;
        while(true){
            for(int i = left; i <= right; i++){
                res[up][i] = cnt;
                cnt++;
            }
            if(++up > down){
                break;
            }
            for(int i = up; i <= down; i++){
                res[i][right] = cnt;
                cnt++;
            }
            if(--right < left){
                break;
            }
            for(int i = right; i >= left; i--){
                res[down][i] = cnt;
                cnt++;
            }
            if(--down < up){
                break;
            }
            for(int i = down; i >= up; i--){
                res[i][left] = cnt;
                cnt++;
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
