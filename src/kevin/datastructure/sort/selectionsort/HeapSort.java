package kevin.datastructure.sort.selectionsort;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 10:03 2021/2/18
 * 堆排序
 */
@SuppressWarnings("all")
public class HeapSort {

    //交换方法
    private static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    //从小到大构建大顶堆
    private static void down(int[] arr, int i, int n){
        int parent = i; //父节点索引
        int child = 2 * i + 1; //子节点索引
        while(child < n){
            if(child + 1 < n && arr[child] < arr[child + 1]){
                // 判断子节点哪个大，大的与父节点比较
                child++;
            }
            if(arr[parent] < arr[child]){//判断父节点是否小于子节点
                swap(arr, parent, child);//交换父节点和子节点
                parent = child;//子节点索引赋值给父节点
            }
            child = child * 2 + 1;//比较下一层父节点和字节点
        }
    }

    //构建堆
    private static void buildHeap(int[] arr, int size){
        for(int i = size / 2 - 1; i >= 0; i--){//从尾部第一个非叶子结点(即倒数第二排的非叶子节点)开始构建堆，从下往上比较
            down(arr, i, size); //否则有的不符合大顶堆定义
        }
    }

    //堆排序
    private static void heapSort(int[] arr, int size){
        System.out.println("初始化数组: ");
        buildHeap(arr, size);//初始化堆
        System.out.println(Arrays.toString(arr));
        for(int i = size - 1; i > 0; i--){
            swap(arr, 0, i);//交换顶点和第i个元素
            down(arr, 0, i);
            //注意：这里是从顶部开始构建的大顶堆，之前在初始化堆的时候是从尾部开始构建堆。
            System.out.println("排序的数组: ");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27};
        System.out.println("排序前: \n" + Arrays.toString(arr));
        heapSort(arr, arr.length);
    }
}
