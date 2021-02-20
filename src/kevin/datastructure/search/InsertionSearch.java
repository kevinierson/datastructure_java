package kevin.datastructure.search;

/**
 * @author: kevin
 * @date: 15:25 2021/2/20
 */
@SuppressWarnings("all")
public class InsertionSearch {
    public static void main(String[] args) {
        int[] arr = {5,13,19,21,37,56,64,75,80,88,92};
        int index = binarySearch(arr, 5);
        if(index == -1){
            System.out.println("查找失败！！！");
        }else{
            System.out.println("查找成功，index = " + index);
        }
    }

    private static int binarySearch(int[] arr, int data) {
        int low = 0, high = arr.length - 1;
        while(low <= high){
//            int mid = (low + high) / 2;
            int mid = low + (data - arr[low]) / (arr[high] - arr[low]) * (high - low); //根据待查关键字大小自适应
            if(data == arr[mid]){
                return mid;
            }else if(data < arr[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
