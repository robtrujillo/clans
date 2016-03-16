/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator.Main;

import java.util.Stack;

/**
 * This class is a calculator class, it will take in a String of calculation and
 * calculates them using a stack
 *
 * @author Chuntak
 */
public class Calculator {

    private static final String OPERATORS = "+-/*()";


    public static double calculate(String operateString) {
        double num1, num2;
        String operator;
        boolean operateImmediately = false;
        String operate[] = operateString.split(" ");
        Stack<String> operands = new Stack<String>();
        Stack<String> operators = new Stack<String>();

        for (int x = 0; x < operate.length; x++) {
            //PUSHES THEM INTO EITHER OPERANDS OR OPERATORS STACK
            if (isOperator(operate[x])) {
                operators.push(operate[x]);
                if (isPriority(operate[x])) {
                    operateImmediately = true;
                }
            } else {
                operands.push(operate[x]);

                //OPERATE WHEN MULTIPLICATION OR DIVISION
                if (operateImmediately) {
                    num2 = Double.parseDouble(operands.pop());
                    num1 = Double.parseDouble(operands.pop());
                    operator = operators.pop();
                    operands.push("" + evaluate(num1, num2, operator));
                    operateImmediately = false;
                }
            }
        }

        while (operands.size() > 1) {
            num2 = Double.parseDouble(operands.pop());
            num1 = Double.parseDouble(operands.pop());
            operator = operators.pop();
            operands.push("" + evaluate(num1, num2, operator));
        }

        return Double.parseDouble(operands.pop());
    }

    //*******************************
    //PRIVATE HELPER METHODS
    //*******************************
    private static boolean isOperator(String operate) {
        return OPERATORS.indexOf(operate) >= 0;
    }

    //CHECKS IF ITS MULTIPLCATION OR DIVISION
    private static boolean isPriority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return true;
        }
        return false;
    }

    //CALCULATES THE NUMBERS
    private static double evaluate(double operand1, double operand2, String operator) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else {
            return -1;
        }
    }
}
