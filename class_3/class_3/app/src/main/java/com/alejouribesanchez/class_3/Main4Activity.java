package com.alejouribesanchez.class_3;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group_radiobutton);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadio = radioGroup.getCheckedRadioButtonId();
                String opt;
                switch (idRadio){
                    case R.id.radio1:
                        opt = "option1";
                        break;
                    case R.id.radio2:
                        opt = "option2";
                        break;
                    case R.id.radio3:
                        opt = "option3";
                        break;
                    case R.id.radio4:
                        opt = "option4";
                        break;
                    default:
                        opt = "option1";
                        break;
                }

                Intent dataBack = new Intent();
                dataBack.putExtra(Main4Activity.class.getSimpleName(),opt);
                setResult(RESULT_OK);
                finish();
            }
        });

    }
}
