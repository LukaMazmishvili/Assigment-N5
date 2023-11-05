package com.example.luka_mazmishvili_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.luka_mazmishvili_5.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ActivitySecond : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        var name: String? = ""

        if (bundle != null) {
            name = bundle.getString("NAME")
        }

        with(binding) {

            btnNext.setOnClickListener {

                val lastName = etSurname.text.toString()

                val intent = Intent(this@ActivitySecond, ActivityThird::class.java)
                intent.putExtra("NAME", name)
                intent.putExtra("LASTNAME", lastName)
                startActivity(intent)
            }
        }
    }
}