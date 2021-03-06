package kevin.test.sort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 10:44 2021/2/16
 */
@SuppressWarnings("all")
public class SortUtils {
    //直接插入排序
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int insertValue = arr[i];
            int preIndex = i - 1;
            while(preIndex >= 0 && insertValue < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = insertValue;
        }
        return arr;
    }
    //折半插入排序
    public static int[] binaryInsertionSort(int[] arr) {
        for(int i = 1; i < arr.length; ++i){
            int insertValue = arr[i];
            int low = 0;
            int high = i - 1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(insertValue < arr[mid])
                    high = mid - 1;
                else
                    low =mid + 1;
            }
            for(int j = i - 1; j >= high + 1; --j){
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = insertValue;
        }
        return arr;
    }
    //希尔排序
    public static int[] shellSort(int[] arr){
        int len = arr.length;
        for(int gap = len / 2; gap > 0; gap /= 2){ //分组，越往后分组越少，每个分组内的元素就越多
            for(int i = gap; i < len; i += gap){//采用直接插入排序算法，i每次增加gap，因为组内的相邻元素实际上还隔了gap - 1个元素
                int insertValue = arr[i];//组内中的待插入元素
                int preGapIndex = i - gap;//组内中待插入元素的前一个索引
                while(preGapIndex >= 0 && insertValue < arr[preGapIndex]){
                    arr[preGapIndex + gap] = arr[preGapIndex];
                    preGapIndex -= gap;
                }
                arr[preGapIndex + gap] = insertValue;
            }
        }
        return arr;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arr){
        int tmp;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    //快速排序
    public static int[] quickSort(int[] arr, int low, int high) {
        if(low < high){
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
        return arr;
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while(low < high){
            while(low < high && arr[high] >= tmp){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    //简单选择排序
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length ; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    //堆排序
    public static void heapSort(int arr[], int len){
        buildHeap(arr, len);
        for(int i = len - 1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr, int len) {
        for(int i = len / 2 - 1; i >= 0; i--){
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int parent = i;
        int child = 2 * i + 1;
        while(child < len){
            if(child + 1 < len && arr[child] < arr[child + 1]){
                child++;
            }
            if(arr[parent] < arr[child]){
                swap(arr, parent, child);
                parent = child;
            }
            child = child * 2 + 1;
        }
    }

    private static void swap(int[] arr, int parent, int child) {
        int tmp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = tmp;
    }
}
