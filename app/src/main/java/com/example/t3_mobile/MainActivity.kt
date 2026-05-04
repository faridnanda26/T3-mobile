package com.example.t3_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inNama = findViewById<EditText>(R.id.inNama)

        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbGaming = findViewById<CheckBox>(R.id.cbGaming)

        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)

        val hasil = findViewById<TextView>(R.id.hasil)

        cbMembaca.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Membaca dipilih", Toast.LENGTH_SHORT).show()
            }
        }

        cbCoding.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Coding dipilih", Toast.LENGTH_SHORT).show()
            }
        }

        cbGaming.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Gaming dipilih", Toast.LENGTH_SHORT).show()
            }
        }

        btnTampilkan.setOnClickListener {
            val nama = inNama.text.toString().trim()

            // Validasi input
            if (nama.isEmpty()) {
                inNama.error = "Nama tidak boleh kosong"
                inNama.requestFocus()
                return@setOnClickListener
            }

            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedGenderId)
                selectedRadioButton.text.toString()
            } else {
                "Tidak dipilih"
            }

            val selectedHobbies = mutableListOf<String>()
            if (cbMembaca.isChecked) selectedHobbies.add("Membaca")
            if (cbCoding.isChecked) selectedHobbies.add("Coding")
            if (cbGaming.isChecked) selectedHobbies.add("Gaming")

            val hasilText = """
                Nama   : $nama
                Kelamin: $gender
                Hobi   : ${selectedHobbies.joinToString()}
            """.trimIndent()

            hasil.text = hasilText
            hasil.setBackgroundColor(android.graphics.Color.parseColor("#c7d5ff"))
            hasil.setTypeface(null, android.graphics.Typeface.NORMAL)
            hasil.setTextColor(android.graphics.Color.parseColor("#000"))
        }
    }
}