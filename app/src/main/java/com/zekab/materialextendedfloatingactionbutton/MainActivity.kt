package com.zekab.materialextendedfloatingactionbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zekab.materialextendedfloatingactionbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnRecyclerview.setOnClickListener {
            startActivity(Intent(this,UsingRecyclerActivity::class.java))
        }

        binding.btnScrollview.setOnClickListener {
            startActivity(Intent(this,UsingScrollActivity::class.java))
        }

    }
}