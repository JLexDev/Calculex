package jlexdev.com.calculex;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

/**
 * Created by JLex on 2019-08-02
 */
public class Calculation {

    private final Symbols symbols;

    private CalculationResult calculationResult;

    private static String currentExpression;

    // Interface
    public interface CalculationResult {
        void onExpressionChanged(String result, boolean successful);
    }

    // ¿SET?
    public void setCalculationResultListener(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
        currentExpression = "";
    }

    // Init Symbols
    public Calculation() {
        symbols = new Symbols();
    }

    /**
     * Delete a single character from currentExpression, unless empty
     * "" - invalid
     * 123 - valid
     * 12*34 - valid
     */
    public void cleanCharacter() {
        if (currentExpression.length() > 0) {
            currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
            calculationResult.onExpressionChanged(currentExpression, true);
        } else {
            calculationResult.onExpressionChanged("Invalid Input", false);
        }
    }

    /**
     * Delete entire expression, unless empty
     * "" - invalid
     */
    public void cleanExpression() {
        if (currentExpression.equals("")) {
            calculationResult.onExpressionChanged("Invalid Input", false);
        } // ¿Porqué no va un 'else'?
        currentExpression = "";
        calculationResult.onExpressionChanged(currentExpression, true);
    }

    /**
     * Append number to currentExpression if valid:
     * "0" & number is 0 - invalid
     * "12345678901234567" - invalid (Max 16 dig)
     */
    public void appendNumber(String number) {
        if (currentExpression.startsWith("0") && number.equals("0")) {
            calculationResult.onExpressionChanged("Invalid", false);
        } else {
            if (currentExpression.length() <= 16) {
                currentExpression += number;
                calculationResult.onExpressionChanged(currentExpression, true);
            } else {
                calculationResult.onExpressionChanged("Expression too long", false);
            }
        }
    }

    /**
     * Append an operator to currentExpression, if valid:
     * 34 - valid
     * 34* - invalid
     * 34*5 - valid
     * "" - invalid
     */
    public void appendOperator(String operator) {
        if (validateExpression(currentExpression)) {
            currentExpression += operator;
            calculationResult.onExpressionChanged(currentExpression, true);
        }
    }

    /**
     * See type comment for appendOperator
     */
    public void appendDecimal() {
        if (validateExpression(currentExpression)) {
            currentExpression += ".";
            calculationResult.onExpressionChanged(currentExpression, true);
        }
    }

    /**
     * If currentExpression passes on checks, pass currentExpression to symbols object,
     * then return the result
     */
    public void performEvaluation() {
        if (validateExpression(currentExpression)) {
            try {
                Double result = symbols.eval(currentExpression);
                currentExpression = Double.toString(result);
                calculationResult.onExpressionChanged(currentExpression, true);
            } catch (SyntaxException e) {
                calculationResult.onExpressionChanged("Invalid input", false);
                e.printStackTrace();
            }
        }
    }

    /**
     * Helper functions to validate expressions against the following checks:
     * "" - invalid
     * 9876 - valid
     * @param expression
     * @return
     */
    public boolean validateExpression(String expression) {
        if (expression.endsWith("/") || expression.endsWith("*") ||
            expression.endsWith("-") || expression.endsWith("+")) {
            calculationResult.onExpressionChanged("Invalid input", false);
            return false;
        } else if (expression.equals("")) {
            calculationResult.onExpressionChanged("Empty expression", false);
            return false;
        } else if (expression.length() > 16) {
            calculationResult.onExpressionChanged("Expression too long", false);
            return false;
        } else {
            return true;
        }
    }

}
