package kevin.datastructure.insertsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 16:16 2021/2/15
 * 希尔排序
 */
@SuppressWarnings("all")
public class ShellSort {

    private static int[] shellSort(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("排序前：" + Arrays.toString(arr));

        int[] result = shellSort(arr);

        System.out.println("排序后：" + Arrays.toString(result));

    }

}
