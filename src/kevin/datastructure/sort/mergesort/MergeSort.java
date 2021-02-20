package kevin.datastructure.sort.mergesort;

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
        int[] temp = new int[arr.length];//辅助空间
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    //参数分别为 待排序数组，左指针，右指针，辅助数组
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //因为使用递归，所以必须规定递归条件，否则将进行无线循环
        if (left < right) {
            //将数组进行分割
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //每分解一轮便合并一轮
            Merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     * @param arr   待排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的初始索引
     * @param temp  辅助数组
     */
    public static void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;// 初始化i，左边有序序列的初始索引
        int j = mid + 1;// 初始化j，右边有序序列的初始索引(右边有序序列的初始位置即为中间位置的后一个位置)
        int t = 0;//t为辅助数组的索引

        // 先把左右两边的数据(已经有序)按规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完成为止
        while (i <= mid && j <= right) {
            // 如果左边有序序列的当前元素小于或等于右边有序序列的当前元素，就将左边的元素填充到temp数组中
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                // 反之，将右边有序序列的当前元素填充到temp数组中
                temp[t++] = arr[j++];
            }
        }
        // 把有剩余数据的一边的元素填充到temp中
        while (i <= mid) {
            // 此时说明左边序列还有剩余元素
            // 全部填充到temp数组
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            // 此时说明左边序列还有剩余元素
            // 全部填充到temp数组
            temp[t++] = arr[j++];
        }
        t = 0;
        //将辅助数组内已经排好的数据全部复制进原数组，排序完成
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
