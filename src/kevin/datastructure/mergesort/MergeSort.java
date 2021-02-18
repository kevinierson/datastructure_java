package kevin.datastructure.mergesort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 20:36 2021/2/18
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27};
        System.out.println("排序前: \n" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后: \n" + Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //参数分别为 待排序数组，左指针，有指针，辅助数组
        //因为使用了递归，所以我们必须规定递归条件否则将进行无线循环
        if (left < right) {
            //将数组进行分割
            int mid = (left + right) / 2;
            //对左子数组继续进行归并排序
            mergeSort(arr, left, mid, temp);
            //对右子数组继续进行归并排序
            mergeSort(arr, mid + 1, right, temp);
            //将数组进行合并
            Merge(arr, left, mid, right, temp);
        }

    }

    //合并函数
    public static void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        //t为辅助数组的索引
        int t = 0;
        while (i <= mid && j <= right) {
            //当二者都没有到达最后一位时，进行比较并向辅助数组复制
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //当其中一个数组复制完毕后，将另一个数组内的数组全部复制进辅助数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将辅助数组内已经排好的数据全部复制进原数组，排序完成
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }
}
