package com.example.luka_mazmishvili_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.luka_mazmishvili_5.databinding.ActivityMainBinding
import com.example.luka_mazmishvili_5.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val timeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            updateTime()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(timeReceiver, intentFilter)
        updateTime()
    }

    private fun listeners() {
        with(binding){
            btnNext.setOnClickListener {
                val name = etName.text.toString().trim()
                val intent = Intent(this@MainActivity, ActivitySecond::class.java)
                intent.putExtra("NAME", name)
                startActivity(intent)
            }
        }
    }

    private fun updateTime() {
        val currentTime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(Date())
        binding.tvTime.text = currentTime
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeReceiver)
    }
}