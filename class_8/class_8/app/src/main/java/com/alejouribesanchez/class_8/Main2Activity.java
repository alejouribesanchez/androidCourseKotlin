package com.alejouribesanchez.class_8;


import android.content.Intent;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View view = findViewById(R.id.activity_main2);
        textView = (TextView) findViewById(R.id.textView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionBar actionBar = getSupportActionBar();
                if(actionBar.isShowing()){
                    actionBar.hide();
                }
                else{
                    actionBar.show();
                    //actionBar.setIcon(R.drawable.logo);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                //metodoAdd()
                textView.setText("Se presionó Añadir");
                return true;
            case R.id.search:
                //metodoSearch()
                textView.setText("Se presionó Buscar");
                return true;
            case R.id.edit:
                //metodoEdit()
                textView.setText("Se presionó Editar");
                return true;
            case R.id.delete:
                //metodoDelete()
                textView.setText("Se presionó Eliminar");
                return true;
            case R.id.action_settings:
                //metodoSettings()
                textView.setText("Se presionó Ajustes");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
