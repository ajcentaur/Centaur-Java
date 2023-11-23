package com.ajcentaur.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/22 15:29
 * @description: JavaTest2
 */
public class JavaTest2 {

    private static List<List<Integer>> resa = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(search(new int[]{1,3}, 1));
//        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(searchRange(new int[]{2,2}, 3));
//        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
//        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(isPerfectSquare(5));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        int left = 1;
        int right = num / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid > num / mid){
                right = mid - 1;
            }else if(mid < num / mid){
                left = mid + 1;
            }else{
                if(num % mid == 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int cen = nums.length / 2;
        boolean isFlag = nums[cen] > target;
        if(isFlag){
            while(cen < nums.length){
                if(nums[cen] == target){
                    return cen;
                }
                cen++;
            }
        }else{
            while(cen >= 0){
                if(nums[cen] == target){
                    return cen;
                }
                cen--;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1,-1};
        //查找目标值起始位置
        while(left <= right){
            int mid = (left + right + 1) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < nums[mid]){
                    res[0] = mid;
                }else{
                    right = mid - 1;
                }
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
        }
        //查找目标值结束位置
        int left1 = 0;
        int right1 = nums.length - 1;
        while(left1 <= right1){
            int mid = (left1 + right1) / 2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]){
                    res[1] = mid;
                }else{
                    left1 = mid + 1;
                }
            }
            if(nums[mid] > target){
                right1 = mid - 1;
            }
            if(nums[mid] < target){
                left1 = mid + 1;
            }
        }
        return res;
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        searchComb(candidates, target, new ArrayList<>(), 0, 0, 0);
        return resa;
    }

    private static void searchComb(int[] candidates, int target, List<Integer> subList, int sum, int val , int index){
        if(sum + val > target){
            return;
        }
        if(sum + val == target){
            resa.add(new ArrayList<>(subList));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            subList.add(candidates[i]);
            searchComb(candidates, target, subList, sum + val, candidates[i], i);
            subList.remove(subList.size() - 1);
        }
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)){
            return false;
        }
        //说明已经找到了最后一个值（只要通过了上面校验的就是找到了目标值）
        if(index == word.length() - 1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '0';
        //index + 1 = 查找下一个目标值
        boolean res = dfs(board, i - 1, j, word, index + 1) ||
                dfs(board, i, j - 1, word, index + 1) ||
                dfs(board, i + 1, j, word, index + 1) ||
                dfs(board, i, j + 1, word, index + 1);
        board[i][j] = temp;

        return res;
    }
}
