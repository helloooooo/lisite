package com.bruce.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 腾 on 2016/7/8.
 * 输入包括多组测试数据。
 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 学生ID编号从1编到N。
 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n+1];
            for(int i = 1; i <= n; i++){
                nums[i] =scanner.nextInt();
            }
            SegmentNode root = buildTree(nums, 1, n);
            for(int i = 0; i < m; i++){
                String ope = scanner.next();
                if(ope.equals("U")){
                    int index = scanner.nextInt();
                    int uVal = scanner.nextInt();
                    updateOne(root, index, uVal);
                }
                else  if(ope.equals("Q")){
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    if(l > r){
                        int temp = l;
                        l = r;
                        r = temp;
                    }
                    System.out.println(query(root, l, r));
                }
            }
        }


    }


    private static SegmentNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        else{
            SegmentNode root = new SegmentNode(start, end);
            if(start == end){
                root.val = nums[start];
            }
            else{
                int mid = start + (end - start) / 2;
                root.left = buildTree(nums, start, mid);
                root.right = buildTree(nums, mid+1, end);
                root.val = Math.max((root.left != null?root.left.val:0), (root.right!=null?root.right.val:0));
            }
            return root;
        }
    }

    private static int query(SegmentNode root, int start, int end){
        if(root.l == start && root.r == end){
            return root.val;
        }
        else{
            int mid = root.l + (root.r - root.l) / 2;
            if(start > mid){
                //right half
                if(root.right != null)
                    return query(root.right, start, end);
            }
            else if(end <= mid){
                if(root.left != null)
                    return query(root.left, start, end);
            }
            else{
                int leftVal=-1, rightVal = -1;
                if(root.left !=  null)
                    leftVal = query(root.left, start, mid);
                if(root.right != null)
                    rightVal = query(root.right, mid+1, end);
                return Math.max(leftVal, rightVal);
            }
            return -1;
        }
    }

    private static void updateOne(SegmentNode root, int index, int updateValue){
        if(root.l == root.r){
            root.val = updateValue;
        }
        else{
            int mid = root.l + (root.r - root.l) / 2;
            if(index > mid){
                //right side
                updateOne(root.right, index, updateValue);
            }
            else{
                updateOne(root.left,  index, updateValue);
            }
            root.val = Math.max(root.left.val, root.right.val);
        }
    }


}


class SegmentNode{
    int l, r, val, addVal;
    SegmentNode left, right;
    public SegmentNode(int l, int r){
        this.l = l;
        this.r = r;
        left = null;
        right = null;
    }
}