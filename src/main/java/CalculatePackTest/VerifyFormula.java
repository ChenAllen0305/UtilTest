//package CalculatePackTest;
//
//import zju.fes.exp.Calculator;
//import zju.fes.exp.IllegalExpressionException;
//import zju.fes.exp.IncalculableExpressionException;
//import zju.fes.exp.UnknownOperatorException;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class VerifyFormula {
//    public static void main(String[] args) {
//        List<Long> measPointNumbers = new ArrayList<>();
//        measPointNumbers.add(11041003400111018L);
//        Calculator calculator = new Calculator();
//        String formula = "var(11041003400111018)=1";
//        Map<Long, Double> measPnValue = new HashMap<>();
//        for (Long pointNumber : measPointNumbers) {
//            measPnValue.put(pointNumber, 0 + Math.random() * (10));
//        }
//        //输出并保存计算公式结果值
//        try {
//            Double result = calculator.eval(formula, transferToNumber(measPnValue)).doubleValue();
//            System.out.println(result);
//        } catch (Exception e) {
////            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private static Map<String, Number> transferToNumber(Map<Long, Double> map) {
//        Map<String, Number> result = new HashMap<>();
//        for (Map.Entry entry : map.entrySet()) {
//            result.put(String.valueOf(entry.getKey()), (Number) entry.getValue());
//        }
//        return result;
//    }
//}
