package CalculatePackTest;



import zju.fes.exp.Calculator;
import zju.fes.exp.IllegalExpressionException;
import zju.fes.exp.IncalculableExpressionException;
import zju.fes.exp.UnknownOperatorException;

import java.util.HashMap;
import java.util.Map;

public class CalculatePackTest {
    public static void main(String[] args) throws IncalculableExpressionException, IllegalExpressionException, UnknownOperatorException {
        Calculator calculator = new Calculator();
//        String formula = "(var(11071001400313)+var(11071001400314))/1000";
//        String formula = "(100-20)>99";
//        String formula = "((100-20)>99) * ((var(11071001400313)+var(11071001400314))/1000)";
//        String formula = "(100-20) > 99 * ((var(11071001400313)+var(11071001400314))/1000)";
//        String formula = "0 * ((var(11071001400313)+var(11071001400314))/1000)";
//        String formula = "(var(1003400111020)==1)||(var(1003400111020)==2)";
//        String formula = "var(1003400111020)!=0";
        String formula = "(var(11081001300118)==7002)||(var(11081001300118)==7004)||(var(11081001300118)==7005)||(var(11081001300118)==7016)";
//        String formula = "var(1003400112020)==1";
        Map<String, Number> map = new HashMap<>();
        map.put("11081001300118", 7016);
//        System.out.println(calculator.eval(formula, map));
        Double result = calculator.eval(formula, map).doubleValue();
        System.out.println(result);
    }
}
