package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalcActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Double num1 = intent.getDoubleExtra("NUM1", 0);
                Double num2 = intent.getDoubleExtra("NUM2", 0);

                intent.putExtra("ADD", num1 + num2);
                intent.putExtra("SUB", num1 - num2);
                intent.putExtra("MUL", num1 * num2);
                intent.putExtra("DIV", num1 / num2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
