package jlexdev.com.calculex.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jlexdev.com.calculex.ICalculatorContract;
import jlexdev.com.calculex.R;


public class DisplayFragment extends Fragment implements ICalculatorContract.View {

    private ICalculatorContract.DisplayToPresenter displayToPresenter;

    // ¿Para qué sirve este SET?
    public void setDisplayToPresenter(ICalculatorContract.DisplayToPresenter displayToPresenter) {
        this.displayToPresenter = displayToPresenter;
    }

    /** Butterknife */

    @BindView(R.id.tv_display)
    TextView tvDisplay;

    @OnClick(R.id.ibtn_menu)
    public void onMenuClick(Button b) {
        displayToPresenter.onMenuClick();
    }

    /** ----------- */


    public DisplayFragment() {
        // Required empty public constructor
    }


    // Return a new Instance
    public static DisplayFragment newInstance() {
        return new DisplayFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_display, container, false);

        ButterKnife.bind(this, v);
        return v;
    }



    @Override
    public void showResult(String result) {
        tvDisplay.setText(result);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
