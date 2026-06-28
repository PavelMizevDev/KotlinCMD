//By Roit-liasp

package com.calib;

public class CaLib {
    private String expression;
    private int position;

    public static double calculate(String expr) {
        return new CaLib(expr).evaluate();
    }

    private CaLib(String expr) {
        this.expression = expr.replaceAll("\\s+", "");
        this.position = 0;
    }

    private double evaluate() {
        double result = parseAddSubtract();
        if (position < expression.length()) {
            throw new IllegalArgumentException("Unexpected character at position " + position);
        }
        return result;
    }

    private double parseAddSubtract() {
        double result = parseMultiplyDivide();

        while (position < expression.length() && 
               (expression.charAt(position) == '+' || expression.charAt(position) == '-')) {
            char op = expression.charAt(position);
            position++;
            double right = parseMultiplyDivide();

            if (op == '+') {
                result += right;
            } else {
                result -= right;
            }
        }

        return result;
    }

    private double parseMultiplyDivide() {
        double result = parsePower();

        while (position < expression.length() && 
               (expression.charAt(position) == '*' || expression.charAt(position) == '/')) {
            char op = expression.charAt(position);
            position++;
            double right = parsePower();

            if (op == '*') {
                result *= right;
            } else {
                if (right == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                result /= right;
            }
        }

        return result;
    }

    private double parsePower() {
        double result = parseNumber();

        while (position < expression.length() && expression.charAt(position) == '^') {
            position++;
            double exponent = parseNumber();
            result = Math.pow(result, exponent);
        }

        return result;
    }

    private double parseNumber() {
        if (position < expression.length() && expression.charAt(position) == '(') {
            position++;
            double result = parseAddSubtract();
            if (position >= expression.length() || expression.charAt(position) != ')') {
                throw new IllegalArgumentException("Expected ')'");
            }
            position++;
            return result;
        }

        if (position < expression.length() && expression.charAt(position) == '-') {
            position++;
            return -parseNumber();
        }

        if (position < expression.length() && expression.charAt(position) == '+') {
            position++;
            return parseNumber();
        }

        return parseDouble();
    }

    private double parseDouble() {
        if (position >= expression.length()) {
            throw new IllegalArgumentException("Expected number");
        }

        int start = position;
        boolean hasDecimal = false;

        while (position < expression.length()) {
            char c = expression.charAt(position);
            
            if (Character.isDigit(c)) {
                position++;
            } else if (c == '.' && !hasDecimal) {
                hasDecimal = true;
                position++;
            } else {
                break;
            }
        }

        if (start == position) {
            throw new IllegalArgumentException("Expected number at position " + position);
        }

        try {
            return Double.parseDouble(expression.substring(start, position));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + expression.substring(start, position));
        }
    }
}
