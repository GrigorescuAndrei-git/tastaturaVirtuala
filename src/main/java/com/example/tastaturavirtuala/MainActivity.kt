package com.example.butoaneapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tastaturavirtuala.R

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var listView: ListView
    private val listaIstoric = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.myEditText)
        listView = findViewById(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaIstoric)
        listView.adapter = adapter

        val butoane = listOf(
            R.id.button16 to "0",
            R.id.button1 to "1",
            R.id.button2 to "2",
            R.id.button3 to "3",
            R.id.button4 to "4",
            R.id.button5 to "5",
            R.id.button6 to "6",
            R.id.button7 to "7",
            R.id.button8 to "8",
            R.id.button9 to "9",
            R.id.button10 to "A",
            R.id.button11 to "B",
            R.id.button12 to "C",
            R.id.button13 to "D",
            R.id.button14 to "E",
            R.id.button15 to "F"
        )

        for ((id, value) in butoane) {
            findViewById<Button>(id).setOnClickListener {
                textView.text = textView.text.toString() + value
            }
        }

        findViewById<Button>(R.id.backButton).setOnClickListener {
            val textActual = textView.text.toString()
            if (textActual.isNotEmpty()) {
                textView.text = textActual.dropLast(1)
            }
        }

        findViewById<Button>(R.id.okButton).setOnClickListener {
            val textActual = textView.text.toString()
            if (textActual.isNotEmpty()) {
                listaIstoric.add(textActual)
                adapter.notifyDataSetChanged()
                textView.text = ""
            }
        }
    }
}