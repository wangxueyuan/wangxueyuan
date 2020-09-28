/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/25/2020 12:55
 * @Version: 1.0
 **/
public class I4MedianInteger {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) / 2;
    }

    private int getKth(int[] nums1, int i, int i1, int[] nums2, int i2, int i3, int left) {
        return 0;
    }
}
