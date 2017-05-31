package com.alejouribesanchez.class_9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.leads_list);

        String[] leadsNames = {
                "Alexander Pierrot",
                "Carlos Lopez",
                "Sara Bonz",
                "Liliana Clarence",
                "Benito Peralta",
                "Juan Jaramillo",
                "Christian Steps",
                "Alexa Giraldo",
                "Linda Murillo",
                "Lizeth Astrada"
        };

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, leadsNames);
        listView.setAdapter(arrayAdapter);

        View view = findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

        View view2 = findViewById(R.id.button2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setDivider(null);
            }
        });

    }
}
