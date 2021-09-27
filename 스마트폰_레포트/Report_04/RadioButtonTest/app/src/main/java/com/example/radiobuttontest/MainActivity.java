package com.example.radiobuttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        EditText edit_num1 = (EditText) findViewById(R.id.num1);
        EditText edit_num2 = (EditText) findViewById(R.id.num2);

        String s_num1 = edit_num1.getText().toString();
        String s_num2 = edit_num2.getText().toString();

        if (s_num1.length() <= 0 || s_num2.length() <= 0)
            Toast.makeText(getApplicationContext(),
                    "빈칸이 존재합니다.", Toast.LENGTH_SHORT).show();
        else {
            Integer num1 = Integer.parseInt(s_num1);
            Integer num2 = Integer.parseInt(s_num2);

            RadioGroup radio_group = (RadioGroup) findViewById(R.id.radio_group);
            switch (radio_group.getCheckedRadioButtonId()) {
                case R.id.add:
                    Toast.makeText(getApplicationContext(),
                            String.valueOf(num1 + num2), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sub:
                    Toast.makeText(getApplicationContext(),
                            String.valueOf(num1 - num2), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mul:
                    Toast.makeText(getApplicationContext(),
                            String.valueOf(num1 * num2), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.div:
                    Toast.makeText(getApplicationContext(),
                            String.valueOf(num1 / num2), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(getApplicationContext(),
                            "연산을 선택하지 않았습니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}