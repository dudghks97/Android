package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    static final int GET_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cal_button = (Button) findViewById(R.id.cal_button);
        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_num1 = (EditText) findViewById(R.id.edit_num1);
                EditText edit_num2 = (EditText) findViewById(R.id.edit_num2);
                RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radio_group);

                String s_num1 = edit_num1.getText().toString();
                String s_num2 = edit_num2.getText().toString();

                if (s_num1.length() <= 0 || s_num2.length() <= 0) {
                    Toast.makeText(getApplicationContext(), "빈칸이 존재합니다.", Toast.LENGTH_SHORT).show();
                }
                else if (radiogroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "연산이 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Double num1 = Double.valueOf(s_num1);
                    Double num2 = Double.valueOf(s_num2);

                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra("NUM1", num1);
                    intent.putExtra("NUM2", num2);
                    startActivityForResult(intent, GET_RESULT);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_RESULT){
            if(resultCode == RESULT_OK) {
                double result = 0;
                RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radio_group);

                switch(radiogroup.getCheckedRadioButtonId()){
                    case R.id.add:
                        result = data.getDoubleExtra("ADD", 0);
                        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sub:
                        result = data.getDoubleExtra("SUB", 0);
                        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mul:
                        result = data.getDoubleExtra("MUL", 0);
                        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.div:
                        result = data.getDoubleExtra("DIV", 0);
                        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "계산 실패!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }
}