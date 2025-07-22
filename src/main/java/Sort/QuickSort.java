package Sort;

public class QuickSort {
    public static void quickSort1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) Math.random() * (r - l + 1)];
        int mid = partition1(arr, l, r, x);
        quickSort1(arr, l, mid - 1);
        quickSort1(arr, mid + 1, r);
    }

    public static int partition1(int[] arr, int l, int r, int x) {
        int a = l;
        int xi = 0;
        // a代表<=x的越界位置
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(arr, a, i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        // ......x  ......
        // l....a-1 a....r
        // 确保<=x区域最右边的数是x
        swap(arr, a - 1, xi);
        return a - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) Math.random() * (r - l + 1)];
        partition2(arr, l, r, x);
        int left = first;
        int right = last;
        quickSort2(arr, l, left - 1);
        quickSort2(arr, right + 1, r);
    }

    //荷兰国旗问题
    public static int first;
    public static int last;

    public static void partition2(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, i++, first++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr, i, last--);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort1(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] nums = new int[]{5, 4, 3, 2, 1};
        quickSort2(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
