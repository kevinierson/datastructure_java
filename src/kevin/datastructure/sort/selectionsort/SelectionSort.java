package kevin.datastructure.sort.selectionsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 9:55 2021/2/18
 * 简单选择排序
 */
public class SelectionSort {

    private static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;//存储最小值索引
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;//把最小值索引赋值给minIndex
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));
        int[] result = selectionSort(arr);
        System.out.println("排序后：" + Arrays.toString(result));
    }
}
