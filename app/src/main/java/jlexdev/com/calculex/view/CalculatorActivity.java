package jlexdev.com.calculex.view;

import android.os.Bundle;

/** Refactor > Migrate to AndroidX... */
import androidx.appcompat.app.AppCompatActivity;

import jlexdev.com.calculex.R;
import jlexdev.com.calculex.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayFragment displayFragment = (DisplayFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_display);

        InputFragment inputFragment = (InputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_input);


        CalculatorPresenter calculatorPresenter = new CalculatorPresenter(displayFragment);
        displayFragment.setDisplayToPresenter(calculatorPresenter);
        inputFragment.setInputToPresenter(calculatorPresenter);

    }
}
