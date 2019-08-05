package jlexdev.com.calculex;

public interface ICalculatorContract {

    // View handles these methods
    interface View {
        void showResult(String result);
        void showMessage(String message);
    }

    // From View (DisplayFragment) to the Presenter
    interface DisplayToPresenter {
        void onMenuClick();                     // showMenu()
    }

    // From View (InputFragment) to the Presenter
    interface InputToPresenter {
        void onNumberClick(int number);         // appendNumber()
        void onOperatorClick(String operator);  // appendOperator()
        void onDecimalClick();                  // appendDecimal()
        void onEvaluateClick();                 // performEvaluation()

        void onCleanClick();                    // cleanCharacter()
        void onCleanLongClick();                // cleanExpression()

        //void onExpressionChanged(String result, boolean successful); // ...(String result)
    }


    /* Model
    interface CalculationResult {               // Model
        void onExpressionChanged(String result, boolean successful);  // ...(String result)
    }*/

}
