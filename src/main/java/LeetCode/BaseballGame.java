package LeetCode;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = new String[]{"5","2","C","D","+"};
        BaseballGame bg = new BaseballGame();
//        System.out.println(bg.calPoints(ops));
        System.out.println(bg.calPoints2(ops));
    }

    /**
     * 暴力破解，无法完善“+”操作内容
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int pointer = 0;
        int sum = 0;
        if(ops.length == 0){
            return 0;
        }
        for(int i=0;i < ops.length; i++){
            if(ops[i].equals("C")){
                sum -= Integer.parseInt(ops[pointer]);
                pointer -= 1;
                if(pointer < 0){
                    pointer = 0;
                }
            } else if(ops[i].equals("D")){
                int count = Integer.parseInt(ops[pointer]);
                sum += 2 * count;
            } else if(ops[i].equals("+")){ // 前两轮有效的得分和
                sum += Integer.parseInt(ops[pointer]);
            } else {
                pointer = i;
                sum += Integer.parseInt(ops[pointer]);
            }
            System.out.println(i + " sum:" + sum);
        }
        return sum;
    }

    public int calPoints2(String[] ops){
        Stack<Integer> stack = new Stack<>();

        for(String op : ops){
            if(op.equals("C")){
                stack.pop(); // 移除顶部对象
            } else if(op.equals("D")){
                stack.push(2 * stack.peek());
            } else if(op.equals("+")){
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        for(int num : stack){
            sum += num;
        }
        return sum;
    }
}
