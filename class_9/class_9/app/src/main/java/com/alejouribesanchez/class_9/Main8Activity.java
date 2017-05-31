package com.alejouribesanchez.class_9;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {

    private FABToolbarLayout morph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        morph = (FABToolbarLayout) findViewById(R.id.fabtoolbar);

        View uno, dos, tres, cuatro, button;

        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        cuatro = findViewById(R.id.cuatro);
        tres = findViewById(R.id.tres);
        button = findViewById(R.id.button);

        fab.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            morph.show();
        }else if(v.getId()==R.id.button) {
            startActivity(new Intent(Main8Activity.this, Main9Activity.class));
        }

        morph.hide();
    }
}
