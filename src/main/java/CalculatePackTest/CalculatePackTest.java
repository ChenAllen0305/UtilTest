//package CalculatePackTest;
//
//
//
//import zju.fes.exp.Calculator;
//import zju.fes.exp.IllegalExpressionException;
//import zju.fes.exp.IncalculableExpressionException;
//import zju.fes.exp.UnknownOperatorException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class CalculatePackTest {
//    public static void main(String[] args) throws IncalculableExpressionException, IllegalExpressionException, UnknownOperatorException {
//        Calculator calculator = new Calculator();
////        String formula = "(var(11071001400313)+var(11071001400314))/1000";
////        String formula = "(100-20)>99";
////        String formula = "((100-20)>99) * ((var(11071001400313)+var(11071001400314))/1000)";
////        String formula = "(100-20) > 99 * ((var(11071001400313)+var(11071001400314))/1000)";
////        String formula = "0 * ((var(11071001400313)+var(11071001400314))/1000)";
//        String formula = "var(11042001300169)==1&var(11042001300167)==1";
//        String formula1 = "(var(11042001300169)@1==1)&(var(11042001300169)@2==1)";
//        String formula2 = "(var(11041001400110018)@1==0)&(var(11041001400110018)@2==1)";
//        String formula3 = "(var(11042001300169)-var(110890001001))<1800000";
////        String formula = "var(1003400111020)!=0";
////        String formula = "(var(11081001300118)==7002)||(var(11081001300118)==7004)||(var(11081001300118)==7005)||(var(11081001300118)==7016)";
////        String formula = "var(1003400112020)==1";
//        Map<String, Number> map = new HashMap<>();
//        map.put("11042001300169", 1614089700000d);
//        map.put("110890001001", 1614132533586d);
//        System.out.println(calculator.eval(formula3, map));
//
////        Map<String, Number> map2 = new HashMap<>();
////        map2.put("11081001300118", System.currentTimeMillis());
////        String foumula2 = "1";
////        Double result2 = calculator.eval(foumula2, map2).doubleValue();
////        System.out.println(result2);
//    }
//}
