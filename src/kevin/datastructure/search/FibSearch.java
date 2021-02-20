package kevin.datastructure.search;

import java.util.Arrays;

/**
 * @author: kevin
 * @date: 17:33 2021/2/20
 */
public class FibSearch {
    private static final int MAXSIZE = 15;
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {5,13,19,21,37,56,64,75,88};
        System.out.println("index = " + fibSearch(arr, 88) + "\ncount = " + count);
    }

    private static int fibSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int[] fib = getFibonacci();
        int k = 0;
        while(high >= fib[k] - 1){
            k++;
        }

        int[] tmp = Arrays.copyOf(arr, fib[k]);
        for(int i = arr.length; i < fib[k]; ++i){
            tmp[i] = arr[high];
        }

        while(low <= high){
            mid = low + fib[k - 1] -1;
            count++;
            if(value < tmp[mid]){
                high = mid -1;
                k--;
            }else if(value > tmp[mid]){
                low = mid + 1;
                k -= 2;
            }else{
                if(mid < arr.length){
                    return mid;
                }else {
                    return arr.length - 1;
                }
            }
        }
        return -1;
    }

    private static int[] getFibonacci() {
        int[] fib = new int[MAXSIZE];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < MAXSIZE; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
