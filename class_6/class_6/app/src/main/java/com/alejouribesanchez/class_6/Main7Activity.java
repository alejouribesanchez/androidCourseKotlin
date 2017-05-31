package com.alejouribesanchez.class_6;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        EditText editUsername = (EditText) findViewById(R.id.username);

        editUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // ¿v tiene el foco?
                if(hasFocus){
                    ImageView iconoDescuento = (ImageView) findViewById(R.id.ic_account);
                    Drawable d = iconoDescuento.getDrawable();

                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d,
                            ContextCompat.getColor(Main7Activity.this, R.color.colorAccent));

                }
            }
        });
    }

}
