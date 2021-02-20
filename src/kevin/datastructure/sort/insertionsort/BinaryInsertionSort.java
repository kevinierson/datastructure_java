package kevin.datastructure.sort.insertionsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 9:11 2021/2/19
 */
@SuppressWarnings("all")
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));
        int[] result = binaryInsertionSort(arr);
        System.out.println("排序后：" + Arrays.toString(result));

    }

    private static int[] binaryInsertionSort(int[] arr) {
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

}
