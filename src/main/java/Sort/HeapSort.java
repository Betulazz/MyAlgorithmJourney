package Sort;

public class HeapSort {

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // i位置的数变小了
    public static void heapify(int[] arr, int i, int size) {
        int l = 2 * i + 1;
        //有左子树才循环
        while (l < size) {
            //有右孩子的话选出最大的孩子
            int best = l + 1 < size && arr[l] < arr[l + 1] ? l + 1 : l;
            best = arr[i] < arr[best] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr, i, best);
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            heapInsert(arr,i);
        }
        int size = n;
        while(size > 1){
            swap(arr,0,--size);
            heapify(arr,0,size);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        heapSort1(arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
