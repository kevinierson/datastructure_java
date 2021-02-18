package kevin.datastructure.selectionsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 10:03 2021/2/18
 * 堆排序
 */
public class HeapSort {


    //交换方法
    private static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    //从小到大排序，大顶堆
    private static void down(int[] arr, int i, int n){
        int parent = i;
        int child = 2 * i + 1;
        while(child < n){
            if(child + 1 < n && arr[child] < arr[child + 1]){
                child++;
            }
            if(arr[parent] < arr[child]){
                swap(arr, parent, child);
                parent = child;
            }
            child = child * 2 + 1;
        }
    }

    //构建堆
    private static void buildHeap(int[] arr, int size){
        for(int i = size / 2 - 1; i >= 0; i--){//从第一个非叶子结点开始构建堆
            down(arr, i, size);
        }
    }

    //堆排序
    private static void heapSort(int[] arr, int size){
        System.out.println("初始化数组: ");
        buildHeap(arr, size);
        System.out.println(Arrays.toString(arr));
        for(int i = size - 1; i > 0; i--){
            swap(arr, 0, i);
            down(arr, 0, i);
            System.out.println("排序的数组: ");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27};
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr, arr.length);
    }
}
