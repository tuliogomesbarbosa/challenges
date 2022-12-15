// Importing required functions
import java.util.*;

class EvalRPN {

    private static Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String[] args) {
        evalRPN(new String[] {"4", "13", "5", "/", "+"});
    }

    public static int evalRPN(String[] tokens) {
        //
        Stack<Integer> operands = new Stack<Integer>();
        // 6 -12 *  2 7 - / 7 +
        // "4", "13", "5", "/", "+"
        for(String token : tokens) {
            if(!operators.contains(token)) {
                operands.push(Integer.valueOf(token));
                continue;
            }


            int operand2 = operands.pop();
            int operand1 = operands.pop();
            // System.out.printf("token %s, operands %d %d\n", token, operand1, operand2);

            int result = 0;
            switch(token) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }

            // System.out.println("Adding again to the stack");
            operands.push(result);
        }

        return operands.pop();
    }
}
