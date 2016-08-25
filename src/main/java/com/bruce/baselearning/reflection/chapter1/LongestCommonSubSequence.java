package com.bruce.baselearning.reflection.chapter1;

/**
 * Created by wuteng1 on 2016/8/13.
 */
public class LongestCommonSubSequence {


    static void LCS(int[] nums1, int[] nums2, int[][] c, int[][] b){
        for(int i = 0; i <= nums2.length; i++){
            c[0][i] = 0;
        }
        for(int i = 0; i <= nums1.length; i++){
            c[i][0] = 0;
        }

        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 0;
                }
                else if(c[i][j-1] < c[i-1][j]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 1;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = -1;
                }
            }
        }
    }

    static  void print(int i, int j, int[][] b, int[] nums){
        if(i == 0 || j == 0)
            return;
        if(b[i][j] == 0){
            print(i-1, j-1, b, nums);
            System.out.println(nums[i-1]);
        }
        else if(b[i][j] == 1){
            print(i-1, j, b, nums);
        }
        else {
            print(i, j-1, b, nums);
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 23, 5};
        int[] b = new int[]{2, 3, 4, 7};
        int[][] c = new int[a.length+1][b.length+1];
        int[][] path = new int[a.length+1][b.length+1];
        LCS(a, b, c, path);
        print(a.length, b.length, path, a);
        System.out.println(c[a.length][b.length]);

    }
}
