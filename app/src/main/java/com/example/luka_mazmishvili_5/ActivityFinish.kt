package com.example.luka_mazmishvili_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.luka_mazmishvili_5.databinding.ActivityFinishBinding

class ActivityFinish : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {
            val name: String? = bundle.getString("NAME")
            val lastName: String? = bundle.getString("LASTNAME")
            val idNum: String? = bundle.getString("IDNUM")

            val result = "Name: $name \nLastName: $lastName \nIDNum: $idNum"
            binding.tvResult.text = result
        }
    }
}