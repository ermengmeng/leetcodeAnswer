/**
 * @Author: ouyangyameng
 * @Date: 2023/2/3 15:53
 * @Version 1.0
 */
public class H4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2,7};
        System.out.println(new H4MedianOfTwoSortedArrays().findMedianSortedArrays(a,b));
    }


    double findKth(int a[], int as, int m, int b[], int bs, int n, int k) {
        //always assume that m is equal or smaller than n
        if (m > n)
            return findKth(b, bs, n, a, as, m, k);
        if (m == 0)
            return b[k - 1];
        if (k == 1)
            return Math.min(a[as + 0], b[bs + 0]);
        //divide k into two parts
        int pa = Math.min(k / 2, m), pb = k - pa;
        if (a[as + pa - 1] < b[bs + pb - 1])
            return findKth(a, as + pa, m - pa, b, bs, n, k - pa);
        else if (a[as + pa - 1] > b[bs + pb - 1])
            return findKth(a, as, m, b, bs + pb, n - pb, k - pb);
        else
            return a[pa - 1];
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int total = m + n;
        if ((total & 0x1) == 1)
            return findKth(a, 0, m, b, 0, n, total / 2 + 1);
        else
            return (findKth(a, 0, m, b, 0, n, total / 2)
                    + findKth(a, 0, m, b, 0, n, total / 2 + 1)) / 2;
    }
}
