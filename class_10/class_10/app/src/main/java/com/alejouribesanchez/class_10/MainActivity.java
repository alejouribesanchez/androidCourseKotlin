package com.alejouribesanchez.class_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNombre;
    private TextInputLayout tilTelefono;
    private TextInputLayout tilCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Referencias TILs
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_telefono);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        Button botonAceptar = (Button)findViewById(R.id.boton_aceptar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/*    Nombre: Solo caracteres alfabéticos con un tamaño máximo de 30.
    Teléfono: Solo caracteres numéricos con un tamaño estándar de 7.
    Email: Secuencia de caracteres que cumplan la sintaxis de correos electrónicos.*/

    private boolean validarNombre(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        return patron.matcher(nombre).matches() || nombre.length() > 30;
    }

    private boolean validarTelefono(String telefono){
        return Patterns.PHONE.matcher(telefono).matches();
    }

    private boolean validarCorreo(String correo){
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }


    private void validarDatos() {
        String nombre = tilNombre.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();
        String correo = tilCorreo.getEditText().getText().toString();

        boolean a = validarNombre(nombre);
        boolean b = validarTelefono(telefono);
        boolean c = validarCorreo(correo);

        if (a && b && c) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show();

        }else{
            tilNombre.setError(null);
            tilCorreo.setError(null);
            tilTelefono.setError(null);
            if(!a){tilNombre.setError("Nombre no Válido");}
            if(!b){tilTelefono.setError("Telefono no Válido");}
            if(!c){tilCorreo.setError("Correo no Válido");}
        }

    }


}
