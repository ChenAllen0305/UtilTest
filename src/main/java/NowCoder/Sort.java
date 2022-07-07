package NowCoder;

/**
 * ClassName: Sort
 * Author: ChenLun
 * date: 2021/10/26
 * Description:
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 8};
        bubbleSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 1. 冒泡排序
     * 每个都进行循环，若当前比下一个大，则更换位置
     *
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr) {
        if (!(arr == null || arr.length == 0)) {
            int length = arr.length;
            // 最后一个不用做循环
            for (int i = 0; i < length - 1; i++) {
                //
                for (int j = 0; j < length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int pre = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = pre;
                    }
                }
            }
        }
    }
//-------------------------------------------------

    /**
     * 2.快排
     * 找基准数
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr, int left, int right) {
        
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        if (less < more) {

        }
        return null;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//-------------------------------------------------

    /**
     * 3.二分排序
     *
     * @param arr
     * @return
     */
    public static void binaryOrdering(int[] arr) {

    }
}
