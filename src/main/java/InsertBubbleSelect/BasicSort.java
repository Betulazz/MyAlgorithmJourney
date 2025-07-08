package InsertBubbleSelect;

public class BasicSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //插入排序
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int end=arr.length-1;end>0;end--){
            for(int i = 0; i <end; i++){
                swap(arr, i, i +1);
            }
        }
    }

    //选择排序
    public static void selectionSort(int[] arr){
        for(int minIndex,i=0;i<arr.length;i++){
            minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        selectionSort(arr);
        print(arr);
        insertionSort(arr);
        print(arr);
        bubbleSort(arr);
        print(arr);
    }
}
