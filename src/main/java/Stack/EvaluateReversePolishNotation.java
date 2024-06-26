package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args){
        EvaluateReversePolishNotation erp = new EvaluateReversePolishNotation();
        int sum = erp.evalRPN_Stack(new String[]{"4","13","5","/","+"});
        System.out.println(sum);
    }

    public int evalRPN_Stack(String[] tokens){
        Stack<Integer> operands = new Stack<>();
        String operatorString = "*/-+";
        for(int i = 0; i < tokens.length; i ++){
            if(operatorString.contains(tokens[i])){
                int value2 = operands.pop();
                int value1 = operands.pop();
                if(tokens[i].equals("*")){
                    operands.push(value1 * value2);
                }else if(tokens[i].equals("/")){
                    operands.push(value1/value2);
                }else if(tokens[i].equals("+")){
                    operands.push(value1 + value2);
                }else if(tokens[i].equals("-")){
                    operands.push(value1 - value2);
                }
            }else{
                operands.add(Integer.valueOf(tokens[i]));
            }
        }
        return operands.pop();
    }

    public int evalRPN(String[] tokens) {
        Queue<Integer> operands = new LinkedList<>();
        Queue<String> operators = new LinkedList<>();
        String operatorString = "*/-+";

        for(int i = 0; i < tokens.length; i ++){
            if(operatorString.contains(tokens[i])){
                operators.add(tokens[i]);
            }else{
                operands.add(Integer.valueOf(tokens[i]));
            }
        }
        int runningCount = evaluateExpression(operands.poll(),operands.poll(), operators.poll());
        while(! operands.isEmpty()){
             runningCount = evaluateExpression(runningCount, operands.poll(), operators.poll());
        }
        return runningCount;
    }

    public int evaluateExpression(int operand1, int operand2, String operator){
        if(operator.equals("*")){
            return operand1* operand2;
        }else if(operator.equals("/")){
            return operand1/operand2;
        }else if(operator.equals("+")){
            return operand1+operand2;
        }else if(operator.equals("-")){
            return operand1-operand2;
        }
        return -1;
    }
}
