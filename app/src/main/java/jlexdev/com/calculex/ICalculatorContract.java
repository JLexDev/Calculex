package jlexdev.com.calculex;

public interface ICalculatorContract {

    // View handles these methods
    interface View {
        void showResult(String result);
        void showMessage(String message);
    }

    // From View (DisplayFragment) to the Presenter
    interface DisplayToPresenter {
        void onMenuClick();
    }

    // From View (InputFragment) to the Presenter
    interface InputToPresenter {
        void onNumberClick(int number);
        void onOperatorClick(String operator);
        void onDecimalClick();
        void onEvaluateClick();

        void onCleanClick();
        void onCleanLongClick();
    }


}
