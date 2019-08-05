package jlexdev.com.calculex.presenter;

import jlexdev.com.calculex.Calculation;
import jlexdev.com.calculex.ICalculatorContract;

/**
 * Created by JLex on 2019-08-01
 */

public class CalculatorPresenter implements ICalculatorContract.DisplayToPresenter,
                                            ICalculatorContract.InputToPresenter,
                                            Calculation.CalculationResult {

    private ICalculatorContract.View view;

    private Calculation calc;


    public CalculatorPresenter(ICalculatorContract.View view) {
        this.view = view;

        calc = new Calculation();
        calc.setCalculationResultListener(this);
    }

    @Override
    public void onMenuClick() {

    }

    @Override
    public void onNumberClick(int number) {
        calc.appendNumber(Integer.toString(number));
    }

    @Override
    public void onOperatorClick(String operator) {
        calc.appendOperator(operator);
    }

    @Override
    public void onDecimalClick() {
        calc.appendDecimal();
    }

    @Override
    public void onEvaluateClick() {
        calc.performEvaluation();
    }

    @Override
    public void onCleanClick() {
        calc.cleanCharacter();
    }

    @Override
    public void onCleanLongClick() {
        calc.cleanExpression();
    }

    @Override
    public void onExpressionChanged(String result, boolean successful) {
        if (successful) {
            view.showResult(result);
        } else {
            view.showMessage(result);
        }
    }
}
