package com.example.bottomsheetejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBottomSheet = findViewById<Button>(R.id.btn_bottom_sheet)
        val b = 2

        btnBottomSheet.setOnClickListener {
            val bottomSheetFragment = MiBottomSheet()
            bottomSheetFragment.show(supportFragmentManager, "BS")
        }
    }
}