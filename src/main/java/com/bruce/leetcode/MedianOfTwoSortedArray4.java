package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/14.
 */
public class MedianOfTwoSortedArray4 {
    Solution sol = new Solution();
    public static void main(String[] args) {
        MedianOfTwoSortedArray4 a = new MedianOfTwoSortedArray4();
        int[] a1 = new int[0];
        int[] a2= new int[1];
        a2[0] = 1;
        System.out.println(a1);
        System.out.println(a2);
        a.sol.findMedianSortedArrays(a1,a2);

    }
    class Solution{
        public  double findMedianSortedArrays(int[] nums1, int[] nums2){
            int m = nums1.length;
            int n = nums2.length;
            if((m+n) % 2 == 0){
                return (double)(getMedian(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2) + getMedian(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1)) / 2;
            }
            else{
                return (double)getMedian(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1);
            }

        }


        public double getMedian(int[] A, int sa, int ea, int[] B, int sb, int eb, int k){
            int m = ea - sa + 1;
            int n = eb - sb + 1;
            if(m > n)
                return getMedian(B, sb, eb, A, sa, ea, k);
            if(m == 0)
                return B[k-1];
            if(k == 1)
                return Math.min(A[sa], B[sb]);
            int lenA = Math.min(k/2, m);
            int lenB = k - lenA;
            if(A[sa + lenA - 1] < B[sb + lenB - 1]){
                return getMedian(A, sa+lenA, ea, B, sb, eb, k-lenA);
            }
            else if(A[sa + lenA - 1] > B[sb + lenB - 1]){
                return getMedian(A, sa, ea, B, sb+lenB, eb, k-lenB);
            }
            else{
                return A[sa + lenA - 1];
            }
        }
    }
}
