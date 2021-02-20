package kevin.datastructure.sort.exchangesort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 8:19 2021/2/17
 * 冒泡排序
 */
public class BubbleSort {

    private static int[] bubbleSort(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));

        int[] result = bubbleSort(arr);

        System.out.println("排序后：" + Arrays.toString(result));


    }

}
