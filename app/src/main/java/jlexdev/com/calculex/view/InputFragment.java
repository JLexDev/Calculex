package jlexdev.com.calculex.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import jlexdev.com.calculex.ICalculatorContract;
import jlexdev.com.calculex.R;


public class InputFragment extends Fragment {

    private ICalculatorContract.InputToPresenter inputToPresenter;

    // ¿Para qué sirve este SET?
    public void setInputToPresenter(ICalculatorContract.InputToPresenter inputToPresenter) {
        this.inputToPresenter = inputToPresenter;
    }

    /** Butterknife */

    @OnClick({R.id.btn_number_1, R.id.btn_number_2, R.id.btn_number_3, R.id.btn_number_4,
            R.id.btn_number_5, R.id.btn_number_6, R.id.btn_number_7, R.id.btn_number_8,
            R.id.btn_number_9, R.id.btn_number_0,})
    public void onNumberClick(Button b) {
        inputToPresenter.onNumberClick(
                Integer.parseInt(b.getText().toString())
        );
    }


    @OnClick({R.id.btn_divide, R.id.btn_multiplication, R.id.btn_substraction, R.id.btn_addition})
    public void onOperatorClick(Button b) {
        inputToPresenter.onOperatorClick(b.getText().toString());
    }


    @OnClick({R.id.btn_dot})
    public void onDecimalClick(Button b) {
        inputToPresenter.onDecimalClick();
    }


    @OnClick({R.id.btn_equal})
    public void onEvaluateClick(Button b) {
        inputToPresenter.onEvaluateClick();
    }


    @OnClick({R.id.btn_clean})
    public void onCleanClick(View v) {
        inputToPresenter.onCleanClick();
    }


    @OnLongClick({R.id.btn_clean})
    public boolean onCleanLongClick(View v) {
        inputToPresenter.onCleanLongClick();
        return true;
    }


    /** ----------- */


    public InputFragment() {
        // Required empty public constructor
    }


    // Return a new Instance
    public static InputFragment newInstance() {
        return new InputFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        // Binding Butterknife
        ButterKnife.bind(this, v);
        return v;
    }


}
