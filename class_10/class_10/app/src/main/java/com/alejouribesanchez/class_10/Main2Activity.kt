package com.alejouribesanchez.class_10

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class Main2Activity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var gridView: GridView? = null
    private var adaptador: AdaptadorDeCoches? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        usarToolbar()

        gridView = findViewById(R.id.grid) as GridView
        adaptador = AdaptadorDeCoches(this)
        gridView!!.adapter = adaptador
        gridView!!.onItemClickListener = this
    }

    private fun usarToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val item = parent.getItemAtPosition(position) as Coche

        val intent = Intent(this, ActividadDetalle::class.java)
        intent.putExtra(ActividadDetalle.EXTRA_PARAM_ID, item.id)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair(view.findViewById(R.id.imagen_coche),
                            ActividadDetalle.VIEW_NAME_HEADER_IMAGE)
            )

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
        } else
            startActivity(intent)
    }

}
