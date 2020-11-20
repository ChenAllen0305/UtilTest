package Iteration;

import java.util.ArrayList;
import java.util.List;

public class distributeCandy {
    public static void main(String[] args) {
        distributeCandy dc = new distributeCandy();
        int[] result = dc.disCan(10, 3);
        for(int i :result){
            System.out.print(i + " ");
        }
    }

    public int[] disCan(int candies, int num_people){
        int[] arr = new int[num_people];
        return addCandy(arr, 1, 0, candies);
    }

    /**
     *
     * @param arr 数组
     * @param candy 分到的糖数目
     * @param sum 糖总和数目
     * @param num 人数总和
     */
    public int[] addCandy(int[] arr, int candy, int sum, int num){
        for(int i=0; i<arr.length; i++){
            System.out.println("c:" + candy);
            System.out.println("s:" + sum);
            if((sum + candy) >= num){
                candy = num - sum;
            }

            arr[i] += candy;

            System.out.println("arr[" + i + "]:" + arr[i]);
            sum += candy;
            if(sum >= num){
                break;
            }
            candy++;

            System.out.println("c:" + candy);
            System.out.println("s:" + sum);
            System.out.println("---------");

            if(i == (arr.length-1)){
                addCandy(arr, candy, sum, num);
            }

        }
        return arr;
    }
}

