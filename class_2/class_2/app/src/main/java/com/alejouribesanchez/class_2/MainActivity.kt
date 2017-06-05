package com.alejouribesanchez.class_2

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get resources
        val resources = resources
        val appName = resources.getString(R.string.app_name)

        //Get Color
        val color = resources.getColor(R.color.colorAccent)
        val color2 = ContextCompat.getColor(this,R.color.colorPrimary)

        //Get Drawable
        val drawable = resources.getDrawable(R.mipmap.ic_launcher)
        val drawable2 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher)

        //Strings
        val text1 = resources.getString(R.string.example)
        val textView = findViewById(R.id.text_view_example) as TextView
        textView.text = text1

        val textViewPlurals = findViewById(R.id.text_view_plurals) as TextView

        //Strings-Plurals
        val random = Random()
        val amount = random.nextInt(9)

        if (amount == 0) {
            textViewPlurals.setText(R.string.zero)
        } else {
            val res = getResources()
            val string = res.getQuantityString(R.plurals.found_product, amount, amount)
            textView.text = string
        }


        //Strings Format
        val res = getResources()
        val recurso = res.getString(R.string.string_formate)
        val stringFormate = String.format(recurso, "James", 120)
        val textView2 = findViewById(R.id.text_view_example2) as TextView
        textView2.text = stringFormate


        //String html
        val text2 = res.getString(R.string.string_html)
        val textoInterpretado = Html.fromHtml(text2)
        val textView3 = findViewById(R.id.text_view_example3) as TextView
        textView3.text = textoInterpretado


        //String html data
        val text3 = res.getString(R.string.string_html_cdata)
        val textView4 = findViewById(R.id.text_view_example4) as TextView
        val textoInterpretado2 = Html.fromHtml(text3)
        textView4.text = textoInterpretado2


        //String spannable
        val textView5 = findViewById(R.id.text_view_example5) as TextView
        val stringBuilder2 = SpannableStringBuilder(getString(R.string.spannable)) //getString
        val stringBuilder = SpannableStringBuilder(getResources().getString(R.string.spannable))
        stringBuilder.setSpan(StyleSpan(Typeface.BOLD), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView5.text = stringBuilder


    }
}
