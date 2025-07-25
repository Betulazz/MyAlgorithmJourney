package Sort;

public class MergeSort {

    public static int MAXN = 50000;
    public static int[] help = new int[MAXN];

    // 归并排序递归版：
    // T(n) = 2 * T(n/2) + O(n)
    // a = 2, b = 2, c = 1
    // 根据master公式，时间复杂度O(n * logn)
    // 空间复杂度O(n)
    public static void mergeSort1(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    // 非递归：
    // 时间复杂度O(n * logn)
    // 空间复杂度O(n)
    public static void mergeSort2(int[] arr) {
        int n = arr.length;
        for (int l, m, r, step = 1; step < n; step *= 2) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + step * 2 - 1, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        mergeSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int[] nums = new int[]{5, 4, 3, 2, 1};
        mergeSort2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
