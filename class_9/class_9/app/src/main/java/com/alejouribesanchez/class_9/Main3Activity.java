package com.alejouribesanchez.class_9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    ListView listView;
    LeadsAdapterHolder adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = (ListView) findViewById(R.id.leads_list);
        adapter = new LeadsAdapterHolder(this, LeadsRepository.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Lead tempLead = (Lead)adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),"Iniciar screen de detalle para: \n" + tempLead.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        View view = (View) findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,Main4Activity.class));
            }
        });

    }
}
