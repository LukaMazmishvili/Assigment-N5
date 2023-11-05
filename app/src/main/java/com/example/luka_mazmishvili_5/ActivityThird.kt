package com.example.luka_mazmishvili_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.luka_mazmishvili_5.databinding.ActivityThirdBinding

class ActivityThird : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        var name: String? = ""
        var lastName: String? = ""

        if (bundle != null) {
            name = bundle.getString("NAME")
            lastName = bundle.getString("LASTNAME")
        }

        with(binding) {

            btnNext.setOnClickListener {

            val idNum = etIdNum.text.toString()

            val intent = Intent(this@ActivityThird, ActivityFinish::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("LASTNAME",lastName)
            intent.putExtra("IDNUM", idNum)
            startActivity(intent)

        }
        }
    }
}