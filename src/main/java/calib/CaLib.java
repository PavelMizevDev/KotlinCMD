//By Roit-liasp

package calib;

public class CaLib {
    private String expression;
    private int position;

    public static double calculate(String expr) {
        return new CaLib(expr).evaluate();
    }

    private CaLib(String expr) {
        if (expr == null) {
            throw new IllegalArgumentException("Expression cannot be null");
        }
        this.expression = expr.replaceAll("\\s+", "");
        this.position = 0;
    }

    private double evaluate() {
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Expression is empty");
        }
        double result = parseAddSubtract();
        if (position < expression.length()) {
            throw new IllegalArgumentException("Unexpected character at position " + position);
        }
        if (Double.isNaN(result)) {
            throw new IllegalArgumentException("Result is not a real number");
        }
        if (Double.isInfinite(result)) {
            throw new IllegalArgumentException("Result overflowed to infinity");
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

    // Pinis >_<

    private double parseMultiplyDivide() {
        double result = parseUnary();

        while (position < expression.length() && (expression.charAt(position) == '*' || expression.charAt(position) == '/')) {
            char op = expression.charAt(position);
            position++;
            double right = parseUnary();

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

    private double parseUnary() {
        if (position < expression.length() && expression.charAt(position) == '-') {
            position++;
            return -parseUnary();
        }
        if (position < expression.length() && expression.charAt(position) == '+') {
            position++;
            return parseUnary();
        }
        return parsePower();
    }

    private double parsePower() {
        double base = parsePrimary();

        if (position < expression.length() && expression.charAt(position) == '^') {
            position++;
            double exponent = parseUnary();
            return calculatePower(base, exponent);
        }

        return base;
    }

    private double calculatePower(double base, double exponent) {
        if (base == 0.0 && exponent == 0.0) {
            throw new IllegalArgumentException("Zero to the power of zero is undefined");
        }
        if (base == 0.0 && exponent < 0) {
            throw new IllegalArgumentException("Division by zero");
        }

        double result = Math.pow(base, exponent);

        if (Double.isNaN(result)) {
            throw new IllegalArgumentException("Result is not a real number");
        }
        if (Double.isInfinite(result)) {
            throw new IllegalArgumentException("Result overflowed");
        }

        return result;
    }

    private double parsePrimary() {
        if (position < expression.length() && expression.charAt(position) == '(') {
            position++;
            double result = parseAddSubtract();
            if (position >= expression.length() || expression.charAt(position) != ')') {
                throw new IllegalArgumentException("Expected ')'");
            }
            position++;
            return result;
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
