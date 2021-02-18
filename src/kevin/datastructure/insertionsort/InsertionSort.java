package kevin.datastructure.insertionsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 10:33 2021/2/14
 */
public class InsertionSort {

    private static int[] insertionSort(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));

        int[] result = insertionSort(arr);

        System.out.println("排序后：" + Arrays.toString(result));

    }
}
