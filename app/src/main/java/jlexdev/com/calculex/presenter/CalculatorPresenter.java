package jlexdev.com.calculex.presenter;

import jlexdev.com.calculex.ICalculatorContract;

/**
 * Created by JLex on 2019-08-01
 */

public class CalculatorPresenter implements ICalculatorContract.DisplayToPresenter,
                                            ICalculatorContract.InputToPresenter {

    private ICalculatorContract.View view;

    public CalculatorPresenter(ICalculatorContract.View view) {
        this.view = view;
    }

    @Override
    public void onMenuClick() {

    }

    @Override
    public void onNumberClick(int number) {

    }

    @Override
    public void onOperatorClick(String operator) {

    }

    @Override
    public void onDecimalClick() {

    }

    @Override
    public void onEvaluateClick() {

    }

    @Override
    public void onCleanClick() {

    }

    @Override
    public void onCleanLongClick() {

    }
}
