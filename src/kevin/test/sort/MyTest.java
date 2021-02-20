package kevin.test.sort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 12:38 2021/2/18
 * 测试
 */
public class MyTest {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27};
        System.out.println("排序前: \n" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后: \n" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort( arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right){
          int mid = (right + left) / 2;
          mergeSort(arr, left, mid, temp);
          mergeSort(arr, mid + 1, right, temp);
          merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        while(j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
