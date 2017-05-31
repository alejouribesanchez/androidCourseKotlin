package com.alejouribesanchez.class_3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    public static int REQUEST_CODE = 1;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra(Main2Activity.class.getName()));

        Uri webpage = Uri.parse("http://yuxiglobal.com/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

        // Verificar si hay aplicaciones disponibles
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;
        // Si hay, entonces ejecutamos la actividad
        if (isIntentSafe) {
            Log.d("CLASS_3", String.valueOf(activities.size()));
        }

        final Intent intent = new Intent(this, Main4Activity.class);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && requestCode==RESULT_OK){
            String result = data.getStringExtra(Main4Activity.class.getSimpleName());
            textView.setText(result);
        }

    }
}