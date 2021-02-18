package kevin.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: kevin
 * @date: 10:22 2021/2/16
 * 排序性能测试
 */
public class SortTest {
    private Random random = new Random();

    //插入排序测试
    @Test
    public void insertSortTest(){
        int arr[] = new int[400000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(10000);
        }
        long startTime = System.currentTimeMillis();
        SortUtils.insertionSort(arr);//直接插入排序
//        SortUtils.shellSort(arr);//希尔排序
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime ));
    }

    @Test
    public void exchangeSortTest(){
        int arr[] = new int[1000000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(10000);
        }
        long startTime = System.currentTimeMillis();
        SortUtils.bubbleSort(arr);//冒泡排序
//        SortUtils.quickSort(arr,0,arr.length - 1);//快速排序
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime ));
    }
}
