package Interview;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,3,1,4,2,7,8,6,5};
        bubbleSort(arr);
        for(int i:arr){
            System.out.print(i);
        }
    }

    public static void bubbleSort(int []arr) {
        for(int i =0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {//-1为了防止溢出
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];

                    arr[j]=arr[j+1];

                    arr[j+1]=temp;
                }
            }
        }
    }
}
