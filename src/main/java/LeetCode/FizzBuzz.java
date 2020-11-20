package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int num = 15;
        for(int i=1; i<= num; i++){
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if(i % 3 == 0){
                list.add("Fizz");
            } else if(i % 5 == 0){
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}
