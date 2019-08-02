package jlexdev.com.calculex.view;

import android.os.Bundle;

/** Refactor > Migrate to AndroidX... */
import androidx.appcompat.app.AppCompatActivity;

import jlexdev.com.calculex.R;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
