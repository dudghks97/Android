package com.example.choicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.group);
        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);

        if (checkbox.isChecked())
            group.setVisibility(View.VISIBLE);
        else {
            group.setVisibility(View.INVISIBLE);
            imgView.setVisibility(View.INVISIBLE);
        }
    }

    public void onClick(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.group);
        ImageView imgView = (ImageView) findViewById(R.id.imgView);
        Drawable drawable;

        imgView.setVisibility(View.VISIBLE);

        switch (group.getCheckedRadioButtonId()) {
            case R.id.dog:
                drawable = getResources().getDrawable(R.drawable.dog);
                imgView.setImageDrawable(drawable);
                break;

            case R.id.cat:
                drawable = getResources().getDrawable(R.drawable.cat);
                imgView.setImageDrawable(drawable);
                break;

            case R.id.duck:
                drawable = getResources().getDrawable(R.drawable.duck);
                imgView.setImageDrawable(drawable);
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "동물을 선택하세요.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}