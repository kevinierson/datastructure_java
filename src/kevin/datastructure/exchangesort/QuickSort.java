package kevin.datastructure.exchangesort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 10:56 2021/2/17
 * 快速排序
 */
public class QuickSort {

    private static int[] quickSort(int[] arr, int low, int high) {
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

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));

        int[] result = quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后：" + Arrays.toString(result));

        Arrays.sort(arr);
    }


}
